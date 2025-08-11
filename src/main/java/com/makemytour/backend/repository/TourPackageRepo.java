package com.makemytour.backend.repository;

import com.makemytour.backend.model.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourPackageRepo extends JpaRepository<TourPackage,Long> {
}
