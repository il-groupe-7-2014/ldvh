package ldvh.ihm.graphed;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class NewEnchainementFrame extends EnchainementFrame {

	// Buttons
	JButton b_valid;
	JButton b_cancel;
	GraphFrame parent;
	
	public NewEnchainementFrame(GraphFrame parent, final Edge edge, final Node nAvant, final Node nApres) {
		super(parent);
		this.parent = parent;

		
		System.out.println("ooo "+NewEnchainementFrame.this.parent.getMapSections().containsKey(nAvant));
		System.out.println("ooob "+NewEnchainementFrame.this.parent.getMapSections().containsKey(nApres));
		
		b_valid = new JButton("Valider");
		b_cancel = new JButton("Annuler");

		b_valid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int id = gf.getGestionLivre().getContenu()
						.ajouterEnchainement(a_text.getText(),
								NewEnchainementFrame.this.parent.getMapSections().get(nAvant),
								NewEnchainementFrame.this.parent.getMapSections().get(nApres));
				gf.getMapEnchainements().put(edge,id);
				
				setVisible(false);
				
			}

		});
		
		b_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				gf.getGraph().removeEdge(edge);
				gf.getPanel().repaint();
				setVisible(false);
				
			}

		});

		p_buttons.add(b_valid);
		p_buttons.add(b_cancel);

	}

}
