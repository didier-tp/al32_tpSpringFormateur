package fr.afcepf.al32.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="compte")
@NamedQueries({
	@NamedQuery(name="Compte.findAll", query="SELECT c FROM Compte c"),
	@NamedQuery(name="Compte.findByClient", query="SELECT c FROM Compte c")
})
public class Compte {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//IDENTITY ok avec mysql recent
	//auto_increment du coté mysql
	private Long numero; //id (pk)

	@Column(name="label", length=32)//VARCHAR(32)
	private String label;
	
	private Double solde;

	
}
