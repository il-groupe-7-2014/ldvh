package ldvh.tests;

import static org.junit.Assert.assertTrue;
import ldvh.livre.GestionLivre;

import org.junit.Test;

public class TestCLivre {
	
	@Test
	public void test() {
		GestionContenuBouchon contenuBouchon = new GestionContenuBouchon();
		GestionLivre livre = new GestionLivre(contenuBouchon);
		
		String titre = "MonLivre";
		String auteur = "Bob";
		livre.creerLivre(titre, auteur);
		
		assertTrue(livre.getTitre().equals(titre));
		assertTrue(livre.getAuteur().equals(auteur));
		assertTrue(contenuBouchon.equals(livre.getContenu()));
		
	}
}
