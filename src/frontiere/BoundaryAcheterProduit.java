package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		int nombre = -1, achatTotal = -1, numVendeur;
		String produit, nomVendeur, resultat = "Erreur achat\n"; // Si une erreur survient
		StringBuilder sb = new StringBuilder();
		if (this.controlAcheterProduit.verifierGaulois(nomAcheteur)) { // Si l'acheteur fait bien parti du village
			
			produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?\n");
		
			sb.append("Chez quel commerçant voulez-vous acheter des " + produit + " ?\n");
			String[] marchands = this.controlAcheterProduit.chercherMarchand(produit);
			
			if (marchands != null) { // Si le produit est bien sur le marché
		
				for (int i = 0; i < marchands.length; i++) {
					sb.append((i+1) + " - " + marchands[i] + "\n");
				}
				numVendeur = Clavier.entrerEntier(sb.toString());
				nomVendeur = marchands[numVendeur-1];
				
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
			}
			else
				resultat = "Désolé, personne ne vend ce produit au marché.\n";
				
			System.out.println(resultat);
		}
		else {
			System.out.println("Je suis désolé " + nomAcheteur +  " mais il faut être un habitant de notre village pour commercer ici.\n");
		}
	}
}
