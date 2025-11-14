package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlLibererEtalTest {
	
	private ControlEmmenager cm;
	private ControlTrouverEtalVendeur cev;
	private ControlVerifierIdentite cv;
	private ControlPrendreEtal cp;
	private ControlLibererEtal cl;

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
	}

	@Test
	void testIsVendeur() {
		assertTrue(cl.isVendeur("Bonemine"));
		assertFalse(cl.isVendeur("Intru"));
		assertFalse(cl.isVendeur("LeChef"));
	}
	
	@Test
	void testLibererEtal() {
		assertNull(cl.libererEtal("Intru"));
		assertNotNull(cl.libererEtal("Bonemine"));
	}

}
