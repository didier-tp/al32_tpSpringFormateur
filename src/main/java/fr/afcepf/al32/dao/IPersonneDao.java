package fr.afcepf.al32.dao;

import java.util.List;

import fr.afcepf.al32.entity.Personne;

/*
 * DAO = Data Access Object (objet spécialisé dans l'accès aux données)
 * couche logicielle "persistance" ou "accès aux données"
 * avec méthodes "CRUD" 
 * C: Create (insert into)
 * R: Recherche
 * U: Update
 * D: Delete
 */

public interface IPersonneDao {
	public Personne findOne(Long numero); //recherche par clef primaire
	public void save(Personne p); //saveOrUpdate (insert into ou update)
	public void delete(Long numero);
	//...
	public List<Personne> findAll();
	//...
}
