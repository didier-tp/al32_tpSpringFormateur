package fr.afcepf.al32.dao;

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

public interface IPersonneDao extends IGenericDao<Personne>{
	//...
}
