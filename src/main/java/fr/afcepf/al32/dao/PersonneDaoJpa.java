package fr.afcepf.al32.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import fr.afcepf.al32.entity.Personne;

/*
 * implémentation avec technologie JPA/Hibernate 
 * (autre implémentation possible PersonneDaoJdbc (Statement, ResultSet )
 */
//@Component
public class PersonneDaoJpa implements IPersonneDao {

	public PersonneDaoJpa() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Personne findOne(Long numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Personne p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long numero) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Personne> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
