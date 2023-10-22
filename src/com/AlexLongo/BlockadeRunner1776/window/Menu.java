package com.AlexLongo.BlockadeRunner1776.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Menu 
{
	private BufferedImage btnNewGame = null;
	private BufferedImage btnLoadGame = null;
	private BufferedImage btnHighScores = null;
	private BufferedImage btnCredits = null;
		
	
	public void render(Graphics g)
	{
		
		Font fnt0 = new Font("Bookman Old Style", Font.PLAIN, 35);
		g.setFont(fnt0);
		g.setColor(new Color(128, 61, 0));
		g.drawString("Blockade Runner", 465, 50);
		g.drawString("1776 Edition", 463, 100);
		
		// New Game Button
		BufferedImageLoader loader = new BufferedImageLoader();
		btnNewGame = loader.loadImage(256, 128, "res/btn_newGame.png");
		g.drawImage(btnNewGame, 38, 530, null);
		
		// Load Game Button
		btnLoadGame = loader.loadImage(256, 128, "res/btn_LoadGame.png");
		g.drawImage(btnLoadGame, 292, 530, null);
		
		// Load Game Button
		btnHighScores = loader.loadImage(256, 128, "res/btn_HighScores.png");
		g.drawImage(btnHighScores, 546, 530, null);
		
		// Credits Button
		btnCredits = loader.loadImage(256, 128, "res/btn_Credits.png");
		g.drawImage(btnCredits, 28, 10, null);
		
		//Mouse Tester box
		// g.setColor(new Color(255, 255, 255));
		// g.fillRect(38,  530,  204,  54);
		
		
		
		// in progress
		
		
		
	}
}
