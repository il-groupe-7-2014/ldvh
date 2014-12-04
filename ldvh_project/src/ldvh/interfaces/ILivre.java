package ldvh.interfaces;

public interface ILivre {
	
	public boolean sauvegarderLivre(Object Stringfile);

	public boolean check();

	public boolean generer();
	
	public boolean genererPagesHTML();
	
	public boolean genererVersionImprimable();
	
	public boolean genererLivre();
	
	public boolean creerLivre(String titre, String auteur);
	
	public boolean chargerLivre();
	
	public boolean chargerInformationsLivre();

	public boolean sauvegarderInformationsLivre();
	
}