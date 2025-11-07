package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {

	private ControlEmmenager cm;
	
	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("LeVillage", 10, 5);
		village.setChef(new Chef("LeChef", 1, village));
		cm = new ControlEmmenager(village);
	}

	@Test
	void testAjouterGaulois() {
		assertFalse(cm.isHabitant("Bonemine"));
		cm.ajouterGaulois("Bonemine", 1);
		assertTrue(cm.isHabitant("Bonemine"));
	}
	
	@Test
	void testChefisHabitant() {
		assertTrue(cm.isHabitant("LeChef"));
	}
	
	@Test
	void testExceptionSansChef() {
		Village v = new Village("VillageSansChef", 5, 5);
		ControlEmmenager boum = new ControlEmmenager(v);
		assertThrows(RuntimeException.class, () -> boum.isHabitant("Bonemine"));
		v.setChef(new Chef("LeChef", 1, v));
		assertDoesNotThrow(() -> boum.isHabitant("Bonemine"));
	}
	
	@Test
	void testAjouterTropHabitants() {
		for (int i = 0; i<100; i++) {
			cm.ajouterDruide("D"+i, 1, 0, 1);
		}
		for (int i = 0; i<100; i++) {
			if (i<10) {
				assertTrue(cm.isHabitant("D"+i));
			}
			else {
				assertFalse(cm.isHabitant("D"+i));
			}
		}
	}

}
