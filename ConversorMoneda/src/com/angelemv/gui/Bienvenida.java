package com.angelemv.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;

public class Bienvenida extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btnConversordeMoneda, btnConversorDeDistancia, btnConversorDeTemperatura ,btnSalir;
	private JPanel contentPane;

	public Bienvenida() {
		setBackground(new Color(0, 64, 128));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Bienvenida.class.getResource("/icons/R.png")));
		setTitle("Conversor de unidades");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		iniciarComponentes();
	}
	private void iniciarComponentes() {
		JLabel lblBienvenida = new JLabel("Bienvenido");
		lblBienvenida.setForeground(new Color(255, 255, 255));
		lblBienvenida.setFont(new Font("Arial", Font.PLAIN, 40));
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setBounds(10, 95, 764, 50);
		contentPane.add(lblBienvenida);

		JLabel lblPorFavorSelecciona = new JLabel("Por favor selecciona una opcion.");
		lblPorFavorSelecciona.setForeground(new Color(255, 255, 255));
		lblPorFavorSelecciona.setHorizontalAlignment(SwingConstants.CENTER);
		lblPorFavorSelecciona.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPorFavorSelecciona.setBounds(10, 139, 764, 50);
		contentPane.add(lblPorFavorSelecciona);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 64, 128));
		panel.setBounds(10, 200, 764, 37);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnConversordeMoneda = new JButton("Conversor de moneda");
		btnConversordeMoneda.setFont(new Font("Arial", Font.PLAIN, 15));
		btnConversordeMoneda.setFocusable(false);
		btnConversordeMoneda.addActionListener(this);
		panel.add(btnConversordeMoneda);

		btnConversorDeDistancia = new JButton("Conversor de distancia");
		btnConversorDeDistancia.setFont(new Font("Arial", Font.PLAIN, 15));
		btnConversorDeDistancia.setFocusable(false);
		btnConversorDeDistancia.addActionListener(this);
		panel.add(btnConversorDeDistancia);

		btnConversorDeTemperatura = new JButton("Conversor de temperatura");
		btnConversorDeTemperatura.setFont(new Font("Arial", Font.PLAIN, 15));
		btnConversorDeTemperatura.setFocusable(false);
		btnConversorDeTemperatura.addActionListener(this);
		panel.add(btnConversorDeTemperatura);

		
		btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.BLACK);
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 15));
		btnSalir.setFocusable(false);
		btnSalir.addActionListener(this);		
		btnSalir.setBounds(666, 12, 108, 23);
		contentPane.add(btnSalir);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnConversordeMoneda == e.getSource()) {
			ConversorMoneda frame2 = new ConversorMoneda();
			frame2.setVisible(true);
			Bienvenida.this.dispose();
		}
		if (btnSalir == e.getSource()) {
			System.exit(0);
		}
		if (btnConversorDeDistancia == e.getSource()) {
			ConversorDistancia frame2 = new ConversorDistancia();
			frame2.setVisible(true);
			Bienvenida.this.dispose();
		}
		if (btnConversorDeTemperatura == e.getSource()) {
			ConversorTemperatura frame2 = new ConversorTemperatura();
			frame2.setVisible(true);
			Bienvenida.this.dispose();
		}

	}
}
