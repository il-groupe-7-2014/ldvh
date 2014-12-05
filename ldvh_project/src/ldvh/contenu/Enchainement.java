package ldvh.contenu;

import java.util.ArrayList;
import java.util.List;

public class Enchainement {
	
	private String description;
	private Integer id;
	private Section sectionAvant;
	private Section sectionApres;
	private List <Objet> objets;
	
	protected Enchainement(int id, String description, Section sectionAvant, Section sectionApres) {
		this.id = id;
		this.description = description;
		this.sectionAvant = sectionAvant;
		this.sectionApres = sectionApres;
		this.objets = new ArrayList<Objet>();
	}
	
	protected boolean modifierSectionAvant(Section section) {
		this.sectionAvant = section;
		return true;
	}

	protected boolean modifierSectionApres(Section section) {
		this.sectionApres = section;
		return true;
	}

	protected boolean setDescription(String description) {
		this.description = description;
		return true;
	}
	
	protected List<String> getNomsObjets() {
		ArrayList <String> listeNoms = new ArrayList <String> ();
		for (int i = 0, length = objets.size(); i < length; ++i) {
			listeNoms.add(objets.get(i).getNom());
		}
		return listeNoms;
	}

	protected boolean ajouterObjet(Objet nom) {
		if (!this.objets.contains(nom)) {
			this.objets.add(nom);
			return true;
		}
		return false;
	}
	
	protected boolean supprimerObjet(Objet nom) {
		if (this.objets.remove(nom)) {
			return true;
		}
		return false;
	}
}