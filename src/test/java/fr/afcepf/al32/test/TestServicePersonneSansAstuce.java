package fr.afcepf.al32.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.al32.entity.Personne;
import fr.afcepf.al32.service.IServicePersonne;

public class TestServicePersonneSansAstuce {
	
	private Logger logger = LoggerFactory.getLogger(TestServicePersonneSansAstuce.class);

	private IServicePersonne servicePersonne; //à tester
	
	@Before
	public void init() {
		//v1 pas bien sans spring:
		//servicePersonne= new ServicePersonneImpl();
		//V2 avec Spring (et config xml):
		ApplicationContext context =
				new ClassPathXmlApplicationContext("springConfAnnot.xml");//"springConfXml.xml"
		servicePersonne = (IServicePersonne) context.getBean("servicePersonneImpl" /* id */);
		//servicePersonne = context.getBean(IServicePersonne.class);
	}
	
	//@Test
	public void testRechercheParNum() {
		Personne p =servicePersonne.rechercherPersonneParNumero(2L);
		Assert.assertTrue(p.getNumero()==2L);
		logger.debug("p="+p.toString());
	}
	

}
