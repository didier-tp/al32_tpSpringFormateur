package fr.afcepf.al32.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="t_option")
public class Option {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String label; //"decouvert_300euros_autorisé" , "..."
	
	@ManyToMany(mappedBy="options")//LAZY par defaut
	private List<Compte> comptes;

	@Override
	public String toString() {
		return "Option [id=" + id + ", label=" + label + "]";
	}
	
	
}
