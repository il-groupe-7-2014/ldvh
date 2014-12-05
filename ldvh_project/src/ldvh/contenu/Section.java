package ldvh.contenu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Section {
	
	private String texte;
	private Integer id;
	private String nom;
	private List<Objet> listeObjets;
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

	protected boolean supprimerObjet(String nom) {
		Iterator<Objet> ite = listeObjets.iterator();
		while(ite.hasNext()) {
			Objet o = ite.next();
			if(o.getNom().compareTo(nom)==0) {
				listeObjets.remove(o);
				return true;
			}
		}
		return false;
	}

	protected boolean ajouterObjet(String nom) {
		listeObjets.add(new Objet(nom));
		return true;
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

	protected List<Objet> getListeObjets() {
		return listeObjets;
	}

	protected String getTexte() {
		return texte;
	}

	protected String getNom() {
		return nom;
	}
	
}