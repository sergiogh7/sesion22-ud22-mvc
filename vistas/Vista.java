package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Vista extends JFrame {

	private JPanel panelR, panelB;
	public JButton insertar;
	public JButton borrar;
	public JButton select;
	public JButton update;
	public JTextField texto;
	public JLabel mostrarResultado;

	public Vista() {
		getContentPane().setLayout(new BorderLayout());

		panelB = new JPanel();
		panelB.setLayout(new FlowLayout());

		panelR = new JPanel();
		panelR.setLayout(new FlowLayout());

		select = new JButton("SELECT");
		insertar = new JButton("INSERT");
		update = new JButton("UPDATE");
		borrar = new JButton("DELETE");

		mostrarResultado = new JLabel ("- - - - - - - - - - - - - - - - - - "
				+ "- - - - - - - - - - - - - - - - - - - - - - - - - "
				+ "- - - - - - - - - - - - - - - - - - - - - - - - - "
				+ "- - - - - - - - - - - - - - - - - - - - - - - - - "
				+ "- - - - - - - - - - - - - - - - -");
		texto = new JTextField();
		
		panelB.add(select);
		panelB.add(insertar);
		panelB.add(update);
		panelB.add(borrar);
		
		panelR.add(texto);
		panelR.add(mostrarResultado);

		add(texto, BorderLayout.NORTH);
		add(panelB, BorderLayout.SOUTH);
		add(panelR, BorderLayout.CENTER);
	}
}