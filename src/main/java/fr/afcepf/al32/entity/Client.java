package fr.afcepf.al32.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@DiscriminatorValue("Client")//valeur de typePersonne pour cette classe
public class Client extends Personne{

	private String password;
	
	//Le @OneToMany est l'inverse du @ManyToOne
	@OneToMany(mappedBy="client")//mappedBy = nom "java" de la relation inverse 
	private List<Compte> comptes;

}
