package fr.afcepf.al32.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al32.entity.Personne;

/*
 * implémentation avec technologie JPA/Hibernate 
 * (autre implémentation possible PersonneDaoJdbc (Statement, ResultSet )
 */
@Component
@Transactional //idealement en version Spring
public class PersonneDaoJpa implements IPersonneDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Personne findOne(Long numero) {
		return entityManager.find(Personne.class, numero);
	}

	@Override
	public void save(Personne p) {
		if(p.getNumero()==null)
			entityManager.persist(p);//INSERT INTO ...
		else 
			entityManager.merge(p); //UPDATE SQL
	}

	@Override
	public void delete(Long numero) {
		Personne p = entityManager.find(Personne.class, numero);
		entityManager.remove(p);
	}

	@Override
	public List<Personne> findAll() {
		// ...
		return null;
	}

}
