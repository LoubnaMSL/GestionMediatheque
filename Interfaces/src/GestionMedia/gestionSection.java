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

public class gestionSection extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				gestionSection frame = new gestionSection();
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
public gestionSection() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 917, 497);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(255, 255, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblNewLabel_4 = new JLabel("\u2190");
	lblNewLabel_4.setForeground(new Color(255, 255, 255));
	lblNewLabel_4.setBackground(new Color(255, 255, 255));
	lblNewLabel_4.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			menuadmins obj =new menuadmins();
			obj.setVisible(true);
			obj.setLocationRelativeTo(null);
			dispose();
		}
	});
	lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 36));
	lblNewLabel_4.setBounds(10, -4, 46, 41);
	contentPane.add(lblNewLabel_4);
	
	
	JLabel lblNewLabel = new JLabel("Date prévu");
	lblNewLabel.setForeground(new Color(0, 0, 0));
	lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
	lblNewLabel.setBounds(31, 65, 116, 17);
	contentPane.add(lblNewLabel);
	
	textField_2 = new JTextField();
	textField_2.setBounds(157, 125, 249, 20);
	contentPane.add(textField_2);
	textField_2.setColumns(10);
	
	textField_3 = new JTextField();
	textField_3.setBounds(157, 156, 249, 20);
	contentPane.add(textField_3);
	textField_3.setColumns(10);
	
	JLabel lblmontant= new JLabel("Montant");
	lblmontant.setForeground(new Color(0, 0, 0));
	lblmontant.setFont(new Font("Arial", Font.BOLD, 15));
	lblmontant.setBounds(31, 127, 116, 14);
	contentPane.add(lblmontant);
	
	JLabel lblIdSanctionneur = new JLabel("Id sanctionneur");
	lblIdSanctionneur.setForeground(new Color(0, 0, 0));
	lblIdSanctionneur.setFont(new Font("Arial", Font.BOLD, 15));
	lblIdSanctionneur.setBounds(22, 158, 125, 14);
	contentPane.add(lblIdSanctionneur);
	
	JButton btnNewButton = new JButton("Ajouter");
	btnNewButton.setBackground(new Color(100, 149, 237));
	btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
	btnNewButton.setBounds(658, 54, 136, 28);
	contentPane.add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("Modifier");
	btnNewButton_1.setBackground(new Color(100, 149, 237));
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 15));
	btnNewButton_1.setBounds(658, 93, 136, 28);
	contentPane.add(btnNewButton_1);
	
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
	btnNewButton_1_1.setBounds(658, 125, 136, 28);
	contentPane.add(btnNewButton_1_1);
	
	JLabel lblNewLabel_1 = new JLabel("Gestion des Sanctions");
	lblNewLabel_1.setForeground(new Color(0, 0, 0));
	lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 25));
	lblNewLabel_1.setBounds(284, 3, 371, 38);
	contentPane.add(lblNewLabel_1);
	
	JDateChooser dateChooser = new JDateChooser();
	dateChooser.setBounds(157, 94, 249, 20);
	contentPane.add(dateChooser);
	
	JDateChooser dateChooser_1 = new JDateChooser();
	dateChooser_1.setBounds(157, 65, 249, 20);
	contentPane.add(dateChooser_1);
	
	JLabel lblNewLabel_2 = new JLabel("Date retour ");
	lblNewLabel_2.setForeground(new Color(0, 0, 0));
	lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
	lblNewLabel_2.setBounds(31, 93, 116, 17);
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
	JButton btnNewButton_1_1_1 = new JButton("Afficher");
	btnNewButton_1_1_1.setBackground(new Color(100, 149, 237));
	btnNewButton_1_1_1.setFont(new Font("Arial", Font.BOLD, 15));
	btnNewButton_1_1_1.setBounds(658, 159, 136, 28);
	contentPane.add(btnNewButton_1_1_1);
	
	JLabel lblNewLabel_3 = new JLabel("New label");
	lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Player n. 1\\Desktop\\mediatheque.jpg"));
	lblNewLabel_3.setBounds(0, -4, 901, 462);
	contentPane.add(lblNewLabel_3);

}

		}
