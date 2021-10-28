package com.proyectalpha.BackEndProyectAlpha.repositories;

import com.proyectalpha.BackEndProyectAlpha.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffersRepository extends JpaRepository<Offer, Long> {
}
