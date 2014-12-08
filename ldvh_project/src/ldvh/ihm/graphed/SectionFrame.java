package ldvh.ihm.graphed;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.JobName;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SectionFrame extends JFrame {

	// Variables
	int id;
	
	// Interface
	GraphFrame gf;
	JPanel p_nom;
	JPanel p_text;
	JPanel p_buttons;
	JLabel l_nom;
	JLabel l_text;
	JTextField f_nom;
	JTextArea a_text;
	JLabel label_obj;
	JButton add_objet;
	JPanel p_objets;
	JComboBox<String> list_obj;
	
	public SectionFrame(GraphFrame parent){
		gf = parent;
		
		p_nom = new JPanel();
		p_text = new JPanel();
		p_buttons = new JPanel();
		p_objets = new JPanel();
		

		
		l_nom = new JLabel("Nom : ");
		l_text = new JLabel("Texte : ");
		f_nom = new JTextField(20);
		a_text = new JTextArea(8, 48);
		label_obj = new JLabel("Liste objets disponibles:");
		add_objet = new JButton("Ajout un objet");
		list_obj = new JComboBox<String>();
		add_objet.setEnabled(false);
		a_text.setEditable(true);
		list_obj.setEnabled(false);
		
		p_nom.add(l_nom,BorderLayout.WEST);
		p_nom.add(f_nom,BorderLayout.EAST);
		p_text.add(l_text);
		p_text.add(a_text);
		p_objets.add(label_obj,BorderLayout.WEST);
		p_objets.add(list_obj,BorderLayout.CENTER);
		p_objets.add(add_objet, BorderLayout.EAST);
		
		setSize(640, 640);
		getContentPane().add(p_objets,BorderLayout.EAST);
		getContentPane().add(p_nom,BorderLayout.NORTH);
		getContentPane().add(p_text,BorderLayout.CENTER);
		getContentPane().add(p_buttons,BorderLayout.SOUTH);
	}
	
}
