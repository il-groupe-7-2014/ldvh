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
	
	Section(Integer id, String texte, String nom) {
		this.id = id;
		this.texte = texte;
		this.nom = nom;
		listeObjets = new ArrayList<Objet>();
		avant = new ArrayList<Enchainement>();
		apres = new ArrayList<Enchainement>();
		etat = new Inatteignable();
	}

	boolean supprimerObjet(Objet objet) {
		if (listeObjets.contains(objet)) {
			System.out.println("il contieneeent=>"+objet.getNom());
			listeObjets.remove(objet);
			return true;
		}
		return false;
	}
	
	void supprimerAllObjets() {
		listeObjets.clear();
	}

	boolean ajouterObjet(Objet objet) {
		if (!listeObjets.contains(objet)) {
			listeObjets.add(objet);
			return true;
		}
		return false;
	}

	 boolean ajouterEnchainementAvant(Enchainement enchainement) {
		if (!avant.contains(enchainement)) {
			avant.add(enchainement);
			return true;
		}
		return false;
	}

	boolean ajouterEnchainementApres(Enchainement enchainement) {
		if (!apres.contains(enchainement)) {
			apres.add(enchainement);
			return true;
		}
		return false;
	}

	boolean supprimerEnchainementAvant(Enchainement enchainement) {
		if (avant.contains(enchainement)) {
			avant.remove(enchainement);
			return true;
		}
		return false;
	}

	 boolean supprimerEnchainementApres(Enchainement enchainement) {
		if (apres.contains(enchainement)) {
			apres.remove(enchainement);
			return true;
		}
		return false;
	}

	 List <Enchainement> getListEnchainementAvant() {
		return avant;
	}
	
	 List <Enchainement> getListEnchainementApres() {
		return apres;
	}

	 boolean setTexte(String texte) {
		this.texte = texte;
		return true;
	}

	 boolean setNom(String nom) {
		this.nom = nom;
		return true;
	}
	
	 Integer getId() {
		return id;
	}

	 void setId(Integer id) {
		this.id = id;
	}

	 List<String> getNomsObjets() {
		ArrayList <String> listeNoms = new ArrayList <String> ();
		for (int i = 0, length = listeObjets.size(); i < length; ++i) {
			listeNoms.add(listeObjets.get(i).getNom());
		}
		return listeNoms;
	 }

	 String getTexte() {
		return this.texte;
	}

	 String getNom() {
		return this.nom;
	}
	
}