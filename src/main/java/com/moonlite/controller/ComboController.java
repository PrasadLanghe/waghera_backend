package com.moonlite.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.moonlite.model.ComboMenu;
import com.moonlite.repository.ComboMenuRepository;

@RestController
@RequestMapping("/api/combos")
@CrossOrigin(origins = "*") // ✅ Enable CORS for React frontend
public class ComboController {

    private final ComboMenuRepository comboMenuRepository;

    public ComboController(ComboMenuRepository comboMenuRepository) {
        this.comboMenuRepository = comboMenuRepository;
    }

    // GET all combos
    @GetMapping
    public List<ComboMenu> getAllCombos() {
        return comboMenuRepository.findAll();
    }

    // CREATE new combo
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ComboMenu createCombo(@RequestBody ComboMenu comboMenu) {
        return comboMenuRepository.save(comboMenu);
    }

    // UPDATE combo by ID
    @PutMapping("/{id}")
    public ResponseEntity<ComboMenu> updateCombo(@PathVariable Long id, @RequestBody ComboMenu comboMenuDetails) {
        Optional<ComboMenu> comboOptional = comboMenuRepository.findById(id);

        if (comboOptional.isPresent()) {
            ComboMenu existingCombo = comboOptional.get();

            existingCombo.setName(comboMenuDetails.getName());
            existingCombo.setDescription(comboMenuDetails.getDescription());
            existingCombo.setPrice(comboMenuDetails.getPrice());
            existingCombo.setImageUrl(comboMenuDetails.getImageUrl());
//            existingCombo.setBestseller(comboMenuDetails.isBestseller());
//            existingCombo.setChefPick(comboMenuDetails.isChefPick());
            existingCombo.setIsDeal(comboMenuDetails.getIsDeal());

            ComboMenu updatedCombo = comboMenuRepository.save(existingCombo);
            return ResponseEntity.ok(updatedCombo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE combo by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCombo(@PathVariable Long id) {
        if (comboMenuRepository.existsById(id)) {
            comboMenuRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
