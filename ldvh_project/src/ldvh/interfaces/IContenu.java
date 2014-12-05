package ldvh.interfaces;

import java.util.List;
import java.util.Set;

import ldvh.contenu.Section;


public interface IContenu {
	
	public int[] getIdSectionSuivante(int idSection);
	
	public boolean isSection(int idSection);
	
	public boolean isEnchainement(int idEnchainement);
	
	public boolean viderContenu();
	
	public List <String> getNomsObjets();
	
	public String getTexteSection(int idSection);
	
	public boolean ajouterSection(String nom, String texte);
	
	public boolean supprimerSection(int idSection);
	
	public boolean supprimerObjet(String nomObjet);
	
	public boolean isObjet(String nomObjet);
	
	public boolean ajouterObjet(String nomObjet);
	
	public boolean analyserGraphe();
	
	public boolean modifierEnchainement(int idSectionAvant, int idSectionApres,
			String texte, List <String> listObjets, int idEnchainement);
	
	public int[] getIdEnchainementsSuivants();
	
	public String getTexteEnchainement(int idEnchainement);
	
	public boolean supprimerEnchainement(int idEnchainement);
	
	public boolean setPremiereSection(int idSection);
	
	public boolean modifierSection(int idSection, String texte, List <String> listObjets);
	
	public boolean ajouterEnchainement(String description, Section avant, Section apres);
	
	public List <String> getNomsObjetsSection(int idSection);
	
	public int[] getIdSections();
	
	public List <String> getNomsObjetsEnchainement(int idEnchainement);
	
	public List<String> getListeObjets();
	
	public boolean deleteAllObjets();
	
	public String getNomSection(int idSection);
	
}