package fr.afcepf.al32.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.afcepf.al32.Calculateur;

public class TestCalculateur {
	private static Logger logger = LoggerFactory.getLogger(TestCalculateur.class);
	
	private Calculateur calculateur; //à tester
	
	@Before
	public void init() {
		calculateur=new Calculateur();
		logger.debug("calculateur à tester bien initialisé");
	}
	
	@Test
	public void testAddition() {
		int res = calculateur.addition(5, 6);
		Assert.assertTrue(res == 11);
		logger.debug("5+6="+res);
	}
	
	@Test
	public void testMultiplication() {
		int res = calculateur.multiplication(5, 6);
		Assert.assertTrue(res == 30);
		logger.debug("5*6="+res);
	}
}
