package ldvh.ihm.graphed;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ldvh.contenu.GestionContenu;
import ldvh.contenu.Objet;
import ldvh.contenu.Section;
import ldvh.interfaces.IContenu;
import ldvh.livre.GestionLivre;

/**
   This frame shows the toolbar and the graph.
*/
public class GraphFrame extends JFrame
{
	
	public static final int FRAME_WIDTH = 600;
	public static final int FRAME_HEIGHT = 400;
	public static final int NUMBER_COLS_TEXT_INFOS = 15;
	public static final int NUMBER_ROWS_TEXT_INFOS = 30;
	
	private Graph graph;
	private GraphPanel panel;
	private JTextArea infosTextArea;
	private JLabel l = new JLabel("Nom section:");
	private JLabel labelObjets = new JLabel(
			"Choisissez objet à ajouter dans la section");
	private JLabel labelTexte = new JLabel("Texte de votre section");
	private JTextField t = new JTextField("Entrez le nom de votre section");
	private JComboBox listObjet = new JComboBox();
	private JButton ajouterObjet = new JButton("Ajout un objet");
	private JButton obtenirListeObjet = new JButton("Obtenir liste objets");
	private JFrame frame_objet = new JFrame();
	private JButton terminer = new JButton("Terminer");
	private JButton ajoutOb = new JButton("Ajouter objet");
	private DefaultListModel dlm = new DefaultListModel();
	private JList objets = new JList(dlm);
	private JTextField objetEntrer = new JTextField(
			"Veuillez saisir le nom de l'objet");
	private JButton supprimerObjet = new JButton("Vider la liste des objets");
	private JPanel panelObj = new JPanel();
	private List<String> objetsAAJouter = new ArrayList<String>();
	private JScrollPane scrollPane;
	private ToolBar toolBar;
	private GestionLivre gestionLivre = new GestionLivre();
	
	public void setInfosTextArea(JTextArea infosTextArea) {
		this.infosTextArea = infosTextArea;
	}

	public GestionLivre getGestionLivre() {
		return gestionLivre;
	}

	public void setGestionLivre(GestionLivre gestionLivre) {
		this.gestionLivre = gestionLivre;
	}

