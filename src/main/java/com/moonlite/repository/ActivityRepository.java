package com.moonlite.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.moonlite.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {}
