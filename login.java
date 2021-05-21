package emi.GI_1A.Projet.Info;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class login extends JFrame {

	private JPanel contentPane;
	protected JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		user = new JTextField();
		user.setBounds(156, 118, 129, 20);
		contentPane.add(user);
		user.setColumns(10);
		
		JButton btnNewButton = new JButton("se connecter");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=user.getText().toString();
				String passe=pass.getText().toString();
		     if(name.equals("root")&&passe.equals("root")){
           		  Welcome ac =new Welcome();
          		   ac.setVisible(true);
           		   
           	   }
					
				
			else {
					try {
		             	   Class.forName("org.gjt.mm.mysql.Driver");
		             	   Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/USERS","root","");
		             	   Statement st=con.createStatement();
		             	   String sql="select* from players  where nom='"+user.getText()+"'and password	='"+ pass.getText()+"'";
		             	   ResultSet rs=st.executeQuery(sql);
		             	   if(rs.next()) {
		             		   
		             		 Welcome ac =new Welcome();
		             		   ac.setVisible(true);
		             		  
		             	   }
		             	   
		             	   else {
		             		   JOptionPane.showMessageDialog(null,"Erreur username or password ");
		             		  
		             	   }
		             	   con.close();
				}catch(Exception ex ) {
	             	   
	                }
				
             	   
             	   
				}
			}
		});
		btnNewButton.setBounds(156, 220, 129, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("s'inscrire");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBackground(Color.BLUE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inscrire in =new inscrire();
				in.setVisible(true);
			
			}
		});
		btnNewButton_1.setBounds(381, 220, 129, 36);
		contentPane.add(btnNewButton_1);
		
		JLabel Password = new JLabel("Password");
		Password.setBackground(new Color(255, 255, 0));
		Password.setForeground(new Color(0, 0, 128));
		Password.setFont(new Font("Tahoma", Font.BOLD, 15));
		Password.setBounds(0, 172, 139, 17);
		contentPane.add(Password);
		
		JLabel name = new JLabel("Nom d'utilisateur");
		name.setForeground(new Color(0, 0, 128));
		name.setFont(new Font("Tahoma", Font.BOLD, 16));
		name.setBounds(0, 114, 146, 27);
		contentPane.add(name);
		
		pass = new JPasswordField();
		pass.setBounds(156, 172, 129, 20);
		contentPane.add(pass);
		
		JLabel font = new JLabel("");
		font.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		Image mg=new ImageIcon(this.getClass().getResource("/br.jpg")).getImage();
		
		JLabel lblNewLabel = new JLabel("Page D'Authentification ");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setBounds(112, 0, 332, 36);
		contentPane.add(lblNewLabel);
		font.setIcon(new ImageIcon(mg));
		font.setDisplayedMnemonic(' ');
		font.setBounds(0, 0, 578, 334);
		contentPane.add(font);
	}

	
}
