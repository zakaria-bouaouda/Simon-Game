package emi.GI_1A.Projet.Info;


import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/*import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;*/
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class Welcome extends JFrame {

	private JPanel contentPane;
	
	 /* Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
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
		public Welcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 352);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("A props");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("R\u00E8gles de jeu");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane jop = new JOptionPane();
                
		        String mess = "Merci ! \n J'espère que vous vous amusez bien !\n";
		        mess += "Le jeu allume aléatoirement une des quatre  couleurs.\n "
		        		+ "C'est ensuite le tour du joueur qui doit appuyer sur cette même touche. \n"
		        		+ "A la manche suivante le jeu allume la même touche puis une deuxième est choisie aléatoirement. \n"
		        		+ "Le joueur doit reproduire cette nouvelle série.\n"
		        		+ " A chaque nouvelle manche réussie, une nouvelle touche s'allume en fin de série.\n"
		        		+ " La partie est terminée dès la première erreur commise par le joueur.\n";
		               
		        jop.showMessageDialog(null, mess, "À propos", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem menuItem = new JMenuItem("?");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane jop = new JOptionPane();
                
		        String mess = "Les différents étudiants en charge du projet:\n";
		        mess += "Bouaouda Zakaria\n "
		        		+"Bouilli Fadwa \n"
		        		+"El Achhab Fatima Ezzahrae \n"
		        		+"Chahid Fatima-Ezzahra\n"
		        		+"Reda El Ouahabi\n";
		               
		        jop.showMessageDialog(null, mess, "À propos", JOptionPane.INFORMATION_MESSAGE);  
			}
		});
		mnNewMenu.add(menuItem);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmMeilleurScore = new JMenuItem("Meilleur Score");
		mntmMeilleurScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
			        try
			        {
			        	Class.forName("org.gjt.mm.mysql.Driver");
			        	Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/USERS","root","");    
			        	Statement st =(Statement) conn.createStatement();
			            
			            String sql="select max(score) from scor";
			            
			            ResultSet rs=(ResultSet) st.executeQuery(sql);
			            while(rs.next())
			            {
			            	JOptionPane jop = new JOptionPane();
			                
			    	        String mess = "le meilleur score est: "+String.valueOf(rs.getInt(1));
			    	               
			    	        jop.showMessageDialog(null, mess, "Meilleur Score", JOptionPane.INFORMATION_MESSAGE);
			            }
			            conn.close();
			        }
			        catch(Exception f)
			        {
			            System.out.println(f);
			        }
			}
		});
		mnFichier.add(mntmMeilleurScore);
		
		JMenuItem mntmFermer = new JMenuItem("Fermer");
		mntmFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
		mnFichier.add(mntmFermer);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image mg=new ImageIcon(this.getClass().getResource("/img.jpeg")).getImage();

		final JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(30, 144, 255));
		comboBox.setToolTipText("Level ");
		comboBox.addItem("Easy");
		comboBox.addItem("Hard");
		comboBox.setSelectedItem(null);
		comboBox.setBounds(196, 127, 184, 20);
		contentPane.add(comboBox);
		
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom=(String)comboBox.getSelectedItem();
				if(nom.equals("Easy")) {
					 Game1.g1=new Game1();
				}
				else {
					 Game2.g2=new Game2();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setBounds(222, 171, 144, 43);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		Image mg1=new ImageIcon(this.getClass().getResource("/img.jpeg")).getImage();
		
		JLabel lblNewLabel_1 = new JLabel("Memory Chalenge");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 43));
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setBounds(57, 29, 463, 57);
		contentPane.add(lblNewLabel_1);
		lblNewLabel.setIcon(new ImageIcon(mg1));
		lblNewLabel.setBounds(0, 0, 573, 327);
		contentPane.add(lblNewLabel);
		
}
}
