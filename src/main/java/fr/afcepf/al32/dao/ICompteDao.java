package fr.afcepf.al32.dao;

import java.util.List;

import fr.afcepf.al32.entity.Compte;

/*
 * DAO = Data Access Object (objet spécialisé dans l'accès aux données)
 * couche logicielle "persistance" ou "accès aux données"
 * avec méthodes "CRUD" 
 * C: Create (insert into)
 * R: Recherche
 * U: Update
 * D: Delete
 */

public interface ICompteDao extends IGenericDao<Compte>{
	public List<Compte> comptesDuClient(Long numClient);
}
