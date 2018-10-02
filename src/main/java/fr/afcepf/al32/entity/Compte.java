package fr.afcepf.al32.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter  @NoArgsConstructor
@Entity
@Table(name="compte")
@NamedQueries({
	@NamedQuery(name="Compte.findAll", query="SELECT c FROM Compte c"),
	@NamedQuery(name="Compte.findByClient", 
	            query="SELECT cpt FROM Client cli INNER JOIN cli.comptes cpt WHERE cli.numero = :numClient"),
	@NamedQuery(name="Compte.findByClientV2", 
				query="SELECT cpt FROM Compte cpt WHERE cpt.client.numero = :numClient")
	})
public class Compte { 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//IDENTITY ok avec mysql recent
	//auto_increment du coté mysql
	private Long numero; //id (pk)
	
	@ManyToOne //many "compte" to one "client"
	@JoinColumn(name="numClient")//fk 
	private Client client;
	
	@ManyToMany
	@JoinTable(name="compte_option",
	     joinColumns= {@JoinColumn(name="numCompte")} ,
	     inverseJoinColumns = {@JoinColumn(name="numOption")})
	private List<Option> options;

	@Column(name="label", length=32)//VARCHAR(32)
	private String label;
	
	private Double solde;

	public Compte(Long numero, String label, Double solde) {
		super();
		this.numero = numero;
		this.label = label;
		this.solde = solde;
	}

	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", label=" + label + ", solde=" + solde + "]";
	}

	
	
	

	
}
