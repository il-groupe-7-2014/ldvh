package ldvh.livre;

public class Livre {
	
	private String titre;
	private String auteur;
	
	public Livre() {
		this("","");
	}
	
	public Livre(String titre) {
		this(titre,"");
	}
	
	public Livre(String titre, String auteur) {
		this.setTitre(titre);
		this.setAuteur(auteur);
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
}