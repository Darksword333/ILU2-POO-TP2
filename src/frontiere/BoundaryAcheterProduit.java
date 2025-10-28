package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		int nombre = -1, achatTotal = -1, numVendeur;
		String produit, nomVendeur, resultat = "Erreur achat\n"; // Si une erreur survient
		StringBuilder sb = new StringBuilder();
		if (this.controlAcheterProduit.verifierGaulois(nomAcheteur)) {
			
			produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?\n");
		
			sb.append("Chez quel commerçant voulez-vous acheter des " + produit + " ?\n");
			Gaulois[] marchands = this.controlAcheterProduit.chercherMarchand(produit);
			
			for (int i = 0; i < marchands.length; i++) {
				sb.append((i+1) + " - " + marchands[i].getNom() + "\n");
			}
			numVendeur = Clavier.entrerEntier(sb.toString());
			nomVendeur = marchands[numVendeur-1].getNom();
			
			nombre = Clavier.entrerEntier("Combien de fleurs voulez-vous acheter ?\n");
			
			achatTotal = this.controlAcheterProduit.acheterProduit(nomVendeur, nombre);
			
			if (nombre == achatTotal)
				resultat = nomAcheteur + " achète " + achatTotal + " " + produit + " à " + nomVendeur;
			else if (nombre > achatTotal)
				resultat = nomAcheteur + " veut acheter " + nombre + " " + produit + ", malheureusement " +
						nomVendeur + " n’en a plus que " + achatTotal + ".\n" + nomAcheteur + " achète tout le stock de " +
						nomVendeur + ".\n";
			else if (achatTotal == 0)
				resultat = nomAcheteur + " veut acheter " + nombre + " " + produit + ", malheureusement il n'y en a plus !\n";
			else if (achatTotal == -1) // normalement inutile car vérifié avant quand le vendeur veut s'installer
				resultat = "Je suis désolé " + nomVendeur +  "mais il faut être un habitant de notre village pour commercer ici.\n";
			
			System.out.println(resultat);
		}
		else {
			System.out.println("Je suis désolé " + nomAcheteur +  "mais il faut être un habitant de notre village pour commercer ici.\n");
		}
	}
}
