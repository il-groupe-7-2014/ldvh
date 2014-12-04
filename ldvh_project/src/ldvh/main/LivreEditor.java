package ldvh.main;
import javax.swing.JFrame;

import ldvh.ihm.graphed.GraphFrame;
import ldvh.ihm.graphed.SimpleGraph;
import ldvh.livre.GestionLivre;

public class LivreEditor {
	
   public static void main(String[] args) { 
      JFrame frame = new GraphFrame(new SimpleGraph());
      frame.setVisible(true);
   }
   
}