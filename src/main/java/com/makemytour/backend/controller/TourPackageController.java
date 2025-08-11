package com.makemytour.backend.controller;

import com.makemytour.backend.dto.ApiResponse;
import com.makemytour.backend.dto.TourPackageRequest;
import com.makemytour.backend.model.TourPackage;
import com.makemytour.backend.services.TourPacketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tours")
public class TourPackageController {
    private TourPacketService tourPacketService;

    @PostMapping
    public ResponseEntity<ApiResponse<TourPackage>> createTourPackage(@Valid @RequestBody TourPackageRequest tourPackageReq) {

        TourPackage tourPackage = new TourPackage();

        tourPackage.setActualPrice(tourPackageReq.getActualPrice());
        tourPackage.setDiscountInPercentage(tourPackageReq.getDiscountInPercentage());
        tourPackage.setDescription(tourPackageReq.getDescription());
        tourPackage.setDiscountedPrice(tourPackageReq.getDiscountedPrice());
        tourPackage.setDuration(tourPackageReq.getDuration());
        tourPackage.setImage(tourPackageReq.getImage());
        tourPackage.setTitle(tourPackageReq.getTitle());

        TourPackage savedTourPackage = tourPacketService.createNewTourPackage(tourPackage);

        ApiResponse<TourPackage> response = ApiResponse.<TourPackage>builder()
                .data(savedTourPackage)
                .message("Tour Package created")
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<TourPackage>>> getAllTourPackages() {
        List<TourPackage> packages = tourPacketService.getAllTourPackage();
        ApiResponse<List<TourPackage>> response = ApiResponse.<List<TourPackage>>builder()
                .data(packages)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TourPackage>> getTourPackageById(@PathVariable Long id) {
        TourPackage tourPackage = tourPacketService.getTourPackage(id);
        ApiResponse<TourPackage> response = ApiResponse.<TourPackage>builder()
                .data(tourPackage)
                .build();
        return ResponseEntity.ok(response);
    }

    @Autowired
    public void setTourPacketService(TourPacketService tourPacketService) {
        this.tourPacketService = tourPacketService;
    }

}
