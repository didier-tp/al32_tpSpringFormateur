package fr.afcepf.al32.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al32.dao.ICompteDao;
import fr.afcepf.al32.entity.Compte;

@Service
@Transactional
public class ServiceCompteImpl implements IServiceCompte {
	
	private Logger logger = LoggerFactory.getLogger(ServiceCompteImpl.class);

	@Autowired
	private ICompteDao dao;
	
	@Override
	//@Transactional ici ou au dessus de la classe entière
	//s.transferer(50.0 , 1L , 2L);--> commit automatique
	//s.transferer(50.0 , 1L , -2L);--> exception et rollback
	public void transferer(double montant, long numCptDeb, long numCptCred) 
	    throws MyServiceException
	    {
		try {
			Compte cptDeb = dao.findOne(numCptDeb);
			cptDeb.setSolde(cptDeb.getSolde()-montant);
			//dao.save(cptDeb);//NB: l'appel à dao.save() sera facultatif si 
			                 //contexte @Transactional et état persistant
			Compte cptCred = dao.findOne(numCptCred);
			cptCred.setSolde(cptCred.getSolde()+montant);
			//dao.save(cptCred);
		} catch (Exception e) {
			logger.error("echec virement",e);
			throw new MyServiceException("echec virement",e); 
		}
	}

	@Override
	public Compte rechercherCompteParNumero(Long num) {
		return dao.findOne(num);
	}

	@Override
	public List<Compte> rechercherTousLesComptes() {
		return dao.findAll();
	}

	@Override
	public List<Compte> rechercherComptesDuClient(long numClient) {
		return dao.comptesDuClient(numClient);
	}

	@Override
	public Compte saveOrUpdateCompte(Compte cpt) {
		 dao.save(cpt);
		 return cpt;
	}

	@Override
	public void supprimerCompte(long numero) {
		dao.delete(numero);
	}

	

	@Override
	public Compte rechercherCompteAvecOptions(Long num) {
		return dao.compteAvecOptions(num);
	}

}
