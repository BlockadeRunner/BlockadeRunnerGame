package com.AlexLongo.BlockadeRunner1776.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HighScores 
{
	public void render(Graphics g)
	{
		// Background
		g.setColor(new Color(25, 191, 224));
		g.fillRect(0,  0,  800,  600);
		
		Font fnt0 = new Font("Pixelari", Font.PLAIN, 35);
		g.setFont(fnt0);
		g.setColor(new Color(128, 61, 0));
		g.drawString("Blockade Runner", 465, 50);
		g.drawString("1776 Edition", 463, 100);
		
		
	}
}
