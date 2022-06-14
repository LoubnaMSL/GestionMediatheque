package GestionMedia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class Authentification extends JFrame{

	private JFrame frame;
	private JTextField loginfeild;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	
	Connection cnx =null;
	PreparedStatement prepared =null ;
	ResultSet resultat =null;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification window = new Authentification();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Authentification() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 829, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		cnx= connectionMysql.ConnectionDB();
		
		JLabel lblNewLabel = new JLabel("Authentification");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(240, 255, 240));
		lblNewLabel.setBounds(10, 0, 793, 63);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login ");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(67, 152, 164, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(67, 189, 164, 26);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		loginfeild = new JTextField();
		loginfeild.setBounds(258, 156, 261, 26);
		frame.getContentPane().add(loginfeild);
		loginfeild.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(258, 193, 261, 26);
		frame.getContentPane().add(passwordField);
		
		btnNewButton = new JButton("Se connecter");
		btnNewButton.setBackground(new Color(100, 149, 237));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String login0 = loginfeild.getText().toString();
				String password0 = passwordField.getText().toString();
				
				String sql= "select login , password from utilisqteurs ";
				try {
					
					prepared = cnx.prepareStatement(sql);
					resultat = prepared.executeQuery();
					
					int i=0;
					
					if(login0.equals("") || password0.equals("")) {

						JOptionPane.showMessageDialog(null, " Champs vide !!");
					}else {
						while(resultat.next()) {
							String login1 = resultat.getString("login").toString();
							String password1 = resultat.getString("password").toString();
							if((login0.equals(login1)) && (password0.equals(password1))) {
								
								i=1;
								menuadmins menu =new menuadmins();
								menu.setVisible(true);
								
							}
							
						}
						
						if(i==0) {
						 JOptionPane.showMessageDialog(null, " Connexion echouee , information incorrecte :(");
						}
					}
					
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				
			}});
		
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBounds(258, 245, 261, 33);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Player n. 1\\Desktop\\mediatheque.jpg"));
		lblNewLabel_2.setBounds(0, 0, 813, 449);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
