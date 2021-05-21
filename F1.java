package emi.GI_1A.Projet.Info;

import javax.swing.JPanel;

import java.awt.Graphics; //POUR ECRIRE de texte
import java.awt.Color;
import java.awt.Font;    //LE FONT DU TEXTE
//IMAGE
import java.awt.Image;
import java.io.File;
import java.io.IOException;   //ON Utilise l'exception pour le chargement d'images
import javax.imageio.ImageIO;//


public class F1 extends JPanel {
	private int posX = -200;
	private int posY = -100;
	public void paintComponent(Graphics g){
		try {
			Image img = ImageIO.read(new File("C:\\Users\\Pc\\Desktop\\PROJET\\image.jpeg"));//‪
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);//Pour une image de fond‪C:\\Users\\Pc\\Desktop\\PROJET\\CapAceuil.jpg
			} catch (IOException e) {
			e.printStackTrace();
			}
		Font K = new Font("Wide Latin", Font.ITALIC, 24);
		g.setFont(K);
		g.setColor(Color.YELLOW);//CYAN
		g.drawString("MEMORY CHALLENGE", 10,200);
		
		
		Font font = new Font("Wide Latin", Font.ITALIC, 15);
		g.setFont(font);
		g.setColor(Color.yellow);//CYAN
		g.drawString("MEMORY CHALLENGE",  posX,posY);
		
		}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
			this.posX = posX;
	}
	public int getPosY() {
			return posY;
	}
	public void setPosY(int posY) {
			this.posY = posY;
	}
}
