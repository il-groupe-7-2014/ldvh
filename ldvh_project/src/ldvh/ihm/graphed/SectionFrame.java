package ldvh.ihm.graphed;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.JobName;
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
	
	
	public SectionFrame(GraphFrame parent){
		gf = parent;
		
		p_nom = new JPanel();
		p_text = new JPanel();
		p_buttons = new JPanel();
		
		l_nom = new JLabel("Nom : ");
		l_text = new JLabel("Texte : ");
		f_nom = new JTextField(32);
		a_text = new JTextArea(8, 48);
		
		p_nom.add(l_nom);
		p_nom.add(f_nom);
		p_text.add(l_text);
		p_text.add(a_text);
		
		setSize(640, 480);
		getContentPane().add(p_nom,BorderLayout.NORTH);
		getContentPane().add(p_text,BorderLayout.CENTER);
		getContentPane().add(p_buttons,BorderLayout.SOUTH);
	}
	
}
