package fr.afcepf.al32.service;

import fr.afcepf.al32.entity.Client;
import fr.afcepf.al32.entity.Personne;

public interface IServicePersonne {
	Personne rechercherPersonneParNumero(Long num);
	Client rechercherClientAvecComptes(Long numClient);
}
