package com.moonlite.model;


import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.moonlite.model.Booking;

import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class PdfGenerator {

    public static byte[] generateBookingPdf(Booking booking) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            PdfWriter writer = new PdfWriter(baos);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            // fonts
            var font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
            document.setFont(font);

            // Header
            Paragraph header = new Paragraph("Booking Confirmation")
                    .setFontSize(18)
                    .setBold()
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(header);
            document.add(new Paragraph(" "));

            // Booking meta
            Table meta = new Table(UnitValue.createPercentArray(new float[]{1, 2})).useAllAvailableWidth();
            meta.addCell(new Cell().add(new Paragraph("Booking ID").setBold()));
            meta.addCell(new Cell().add(new Paragraph(String.valueOf(booking.getId()))));
            meta.addCell(new Cell().add(new Paragraph("Guest").setBold()));
            meta.addCell(new Cell().add(new Paragraph(booking.getUser().getName())));
            meta.addCell(new Cell().add(new Paragraph("Room").setBold()));
            meta.addCell(new Cell().add(new Paragraph(booking.getRoom().getRoomName())));
            meta.addCell(new Cell().add(new Paragraph("Check In").setBold()));
            meta.addCell(new Cell().add(new Paragraph(booking.getCheckInDate().toString())));
            meta.addCell(new Cell().add(new Paragraph("Check Out").setBold()));
            meta.addCell(new Cell().add(new Paragraph(booking.getCheckOutDate().toString())));
            meta.addCell(new Cell().add(new Paragraph("Nights").setBold()));
            long nights = java.time.temporal.ChronoUnit.DAYS.between(booking.getCheckInDate(), booking.getCheckOutDate());
            meta.addCell(new Cell().add(new Paragraph(String.valueOf(nights))));
            document.add(meta);

            document.add(new Paragraph(" "));

            // Price breakdown
            Table priceTable = new Table(UnitValue.createPercentArray(new float[]{3, 1})).useAllAvailableWidth();
            priceTable.addHeaderCell(new Cell().add(new Paragraph("Description").setBold()));
            priceTable.addHeaderCell(new Cell().add(new Paragraph("Amount").setBold()));

            double roomPerNight = booking.getRoom().getPrice();
            priceTable.addCell(new Cell().add(new Paragraph("Room (" + booking.getRoom().getRoomName() + ") @ " + roomPerNight + " per night")));
            priceTable.addCell(new Cell().add(new Paragraph(String.format(Locale.US, "%.2f", roomPerNight * nights))));

            // services
            if (booking.getExtraServices() != null && !booking.getExtraServices().isEmpty()) {
                for (var svc : booking.getExtraServices()) {
                    double svcTotal = svc.getPricePerNight() * nights;
                    priceTable.addCell(new Cell().add(new Paragraph(svc.getName() + " @ " + svc.getPricePerNight() + " per night")));
                    priceTable.addCell(new Cell().add(new Paragraph(String.format(Locale.US, "%.2f", svcTotal))));
                }
            }

            // extra bed price: assume some fixed per-bed price if needed (we'll compute earlier)
            priceTable.addCell(new Cell().add(new Paragraph("Extra bed(s)")));
            priceTable.addCell(new Cell().add(new Paragraph(String.format(Locale.US, "%.2f", booking.getTotalPrice() - (roomPerNight * nights) - booking.getExtraServices().stream().mapToDouble(s -> s.getPricePerNight() * nights).sum())))); // fallback

            // total
            priceTable.addCell(new Cell(1,1).add(new Paragraph("Total").setBold()));
            priceTable.addCell(new Cell(1,1).add(new Paragraph(String.format(Locale.US, "%.2f", booking.getTotalPrice())).setBold()));

            document.add(priceTable);

            document.add(new Paragraph(" "));
            document.add(new Paragraph("Thank you for booking with us."));

            document.close();
            return baos.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("PDF generation failed: " + e.getMessage(), e);
        }
    }
}
