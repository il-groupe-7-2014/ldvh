package ldvh.contenu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Section {
	
	private String texte;
	private Integer id;
	private String nom;
	private List <Objet> listeObjets;
	private List<Enchainement> avant;
	private List<Enchainement> apres;
	private Etat etat;
	
	protected Section(Integer id, String texte, String nom) {
		this.id = id;
		this.texte = texte;
		this.nom = nom;
		listeObjets = new ArrayList<Objet>();
		avant = new ArrayList<Enchainement>();
		apres = new ArrayList<Enchainement>();
		etat = new Inatteignable();
	}

	protected boolean supprimerObjet(Objet objet) {
		if (listeObjets.contains(objet)) {
			listeObjets.remove(objet);
			return true;
		}
		return false;
	}

	protected boolean ajouterObjet(Objet objet) {
		if (!listeObjets.contains(objet)) {
			listeObjets.add(objet);
			return true;
		}
		return false;
	}

	protected boolean ajouterEnchainementAvant(Enchainement enchainement) {
		if (!avant.contains(enchainement)) {
			avant.add(enchainement);
			return true;
		}
		return false;
	}

	protected boolean ajouterEnchainementApres(Enchainement enchainement) {
		if (!apres.contains(enchainement)) {
			apres.add(enchainement);
			return true;
		}
		return false;
	}

	protected boolean supprimerEnchainementAvant(Enchainement enchainement) {
		if (avant.contains(enchainement)) {
			avant.remove(enchainement);
			return true;
		}
		return false;
	}

	protected boolean supprimerEnchainementApres(Enchainement enchainement) {
		if (apres.contains(enchainement)) {
			apres.remove(enchainement);
			return true;
		}
		return false;
	}

	protected List <Enchainement> getListEnchainementAvant() {
		return avant;
	}
	
	protected List <Enchainement> getListEnchainementApres() {
		return apres;
	}

	protected boolean setTexte(String texte) {
		this.texte = texte;
		return true;
	}

	protected boolean setNom(String nom) {
		this.nom = nom;
		return true;
	}
	
	protected Integer getId() {
		return id;
	}

	protected void setId(Integer id) {
		this.id = id;
	}

	protected List<String> getNomsObjets() {
		ArrayList <String> listeNoms = new ArrayList <String> ();
		for (int i = 0, length = listeObjets.size(); i < length; ++i) {
			listeNoms.add(listeObjets.get(i).getNom());
		}
		return listeNoms;
	}

	protected String getTexte() {
		return this.texte;
	}

	protected String getNom() {
		return this.nom;
	}
	
}