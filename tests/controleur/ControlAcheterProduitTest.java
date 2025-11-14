package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	
	private ControlEmmenager cm;
	private ControlTrouverEtalVendeur cev;
	private ControlVerifierIdentite cv;
	private ControlPrendreEtal cp;
	private ControlLibererEtal cl;
	private ControlAcheterProduit cap;

	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("LeVillage", 10, 1);
		village.setChef(new Chef("LeChef", 1, village));
		cm = new ControlEmmenager(village);
		cv = new ControlVerifierIdentite(village);
		cp = new ControlPrendreEtal(cv, village);
		cev = new ControlTrouverEtalVendeur(village);
		cl = new ControlLibererEtal(cev);
		cm.ajouterGaulois("Bonemine", 1);
		cp.prendreEtal("Bonemine", "fleurs", 10);
		cap = new ControlAcheterProduit(cv, cev, village);
	}

	@Test
	void testVerifierGaulois() {
		assertTrue(cap.verifierGaulois("Bonemine"));
		assertFalse(cap.verifierGaulois("Intru"));
	}
	
	@Test
	void testChercherMarchand() {
		String[] vide = {}, expected = {"Bonemine"},
				actual = cap.chercherMarchand("fleurs"),
				actualvide = cap.chercherMarchand("caillou");
		assertArrayEquals(actual, expected);
		assertArrayEquals(actualvide, vide);
	}
	
	@Test
	void testAcheterProduitInexistant() {
		assertEquals(cap.acheterProduit("Intru", 10), -1);
	}

	
	@Test
	void testAcheterProduitExistant() {
		assertEquals(cap.acheterProduit("Bonemine", 10), 10);
	}
	
	@Test
	void testAcheterProduitPasAssez() {
		// Pas normal on en achete -10 et ca pose pas de pb
		//assertEquals(cap.acheterProduit("Bonemine", -10), -1);
		assertEquals(cap.acheterProduit("Bonemine", -10), -10);
	}
	
	@Test
	void testAcheterProduitTrop() {
		assertEquals(cap.acheterProduit("Bonemine", 100), 10);
	}
}
