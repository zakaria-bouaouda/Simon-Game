package emi.GI_1A.Projet.Info;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class F2 extends JPanel
{

	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		if (Game1.g1 != null)
		{
			Game1.g1.paint((Graphics2D) g);
		}
	}

}