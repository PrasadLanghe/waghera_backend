package com.moonlite.service;

<<<<<<< HEAD

import lombok.RequiredArgsConstructor;
=======
>>>>>>> ee8c5a4 (Save local changes before pulling)
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.moonlite.model.Activity;
import com.moonlite.repository.ActivityRepository;

@Service
<<<<<<< HEAD
@RequiredArgsConstructor
=======

>>>>>>> ee8c5a4 (Save local changes before pulling)

public class ActivityService {

    private final CloudinaryService cloudinaryService;
    private final ActivityRepository activityRepo;
    
    
    public ActivityService(CloudinaryService cloudinaryService,ActivityRepository activityRepo)
    {
    	this.cloudinaryService=cloudinaryService;
    	this.activityRepo=activityRepo;
    }

    public Activity uploadActivity(String title, String description, MultipartFile file) throws Exception {

        // Upload to Cloudinary
        String uploadedUrl = cloudinaryService.uploadImage(file);

        // Save activity
        Activity activity = new Activity();
        activity.setTitle(title);
        activity.setDescription(description);
        activity.setImageUrl(uploadedUrl);

        return activityRepo.save(activity);
    }

    public java.util.List<Activity> getAllActivities() {
        return activityRepo.findAll();
    }
}

