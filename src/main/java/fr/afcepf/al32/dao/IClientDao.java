package fr.afcepf.al32.dao;

import fr.afcepf.al32.entity.Client;



public interface IClientDao extends IGenericDao<Client>{
	Client rechercherClientAvecComptes(Long numClient);
}
