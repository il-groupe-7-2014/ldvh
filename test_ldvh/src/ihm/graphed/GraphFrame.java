package ihm.graphed;

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

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
   This frame shows the toolbar and the graph.
*/
public class GraphFrame extends JFrame
{
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
//    openItem.addActionListener(new
//       ActionListener()
//       {
//          public void actionPerformed(ActionEvent event)
//          {
//             creerLivre();
//          }
//       });
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
      menuBar.add(editMenu);
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
	  infosTextArea.setEditable(false);
	  infosTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
	  JPanel infosPanel = new JPanel(new BorderLayout());
      infosPanel.add(infosTextArea, BorderLayout.CENTER);
      infosTextArea.setText("Coucou");
      
      Container contentPane = getContentPane();
      contentPane.add(toolBar, BorderLayout.NORTH);
      contentPane.add(scrollPane, BorderLayout.CENTER);
      contentPane.add(infosPanel, BorderLayout.EAST);
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

   private Graph graph;
   private GraphPanel panel;
   private JTextArea infosTextArea;
   private JScrollPane scrollPane;
   private ToolBar toolBar;

   public static final int FRAME_WIDTH = 600;
   public static final int FRAME_HEIGHT = 400;
   public static final int NUMBER_COLS_TEXT_INFOS = 15;
   public static final int NUMBER_ROWS_TEXT_INFOS = 30;
}
