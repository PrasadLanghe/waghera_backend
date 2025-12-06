package com.moonlite.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; // New import for POST
import org.springframework.web.bind.annotation.RequestBody; // New import for request body
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus; // New import for 201 status
import org.springframework.web.bind.annotation.RestController;

import com.moonlite.model.MenuItem;
import com.moonlite.repository.MenuItemRepository;

import java.util.List;

@RestController
@RequestMapping("/api/menu") // Base URL: http://localhost:8080/api/menu
public class MenuController {

    private final MenuItemRepository menuItemRepository;

    // Dependency Injection
    public MenuController(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    // 1. Endpoint: GET /api/menu (Gets all items)
    @GetMapping
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    // 2. Endpoint: GET /api/menu/category/Breakfast (Gets items by category)
    @GetMapping("/category/{categoryName}")
    public List<MenuItem> getMenuItemsByCategory(@PathVariable String categoryName) {
        // Calls the custom method in MenuItemRepository
        return menuItemRepository.findByCategory(categoryName);
    }
    
    // ⭐ 3. NEW ENDPOINT: POST /api/menu (Creates a new item) ⭐
    // This is the method that fixes your 405 error
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Correctly returns HTTP 201 on success
    public MenuItem createMenuItem(@RequestBody MenuItem menuItem) {
        // Spring automatically converts the JSON body into a MenuItem object
        // and JpaRepository's .save() method handles the database insertion.
        return menuItemRepository.save(menuItem);
    }
}