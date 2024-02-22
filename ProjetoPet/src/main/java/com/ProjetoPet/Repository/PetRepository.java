package com.ProjetoPet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoPet.Entities.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{

}
