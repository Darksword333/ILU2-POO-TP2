package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = this.controlLibererEtal.isVendeur(nomVendeur);
		String[] data;
		if (!vendeurReconnu) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !\n");
		}
		else {
			data = this.controlLibererEtal.libererEtal(nomVendeur);
			if (Boolean.parseBoolean(data[0])) {
				System.out.println("Vous avez vendu " + data[4] + " sur " + data[3] + " "
									+ data[2] + ".\n");
				System.out.println("Au revoir " + nomVendeur + ", passez une bonne journée\n");
			}
		}
	}

}
