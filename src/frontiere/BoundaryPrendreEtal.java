package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		StringBuilder q1 = new StringBuilder(), q2 = new StringBuilder();
		String produit;
		int quantite;
		
		// Déterminer le produit
		q1.append("Il me faudrait quelques renseignements :\n");
		q1.append("Quel produit souhaitez-vous vendre ?\n");
		String choixUtilisateur1;
		int choixUtilisateur2;
		choixUtilisateur1 = Clavier.entrerChaine(q1.toString());
		produit = choixUtilisateur1;
		
		// Determiner la quantité du produit
		q2.append("Combien souhaitez-vous en vendre ?\n");
		choixUtilisateur2 = Clavier.entrerEntier(q2.toString());
		quantite = choixUtilisateur2;
		
		this.controlPrendreEtal.prendreEtal(nomVendeur, produit, quantite);
	}

	private void installerVendeur(String nomVendeur) {
		if (this.controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Bonjour " + nomVendeur +
					", je vais regarder si je peux vous trouver un étal.\n");
			if (this.controlPrendreEtal.resteEtals()) {
				System.out.println("C'est parfait, il me reste un étal pour vous !\n");
				this.prendreEtal(nomVendeur);
			}
			else {
				System.out.println("Désolée " + nomVendeur + 
						" je n'ai plus d'étal qui ne soit pas déjà occupé.\n");
			}
		}
		else {
			System.out.println("Je suis désolée " + nomVendeur + 
					" mais il faut être un habitant de notre village pour commercer ici.\n");
		}
	}
}
