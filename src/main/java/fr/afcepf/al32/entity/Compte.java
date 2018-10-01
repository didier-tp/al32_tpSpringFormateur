package fr.afcepf.al32.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter  @NoArgsConstructor
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
	
	@ManyToOne //many "compte" to one "client"
	@JoinColumn(name="numClient")//fk
	private Client client;

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
