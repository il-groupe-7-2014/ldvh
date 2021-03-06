package ldvh.contenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import ldvh.interfaces.IContenu;


public class GestionContenu implements IContenu {
	
	private HashMap<Integer,Section> hashMapSections;
	private HashMap<Integer,Enchainement> hashMapEnchainements;
	private List<Objet> listeObjets;
	private Random rng;

	public GestionContenu() {
		hashMapSections = new HashMap<Integer,Section>();
		hashMapEnchainements = new HashMap<Integer,Enchainement>();
		listeObjets = new ArrayList<Objet>();
		rng = new Random();
	}

	public int[] getIdSectionSuivante(int idSection) {
		return null;
	}
	
	public int getIdSectionApres(int idEnchainement) {
		Enchainement en = hashMapEnchainements.get(idEnchainement);
		return en.getIdSectionApres();
	}
	
	public int getIdSectionAvant(int idEnchainement) {
		Enchainement en = hashMapEnchainements.get(idEnchainement);
		return en.getIdSectionAvant();
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
	
	public boolean deleteAllObjets() {
		boolean bool = true;
		for(Entry <Integer, Section> entry : hashMapSections.entrySet()) {
			entry.getValue().supprimerAllObjets();
		}
		return bool;
	}
	
	public String getTexteSection(int idSection) {
		return hashMapSections.get(idSection).getTexte();
	}
	
	public String getNomSection(int idSection){
		return hashMapSections.get(idSection).getNom();
	}
	
	public int ajouterSection(String nom, String texte) {
		int id = 0;
		do {
			id = rng.nextInt();
		} while (hashMapSections.containsKey(id));
		hashMapSections.put(id, new Section(id, texte, nom));
		return id;
	}
	
	public boolean supprimerSection(int idSection) {
		List <Enchainement> liste = hashMapSections.get(idSection).getListEnchainementAvant();
		for(Enchainement e : liste){
			e.supprimer();
			hashMapEnchainements.remove(e.getId());
		}
		liste = hashMapSections.get(idSection).getListEnchainementApres();
		for(Enchainement e : liste){
			e.supprimer();
			hashMapEnchainements.remove(e.getId());
		}
		hashMapSections.remove(idSection);
		return true;
	}

	public boolean supprimerObjet(String nomObjet) {
		int objet = -1;
		for (int i = 0, length = listeObjets.size(); i < length && objet == -1; ++i) {
			if (listeObjets.get(i).getNom().compareTo(nomObjet) == 0) {
				objet = i;
			}
		}
		for(Entry <Integer, Enchainement> entry : hashMapEnchainements.entrySet()) {
			entry.getValue().supprimerObjet(listeObjets.get(objet));
		}
		for(Entry <Integer, Section> entry : hashMapSections.entrySet()) {
			entry.getValue().supprimerObjet(listeObjets.get(objet));
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
		Enchainement e = hashMapEnchainements.get(idEnchainement);
		e.setDescription(texte);
		
		return true;
	}

	public int[] getIdEnchainementsSuivants() {
		return null;
	}

	public String getTexteEnchainement(int idEnchainement) {
		return hashMapEnchainements.get(idEnchainement).getDescription();
	}

	public boolean supprimerEnchainement(int idEnchainement) {
		if (!hashMapEnchainements.containsKey(idEnchainement)) {
			return false;
		}
		Enchainement enchainement = hashMapEnchainements.get(idEnchainement);
		enchainement.supprimer();
		hashMapEnchainements.remove(idEnchainement);
		return true;
	}

	public boolean setPremiereSection(int idSection) {
		return false;
	}

	public boolean modifierSection(int idSection, String texte, String nom, List<String> listObjets) {
		if (hashMapSections.containsKey(idSection)) {
			Section s = this.hashMapSections.get(idSection);
			s.setTexte(texte);
			s.setNom(nom);
			s.supprimerAllObjets();
			for (String nomObjet : listObjets) {
				s.ajouterObjet(new Objet(nomObjet));
			}
			return true;
		}
		return false;
	}

	public int ajouterEnchainement(String description, int avant, int apres) {
		int id = 0;
		do {
			id = rng.nextInt();
		} while (hashMapEnchainements.containsKey(id));
		hashMapEnchainements.put(id, new Enchainement(id, description, hashMapSections.get(avant), hashMapSections.get(apres)));
		return id;
	}

	public List <String> getNomsObjetsSection(int idSection) {
		return hashMapSections.get(idSection).getNomsObjets();
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
		return new ArrayList<String>();
	}
	
}