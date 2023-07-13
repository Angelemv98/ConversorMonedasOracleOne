package com.angelemv.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class ConversorTemperatura extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	JButton btnConvertir, btnRegresar;
	JComboBox<String> comboBox;
	JLabel lblResultado;
	DecimalFormat formato = new DecimalFormat("#.##");

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ConversorTemperatura() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ConversorTemperatura.class.getResource("/icons/termometro.png")));
		iniciarComponentes();

	}

	private void iniciarComponentes() {
		setTitle("Conversor de Temperatura");
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

		comboBox = new JComboBox<String>();
		comboBox.setBounds(30, 169, 350, 22);
		comboBox.addItem("Selecciona una opcion");
		comboBox.addItem("Celsius a Fahrenheit");
		comboBox.addItem("Celsius a Kelvin");
		comboBox.addItem("Fahrenheit a Celsius");
		comboBox.addItem("Fahrenheit a Kelvin");
		comboBox.addItem("Kelvin a Celsius");
		comboBox.addItem("Kelvin a Fahrenheit");
		comboBox.addActionListener(this);
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

		lblResultado = new JLabel("");
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
			ConversorTemperatura.this.dispose();
		}
		if (btnConvertir == e.getSource()) {
			String textoCampo = textField.getText();
			if (esNumero(textoCampo) && !textoCampo.isEmpty()) {
				int cantidad = Integer.parseInt(textoCampo);
				String resultado = conversionCantidad(comboBox.getSelectedIndex(), cantidad);
				lblResultado.setText(resultado);
			} else {
				JOptionPane.showMessageDialog(null, "Por favor no dejes el campo vacio, e ingresa solo numeros");
			}
		}
	}

	private String conversionCantidad(int selectedIndex, int cantidad) {
		switch (selectedIndex) {
		case 0: {
			return "Selecciona una opción";
		}
		case 1: {
			double total = (cantidad * 1.8)+32;
			return "El total en grados Fahrenheit es: " + formato.format(total);
		}
		case 2: {
			double total = cantidad + 273.15;
			return "El total en grados Kelvin es: " + formato.format(total);
		}
		case 3: {
			double total = (cantidad -32)/1.8;
			return "El total en grados Celcius es: " + formato.format(total);
		}
		case 4: {
			double total = (cantidad +459.67)* 0.5555555555555556;
			return "El total en grados Kelvin es: " + formato.format(total);
		}
		case 5: {
			double total = cantidad - 273.15;
			return "El total en grados Celcius es: " + formato.format(total);
		}
		case 6: {
			double total = cantidad  * 9/5 - 459.67 ;
			return "El total en grados Fahrenheit es: " + formato.format(total);
		
		}
		}
		return null;
	}

	private boolean esNumero(String texto) {
		return texto.matches("\\d+");
	}
}
