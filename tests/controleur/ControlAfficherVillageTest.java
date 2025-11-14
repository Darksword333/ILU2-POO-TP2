package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	
	private ControlEmmenager cm;
	private ControlAfficherVillage cv;

	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("LeVillage", 10, 5);
		village.setChef(new Chef("LeChef", 1, village));
		cm = new ControlEmmenager(village);
		cv = new ControlAfficherVillage(village);
	}

	@Test
	void testNomVillage() {
		assertEquals(cv.donnerNomVillage(), "LeVillage");
	}
	
	@Test
	void testNombreEtal() {
		assertNotEquals(cv.donnerNbEtals(), 6);
	}
	
	@Test
	void testNomsVillageois() {
		String[] villageois = cv.donnerNomsVillageois();
		assertEquals(villageois[0], "LeChef");
		cm.ajouterGaulois("Bonemine", 1);
		assertEquals(villageois.length, 1);
		villageois = cv.donnerNomsVillageois();
		assertEquals(villageois[1], "Bonemine");
		cm.ajouterDruide("Panoramix", 3, 1, 2);
		villageois = cv.donnerNomsVillageois();
		assertEquals(villageois[2], "le druide Panoramix");
	}

}
