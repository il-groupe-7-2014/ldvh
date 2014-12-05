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
		return hashMapSections.containsKey(idSection);
	}

	public boolean isEnchainement(int idEnchainement) {
		return hashMapEnchainements.containsKey(idEnchainement);
	}
	
	public boolean viderContenu() {
		hashMapSections.clear();
		hashMapEnchainements.clear();
		listeObjets.clear();
		return true;
	}

	public List <String> getNomsObjets() {
		ArrayList <String> listeNoms = new ArrayList <String> ();
		for (int i = 0, length = listeObjets.size(); i < length; ++i) {
			listeNoms.add(listeObjets.get(i).getNom());
		}
		return listeNoms;
	}
	
	public String getTexteSection(int idSection) {
		return hashMapSections.get(idSection).getTexte();
	}
	
	public boolean ajouterSection(String nom, String texte) {
		hashMapSections.put(hashMapSections.size(), new Section(hashMapSections.size(), texte, nom));
		return true;
	}
	
	public boolean supprimerSection(int idSection) {
		List <Enchainement> liste = hashMapSections.get(idSection).getListEnchainementAvant();
		for (int i = 0, length = liste.size(); i < length; ++i) {
			liste.get(i).supprimer();
		}
		liste = hashMapSections.get(idSection).getListEnchainementApres();
		for (int i = 0, length = liste.size(); i < length; ++i) {
			liste.get(i).supprimer();
		}
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
			String texte, List <String> listObjets, int idEnchainement) {
		
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

	public boolean modifierSection(int idSection, String texte, List <String> listObjets) {
		return false;
	}

	public boolean ajouterEnchainement(String description, Section avant, Section apres) {
		int id = hashMapEnchainements.size() + 1;
		Enchainement enchainement = new Enchainement(id, description, avant, apres);
		hashMapEnchainements.put(id, enchainement);
		return true;
	}

	public List <String> getNomsObjetsSection(int idSection) {
		return null;
	}

	public int [] getIdSections() {
		Set <Integer> set = hashMapSections.keySet();
		int [] tableId = new int[set.size()];
		int i = 0;
		for (Iterator <Integer> lol = set.iterator(); lol.hasNext(); ++i) {
			tableId[i] = lol.next();
		}
		return tableId;
	}
	
	public List <String> getNomsObjetsEnchainement(int idEnchainement) {
		Enchainement enchainement = hashMapEnchainements.get(idEnchainement);
		if (enchainement != null)
			return enchainement.getNomsObjets();
		return null;
	}
}