package ldvh.ihm.graphed;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import ldvh.livre.GestionLivre;

/**
   A tool bar that contains node and edge prototype icons.
   Exactly one icon is selected at any time.
*/
public class ToolBar extends JPanel
{
	
	private static final int BUTTON_SIZE = 25;
	private static final int OFFSET = 4;

	private ButtonGroup group;
	private ArrayList tools;
	private GestionLivre gestionLivre;
	
   /**
      Constructs a tool bar with no icons.
   */
   public ToolBar(Graph graph, GestionLivre gestionLivre)
   {
      this.group = new ButtonGroup();
      this.tools = new ArrayList();
      this.gestionLivre = gestionLivre;

      JToggleButton grabberButton = new JToggleButton(new 
         Icon()
         {
            public int getIconHeight() { return BUTTON_SIZE; }
            public int getIconWidth() { return BUTTON_SIZE; }
            public void paintIcon(Component c, Graphics g,
               int x, int y)
            {
               Graphics2D g2 = (Graphics2D) g;
               GraphPanel.drawGrabber(g2, x + OFFSET, y + OFFSET);
               GraphPanel.drawGrabber(g2, x + OFFSET, y + BUTTON_SIZE - OFFSET);
               GraphPanel.drawGrabber(g2, x + BUTTON_SIZE - OFFSET, y + OFFSET);
               GraphPanel.drawGrabber(g2, x + BUTTON_SIZE - OFFSET, y + BUTTON_SIZE - OFFSET);
            }
         });
      group.add(grabberButton);      
      add(grabberButton);
      grabberButton.setSelected(true);
      tools.add(null);

      Node[] nodeTypes = graph.getNodePrototypes();
      for (int i = 0; i < nodeTypes.length; i++)
         add(nodeTypes[i]);
      Edge[] edgeTypes = graph.getEdgePrototypes();
      for (int i = 0; i < edgeTypes.length; i++)
         add(edgeTypes[i]);
      
		JButton addObjetButton = new JButton(new Icon() {
			public int getIconHeight() { return BUTTON_SIZE; }
			public int getIconWidth() { return BUTTON_SIZE; }

			public void paintIcon(Component c, Graphics g, int x, int y) {
				Graphics2D g2 = (Graphics2D) g;
				GraphPanel.drawGrabber(g2, x + BUTTON_SIZE/2, y + BUTTON_SIZE/2);
			}
		});
      group.add(addObjetButton);
      add(addObjetButton);
      
      addObjetButton.addActionListener(new ActionListener() {
    		  
    	  public void actionPerformed(ActionEvent e) {
    		  String nomObjet = JOptionPane.showInputDialog(ToolBar.this,"Nom de l'objet : ","Créer un objet",1);
    		  ToolBar.this.gestionLivre.getContenu().ajouterObjet(nomObjet);
    	  }
    	  
      });
   }

   /**
      Gets the node or edge prototype that is associated with
      the currently selected button
      @return a Node or Edge prototype
   */
   public Object getSelectedTool()
   {
      for (int i = 0; i < tools.size(); i++)
      {
         JToggleButton button = (JToggleButton) getComponent(i);
         if (button.isSelected()) return tools.get(i);
      }
      return null;
   }

   /**
      Adds a node to the tool bar.
      @param n the node to add
   */
   public void add(final Node n)
   {
      JToggleButton button = new JToggleButton(new
         Icon()
         {
            public int getIconHeight() { return BUTTON_SIZE; }
            public int getIconWidth() { return BUTTON_SIZE; }
            public void paintIcon(Component c, Graphics g,
               int x, int y)
            {
               double width = n.getBounds().getWidth();
               double height = n.getBounds().getHeight();
               Graphics2D g2 = (Graphics2D) g;
               double scaleX = (BUTTON_SIZE - OFFSET)/ width;
               double scaleY = (BUTTON_SIZE - OFFSET)/ height;
               double scale = Math.min(scaleX, scaleY);

               AffineTransform oldTransform = g2.getTransform();
               g2.translate(x, y);
               g2.scale(scale, scale);
               g2.translate(Math.max((height - width) / 2, 0), Math.max((width - height) / 2, 0));
               g2.setColor(Color.black);
               n.draw(g2);
               g2.setTransform(oldTransform);
            }
         });
      group.add(button);      
      add(button);
      tools.add(n);
   }

   /**
      Adds an edge to the tool bar.
      @param n the edge to add
   */
   public void add(final Edge e)
   {
      JToggleButton button = new JToggleButton(new
         Icon()
         {
            public int getIconHeight() { return BUTTON_SIZE; }
            public int getIconWidth() { return BUTTON_SIZE; }
            public void paintIcon(Component c, Graphics g,
               int x, int y)
            {
               Graphics2D g2 = (Graphics2D) g;
               PointNode p = new PointNode();
               p.translate(OFFSET, OFFSET);
               PointNode q = new PointNode();
               q.translate(BUTTON_SIZE - OFFSET, BUTTON_SIZE - OFFSET);
               e.connect(p, q);
               g2.translate(x, y);
               g2.setColor(Color.black);
               e.draw(g2);
               g2.translate(-x, -y);
            }
         });
      group.add(button);
      add(button);      
      tools.add(e);
   }
   
}
