package ldvh.contenu;

import java.util.ArrayList;
import java.util.List;

public class Enchainement {
	
	private String description;
	private Integer id;
	private Section sectionAvant;
	private Section sectionApres;
	private List <Objet> listeObjets;
	
	Enchainement(int id, String description, Section sectionAvant, Section sectionApres) {
		this.id = id;
		this.description = description;
		this.sectionAvant = sectionAvant;
		this.sectionApres = sectionApres;
		this.listeObjets = new ArrayList<Objet>();
	}
	
	boolean modifierSectionAvant(Section section) {
		this.sectionAvant = section;
		return true;
	}

	boolean modifierSectionApres(Section section) {
		this.sectionApres = section;
		return true;
	}

	boolean setDescription(String description) {
		this.description = description;
		return true;
	}
	
	boolean supprimer() {
		sectionAvant.supprimerEnchainementAvant(this);
		sectionApres.supprimerEnchainementApres(this);
		return true;
	}
	
	List<String> getNomsObjets() {
		ArrayList <String> listeNoms = new ArrayList <String> ();
		for (int i = 0, length = listeObjets.size(); i < length; ++i) {
			listeNoms.add(listeObjets.get(i).getNom());
		}
		return listeNoms;
	}

	boolean ajouterObjet(Objet objet) {
		if (!this.listeObjets.contains(objet)) {
			this.listeObjets.add(objet);
			return true;
		}
		return false;
	}
	
	boolean supprimerObjet(Objet objet) {
		if (this.listeObjets.contains(objet)) {
			this.listeObjets.remove(objet);
			return true;
		}
		return false;
	}
	
	String getDescription() {
		return this.description;
	}
	
	int getId() {
		return id;
	}
	
	int getIdSectionApres() {
		return sectionApres.getId();
	}
	
	int getIdSectionAvant() {
		return sectionAvant.getId();
	}
	
}