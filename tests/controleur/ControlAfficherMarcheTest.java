package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	
	private ControlEmmenager cm;
	private ControlTrouverEtalVendeur cev;
	private ControlVerifierIdentite cv;
	private ControlPrendreEtal cp;
	private ControlLibererEtal cl;
	private ControlAfficherMarche cam;

	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("LeVillage", 10, 1);
		village.setChef(new Chef("LeChef", 1, village));
		cm = new ControlEmmenager(village);
		cv = new ControlVerifierIdentite(village);
		cp = new ControlPrendreEtal(cv, village);
		cev = new ControlTrouverEtalVendeur(village);
		cl = new ControlLibererEtal(cev);
		cam = new ControlAfficherMarche(village);
	}

	@Test
	void testDonnerInfosMarche() {
		cm.ajouterGaulois("Bonemine", 1);
		cp.prendreEtal("Bonemine", "fleurs", 10);
		String[] actual = cam.donnerInfosMarche();
		String[] expected = {"Bonemine", "10", "fleurs"};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void testDonnerInfosMarcheVide() {
		String[] actual = cam.donnerInfosMarche();
		assertEquals(0, actual.length);
	}

}
