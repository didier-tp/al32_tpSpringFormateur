package fr.afcepf.al32.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al32.entity.Compte;
@Component
@Transactional //idealement en version Spring
public class CompteDaoJpa implements ICompteDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Compte findOne(Long numero) {
		return entityManager.find(Compte.class, numero);
	}

	@Override
	public void save(Compte c) {
		if(c.getNumero()==null)
			entityManager.persist(c);//INSERT INTO ...
		else 
			entityManager.merge(c); //UPDATE SQL

	}

	@Override
	public void delete(Long numero) {
		Compte c = entityManager.find(Compte.class, numero);
		entityManager.remove(c);
	}

	@Override
	public List<Compte> findAll() {
		//return entityManager.createQuery("SELECT c FROM Compte c", Compte.class)
		//		            .getResultList();
		return entityManager.createNamedQuery("Compte.findAll", Compte.class)
				            .getResultList();
		//avec @NamedQuery(name="Compte.findAll", query="SELECT c FROM Compte c")
		//au dessus de la classe Compte
	}

	@Override
	public List<Compte> comptesDuClient(Long numClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte compteAvecOptions(Long numCompte) {
		String jpaRequest="SELECT cpt FROM Compte cpt INNER JOIN FETCH cpt.options "
				        + " WHERE cpt.numero = :numCompte";
		return entityManager.createQuery(jpaRequest,Compte.class)
				            .setParameter("numCompte",numCompte)
				            .getSingleResult();
	}

}
