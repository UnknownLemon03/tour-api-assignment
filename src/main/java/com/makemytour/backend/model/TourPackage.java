package com.makemytour.backend.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tour_packages")
public class TourPackage {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String image;
    @Column(nullable = false)
    private String discountInPercentage;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String duration;
    @Column(nullable = false)
    private String actualPrice;
    @Column(nullable = false)
    private String discountedPrice;
}
