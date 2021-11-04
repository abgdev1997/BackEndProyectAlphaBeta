package com.proyectalpha.BackEndProyectAlpha.controllers;

import com.proyectalpha.BackEndProyectAlpha.models.Offer;
import com.proyectalpha.BackEndProyectAlpha.models.Technology;
import com.proyectalpha.BackEndProyectAlpha.repositories.OffersRepository;
import com.proyectalpha.BackEndProyectAlpha.repositories.TechnologyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Show all available offers
     * @return JSON (All offers)
     */
    @GetMapping("/api/offers")
    public List<Offer> findAll(){
        return offerRepo.findAll();
    }

    /**
     * Show an element based on a given id
     * @param id
     * @return JSON (Offer)
     */
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

    /**
     * Create a new offer
     * @param offer
     * @return JSON (Offer)
     */
    @PostMapping("/api/enterprise")
    public ResponseEntity<Offer> create(@RequestBody Offer offer) {
        if (offer.getId() != null) {
            log.warn("Trying to create a offer with id not null");
            return ResponseEntity.badRequest().build();
        }

        for (Technology technology : offer.getTechnologies()) {
            if (technology.getId() != null) {
                log.warn("Trying to create a offer with id not null");
                return ResponseEntity.badRequest().build();
            }
        }

        return ResponseEntity.ok(offerRepo.save(offer));

    }

    /**
     * Update an offer
     * @param offer
     * @return JSON (Offer)
     */
    @PutMapping("/api/enterprise")
    public ResponseEntity<Offer> update(@RequestBody Offer offer){
        if (offer.getId() == null) {
            log.warn("Trying to update a non existent offer");
            return ResponseEntity.badRequest().build();
        }

        else if(!offerRepo.existsById(offer.getId())) {
            log.warn("Trying to update a non existent offer");
            return ResponseEntity.notFound().build();
        }

        else {
            return ResponseEntity.ok(offerRepo.save(offer));
        }
    }

    /**
     * Delete an offer by id
     * @param id
     * @return No content
     */
    @DeleteMapping("/api/enterprise/{id}")
    public ResponseEntity<Offer> delete(@PathVariable Long id){
        if(!offerRepo.existsById(id)) {
            log.warn("Trying to delete a non existent offer");
            return ResponseEntity.notFound().build();
        }
        else {
            offerRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * Delete all offers
     * @return No content
     */
    @DeleteMapping("/api/enterprise")
    public ResponseEntity<Offer> deleteAll(){
        log.info("REST Request for Deleting all offers");
        offerRepo.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
