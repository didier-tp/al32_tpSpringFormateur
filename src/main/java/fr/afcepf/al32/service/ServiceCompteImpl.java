package fr.afcepf.al32.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al32.dao.ICompteDao;
import fr.afcepf.al32.entity.Compte;

@Service
@Transactional
public class ServiceCompteImpl implements IServiceCompte {

	@Autowired
	private ICompteDao dao;

	@Override
	public Compte rechercherCompteParNumero(Long num) {
		return dao.findOne(num);
	}

	@Override
	public List<Compte> rechercherTousLesComptes() {
		return dao.findAll();
	}

}
