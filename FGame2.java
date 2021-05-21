package emi.GI_1A.Projet.Info;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class FGame2 extends JPanel
{

	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		if (Game2.g2 != null)
		{
			Game2.g2.paint((Graphics2D) g);
		}
	}

}