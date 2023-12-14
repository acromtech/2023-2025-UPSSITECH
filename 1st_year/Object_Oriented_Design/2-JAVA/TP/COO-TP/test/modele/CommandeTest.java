package modele;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommandeTest {
	private int numClient=13;
	private int numCommande=10;
	private Hamburger hamburger;
	private Accompagnement accompagnement;
	private Boisson boisson;
	private Commande commande = new Commande (numClient,hamburger,accompagnement,boisson);
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		assumeTrue(numCommande!=0,"numCommande");
		assumeTrue();
		this.commande = new Commande (numClient,hamburger,accompagnement,boisson);
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}
	
	@Test
	void getNumeroCommandeAttribueeTest() {
		assertEquals(numCommande,commande.getNumeroCommandeAttribuee(),"Test Numéro de commande : OK");
	}
	
	@Test
	void getAccompagnementTest() {
		assertEquals(accompagnement,commande.getAccompagnement(),"Test Accompagnement : OK");
	}
	
	@Test
	void getBoissonTest() {
		assertEquals(boisson,commande.getBoisson(),"Test Boisson : OK");
	}
	
	@Test
	void getNumClientTest() {
		assertEquals(numClient,commande.getNumClient(),"Test Numéro Client : OK");
	}
	
	@Test
	void createTest() {
		
	}
	
	@Test
	void initialiseNumeroCommandeTest() {
		assertEquals(numCommande,Commande.initialiseNumeroCommande(),"Test Numéro Client : OK");
	}
	
	@Test
	void getHamburgerTest() {
		assertEquals(hamburger,commande.getHamburger(),"Test Hamburger : OK");
	}
	
	
}
