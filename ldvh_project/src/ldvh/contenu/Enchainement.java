package ldvh.contenu;

import java.util.Set;

public class Enchainement {
	
	private String description;
	private Integer id;
	private Section sectionAvant;
	private Section sectionApres;
	private Set<Objet> objets;

	public boolean modifierSectionAvant(Enchainement idSection) {
		return false;
	}

	public boolean modifierSectionApres(Enchainement idSection) {
		return false;
	}

	public boolean setDescription(String description) {
		return false;
	}

	public boolean ajouterObjet(String nom) {	
		return false;
	}
	
	public boolean supprimerObjet(String nom) {
		return false;
	}
	
}