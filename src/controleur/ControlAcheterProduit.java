package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierGaulois(String nom) {
		return this.controlVerifierIdentite.verifierIdentite(nom);
	}
	
	public String[] chercherMarchand (String produit) {
		Gaulois[] marchands = this.village.rechercherVendeursProduit(produit);
		if (marchands == null)
			return new String[0];
		String[] nomMarchands = new String[marchands.length];
		for (int i = 0; i< marchands.length;i++)
			nomMarchands[i] = marchands[i].getNom();
		return nomMarchands;
	}
	
	public int acheterProduit(String nomMarchand, int quantite) {
		int nbAchat = -1; // Renvoie -1 si le vendeur ne fait pas partie du village
		if (this.verifierGaulois(nomMarchand)) {
			Etal etal = this.controlTrouverEtalVendeur.trouverEtalVendeur(nomMarchand);
			nbAchat = etal.acheterProduit(quantite);
		}
		return nbAchat;
	}
}
