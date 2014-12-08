package ldvh.ihm.graphed;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ModifySectionFrame extends SectionFrame {

	// Buttons
	JButton b_modify;
	JButton b_cancel;
	JButton b_suppress;
	JButton b_obtenir;
	JButton b_deleteObj;
	List<String> objetsAAdd;
	DefaultListModel dlm = new DefaultListModel();
	JList objets = new JList(dlm);

	public ModifySectionFrame(GraphFrame parent, final Node node, final int id,
			String nom, String text) {
		super(parent);

		f_nom.setText(nom);
		a_text.setText(text);
		add_objet.setEnabled(true);
		list_obj.setEnabled(true);

		b_obtenir = new JButton("Obtenir la liste des objets");
		b_deleteObj = new JButton("Supprimer Objet");
		b_modify = new JButton("Modifier");
		b_cancel = new JButton("Annuler");
		b_suppress = new JButton("Supprimer");

		b_modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				gf.getGestionLivre()
						.getContenu()
						.modifierSection(id, a_text.getText(), f_nom.getText(),
								objetsAAdd);
				gf.getMapSections().put(node, id);

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
				gf.getGestionLivre().getContenu().supprimerSection(id);
				gf.getGraph().removeNode(node);
				gf.getPanel().repaint();
				setVisible(false);

			}

		});

	

		// ajout des objets
		List<String> noms = gf.getGestionLivre().getContenu().getNomsObjets();
		List<String> objetss = gf.getGestionLivre().getContenu()
				.getNomsObjetsSection(id);
		objetsAAdd = new ArrayList<String>();
		
		for (String n : noms) {
			if (!objetss.contains(n))
			list_obj.addItem(n);
			else {
				dlm.addElement(n);
				objetsAAdd.add(n);
			}
		}
	
		
		hideAndShow();

		add_objet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Object selected = list_obj.getSelectedItem();
				if (!dlm.contains(selected)) {
					objetsAAdd.add(selected.toString());
					dlm.addElement(selected);
					list_obj.removeItem(selected);
				}
				hideAndShow();

			}

		});

		b_deleteObj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Object selected = objets.getSelectedValue();
				if (dlm.contains(selected)) {
					dlm.removeElement(selected);
					objetsAAdd.remove(selected.toString());
					list_obj.addItem(selected.toString());
				}
				hideAndShow();

			}

		});

		p_southobj.add(objets, BorderLayout.NORTH);
		p_southobj.add(b_deleteObj, BorderLayout.SOUTH);
		p_center.add(p_southobj, BorderLayout.SOUTH);

		p_buttons.add(b_modify);
		p_buttons.add(b_cancel);
		p_buttons.add(b_suppress);

	}

	public void hideAndShow() {
		if (dlm.size() == 0) {
			b_deleteObj.setVisible(false);
		} else {
			b_deleteObj.setVisible(true);
		}
	}

}
