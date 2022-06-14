package GestionMedia;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;

public class gestionEmprunt extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionEmprunt frame = new gestionEmprunt();
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
	public gestionEmprunt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 917, 497);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Date Emprunt ");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(31, 65, 116, 17);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(157, 125, 169, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(157, 156, 169, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblIdEprunteur = new JLabel("num Emprunteur");
		lblIdEprunteur.setForeground(new Color(0, 0, 0));
		lblIdEprunteur.setFont(new Font("Arial", Font.BOLD, 15));
		lblIdEprunteur.setBounds(22, 127, 125, 14);
		contentPane.add(lblIdEprunteur);
		
		JLabel lblNumroEmprun = new JLabel("Numero Emprunt");
		lblNumroEmprun.setForeground(new Color(0, 0, 0));
		lblNumroEmprun.setFont(new Font("Arial", Font.BOLD, 15));
		lblNumroEmprun.setBounds(22, 158, 129, 14);
		contentPane.add(lblNumroEmprun);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBackground(new Color(100, 149, 237));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(633, 54, 136, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.setBackground(new Color(100, 149, 237));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel_2.setBounds(10, -4, 46, 41);
		contentPane.add(lblNewLabel_2);
		
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_1.setBounds(633, 92, 136, 27);
		contentPane.add(btnNewButton_1);
		
		JLabel lblDateRetourne = new JLabel("Date Retourne ");
		lblDateRetourne.setForeground(new Color(0, 0, 0));
		lblDateRetourne.setFont(new Font("Arial", Font.BOLD, 15));
		lblDateRetourne.setBounds(31, 97, 116, 17);
		contentPane.add(lblDateRetourne);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 198, 881, 249);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1_1 = new JButton("Supprimer");
		btnNewButton_1_1.setBackground(new Color(100, 149, 237));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(633, 125, 136, 27);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Gestion des Emprunts");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_1.setBounds(277, 4, 281, 38);
		contentPane.add(lblNewLabel_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(157, 94, 169, 20);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(157, 65, 169, 20);
		contentPane.add(dateChooser_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Afficher");
		btnNewButton_1_1_1.setBackground(new Color(100, 149, 237));
		btnNewButton_1_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_1_1_1.setBounds(633, 160, 136, 27);
		contentPane.add(btnNewButton_1_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Player n. 1\\Desktop\\mediatheque.jpg"));
		lblNewLabel_3.setBounds(0, -4, 901, 451);
		contentPane.add(lblNewLabel_3);
	
	}

}
