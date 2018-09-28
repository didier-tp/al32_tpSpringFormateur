package fr.afcepf.al32.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.entity.Personne;

//@Component("id_bizarre_du_composant") 
//id par defaut = nom de la classe java avec la premiere lettre en minuscule.
@Component //demander à spring de prendre en charge cette classe
           //en tant que "composant spring"
public class PersonneDaoSimulation implements IPersonneDao {
	
	private Logger logger = LoggerFactory.getLogger(PersonneDaoSimulation.class);
	
	private Map<Long,Personne> mapPersonnes = new HashMap<Long,Personne>();
	private long numMax=0;
	
	private String commentaire;
	
	

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
		logger.debug("commentaire="+commentaire);
	}

	public PersonneDaoSimulation() {
		mapPersonnes.put(1L, new Personne(1L,"jean","Bon","jb@gmail.com"));
		mapPersonnes.put(2L, new Personne(2L,"alain","Therieur","at@gmail.com"));
		numMax=2;
	}

	@Override
	public Personne findOne(Long numero) {
		return mapPersonnes.get(numero);
	}

	@Override
	public void save(Personne p) {
		Long numero = p.getNumero();
		if(numero==null) {
			numero= ++numMax; //simuler auto_increment mysql
			p.setNumero(numero);
		}
		mapPersonnes.put(numero, p);
	}

	@Override
	public void delete(Long numero) {
		mapPersonnes.remove(numero);
	}

	@Override
	public List<Personne> findAll() {
		return new ArrayList<Personne>(mapPersonnes.values());
	}

}
