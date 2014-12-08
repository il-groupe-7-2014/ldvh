package ldvh.ihm.graphed;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class NewSectionFrame extends SectionFrame {

	// Buttons
	JButton b_valid;
	JButton b_cancel;
	
	public NewSectionFrame(GraphFrame parent, final Node node) {
		super(parent);

		b_valid = new JButton("Valider");
		b_cancel = new JButton("Annuler");

		b_valid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				int id = gf.getGestionLivre().getContenu()
						.ajouterSection(f_nom.getText(), a_text.getText());
				gf.getMapSections().put(node,id);
				
				setVisible(false);
				
			}

		});
		
		b_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				gf.getGraph().removeNode(node);
				gf.getPanel().repaint();
				setVisible(false);
				
			}

		});

		p_buttons.add(b_valid);
		p_buttons.add(b_cancel);

	}

}
