package ldvh.ihm.graphed;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class ModifySectionFrame extends SectionFrame {
	
	// Buttons
	JButton b_modify;
	JButton b_cancel;
	JButton b_suppress;
	
	public ModifySectionFrame(GraphFrame parent, final Node node,final int id, String nom, String text) {
		super(parent);
		
		f_nom.setText(nom);
		a_text.setText(text);
		
		b_modify = new JButton("Modifier");
		b_cancel = new JButton("Annuler");
		b_suppress = new JButton("Supprimer");

		b_modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				gf.getGestionLivre().getContenu()
						.modifierSection(id, a_text.getText(), f_nom.getText(), new ArrayList<String>());
				gf.getMapSections().put(node,id);
				
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

		p_buttons.add(b_modify);
		p_buttons.add(b_cancel);
		p_buttons.add(b_suppress);
		
	}

}
