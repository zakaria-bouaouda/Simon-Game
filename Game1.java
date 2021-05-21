package emi.GI_1A.Projet.Info;
import java.sql.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Game1 extends JFrame implements ActionListener, MouseListener
{
	//public static int score;//pour enregistrer le meilleur score
	public static Game1 g1;
	public int flash=0;
	public int dark, ticks, indexPattern;
	public F2 f2;//LA classe F2 héritée de JPanel

	public static final int WIDTH = 800, HEIGHT = 800;//Canstantes de la taille de la fenetre
	public boolean creatingPattern = true;

	public ArrayList<Integer> pattern;

	public Random random;

	private boolean gameOver;
	public void nouveau()
	{
		random = new Random();
		pattern = new ArrayList<Integer>();
		indexPattern = 0;
		dark = 2;
		flash = 0;
		ticks = 0;
	}

	public Game1 ()
	{
		JFrame frame = new JFrame("Projet integré");
		
		f2 = new F2();//On appelle la classe F2
		
		frame.setSize(WIDTH +10, HEIGHT+25);
		frame.setVisible(true);
		frame.addMouseListener(this);
		frame.setResizable(false);//pour empecher le redimentionnement
		frame.add(f2);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//EXIT_ON_CLOSE
		Timer t = new Timer(10, this);//pour determiner la duree de clignotement 
		nouveau();//pour commencer la premiere fois
		t.start();//java.swing.Timer.start()

		
	}
	

	public void paint(Graphics2D g)
	{
		if (flash == 1)
		{
			g.setColor(Color.GREEN);//la couleur clignote
		}
		else
		{
			g.setColor(Color.GREEN.darker());//la couleur ne clignote pas
		}

		g.fillRect(0, 0, WIDTH / 2, HEIGHT / 2);

		if (flash == 2)
		{
			g.setColor(Color.RED);
		}
		else
		{
			g.setColor(Color.RED.darker());
		}

		g.fillRect(WIDTH / 2, 0, WIDTH / 2, HEIGHT / 2);

		if (flash == 3)
		{
			g.setColor(Color.ORANGE);
		}
		else
		{
			g.setColor(Color.ORANGE.darker());
		}

		g.fillRect(0, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);

		if (flash == 4)
		{
			g.setColor(Color.BLUE);
		}
		else
		{
			g.setColor(Color.BLUE.darker());
		}

		g.fillRect(WIDTH / 2, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);

		g.setColor(Color.BLACK);
		
		g.fillRect(WIDTH / 2 - WIDTH / 12, 0, WIDTH / 7, HEIGHT);//pour separer entre les couleurs VERTICALEMENT
		g.fillRect(0, WIDTH / 2 - WIDTH / 12, WIDTH, HEIGHT / 7);//pour separer entre les couleurs horizontalement
		g.fillRoundRect(220, 220, 350, 350, 300, 300);//POUR LE MILIEU, de couleur noir
		g.setColor(Color.BLACK);
		g.setStroke(new BasicStroke(200));
		g.drawOval(-100, -100, WIDTH + 200, HEIGHT + 200);//pour dessiner un ovale

		g.setColor(Color.black);
		g.setStroke(new BasicStroke(10));
		g.drawOval(0, 0, WIDTH, HEIGHT);//pour faire un contour du cercle
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", 1, 120));
		if (gameOver)
		{
			g.drawString("Game Over", WIDTH / 2 - 300, HEIGHT / 2 + 30);
		}
		else
		{
			g.drawString(indexPattern + "/" + pattern.size(), WIDTH / 2 - 100, HEIGHT / 2 + 42);
		}

		
	}
	
	public void mousePressed(MouseEvent e)
	{
		int x = e.getX(), y = e.getY();

		if (!gameOver && !creatingPattern){
		if (x > 0 && x < WIDTH / 2 && y > 0 && y < HEIGHT / 2)//COULEUR VERT
		{
			flash = 1;
			ticks = 1;//la couleur clignote
			
		}
		else if (x > WIDTH / 2 && x < WIDTH && y > 0 && y < HEIGHT / 2)//COULEUR ROUGE
		{
			flash = 2;
			ticks = 1;
			
		}
		else if (x > 0 && x < WIDTH / 2 && y > HEIGHT / 2 && y < HEIGHT)//COULEUR ORANGE
		{
			flash = 3;
			ticks = 1;
			
		}
		else if (x > WIDTH / 2 && x < WIDTH && y > HEIGHT / 2 && y < HEIGHT)//COULEUR BLEU
		{
			flash= 4;
			ticks = 1;
			
		}
		
		if (flash != 0)//verifier si le joueur a cliqué sur la bonne couleur
		{
			if (pattern.get(indexPattern) == flash)
			{
				indexPattern++;//Si la couleur cliqué correspond à la meme couleur clignoté
			}
			else
			{
				int score;
				//score=pattern.get(indexPattern);
				score=pattern.size();
				Connection conn=null;
		    	Statement st=null;
		    	ResultSet rs;
		        try
		        {
		        	Class.forName("oracle.jdbc.driver.OracleDriver");
		            conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","hafsa.emi");    
		            st =conn.createStatement();
		            
		            String s="insert into ms values("+score+")";
		            //String sql="select score from ms";
		            st.executeQuery(s);  
		          //  rs=st.executeQuery(sql);
		           
		            	JOptionPane jop = new JOptionPane();
		                
		    	        String mess = "vous avez perdu et votre score est: "+String.valueOf(score);
		    	               
		    	        jop.showMessageDialog(null, mess, "OK", JOptionPane.INFORMATION_MESSAGE);
		           
		            conn.close();
		        }
		        catch(Exception f)
		        {
		            System.out.println(f);
		        }
				//int n;//MEILLEUR SCORE
				gameOver = true;//sinon le joueur à perdu
				
				


				
			}
		}//End if flash!=0
		}//END IF
		else if(gameOver==true)
		{
			
			
			
			
	           
	        nouveau();//on recommence a zero
			gameOver=false;//On commence une nouvelle partie,une nouvelle chance
		}
		

		
	}
	public static void main(String[] args)
	{
		g1 = new Game1();
	}
	public void actionPerformed(ActionEvent e)
	{
		ticks++;//on incremente ticks de 1 à chaque fois 

		if (ticks % 30 == 0)
		{
			flash = 0;

			if (dark >= 0)
			{
				dark--;
			}
		}

		if (creatingPattern)
		{
			if (dark <= 0)
			{
				if (indexPattern >= pattern.size())
				{
					flash = random.nextInt(40) % 4 + 1;
					pattern.add(flash);
					indexPattern = 0;
					creatingPattern = false;
				}
				else
				{
					flash = pattern.get(indexPattern);
					indexPattern++;
				}

				dark = 2;
			}
		}
		else if (indexPattern == pattern.size())
		{
			creatingPattern = true;
			indexPattern = 0;
			dark = 2;
		}
		f2.repaint();
	}
	

	public void mouseClicked(MouseEvent e)
	{

		
	}

	public void mouseReleased(MouseEvent e)
	{

	}

	public void mouseEntered(MouseEvent e)
	{
		

	}

	public void mouseExited(MouseEvent e)
	{
		

	}

}

