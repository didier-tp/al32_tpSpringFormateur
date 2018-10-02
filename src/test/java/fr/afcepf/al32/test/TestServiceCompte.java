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
import fr.afcepf.al32.entity.Option;
import fr.afcepf.al32.service.IServiceCompte;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations= {"/springConfAnnot.xml"})
@ContextConfiguration(classes= {ServiceConfig.class})
public class TestServiceCompte {
	
	private Logger logger = LoggerFactory.getLogger(TestServiceCompte.class);

	@Autowired
	private IServiceCompte serviceCompte; //à tester
	
	
	@Test
	public void testBonVirement() {
		double s1Avant = serviceCompte.rechercherCompteParNumero(1L).getSolde();
		double s2Avant = serviceCompte.rechercherCompteParNumero(2L).getSolde();
		serviceCompte.transferer(50.0, 1L, 2L);
		double s1Apres = serviceCompte.rechercherCompteParNumero(1L).getSolde();
		double s2Apres = serviceCompte.rechercherCompteParNumero(2L).getSolde();
		Assert.assertEquals(s1Avant-50.0, s1Apres , 0.00001);
		Assert.assertEquals(s2Avant+50.0, s2Apres , 0.00001);
		logger.debug("s1Avant="+s1Avant + " s2Avant=" + s2Avant);
		logger.debug("s1Apres="+s1Apres + " s2Apres=" + s2Apres);
	}
	
	@Test
	public void testCompteAvecOptions() {
		Compte c1 =serviceCompte.rechercherCompteAvecOptions(1L);
		Assert.assertTrue(c1.getNumero()==1L);
		logger.debug("c1="+c1.toString());
        for(Option o : c1.getOptions()) {
        	logger.debug("\t" + o.toString());
        }

	}
	
	@Test
	public void testRechercheParNum() {
		Compte c =serviceCompte.rechercherCompteParNumero(2L);
		Assert.assertTrue(c.getNumero()==2L);
		logger.debug("c="+c.toString());
		logger.debug("client-c:" + c.getClient().toString());
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
