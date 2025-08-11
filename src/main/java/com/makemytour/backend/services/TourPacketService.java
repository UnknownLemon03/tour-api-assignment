package com.makemytour.backend.services;

import com.makemytour.backend.model.TourPackage;
import com.makemytour.backend.repository.TourPackageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TourPacketService {
    private TourPackageRepo tourPackageRepo;

    public TourPackage createNewTourPackage(TourPackage tourPackage){
        return tourPackageRepo.save(tourPackage);
    }
    public List<TourPackage> getAllTourPackage(){
        return tourPackageRepo.findAll();
    }
    public TourPackage getTourPackage(Long id){
        Optional<TourPackage> tourPackage =  tourPackageRepo.findById(id);
        if (tourPackage.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tour package not found");
        }
        return  tourPackage.get();
    }
    @Autowired
    public void setTourPackageRepo(TourPackageRepo tourPackageRepo) {
        this.tourPackageRepo = tourPackageRepo;
    }
}
