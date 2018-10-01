package fr.afcepf.al32.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="personne")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typePersonne",
                     discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Personne")//valeur de typePersonne pour cette classe
public class Personne {

	@Id
	private Long numero; //id (pk)
	
	private String prenom;
	
	@Column(name="nom", length=32)//VARCHAR(32)
	private String nom;
	
	private String email;
	//...
	
}
