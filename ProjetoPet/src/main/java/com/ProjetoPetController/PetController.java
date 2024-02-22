package com.ProjetoPetController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoPet.DTO.PetDTO;
import com.ProjetoPet.Entities.Pet;
import com.ProjetoPet.Service.PetService;

import jakarta.validation.Valid;


@RestController
@RequestMapping ("/Pet")
public class PetController {
	
	private final PetService petService;
	
	@Autowired
	public PetController (PetService petService) {
		this.petService = petService;
	}
	
	
    @GetMapping("/{id}")
    public ResponseEntity <Pet> buscaUsuarioIdControlId(@PathVariable Long id){
        Pet pet = petService.getById(id);
        if(pet!= null) {
            return ResponseEntity.ok(pet);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<Pet>> buscaTodosUsuarioControl() {
        List<Pet> pet = petService.getAll();
 
        return ResponseEntity.ok(pet);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePet(@PathVariable Long id) {
        boolean deleted = petService.deletePet(id);
        if (deleted) {
        	 return ResponseEntity.ok().body("O cadastro do pet foi excluído com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public ResponseEntity<PetDTO> save(@RequestBody  @Valid PetDTO petDTO) {
    	PetDTO savePet = petService.save(petDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savePet);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PetDTO> updatePetDTO(@PathVariable Long id, @RequestBody PetDTO petDTO) {
    	PetDTO updatedPet = petService.update(id, petDTO);
        if (updatedPet != null) {
            return ResponseEntity.ok(updatedPet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
