package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] data = this.controlAfficherMarche.donnerInfosMarche();
		String vendeur, produit;
		int quantite;
		
		if (data.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard.\n");
		}
		else {
			System.out.println(nomAcheteur + " vous trouverez au marché :\n");
			for (int i = 0, j = 0; i < data.length; i++) {
				vendeur = data[i];
				i++;
				quantite = data[i];
				i++;
				produit = data[i];
			}
		}
	}
}
