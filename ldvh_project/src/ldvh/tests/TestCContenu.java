package ldvh.tests;

import static org.junit.Assert.assertTrue;

import java.util.List;

import ldvh.contenu.GestionContenu;

import org.junit.Test;

public class TestCContenu {
	
	@Test
	public void test() {
		String texteAvant =  "Section avant";
		String texteApres =  "Section après";
		String texteObjetHache = "Hache";
		String texteObjetBouclier = "Bouclier";
		
		GestionContenu contenu = new GestionContenu();
		
		contenu.ajouterSection("Avant", texteAvant);
		contenu.ajouterSection("Après", texteApres);
		contenu.ajouterObjet(texteObjetHache);
		contenu.ajouterObjet(texteObjetBouclier);
		
		int idsSections[] = contenu.getIdSections();
		List<String> objets = contenu.getNomsObjets();
		
		assertTrue(contenu.getTexteSection(idsSections[0]).equals(texteAvant));
		assertTrue(contenu.getTexteSection(idsSections[1]).equals(texteApres));
		assertTrue(objets.get(0).equals(texteObjetHache));
		assertTrue(objets.get(1).equals(texteObjetBouclier));
		
		contenu.deleteAllObjets();
		
		objets = contenu.getNomsObjets();
		assertTrue(objets.size() == 0);
	}
}
