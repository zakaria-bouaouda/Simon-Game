package emi.GI_1A.Projet.Info;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class Acceuil2 extends JFrame{
	private JMenuBar menuBar = new JMenuBar();
	  private JMenu test1 = new JMenu("Fichier");
	  private JMenu test1_2 = new JMenu("difficulté");
	  private JMenu test2 = new JMenu("à propos");

	  private JMenuItem item1 = new JMenuItem("Ouvrir");
	  private JMenuItem item2 = new JMenuItem("Fermer");
	  private JMenuItem item3 = new JMenuItem("meilleur score");
	  private JMenuItem item4 = new JMenuItem("Règles du jeux");
	  private JMenuItem item5 = new JMenuItem("?");
	  
	  /*
	  private JCheckBoxMenuItem jcmi1 = new JCheckBoxMenuItem("easy");
	  private JCheckBoxMenuItem jcmi2 = new JCheckBoxMenuItem("hard");
	  */
	  private JRadioButton radio1=new JRadioButton("Easy");
	  private JRadioButton radio2=new JRadioButton("Hard");
	  ButtonGroup btng=new ButtonGroup();
	  
	  
	

	
	F1 pan=new F1();
	public Acceuil2(){
		this.setTitle("EMI GAME");
		this.setSize(550,550);
		this.setLocationRelativeTo(null);    //POUR positionner au centre
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //EXIT_ON_CLOSE 
		this.setResizable(false);  // POUR empecher le redimensionnement
		//this.setContentPane(pan);
		//this.setLayout(new BorderLayout());          //POUR CREER LE BUTTON
		//this.getContentPane().add(bouton,BorderLayout.SOUTH);//
		this.getContentPane().add(pan);//,BorderLayout.CENTER);//
		///////////////////////////////////////////////////////////////////////////////////////////////////////MENU
		this.test1.add(item1);
		this.test1.add(item2);
		
		 //On ajoute les éléments dans notre sous-menu
		btng.add(radio1);//on groupe les 2 radio pour n'avaoir qu'un seule choix
		btng.add(radio2);
		
		this.test1_2.add(radio1);
		this.test1_2.add(radio2);
	    
		//Ajout du sous-menu dans notre menu
	    this.test1.add(this.test1_2);
	    this.test2.add(item3);
	    this.test2.add(item4);
	    this.test2.add(item5);
	    item2.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent arg0) {//LE BOUTON FERMER  DU MENU
	          System.exit(0);
	        }        
	      });
	  //Ajout de ce que doit faire le "Regles du jeux"
	    item4.addActionListener(new ActionListener(){
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
	  //Ajout de ce que doit faire le "?"
	    item5.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {
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
	    item1.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
		       if (radio1.isSelected())
		       {
		    	   Game1.g1=new Game1();
		       }
		       else
		       {
		    	   Game2.g2=new Game2();
		       }
		       
		       
		      

		        
		      }            
		    });
	    //meilleur score
	    item3.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
		    	  Connection conn=null;
			    	Statement st=null;
			    	ResultSet rs;
			        try
			        {
			        	Class.forName("oracle.jdbc.driver.OracleDriver");
			            conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","hafsa.emi");    
			            st =conn.createStatement();
			            
			            String sql="select max(score) from ms";
			            
			            rs=st.executeQuery(sql);
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
	    
	    
		
		
		
		
	    this.menuBar.add(test1);
	    this.menuBar.add(test2);
	    this.setJMenuBar(menuBar);
		
	    
	    this.setVisible(true);
		go();
	}
	/*
	private void go(){//POUR LA CINEMATIQUE DU TITRE
		//for(int i = -50; i < pan.getWidth(); i++){
		for(;;){     //
		int x = pan.getPosX(), y = pan.getPosY();
		x++;
		y++;
		pan.setPosX(x);
		pan.setPosY(y);
		pan.repaint();
		try {
		Thread.sleep(15);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
		if(x == pan.getWidth() || y == pan.getHeight()){
		pan.setPosX(-50);
		pan.setPosY(-50);
		}            //IF
		}            //FOR
		}            //GO
	*/
	private void go(){
		int x = pan.getPosX(), y = pan.getPosY();
		boolean backX = false;
		boolean backY = false;
		while (true) {
		if (x < 1)
		backX = false;
		if (x > pan.getWidth() - 50)
		backX = true;
		if (y < 1)
		backY = false;
		if (y > pan.getHeight() - 50)
		backY = true;
		if (!backX)
		pan.setPosX(++x);
		else
		pan.setPosX(--x);
		if (!backY)
		pan.setPosY(++y);
		else
		pan.setPosY(--y);

		pan.repaint();

		try {
		Thread.sleep(10);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}}           
		}
	public static void main(String args[]){
		
		Acceuil2 a=new Acceuil2();
		
	}

}
