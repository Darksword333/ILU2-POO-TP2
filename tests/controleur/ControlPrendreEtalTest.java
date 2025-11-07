package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {

	private ControlEmmenager cm;
	private ControlVerifierIdentite cv;
	private ControlPrendreEtal cp;
	
	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("LeVillage", 10, 1);
		village.setChef(new Chef("LeChef", 1, village));
		cm = new ControlEmmenager(village);
		cv = new ControlVerifierIdentite(village);
		cp = new ControlPrendreEtal(cv, village);
	}

	@Test
	void testPrendreEtal() {
		int numeroEtal;
		numeroEtal = cp.prendreEtal("Bonemine", "fleurs", 10);
		assertEquals(numeroEtal, 1);
		numeroEtal = cp.prendreEtal("Intru", "rien", 10);
		assertNotEquals(numeroEtal, 1);
	}
	
	@Test
	void testVerifierIdentite() {
		assertFalse(cp.verifierIdentite("Intru"));
		assertTrue(cp.verifierIdentite("LeChef"));
	}
	
	@Test
	void testResteEtal() {
		cp.prendreEtal("Bonemine", "fleurs", 10);
		assertFalse(cp.resteEtals());
	}

}
