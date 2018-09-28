package fr.afcepf.al32.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="personne")
public class Personne {

	@Id
	private Long numero; //id (pk)
	
	private String prenom;
	
	@Column(name="nom", length=32)//VARCHAR(32)
	private String nom;
	
	private String email;
	//...
	
}
