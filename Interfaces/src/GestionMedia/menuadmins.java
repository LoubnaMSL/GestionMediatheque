package GestionMedia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class menuadmins extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuadmins frame = new menuadmins();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public menuadmins() {
		setBackground(new Color(32, 178, 170));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 512);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion M\u00E9diath\u00E8que ");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 0, 810, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Menu principal ");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(0, 54, 810, 38);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Gestion des adh\u00E9rents ");
		btnNewButton.setBackground(new Color(100, 149, 237));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionadherents obj =new gestionadherents();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBounds(263, 103, 295, 45);
		contentPane.add(btnNewButton);
		
		JButton btnGestionDesLivres = new JButton("Gestion des livres");
		btnGestionDesLivres.setBackground(new Color(100, 149, 237));
		btnGestionDesLivres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionLivre obj =new gestionLivre();
				obj.setVisible(true);
				dispose();
			}
		});
		btnGestionDesLivres.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		btnGestionDesLivres.setBounds(263, 159, 295, 45);
		contentPane.add(btnGestionDesLivres);
		
		JButton btnGestionDesCds = new JButton("Gestion des CD");
		btnGestionDesCds.setBackground(new Color(100, 149, 237));
		btnGestionDesCds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionCD obj =new gestionCD();
				obj.setVisible(true);
				dispose();
			}
		});
		btnGestionDesCds.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		btnGestionDesCds.setBounds(263, 215, 295, 45);
		contentPane.add(btnGestionDesCds);
		
		JButton btnGestionDesDvds = new JButton("Gestion des DVD");
		btnGestionDesDvds.setBackground(new Color(100, 149, 237));
		btnGestionDesDvds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionDVD obj =new gestionDVD();
				obj.setVisible(true);
				dispose();
			}
		});
		btnGestionDesDvds.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		btnGestionDesDvds.setBounds(263, 271, 295, 45);
		contentPane.add(btnGestionDesDvds);
		
		JButton btnGestionDesEmprunts = new JButton("Gestion des emprunts");
		btnGestionDesEmprunts.setBackground(new Color(100, 149, 237));
		btnGestionDesEmprunts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionEmprunt obj =new gestionEmprunt();
				obj.setVisible(true);
				dispose();
			}
		});
		btnGestionDesEmprunts.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		btnGestionDesEmprunts.setBounds(263, 322, 295, 45);
		contentPane.add(btnGestionDesEmprunts);
		
		JButton btnGestionDesSanctions = new JButton("Gestion des sanctions ");
		btnGestionDesSanctions.setBackground(new Color(100, 149, 237));
		btnGestionDesSanctions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionSection obj =new gestionSection();
				obj.setVisible(true);
				dispose();
			}
		});
		btnGestionDesSanctions.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		btnGestionDesSanctions.setBounds(263, 378, 295, 45);
		contentPane.add(btnGestionDesSanctions);
		
		JButton btnNewButton_1 = new JButton("Quitter");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.setBackground(new Color(100, 149, 237));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(373, 439, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Player n. 1\\Desktop\\mediatheque.jpg"));
		lblNewLabel_2.setBounds(0, 0, 810, 473);
		contentPane.add(lblNewLabel_2);
	}
}
