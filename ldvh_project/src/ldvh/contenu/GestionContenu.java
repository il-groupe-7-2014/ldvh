package ldvh.contenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ldvh.interfaces.IContenu;


public class GestionContenu implements IContenu {
	
	private HashMap<Integer,Section> hashMapSections;
	private HashMap<Integer,Enchainement> hashMapEnchainements;
	private List<Objet> listeObjets;
	
	public GestionContenu() {
		hashMapSections = new HashMap<Integer,Section>();
		hashMapEnchainements = new HashMap<Integer,Enchainement>();
		listeObjets = new ArrayList<Objet>();
	}

	public int[] getIdSectionSuivante(int idSection) {
		return null;
	}

	
	public boolean isSection(int idSection) {
		return false;
	}

	
	public boolean isEnchainement(int idEnchainement) {
		return false;
	}

	
	public boolean viderContenu() {
		hashMapSections.clear();
		hashMapEnchainements.clear();
		listeObjets.clear();
		return true;
	}

	
	public Set<String> getNomsObjets() {
		return null;
	}

	
	public String getTexteSection(int idSection) {
		return null;
	}

	
	public boolean ajouterSection() {
		return false;
	}

	
	public boolean supprimerSection(int idSection) {
		return false;
	}

	
	public boolean supprimerObjet(String nomObjet) {
		Iterator<Objet> ite = listeObjets.iterator();
		while(ite.hasNext()) {
			Objet o = ite.next();
			if(o.getNom().compareTo(nomObjet)==0) {
				listeObjets.remove(o);
				return true;
			}
		}
		return false;
	}

	
	public boolean isObjet(String nomObjet) {
		Iterator<Objet> ite = listeObjets.iterator();
		while(ite.hasNext()) {
			Objet o = ite.next();
			if(o.getNom().compareTo(nomObjet)==0) {
				return true;
			}
		}
		return false;
	}

	
	public boolean ajouterObjet(String nomObjet) {
		listeObjets.add(new Objet(nomObjet));
		return true;
	}

	
	public boolean analyserGraphe() {
		return false;
	}

	
	public boolean modifierEnchainement(int idSectionAvant, int idSectionApres,
			String texte, Set<String> listObjets, int idEnchainement) {
		return false;
	}

	
	public int[] getIdEnchainementsSuivants() {
		return null;
	}

	
	public String getTexteEnchainement(int idEnchainement) {
		return null;
	}

	
	public boolean supprimerEnchainement(int idEnchainement) {
		return false;
	}

	
	public boolean setPremiereSection(int idSection) {
		return false;
	}

	
	public boolean modifierSection(int idSection, String texte,
			String... listObjets) {
		return false;
	}

	
	public boolean ajouterEnchainement() {
		return false;
	}

	
	public Set<String> getNomsObjetsSection(int idSection) {
		return null;
	}

	
	public int[] getIdSections() {
		return null;
	}

	
	public Set<String> getNomsObjetsEnchainement(int idEnchainement) {
		return null;
	}
	
}