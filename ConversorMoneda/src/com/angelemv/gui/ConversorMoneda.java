package com.angelemv.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

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
import java.awt.Toolkit;

public class ConversorMoneda extends JFrame implements ActionListener {

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


	public ConversorMoneda() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConversorMoneda.class.getResource("/icons/dinero.png")));
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		setTitle("Conversor de moneda");
		setResizable(false);
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
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(0, 64, 128));
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(404, 170, 350, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		comboBox = new JComboBox<String>();
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBackground(new Color(0, 64, 128));
		comboBox.setBounds(30, 169, 350, 22);
		comboBox.addItem("Selecciona una opción");
		comboBox.addItem("MXN Pesos mexicanos - EUR Euro");
		comboBox.addItem("MXN Pesos mexicanos - USD Dólar estadounidense");
		comboBox.addItem("MXN Pesos mexicanos - PEN Nuevo sol peruano");
		comboBox.addItem("MXN Pesos mexicanos - ARS Peso argentino");
		comboBox.addItem("EUR Euro - MXN Pesos mexicanos");
		comboBox.addItem("USD Dólar estadounidense - MXN Pesos mexicanos");
		comboBox.addItem("PEN Nuevo sol peruano - MXN Pesos mexicanos");
		comboBox.addItem("ARS Peso argentino - MXN Pesos mexicanos");
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
		lblResultado.setFont(new Font("Arial", Font.PLAIN, 30));
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
			if (esNumero(textoCampo) && !textoCampo.isEmpty()) {
				int cantidad = Integer.parseInt(textoCampo);
				String resultado = conversionCantidad(comboBox.getSelectedIndex(), cantidad);
				lblResultado.setText(resultado);
			} else {
				JOptionPane.showMessageDialog(null, "Por favor no dejes el campo vacio, e ingresa solo numeros");
			}
		}
	}

	private String conversionCantidad(int selectedItem, int cantidad) {
		switch (selectedItem) {
		case 0: {
			return "Selecciona una opción";
		}
		case 1: {
			double total = cantidad / 18.85;
			return "El total en euros es: " + formato.format(total) + " EUR";
		}
		case 2: {
			double total = cantidad / 17;
			return "El total en dolares es: " + formato.format(total) + " USD";
		}
		case 3: {
			double total = cantidad / 4.75;
			return "El total en soles peruanos es: " + formato.format(total) + " PEN";
		}
		case 4: {
			double total = cantidad * 15.61;
			return "El total en pesos argentinos es: " + formato.format(total) + " ARS";
		}
		case 5: {
			double total = cantidad * 18.85;
			return "El total en pesos mexicanos es: " + formato.format(total) + " MXN";
		}
		case 6: {
			double total = cantidad * 17;
			return "El total en pesos mexicanos es: " + formato.format(total) + " MXN";
		}
		case 7: {
			double total = cantidad * 4.75;
			return "El total en pesos mexicanos es: " + formato.format(total) + " MXN";
		}
		case 8: {
			double total = cantidad / 15.61;
			return "El total en pesos mexicanos es: " + formato.format(total) + " MXN";
		}
		}
		return null;

	}

	private boolean esNumero(String texto) {
		return texto.matches("\\d+");
	}

}
