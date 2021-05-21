package emi.GI_1A.Projet.Info;

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
import javax.swing.Timer;

public class Game2 implements ActionListener, MouseListener
{

	public static Game2 g2;
	public int flash=0;
	public int dark, ticks, indexPattern;
	public FGame2 fG2;//LA classe F2 héritée de JPanel

	public static final int W = 800, H = 800;//Canstantes de la taille de la fenetre
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

	public Game2()
	{
		JFrame frame = new JFrame("niveau 2");
		
		fG2= new FGame2();//On appelle la classe F2
		
		frame.setSize(W +10, H+25);
		frame.setVisible(true);
		frame.addMouseListener(this);
		frame.setResizable(false);//pour empecher le redimentionnement
		frame.add(fG2);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Timer t = new Timer(15, this);//pour determiner la duree de clignotement (dans ce cas=15 CAR c'est un niveau plus difficile)
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

		g.fillRect(0, 0, W / 3, H / 2);///////////////////////////////////////////////////////////////////VERT

		if (flash == 2)
		{
			g.setColor(Color.RED);
		}
		else
		{
			g.setColor(Color.RED.darker());
		}

		g.fillRect(W / 3, 0, W/3, H/2);////////////////////////////////////////////////////ROUGE

		if (flash == 3)
		{
			g.setColor(Color.ORANGE);
		}
		else
		{
			g.setColor(Color.ORANGE.darker());
		}

		g.fillRect(2*W/3,0, W/3, H/ 2);/////////////////////////////ORONGE

		if (flash == 4)
		{
			g.setColor(Color.BLUE);
		}
		else
		{
			g.setColor(Color.BLUE.darker());
		}

		g.fillRect(0, H / 2,W/ 3, H/ 2);//////////////////////////////////BLEU
		//////////////////////////////////////////////////////////////////
		if (flash == 5)
		{
			g.setColor(Color.PINK);
		}
		else
		{
			g.setColor(Color.PINK.darker());
		}

		g.fillRect(W/3, H / 2,W/ 3, H/ 2);
		/////////////////////////////////////////////////////////////ROSE
		if (flash == 6)
		{
			g.setColor(Color.CYAN);
		}
		else
		{
			g.setColor(Color.CYAN.darker());
		}

		g.fillRect(2*W/3, H / 2,W/ 3, H/ 2);////////////////BLEU CIEL

		/////////////////////////////////////////ENCADREMENT NOIRE
		g.setColor(Color.BLACK);
		g.fillRect(0, W / 2 - W / 12, W, H / 7);//pour separer entre les couleurs horizontalement
		g.fillRect(0, 0, W/ 40, H);//pour separer entre les couleurs VERTICALEMENT
		g.fillRect(W/3, 0, W/ 40, H);
		g.fillRect(2*W/3-10, 0, W/ 40, H);
		g.fillRect(W-W/40, 0, W/ 40, H);
	
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", 1, 100));

		if (gameOver)
		{
			g.drawString("Game Over", W / 2 - 240, H / 2+20 );
		}
		else
		{
			g.drawString(indexPattern + "/" + pattern.size(), W/ 2 - 50, H / 2 + 20);
		}
		

		

		
		
	}
	
	public void mousePressed(MouseEvent e)
	/*
	 * g.fillRect(0, 0, W / 3, H / 2);///////////////////////////////////////////////////////////////////VERT
	 * g.fillRect(W / 3, 0, W/3, H/2);////////////////////////////////////////////////////ROUGE
	 * g.fillRect(2*W/3,0, W/3, H/ 2);/////////////////////////////ORONGE
	 * g.fillRect(0, H / 2,W/ 3, H/ 2);//////////////////////////////////BLEU
	 * g.fillRect(W/3, H / 2,W/ 3, H/ 2);////////////////////ROSE
	 * g.fillRect(2*W/3, H / 2,W/ 3, H/ 2);////////////////BLEU CIEL

	 * */
	{int x = e.getX(), y = e.getY();

	if (!gameOver && !creatingPattern){
	if (x > 0 && x < W/ 3 && y > 0 && y < H/ 2)//COULEUR VERT
	{
		flash = 1;
		ticks = 1;//la couleur clignote
		
	}
	else if (x > W/ 3 && x < 2*W/3 && y > 0 && y < H/ 2)//COULEUR ROUGE
	{
		flash = 2;
		ticks = 1;
		
	}
	else if (x > 2*W/3 && x < W && y > 0 && y < H/2)//COULEUR ORANGE
	{
		flash = 3;
		ticks = 1;
		
	}
	else if (x > 0 && x < W/3 && y > H/ 2 && y < H)//COULEUR BLEU
	{
		flash= 4;
		ticks = 1;
		
	}
	else if (x > W/3 && x < 2*W/3 && y > H/ 2 && y < H)//COULEUR ROSE
	{
		flash= 5;
		ticks = 1;
		
	}
	else if (x > 2*W/3 && x < W && y > H/ 2 && y < H)//COULEUR CYAN
	{
		flash= 6;
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
			gameOver = true;//sinon le joueur à perdu
		}
	}//End if flash!=0
	}//END IF
	else if(gameOver)
	{
		nouveau();//on recommence a zero
		gameOver=false;//On commence une nouvelle partie,une nouvelle chance
	}

	
		
	}
	/*public static void main(String[] args)
	{
		g2 = new Game2();
	}*/
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
					flash = random.nextInt(40) % 6 + 1;//
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
		fG2.repaint();
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