   /**
      Constructs a graph frame that displays a given graph.
      @param graph the graph to display
   */
   public GraphFrame(final Graph graph)
   {  
	  setTitle("LDVH");
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      this.graph = graph;

      constructFrameComponents();
      // set up menus

      JMenuBar menuBar = new JMenuBar();
      setJMenuBar(menuBar);
      JMenu fileMenu = new JMenu("Fichier");
      menuBar.add(fileMenu);
      
      JMenuItem newItem = new JMenuItem("Créer un livre");
    newItem.addActionListener(new
       ActionListener()
       {
          public void actionPerformed(ActionEvent event)
          {
				JOptionPane jop = new JOptionPane();
				JOptionPane jop2 = new JOptionPane();
				String nom = jop.showInputDialog(null,"Veuillez saisir le nom de votre livre !","Création d'un livre !", JOptionPane.QUESTION_MESSAGE);
				String auteur = jop.showInputDialog(null,"Veuillez saisir l'auteur du livre !","Création d'un livre !", JOptionPane.QUESTION_MESSAGE);
				// creation du livre
				if (gestionLivre.creerLivre(nom, auteur)) {
					jop2.showMessageDialog(null, "Le nom du livre est "+ gestionLivre.getLivre().getTitre() + " et l'auteur est "+ gestionLivre.getLivre().getAuteur(), "Création réussie",JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "ok",
							"Les champs saisis sont incorrects!",
							JOptionPane.ERROR_MESSAGE);
				}
        	  

          }
       });
      fileMenu.add(newItem);

      JMenuItem openItem = new JMenuItem("Charger un livre");
//      openItem.addActionListener(new
//         ActionListener()
//         {
//            public void actionPerformed(ActionEvent event)
//            {
//               chargerLivre();
//            }
//         });
      fileMenu.add(openItem);

      JMenuItem saveItem = new JMenuItem("Sauvegarder le livre");
//      saveItem.addActionListener(new 
//         ActionListener()
//         {
//            public void actionPerformed(ActionEvent event)
//            {
//               sauvegarderLivre();
//            }
//         });
      fileMenu.add(saveItem);
      
      JMenuItem generateItem = new JMenuItem("Générer le livre");
//    generateItem.addActionListener(new 
//       ActionListener()
//       {
//          public void actionPerformed(ActionEvent event)
//          {
//             genererLivre();
//          }
//       });
      fileMenu.add(generateItem);

      JMenuItem exitItem = new JMenuItem("Quitter");
      exitItem.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0);
            }
         });
      fileMenu.add(exitItem);

      JMenuItem deleteItem = new JMenuItem("Supprimer");
      deleteItem.addActionListener(new 
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               panel.removeSelected();
            }
         });
      
      JMenuItem ajouterItem = new JMenuItem("Definir liste objets dans le livre");
      ajouterItem.addActionListener(new 
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               
               
              
               frame_objet.setVisible(true);
            }
         });
      
 
      JMenuItem propertiesItem 
         = new JMenuItem("Modifier");
      propertiesItem.addActionListener(new 
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               panel.editSelected();
            }
         });

      JMenu editMenu = new JMenu("Editer");
      editMenu.add(deleteItem);
      editMenu.add(propertiesItem);
      editMenu.add(ajouterItem);
      menuBar.add(editMenu);
   }
   
   
   public void ajouterActionsDefinirObjet(JButton terminerr, JButton ajoutObb){
	   //bouton ajoutOb
	   ajoutObb.addActionListener(new 
		         ActionListener()
		         {
		            public void actionPerformed(ActionEvent event)
		            {
		            	
		            	boolean doublon = false;
	            		for (int j=0;j<dlm.size();j++){
		            		String nom = ""+dlm.get(j);
		            		if (nom.equals(objetEntrer.getText())){
		            			doublon = true;
		            		}
		            	}
	            		if (doublon==false){
	            		dlm.addElement(objetEntrer.getText());
	            		}
	            		else{
	            			JOptionPane.showMessageDialog(null, "Erreur cet objet est déjà ajouté",
	          		               "Impossible d'ajouter un nouvel objet en double!", JOptionPane.ERROR_MESSAGE);
	            		}
		            	}
		               
		            });
	   //bouton supprimer les objets
	   supprimerObjet.addActionListener(new 
		         ActionListener()
		         {
		            public void actionPerformed(ActionEvent event)
		            {
		            	dlm.clear();
		            	gestionLivre.getContenu().deleteAllObjets();
		            	//suppression de la liste des objets
		            	for (int i=0;i<gestionLivre.getContenu().getListeSections().size();i++){
		            		gestionLivre.getContenu().getListeSections().get(i).getListeObjet().clear();
		            	}
		            }
		               
		           });
	 //bouton terminer
	  terminer.addActionListener(new 
		         ActionListener()
		         {
		            public void actionPerformed(ActionEvent event)
		            {
		            	
		            	if (dlm.size()>0){
			            	for (int i=0;i<dlm.size();i++){
			            		String nom = ""+dlm.get(i);
			            		gestionLivre.getContenu().ajouterObjet(nom);
			            	}
		            	}
		            	
		            	dlm.clear();
		            	for(int j=0;j<gestionLivre.getContenu().getListeObjet().size();j++){
		            		dlm.addElement(gestionLivre.getContenu().getListeObjet().get(j).getNom());
		            	}
		            	frame_objet.setVisible(false);
		            }
		               
		            });
   }

   /**
      Constructs the tool bar and graph panel.
   */
   private void constructFrameComponents()
   {
      toolBar = new ToolBar(graph);
      panel = new GraphPanel(toolBar, graph);
      scrollPane = new JScrollPane(panel);
      
      infosTextArea = new JTextArea(NUMBER_ROWS_TEXT_INFOS,NUMBER_COLS_TEXT_INFOS);
	  infosTextArea.setEditable(true);
	  infosTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
	  JPanel infosPanel = new JPanel();
	  /**
	   * Frame objets
	   */
	  JLabel labelObjet = new JLabel("Objet à ajouter dans le livre:");
      ajouterActionsDefinirObjet(terminer, ajoutOb);
      panelObj.add(labelObjet);
      panelObj.add(objetEntrer);
      panelObj.add(ajoutOb);
      panelObj.add(objets);
      panelObj.add(supprimerObjet);
      panelObj.add(terminer);
      panelObj.add(obtenirListeObjet);
      frame_objet.setSize(800, 800);
      frame_objet.getContentPane().add(panelObj,BorderLayout.CENTER);
      /**
       * Modifier une section
       */
	  //plus facile pour la recherche
	  infosPanel.setName("infosPanel");
	  JButton boutonModifier = new JButton("Modifier Section");
	  boutonModifier.addActionListener(new 
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
            	if (panel.getSelected() instanceof CircleNode){
            		gestionLivre.getContenu().setListeSections(gestionLivre.getContenu().getListeSections());
            		String texteSection = infosTextArea.getText();
            		String nomSection = t.getText();
            		boolean retour = gestionLivre.getContenu().modifierSection(panel.getIdSelected(), nomSection, texteSection, objetsAAJouter);
            		
            		if (retour == true){
            			JOptionPane.showMessageDialog(null, 
            		               "Modification de la section "+panel.getIdSelected()+" réussie!");
            		}
            		else{
            			JOptionPane.showMessageDialog(null, "ok",
         		               "Erreur lors de la modification de la section "+panel.getIdSelected()+"!", JOptionPane.ERROR_MESSAGE);
            		}
            		}
            	}
               
            });
	  /**
	   * Ajouter un objet à la section
	   */
         
	  ajouterObjet.addActionListener(new 
		         ActionListener()
		         {
		            public void actionPerformed(ActionEvent event)
		            {
		            	if (panel.getSelected() instanceof CircleNode){
		            		String o = ""+listObjet.getSelectedItem();
		            		
		            		 Section s = gestionLivre.getContenu().getSectionById(panel.getIdSelected());
		            		 
		            		 if (s.ajouterObjet(o)==true){
		            			 objetsAAJouter.add(o);
		            			 JOptionPane.showMessageDialog(null, 
		            		               "Ajout de l'objet "+o+" dans la section "+panel.getIdSelected()+" réussie!");
		            		 }
		            		 else{
		            			 JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout de l'objet "+o+" dans la section "+panel.getIdSelected()+"! \n Il est possible que cet objet ait déjà été ajouté dans cette section",
			         		               "Erreur !", JOptionPane.ERROR_MESSAGE);
		            		 }
		            		 
		            		
		            		}
		            	}
		               
		            });
	  
	  /**
	   * Obtenir liste des objets
	   */
         
	  obtenirListeObjet.addActionListener(new 
		         ActionListener()
		         {
		            public void actionPerformed(ActionEvent event)
		            {
		            	if (panel.getSelected() instanceof CircleNode){
		            		String texteObj="-";
		            		 Section s = gestionLivre.getContenu().getSectionById(panel.getIdSelected());
		            		 List<Objet> objetss = s.getListeObjet();
		            		 if (objetss!=null){
		            		 for (Objet o:objetss){
		            			 texteObj=texteObj+o.getNom()+"\n";
		            		 }
		            		 	if (objetss.size()>0){
		            			 JOptionPane.showMessageDialog(null, 
		            		               "Voici la liste des objets de cette section:  \n"+texteObj);
		            		 	}
		            		 	else{
		            		 		JOptionPane.showMessageDialog(null, 
			            		               "Aucun objet associé à cette section");
		            		 	}
		            		 
		            			
		            		 }
		            		 
		            		
		            		}
		            	}
		               
		            });
	  
	  
	  
	  infosPanel.add(labelTexte,BorderLayout.SOUTH);
	  infosPanel.add(infosTextArea, BorderLayout.CENTER);
	  infosPanel.add(l,BorderLayout.SOUTH);
	  infosPanel.add(t,BorderLayout.SOUTH);
	  infosPanel.add(labelObjets,BorderLayout.SOUTH);
	  infosPanel.add(listObjet,BorderLayout.CENTER);
	  infosPanel.add(ajouterObjet, BorderLayout.WEST);
	  infosPanel.add(obtenirListeObjet, BorderLayout.SOUTH);
	  infosPanel.add(boutonModifier, BorderLayout.NORTH);
	  infosPanel.setVisible(false);
      Container contentPane = getContentPane();
      contentPane.add(toolBar, BorderLayout.NORTH);
      contentPane.add(scrollPane, BorderLayout.CENTER);
      contentPane.add(infosPanel, BorderLayout.EAST);
      
      panel.setGf(this);
   }

   public JComboBox getListObjet() {
	return listObjet;
}

