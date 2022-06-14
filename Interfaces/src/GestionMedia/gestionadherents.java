package GestionMedia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;


public class gestionadherents extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	Connection cnx =null;
	PreparedStatement prepared =null ;
	ResultSet resultat =null;
	
	
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionadherents frame = new gestionadherents();
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
	public gestionadherents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 495);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		cnx= connectionMysql.ConnectionDB();
		
		JLabel lblNewLabel = new JLabel("Gestion des adherents ");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuadmins obj =new menuadmins();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();

			}
		});
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(94, -4, 627, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(35, 56, 56, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prenom ");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 90, 98, 23);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Adresse");
		lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(10, 132, 98, 23);
		contentPane.add(lblNewLabel_1_2);
		
		textField = new JTextField();
		textField.setBounds(125, 48, 269, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(125, 86, 269, 33);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(125, 127, 269, 34);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBackground(new Color(100, 149, 237));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom =textField.getText().toString();
				String prenom =textField_1.getText().toString();
				String adresse =textField_2.getText().toString();
				String sql = "insert into adherent (nom , prenom ,adresse) values ( ? , ? ,? ) ";
				try {
					if(!textField.getText().equals("") && !textField_1.getText().equals("") && !textField_2.getText().equals("")  ) {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1,nom);
					prepared.setString(2,prenom);
					prepared.setString(3,adresse);
					
					prepared.execute();
					JOptionPane.showMessageDialog(null,"l'adherent est ajouté");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					UpdateTable();
					}
					else {
						JOptionPane.showMessageDialog(null,"Remplissez tout les cases");
					}
				} 
					catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}});
		btnNewButton.setBounds(549, 32, 129, 28);
		contentPane.add(btnNewButton);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBackground(new Color(100, 149, 237));
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "delete from adherent where nom = ? and prenom = ? and adresse = ? ";
				
				try {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1,textField.getText().toString());
					prepared.setString(2,textField_1.getText().toString());
					prepared.setString(3,textField_2.getText().toString());
					prepared.execute();
					JOptionPane.showMessageDialog(null, "l'adhérent est supprimé ");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					UpdateTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSupprimer.setFont(new Font("Arial", Font.BOLD, 15));
		btnSupprimer.setBounds(549, 110, 129, 28);
		contentPane.add(btnSupprimer);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBackground(new Color(100, 149, 237));
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ligne=table.getSelectedRow();

				String nom =textField.getText().toString();
				String prenom =textField_1.getText().toString();
				String adresse =textField_2.getText().toString();
				String sql = "update adherent set  nom = ?, prenom = ?, adresse = ? where nom='"+nom+"'";
				try {
					if(!textField.getText().equals("") && !textField_1.getText().equals("") && !textField_2.getText().equals("")  ) {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1,nom);
					prepared.setString(2,prenom);
					prepared.setString(3,adresse);
					
					prepared.execute();
					JOptionPane.showMessageDialog(null,"l'adherent est modifié");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					UpdateTable();
					}
					else {
						JOptionPane.showMessageDialog(null,"Remplissez tout les cases");
					}
				} 
					catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
		
			}
		);
		btnModifier.setFont(new Font("Arial", Font.BOLD, 15));
		btnModifier.setBounds(549, 71, 129, 28);
		contentPane.add(btnModifier);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 188, 798, 257);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("\u2190");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel_2.setBounds(10, -4, 46, 41);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuadmins obj =new menuadmins();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.setBackground(new Color(100, 149, 237));
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateTable();
			}
		});
		btnAfficher.setFont(new Font("Arial", Font.BOLD, 15));
		btnAfficher.setBounds(549, 149, 129, 28);
		contentPane.add(btnAfficher);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Player n. 1\\Desktop\\mediatheque.jpg"));
		lblNewLabel_3.setBounds(0, -4, 818, 460);
		contentPane.add(lblNewLabel_3);
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ligne = table.getSelectedRow();
				String nom =table.getModel().getValueAt(ligne, 0).toString();
				String prenom =table.getModel().getValueAt(ligne, 1).toString();
				String adresse=table.getModel().getValueAt(ligne, 2).toString();
				textField.setText(nom);
				textField_1.setText(prenom);
				textField_2.setText(adresse);
			}
		});
		
		
		
	}
	public void UpdateTable() {
		String sql = " select nom , prenom , adresse from adherent ";
		try {
			prepared =cnx.prepareStatement(sql);
			resultat = prepared.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(resultat));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}