package com.moonlite.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moonlite.model.ComboMenu;

@Repository
// The Repository now manages the ComboMenu entity
public interface ComboMenuRepository extends JpaRepository<ComboMenu, Long> {
    
    // All standard CRUD methods are inherited for the ComboMenu entity.
}