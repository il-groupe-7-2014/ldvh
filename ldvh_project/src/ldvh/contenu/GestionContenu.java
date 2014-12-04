package ldvh.contenu;

import java.util.Set;
import ldvh.interfaces.IContenu;


public class GestionContenu implements IContenu {
	
	private Set<Objet> listeObjet;
	private Set<Section> listeSections;
	private Set<Objet> listeObjets;
	private Set<Enchainement> enchainements;

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
		return false;
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
		return false;
	}

	
	public boolean isObjet(String nomObjet) {
		return false;
	}

	
	public boolean ajouterObjet(String nomObjet) {
		return false;
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