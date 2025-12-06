package com.moonlite.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.moonlite.model.PackageEntity;

public interface PackageRepository extends JpaRepository<PackageEntity, Long> {
}
