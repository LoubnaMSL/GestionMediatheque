package GestionMedia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class gestionDVD extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	Connection cnx =null;
	PreparedStatement prepared =null ;
	ResultSet resultat =null;
	private JTextField textField_4;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionDVD frame = new gestionDVD();
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
	public gestionDVD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 492);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		cnx= connectionMysql.ConnectionDB();
		
		JLabel lblNewLabel = new JLabel("Gestion des DVD");
		
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuadmins obj =new menuadmins();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();

			}
		});
		JLabel lblNewLabel_2 = new JLabel("\u2190");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuadmins obj =new menuadmins();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 36));
		lblNewLabel_2.setBounds(10, -4, 46, 41);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(34, 0, 798, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Realisateur");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_1.setBounds(34, 84, 104, 22);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(161, 118, 193, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBackground(new Color(100, 149, 237));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom =textField_4.getText().toString();
				String realisateur =textField_5.getText().toString();
				String producteur =textField.getText().toString();
				String editeur =textField_6.getText().toString();
				String acteurs =textField_7.getText().toString();
				String sql = "insert into dvd (nom , realisateur ,producteur , editeur , acteurs) values ( ? , ? ,? ,? , ?) ";
				try {
					if(!textField_4.getText().equals("") && !textField_5.getText().equals("") && !textField.getText().equals("")  && !textField_6.getText().equals("")  && !textField_7.getText().equals("") ) {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1,nom);
					prepared.setString(2,realisateur);
					prepared.setString(3,producteur);
					prepared.setString(4,editeur);
					prepared.setString(5,acteurs);
					
					prepared.execute();
					JOptionPane.showMessageDialog(null,"le DVD est ajouté");
					textField_4.setText("");
					textField_5.setText("");
					textField.setText("");
					textField_6.setText("");
					textField_7.setText("");
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
			
		});

		btnNewButton.setBounds(612, 52, 116, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.setBackground(new Color(100, 149, 237));
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ligne=table.getSelectedRow();
				String nom =textField_4.getText().toString();
				String realisateur =textField_5.getText().toString();
				String producteur =textField.getText().toString();
				String editeur =textField_6.getText().toString();
				String acteurs =textField_7.getText().toString();
				String sql =" update dvd set nom = ?, realisateur =?, producteur = ?, editeur =?, acteurs =?  where nom = '"+ nom +"'";
				try {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1,nom);
					prepared.setString(2,realisateur);
					prepared.setString(3,producteur);
					prepared.setString(4,editeur);
					prepared.setString(5,acteurs);
					prepared.execute();
					JOptionPane.showMessageDialog(null, "le DVD est modifié ");
					textField_4.setText("");
					textField_5.setText("");
					textField.setText("");
					textField_6.setText("");
					textField_7.setText("");
					UpdateTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		
		btnNewButton_1.setBounds(612, 99, 116, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.setBackground(new Color(100, 149, 237));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "delete from dvd where nom = ? and realisateur =? and producteur = ? and editeur =? and acteurs =? ";
				String nom =textField_4.getText().toString();
				String realisateur =textField_5.getText().toString();
				String producteur =textField.getText().toString();
				String editeur =textField_6.getText().toString();
				String acteurs =textField_7.getText().toString();
				try {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1,nom);
					prepared.setString(2,realisateur);
					prepared.setString(3,producteur);
					prepared.setString(4,editeur);
					prepared.setString(5,acteurs);
					prepared.execute();
					JOptionPane.showMessageDialog(null, "le DVD est supprimé ");
					textField_4.setText("");
					textField_5.setText("");
					textField.setText("");
					textField_6.setText("");
					textField_7.setText("");
					UpdateTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_2.setBounds(612, 147, 116, 31);
		contentPane.add(btnNewButton_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(161, 84, 193, 26);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(161, 150, 193, 26);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(161, 184, 193, 26);
		contentPane.add(textField_7);
		
		JLabel lblNewLabel_1_1 = new JLabel("Producteur");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(34, 122, 104, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Editeur");
		lblNewLabel_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_1_1_1.setBounds(34, 150, 116, 22);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Acteurs");
		lblNewLabel_1_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_1_1_2.setBounds(44, 184, 94, 22);
		contentPane.add(lblNewLabel_1_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 244, 873, 198);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ligne = table.getSelectedRow();
				String nom =table.getModel().getValueAt(ligne, 0).toString();
				String realisateur =table.getModel().getValueAt(ligne, 1).toString();
				String producteur=table.getModel().getValueAt(ligne, 2).toString();
				String editeur=table.getModel().getValueAt(ligne, 3).toString();
				String acteurs=table.getModel().getValueAt(ligne, 4).toString();
				textField_4.setText(nom);
				textField_5.setText(realisateur);
				textField.setText(producteur);
				textField_6.setText(editeur);
				textField_7.setText(acteurs);
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nom");
		lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_1_2.setBounds(34, 59, 80, 14);
		contentPane.add(lblNewLabel_1_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(161, 52, 193, 26);
		contentPane.add(textField_4);
		
		JButton btnNewButton_2_1 = new JButton("Afficher");
		btnNewButton_2_1.setBackground(new Color(100, 149, 237));
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateTable();
			}
		});
		btnNewButton_2_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_2_1.setBounds(612, 189, 116, 31);
		contentPane.add(btnNewButton_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Player n. 1\\Desktop\\mediatheque.jpg"));
		lblNewLabel_3.setBounds(0, -4, 912, 457);
		contentPane.add(lblNewLabel_3);
	}
	public void UpdateTable() {
		String sql = " select * from dvd ";
		try {
			prepared = cnx.prepareStatement(sql);
			resultat = prepared.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(resultat));
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
