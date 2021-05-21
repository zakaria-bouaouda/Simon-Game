package emi.GI_1A.Projet.Info;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.mysql.jdbc.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class inscrire extends JFrame {

	private JPanel contentPane;
	private JTextField nom;
	private JTextField prenom;
	private JTextField age;
	private JTextField pass;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inscrire frame = new inscrire();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public inscrire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nom = new JTextField();
		nom.setBounds(111, 69, 86, 20);
		contentPane.add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setBounds(111, 129, 86, 20);
		contentPane.add(prenom);
		prenom.setColumns(10);
		
		age = new JTextField();
		age.setBounds(111, 186, 86, 20);
		contentPane.add(age);
		age.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("nom");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(45, 71, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("prenom");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(45, 131, 67, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("age");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(45, 188, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("ajouter");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					 Class.forName("org.gjt.mm.mysql.Driver");
	             	   Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/USERS","root","");
	             	   String sql="insert into players  values(?,?,?,?,?)";
	             	   java.sql.PreparedStatement st=con.prepareStatement(sql);
	             	   st.setString(1,nom.getText());
	             	  st.setString(2,prenom.getText());
	             	 st.setString(3,age.getText());	
	             	 st.setString(4,pass.getText());
	             	
	             	 st.execute();
	             	 JOptionPane.showMessageDialog(null, "inscription avec succès");
	             	 login lg=new login();
	             	 lg.setVisible(true);
	             	 con.close();

				}catch(Exception ex) {
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(324, 128, 122, 39);
		contentPane.add(btnNewButton);
		
		pass = new JTextField();
		pass.setBounds(111, 244, 86, 20);
		contentPane.add(pass);
		pass.setColumns(10);
		
		lblNewLabel_3 = new JLabel("mot de passe ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 246, 91, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		Image mg=new ImageIcon(this.getClass().getResource("/pattern.png")).getImage();
		
		lblNewLabel_5 = new JLabel("PAGE D'INSCRIPTION");
		lblNewLabel_5.setFont(new Font("Wide Latin", Font.ITALIC, 18));
		lblNewLabel_5.setBounds(111, 29, 396, 20);
		contentPane.add(lblNewLabel_5);
		lblNewLabel_4.setIcon(new ImageIcon(mg));
		lblNewLabel_4.setBounds(0, 0, 576, 299);
		contentPane.add(lblNewLabel_4);
	}
}

