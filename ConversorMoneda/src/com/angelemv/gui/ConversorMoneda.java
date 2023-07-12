package com.angelemv.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import javax.swing.JButton;
import java.awt.BorderLayout;

public class ConversorMoneda extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textField;
	JButton btnConvertir, btnRegresar;

	public ConversorMoneda() {
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		setTitle("Conversor de moneda");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBienvenida = new JLabel("Elige una opción para convertir");
		lblBienvenida.setForeground(new Color(255, 255, 255));
		lblBienvenida.setFont(new Font("Arial", Font.PLAIN, 40));
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setBounds(10, 50, 764, 50);
		contentPane.add(lblBienvenida);

		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(404, 170, 350, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(30, 169, 350, 22);
		contentPane.add(comboBox);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 64, 128));
		panel.setBounds(30, 202, 725, 126);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		btnConvertir = new JButton("Convertir");
		btnConvertir.setFont(new Font("Arial", Font.PLAIN, 15));
		btnConvertir.setFocusable(false);
		btnConvertir.addActionListener(this);
		panel.add(btnConvertir, BorderLayout.NORTH);

		JLabel lblResultado = new JLabel("");
		lblResultado.setForeground(new Color(255, 255, 255));
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Arial", Font.PLAIN, 40));
		panel.add(lblResultado, BorderLayout.SOUTH);

		btnRegresar = new JButton("Regresar");
		btnRegresar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRegresar.setForeground(new Color(0, 0, 0));
		btnRegresar.setBounds(10, 11, 108, 23);
		btnRegresar.setFocusable(false);
		btnRegresar.addActionListener(this);
		contentPane.add(btnRegresar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnRegresar == e.getSource()) {
			Bienvenida frame = new Bienvenida();
			frame.setVisible(true);
			ConversorMoneda.this.dispose();
		}		
		if (btnConvertir == e.getSource()) {
			String textoCampo = textField.getText();
			if (esNumero(textoCampo)) {
				JOptionPane.showMessageDialog(null, "Ingresaste numeros!");
				//TODO HAy que implementar lo de la caja para seleccionar opciones y hacer dichas conversiones en la logica
			}
			else {
				JOptionPane.showMessageDialog(null, "Ingresa Numeros por favor");
			}
		}
	}

	private boolean esNumero(String texto) {
		return texto.matches("\\d+");
	}
	
	
}
