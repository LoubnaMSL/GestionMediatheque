package GestionMedia;
import java.sql.*;

import javax.swing.JOptionPane;
public class connectionMysql {

			Connection con =null;
			public static Connection ConnectionDB() {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gestionmedia","root","");
					return con;
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null , e);
					return null;
				}
			}



}
