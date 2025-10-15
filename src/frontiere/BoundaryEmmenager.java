package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		int force, pmin, pmax;
		StringBuilder q1 = new StringBuilder(), q2 = new StringBuilder(), q3 = new StringBuilder();
		
		// Création des questions
		q1.append("Bienvenue Druide " + nomVisiteur + "\n");
		q1.append("Quelle est votre force ?\n");
		q2.append("Quelle est la force de la potion la plus faible que vous produisez\n");
		q3.append("Quelle est la force de la potion la plus forte que vous produisez\n");
		
		// Determiner la force
		int choixUtilisateur = -1;
		choixUtilisateur = Clavier.entrerEntier(q1.toString());
		force = choixUtilisateur;
		
		do {
			// Determiner l'effet min de la potion
			choixUtilisateur = Clavier.entrerEntier(q2.toString());
			pmin = choixUtilisateur;
		
			// Determiner l'effet max de la potion
			choixUtilisateur = Clavier.entrerEntier(q3.toString());
			pmax = choixUtilisateur;
			
			if (pmin >= pmax)
				System.out.println("Attention druide, vous vous êtes trompé entre le minimum et le maximum\n");
		} while (pmin > pmax);
		
		
		this.controlEmmenager.ajouterDruide(nomVisiteur, force, pmin, pmax);
	}
	
	private void emmenagerGaulois(String nomVisiteur) {
		int force;
		StringBuilder question = new StringBuilder();
		
		// Determiner la force
		question.append("Bienvenue villageois " + nomVisiteur + "\n");
		question.append("Quelle est votre force ?\n");
		int choixUtilisateur = -1;
		choixUtilisateur = Clavier.entrerEntier(question.toString());
		force = choixUtilisateur;
		
		this.controlEmmenager.ajouterGaulois(nomVisiteur, force);
	}
}
