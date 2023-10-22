package com.AlexLongo.BlockadeRunner1776.window;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation 
{
	private int speed;
	private int frames;
	
	private int index = 0;
	private int count = 0;
	
	private BufferedImage[] images;
	private BufferedImage currentImg;
	
	public Animation(int speed, BufferedImage... args)
	{
		this.speed = speed;
		
		images = new BufferedImage[args.length];
		
		for(int i = 0; i < args.length; i++)
		{
			images[i] = args[i];
		}	// end for loop
		
		frames = args.length;
		
	}	// end public Animation() method
	
	public void runAnimation()
	{
		index++;
		if(index > speed)
		{
			index = 0;
			nextFrame();
		}
		
	}	// end public void runAnimation() method
	
	private void nextFrame()
	{
		for(int i = 0; i < frames; i++)
		{
			if (count == i)
			{
				currentImg = images[i];
			}
		}
		
		count++;
		
		// this code repeats the animation once it has gone all the way through
		////////////////////////////////////////////////////////////////////////////
		if (count > frames)
		{
			count = 0;
		}
		////////////////////////////////////////////////////////////////////////////
		
		
	}	// end private void nextFrame() method
	
	public void drawAnimation(Graphics g, int x, int y)
	{
		g.drawImage(currentImg, x, y, null);
		
	}
	
	public void drawAnimation(Graphics g, int x, int y, int scaleX, int scaleY)
	{
		g.drawImage(currentImg, x, y, scaleX, scaleY, null);
		
	}
	
	
}	// end public class Animation
