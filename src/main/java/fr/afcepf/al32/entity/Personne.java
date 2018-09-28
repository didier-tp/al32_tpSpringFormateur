package fr.afcepf.al32.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Personne {

	private Long numero; //id (pk)
	private String prenom;
	private String nom;
	private String email;
	//...
	
}
