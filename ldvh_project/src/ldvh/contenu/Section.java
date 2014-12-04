package ldvh.contenu;

import java.util.List;
import java.util.Set;

public class Section {
	
	private String texte;
	private Integer id;
	private String nom;
	private List<Objet> listeObjet;
	private Set<Enchainement> avant;
	private Set<Enchainement> apres;
	private Etat etat;
	private Set<Objet> objets;

	public boolean supprimerObjet(String nom) {
		return false;
	}

	public boolean ajouterObjet(String nom) {
		return false;
	}

	public boolean ajouterEnchainementAvant(Enchainement idEnchainement) {
		return false;
	}

	public boolean ajouterEnchainementApres(Enchainement idEnchainement) {
		return false;
	}

	public boolean supprimerEnchainementAvant(Enchainement idEnchainement) {
		return false;
	}

	public boolean supprimerEnchainementApres(Enchainement idEnchainement) {
		return false;
	}

	public boolean setTexte(String texte) {
		this.texte = texte;
		return true;
	}

	public boolean setNom(String nom) {
		this.nom = nom;
		return true;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Objet> getListeObjet() {
		return listeObjet;
	}

	public String getTexte() {
		return texte;
	}

	public String getNom() {
		return nom;
	}
	
}