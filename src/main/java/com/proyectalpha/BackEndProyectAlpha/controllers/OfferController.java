package com.proyectalpha.BackEndProyectAlpha.controllers;

import com.proyectalpha.BackEndProyectAlpha.models.Offer;
import com.proyectalpha.BackEndProyectAlpha.repositories.OffersRepository;
import com.proyectalpha.BackEndProyectAlpha.repositories.TechnologyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OfferController {

    private final Logger log = LoggerFactory.getLogger(OfferController.class);
    private TechnologyRepository techRepo;
    private OffersRepository offerRepo;

    public OfferController(TechnologyRepository techRepo, OffersRepository offerRepo) {
        this.techRepo = techRepo;
        this.offerRepo = offerRepo;
    }

    @GetMapping("/api/offers")
    public List<Offer> findAll(){
        return offerRepo.findAll();
    }

    @GetMapping("/api/offers/{id}")
    public ResponseEntity<Offer> findOneId(@PathVariable Long id){
        Optional<Offer> offerOpt = offerRepo.findById(id);
        if(offerOpt.isPresent()){
            return ResponseEntity.ok(offerOpt.get());
        } else {
            log.warn("The offer not exist");
            return ResponseEntity.notFound().build();
        }
    }

}
