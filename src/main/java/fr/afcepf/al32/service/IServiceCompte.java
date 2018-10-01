package fr.afcepf.al32.service;

import java.util.List;

import fr.afcepf.al32.entity.Compte;

public interface IServiceCompte {
   
   Compte rechercherCompteParNumero(Long num);
   List<Compte> rechercherTousLesComptes();
   List<Compte> rechercherComptesDuClient(long numClient);
   
   Compte saveOrUpdateCompte(Compte cpt);
   void supprimerCompte(long numero);
   
   void transferer(double montant,long numCptDeb,long numCptCred);//virement
}
