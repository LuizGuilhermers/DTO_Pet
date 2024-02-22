package com.ProjetoPet.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoPet.DTO.PetDTO;
import com.ProjetoPet.Entities.Pet;
import com.ProjetoPet.Repository.PetRepository;

@Service
public class PetService {
	

	private final PetRepository petRepository;
		
		@Autowired
		public PetService (PetRepository petRepository) {
			this.petRepository = petRepository;
		}
		
		//DTO
		public PetDTO save (PetDTO petDTO)	{
			Pet pet = new Pet (petDTO.nome(),petDTO.nascimento(), petDTO.cuidador());
			Pet savePet = petRepository.save(pet);
			return new PetDTO (savePet.getId(), savePet.getNome(), savePet.getNascimento(),savePet.getCuidador());
		}
		
		public PetDTO update (Long id, PetDTO petDTO) {
			Pet existingPet = petRepository.findById(id).orElseThrow (() -> new RuntimeException ("Usuário não encontrado"));
			
			existingPet.setNome(petDTO.nome());
			existingPet.setNascimento(petDTO.nascimento());
			existingPet.setCuidador(petDTO.cuidador());
			
			Pet updatePet = petRepository.save(existingPet);
			return new PetDTO (updatePet.getId(), updatePet.getNome(), updatePet.getNascimento(), updatePet.getCuidador());
					
		}
		
		//Tradicional
		
		public boolean deletePet (Long id) {
			Optional <Pet> existingPet = petRepository.findById(id);
			if (existingPet.isPresent()) {
				petRepository.deleteById(id);
				return true;
			}
			return false;

		}
		
		public List<Pet> getAll(){
			return petRepository.findAll();
		}
		
		public Pet getById (Long id) {
			Optional<Pet> Pet = petRepository.findById(id);
			return Pet.orElse(null);
		}
		

}
