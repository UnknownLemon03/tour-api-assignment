package com.makemytour.backend.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
public class TourPackageRequest {

    @NotBlank(message = "Image URL is required")
    private String image;

    @NotBlank(message = "Discount percentage is required")
    private String discountInPercentage;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Duration is required")
    private String duration;

    @NotBlank(message = "Actual price is required")
    private String actualPrice;

    @NotBlank(message = "Discounted price is required")
    private String discountedPrice;

    // getters and setters
}
