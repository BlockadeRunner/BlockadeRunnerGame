package com.AlexLongo.BlockadeRunner1776.window;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader 
{
	File f = null;
	int imgWidth = 0;
	int imgHeight = 0;
	
	
	private BufferedImage image;
	
	// unused:
	//   private Image image2;
	//   private BufferedImage image3;
	
	
	/*
	public BufferedImage loadImage(String path)
	{
		try 
		{
			image = ImageIO.read(getClass().getResource(path));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return image;
	}
	*/
	
	
	
	// Code to use if this ^^^ one doesn't work:
	
	
	
	
	public BufferedImage loadImage(int imgWidth, int imgHeight, String path)
	{
		try 
		{
			f = new File(path);
			image = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_ARGB);
			image = ImageIO.read(f);
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		this.imgWidth = imgWidth;
		this.imgHeight = imgHeight;
		
		
		return image;
		
	}	// end public BufferedImage loadImage
	
	
	
	// The remains of my failed attempts are below :(
	
	
	/*
	
	public BufferedImage loadImage2(int imgWidth, int imgHeight, String path)
	{
		image2 = new ImageIcon(path).getImage();
		image = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		return image;
			
	}	// end public BufferedImage loadImage
	
	public BufferedImage loadImage3(int imgWidth, int imgHeight, String path)
	{
		try 
		{
			image3 = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return image3;
	}
	
	*/
	
	
	
}	// end public class BufferedImageLoader
