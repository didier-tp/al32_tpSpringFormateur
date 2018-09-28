package fr.afcepf.al32.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor

@Entity
public class Personne {

	@Id
	private Long numero; //id (pk)
	private String prenom;
	private String nom;
	private String email;
	//...
	
}
