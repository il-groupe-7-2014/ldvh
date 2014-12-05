package ldvh.livre;
import ldvh.contenu.GestionContenu;
import ldvh.interfaces.IContenu;
import ldvh.interfaces.ILivre;

public class GestionLivre extends Livre implements ILivre {
	
	private Livre livre;
	private IContenu contenu;
	
	public GestionLivre() {
		
	}
	
	public Livre getLivre() {
		return livre;
	}
	
	public IContenu getContenu() {
		return contenu;
	}
	
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
		livre = new Livre(titre,auteur);
		contenu = new GestionContenu();
		return true;
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