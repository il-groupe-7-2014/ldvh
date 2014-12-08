package ldvh.tests;

import java.util.List;

import ldvh.contenu.Section;
import ldvh.interfaces.IContenu;

public class GestionContenuBouchon implements IContenu {
	
	public GestionContenuBouchon() {
		
	}
	
	public int getIdSectionApres(int idEnchainement) {
		return 0;
	}
	
	public int getIdSectionAvant(int idEnchainement) {
		return 0;
	}

	@Override
	public int[] getIdSectionSuivante(int idSection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSection(int idSection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnchainement(int idEnchainement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean viderContenu() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> getNomsObjets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTexteSection(int idSection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int ajouterSection(String nom, String texte) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean supprimerSection(int idSection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimerObjet(String nomObjet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isObjet(String nomObjet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ajouterObjet(String nomObjet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean analyserGraphe() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifierEnchainement(int idSectionAvant, int idSectionApres,
			String texte, List<String> listObjets, int idEnchainement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[] getIdEnchainementsSuivants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTexteEnchainement(int idEnchainement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supprimerEnchainement(int idEnchainement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setPremiereSection(int idSection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifierSection(int idSection, String texte, String nom,
			List<String> listObjets) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int ajouterEnchainement(String description, int avant,
			int apres) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> getNomsObjetsSection(int idSection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getIdSections() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getNomsObjetsEnchainement(int idEnchainement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAllObjets() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getNomSection(int idSection) {
		// TODO Auto-generated method stub
		return null;
	}

}
