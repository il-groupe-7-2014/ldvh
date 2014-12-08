package ldvh.ihm.graphed;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ModifyEnchainementFrame extends EnchainementFrame {
	
	// Buttons
	JButton b_modify;
	JButton b_cancel;
	JButton b_suppress;
	JButton b_obtenir;
	List<String> objetsAAdd;
	DefaultListModel dlm = new DefaultListModel();
	JList objets = new JList(dlm);
	
	public ModifyEnchainementFrame(GraphFrame parent, final Edge edge, final int id, 
				final int idApres, final int idAvant, String text) {
		super(parent);
		
		a_text.setText(text);
		add_objet.setEnabled(true);
		list_obj.setEnabled(true);
		
		b_obtenir = new JButton("Obtenir la liste des objets");
		b_modify = new JButton("Modifier");
		b_cancel = new JButton("Annuler");
		b_suppress = new JButton("Supprimer");

		b_modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				gf.getGestionLivre().getContenu()
						.modifierEnchainement(idAvant, idApres, a_text.getText(), objetsAAdd, id);
				
				setVisible(false);
				
			}

		});
		
		b_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
				
			}

		});
		
		b_suppress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				gf.getGestionLivre().getContenu().supprimerEnchainement(id);
				gf.getGraph().removeEdge(edge);
				gf.getPanel().repaint();
				setVisible(false);
				
			}

		});
		
		
		
		b_obtenir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
					String texteObj = "";
					List<String> objetss = gf.getGestionLivre().getContenu()
							.getNomsObjetsSection(id);
					if (objetss != null) {
						for (String o : objetss) {
							texteObj = "-"+texteObj + o + "\n";
						}
						if (objetss.size() > 0) {
							JOptionPane.showMessageDialog(null,
									"Voici la liste des objets de cette section:  \n"
											+ texteObj);
						} else {
							JOptionPane.showMessageDialog(null,
									"Aucun objet associé à cette section");
						}

					}

				
			}

		});
		
		
		//ajout des objets
		List<String>  noms = gf.getGestionLivre().getContenu().getNomsObjets();
				for (String n : noms){
					list_obj.addItem(n);
				}
				objetsAAdd = new ArrayList<String>();
				
				List<String> objetss = gf.getGestionLivre().getContenu().getNomsObjetsEnchainement(id);
				for (String o : objetss){
					dlm.addElement(o);
				}
				
				add_objet.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
	
							if (!dlm.contains(list_obj.getSelectedItem())){
							objetsAAdd.add(list_obj.getSelectedItem().toString());
							dlm.addElement(list_obj.getSelectedItem());
							}
					
				
					}
					
					
				

				});
				
		p_objets.add(objets);
		p_buttons.add(b_modify);
		p_buttons.add(b_cancel);
		p_buttons.add(b_suppress);
		
	}

}
