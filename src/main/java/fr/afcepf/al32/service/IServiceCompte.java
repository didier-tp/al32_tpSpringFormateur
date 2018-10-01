package fr.afcepf.al32.service;

import java.util.List;

import fr.afcepf.al32.entity.Compte;

public interface IServiceCompte {
   
   Compte rechercherCompteParNumero(Long num);
   List<Compte> rechercherTousLesComptes();
   //...
}
