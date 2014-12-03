package ldvh.main;
import ihm.graphed.GraphFrame;
import ihm.graphed.SimpleGraph;

import javax.swing.JFrame;

public class LivreEditor
{  
   public static void main(String[] args)
   {  
      JFrame frame = new GraphFrame(new SimpleGraph());
      frame.setVisible(true);
   }
   
}

