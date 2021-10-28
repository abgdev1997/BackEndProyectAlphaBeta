package com.proyectalpha.BackEndProyectAlpha.repositories;

import com.proyectalpha.BackEndProyectAlpha.models.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology,Long>{
}
