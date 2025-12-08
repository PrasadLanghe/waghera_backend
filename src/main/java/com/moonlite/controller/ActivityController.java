package com.moonlite.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.moonlite.model.Activity;
import com.moonlite.service.ActivityService;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
<<<<<<< HEAD
@RequiredArgsConstructor
=======

>>>>>>> ee8c5a4 (Save local changes before pulling)
@CrossOrigin(origins = "http://localhost:5173")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService)
    {
    	this.activityService=activityService;
    }
    @PostMapping("/upload")
    public Activity uploadActivity(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("file") MultipartFile file) throws Exception {

        return activityService.uploadActivity(title, description, file);
    }

    @GetMapping("/all")
    public List<Activity> getAll() {
        return activityService.getAllActivities();
    }
}
