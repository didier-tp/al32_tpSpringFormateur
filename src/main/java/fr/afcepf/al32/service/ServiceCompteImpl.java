package fr.afcepf.al32.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al32.dao.ICompteDao;
import fr.afcepf.al32.entity.Compte;

@Service
//@Transactional
public class ServiceCompteImpl implements IServiceCompte {

	@Autowired
	private ICompteDao dao;
	
	@Override
	@Transactional
	//s.transferer(50.0 , 1L , 2L);--> commit automatique
	//s.transferer(50.0 , 1L , -2L);--> exception et rollback
	public void transferer(double montant, long numCptDeb, long numCptCred) {
		Compte cptDeb = dao.findOne(numCptDeb);
		cptDeb.setSolde(cptDeb.getSolde()-montant);
		dao.save(cptDeb);//NB: l'appel à dao.save() sera facultatif si 
		                 //contexte @Transactional et état persistant
		Compte cptCred = dao.findOne(numCptCred);
		cptCred.setSolde(cptCred.getSolde()+montant);
		dao.save(cptCred);
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
