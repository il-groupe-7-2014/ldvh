package ldvh.livre;
import ldvh.interfaces.IContenu;
import ldvh.interfaces.ILivre;

public class GestionLivre extends Livre implements ILivre {
	
	private Livre livre;
	private IContenu contenu;
	
	public boolean sauvegarderLivre(Object Stringfile) {
		return false;
	}
	
	public boolean check() {
		return false;
	}

	public boolean generer() {
		return false;
	}

	public boolean genererPagesHTML() {
		return false;
	}

	
	public boolean genererVersionImprimable() {
		return false;
	}

	
	public boolean genererLivre() {
		return false;
	}

	
	public boolean creerLivre(String titre, String auteur) {
		return false;
	}

	
	public boolean chargerLivre() {
		return false;
	}

	
	public boolean chargerInformationsLivre() {
		return false;
	}

	
	public boolean sauvegarderInformationsLivre() {
		return false;
	}
	
}