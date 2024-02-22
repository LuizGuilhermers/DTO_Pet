package com.ProjetoPet.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "Pet")
@Data 
public class Pet {

				
			@Id
			@GeneratedValue (strategy = GenerationType.IDENTITY)
			private Long id;
				
			@NotNull
			@NotBlank
			private String nome;

			private String documento;
			
			@NotNull
			@NotBlank
			private String nascimento;
			
			@NotNull
			@NotBlank
			private String cuidador;
			

			public Pet (String nome, String nascimento, String cuidador) {
				this.nome=nome;
				this.nascimento=nascimento;
				this.cuidador=cuidador;
			}

}
