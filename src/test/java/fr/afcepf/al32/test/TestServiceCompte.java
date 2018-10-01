package fr.afcepf.al32.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.afcepf.al32.config.ServiceConfig;
import fr.afcepf.al32.entity.Compte;
import fr.afcepf.al32.service.IServiceCompte;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations= {"/springConfAnnot.xml"})
@ContextConfiguration(classes= {ServiceConfig.class})
public class TestServiceCompte {
	
	private Logger logger = LoggerFactory.getLogger(TestServiceCompte.class);

	@Autowired
	private IServiceCompte serviceCompte; //à tester
	
	
	@Test
	public void testRechercheParNum() {
		Compte c =serviceCompte.rechercherCompteParNumero(2L);
		Assert.assertTrue(c.getNumero()==2L);
		logger.debug("c="+c.toString());
	}
	
	@Test
	public void testRechercherTousLesComptes() {
		List<Compte> listeCpt = serviceCompte.rechercherTousLesComptes();
		for(Compte c : listeCpt) {
			logger.debug("*** c="+c.toString());
		}
	}
	
	@Test 
	public void testCrudCompte() {
		//création nouveau compte
		Compte nouveauCompte = new Compte(null,"compte xy",300.0);
		serviceCompte.saveOrUpdateCompte(nouveauCompte);
		Long pk = nouveauCompte.getNumero(); 
		Assert.assertNotNull(pk);
		logger.debug("pk="+pk);
		//recherche pour vérifier
		Compte compteRelu =serviceCompte.rechercherCompteParNumero(pk);
		Assert.assertTrue(compteRelu.getLabel().equals("compte xy"));
		//mise à jour 
		compteRelu.setSolde(400.0);
		compteRelu.setLabel("label xyz");
		serviceCompte.saveOrUpdateCompte(compteRelu);
		//vérification
		compteRelu =serviceCompte.rechercherCompteParNumero(pk);
		Assert.assertTrue(compteRelu.getLabel().equals("label xyz"));
		Assert.assertEquals(400.0, compteRelu.getSolde(),0.0001);
		logger.debug("compteRelu="+compteRelu.toString());
		//suppression:
		serviceCompte.supprimerCompte(pk);
		//verification:
		compteRelu =serviceCompte.rechercherCompteParNumero(pk);
		Assert.assertNull(compteRelu);
	}
	

}
