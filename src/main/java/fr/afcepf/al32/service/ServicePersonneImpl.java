package fr.afcepf.al32.service;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.dao.IClientDao;
import fr.afcepf.al32.dao.IPersonneDao;
import fr.afcepf.al32.entity.Client;
import fr.afcepf.al32.entity.Personne;

@Component //ou bien @Service qui herite de @Component
public class ServicePersonneImpl implements IServicePersonne {
	private Logger logger = LoggerFactory.getLogger(ServicePersonneImpl.class);
	
	@Autowired //sur le private ou bien sur le set...()
	//@Autowired demande à spring d'initialiser la référence "personneDao"
	//en pointant vers un composant spring existant compatible avec l'interface.
	private IPersonneDao personneDao=null;
	
	@Autowired	
	private IClientDao clientDao=null;
	
	@Override
	public Client rechercherClientAvecComptes(Long numClient) {
		return clientDao.rechercherClientAvecComptes(numClient);
	}
	
	//pour injection de dépendance xml:
	public void setPersonneDao(IPersonneDao personneDao) {
		this.personneDao = personneDao;
	}
	
	public ServicePersonneImpl() {
		logger.debug("constructeur de ServicePersonneImpl appelé avant injections "
				+ " avec personneDao="+personneDao);
	}
	
	@PostConstruct
	public void initBean() {
		logger.debug("initBean() appelée après injection avec @PostConstruct "
				+ " avec personneDao="+personneDao);
	}


	@Override
	public Personne rechercherPersonneParNumero(Long num) {
		// v1 pas bien sans spring:
		//IPersonneDao dao = new PersonneDaoSimulation();
		//return dao.findOne(num);
		
		//V2 utilisant dao injecté par spring:
		return personneDao.findOne(num);
	}

	

}
