package ldvh.main;
import javax.swing.*;

import frm.graphed.GraphFrame;
import frm.graphed.SimpleGraph;

public class LivreEditor
{  
   public static void main(String[] args)
   {  
      JFrame frame = new GraphFrame(new SimpleGraph());
      frame.setVisible(true);
   }
   
}