public void setListObjet(JComboBox listObjet) {
	this.listObjet = listObjet;
}


  
   /**
      Asks the user to open a graph file.
   */
   private void openFile()
   {  
      // let user select file

      JFileChooser fileChooser = new JFileChooser();
      int r = fileChooser.showOpenDialog(this);
      if (r == JFileChooser.APPROVE_OPTION)
      {  
         // open the file that the user selected
         try
         {
            File file = fileChooser.getSelectedFile();
            ObjectInputStream in = new ObjectInputStream(
               new FileInputStream(file));
            Graph graph = (Graph) in.readObject();
            in.close();
            Container contentPane = getContentPane();
            contentPane.remove(scrollPane);
            contentPane.remove(toolBar);
            constructFrameComponents();
            validate();
            repaint();
         }
         catch (IOException exception)
         {
            JOptionPane.showMessageDialog(null, 
               exception);
         }
         catch (ClassNotFoundException exception)
         {
            JOptionPane.showMessageDialog(null, 
               exception);
         }
      }
   }

   /**
      Saves the current graph in a file. 
   */
   private void saveFile()
   {
      JFileChooser fileChooser = new JFileChooser();
      if (fileChooser.showSaveDialog(this) 
         == JFileChooser.APPROVE_OPTION)
      {
         try
         {
            File file = fileChooser.getSelectedFile();
            ObjectOutputStream out = new ObjectOutputStream(
               new FileOutputStream(file));
            out.writeObject(graph);
            out.close();
         }
         catch (IOException exception)
         {
            JOptionPane.showMessageDialog(null, 
               exception);
         }
      }
   }

   public JButton getAjouterObjet() {
	return ajouterObjet;
}

	public void setAjouterObjet(JButton ajouterObjet) {
		this.ajouterObjet = ajouterObjet;
	}

	public JTextArea getInfosTextArea() {
		return infosTextArea;
	}

	public JTextField getT() {
		return t;
	}

	public void setT(JTextField t) {
		this.t = t;
	}

}
