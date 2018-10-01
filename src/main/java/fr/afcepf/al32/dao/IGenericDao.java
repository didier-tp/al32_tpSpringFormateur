package fr.afcepf.al32.dao;

import java.util.List;

/*
 * DAO = Data Access Object (objet spécialisé dans l'accès aux données)
 * couche logicielle "persistance" ou "accès aux données"
 * avec méthodes "CRUD" 
 * C: Create (insert into)
 * R: Recherche
 * U: Update
 * D: Delete
 */

public interface IGenericDao<T> {
	public T findOne(Long numero); //recherche par clef primaire
	public void save(T p); //saveOrUpdate (insert into ou update)
	public void delete(Long numero);
	//...
	public List<T> findAll();
	//...
}
