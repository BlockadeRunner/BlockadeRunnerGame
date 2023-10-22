package com.AlexLongo.BlockadeRunner1776.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.AlexLongo.BlockadeRunner1776.framework.GameObject;
import com.AlexLongo.BlockadeRunner1776.framework.ObjectId;

public class Bullet extends GameObject
{

	public Bullet(float x, float y, ObjectId id, int velocityX) 
	{
		super(x, y, id);
		this.velocityX = velocityX;
	}

	public void tick(LinkedList<GameObject> object) 
	{
		x += velocityX;
		
	}

	public void render(Graphics g) 
	{
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
		
		
	}

	public Rectangle getBounds() 
	{
		
		return new Rectangle((int) x, (int)y, 16, 16);
	}
	
}	// end public class Bullet extends GameObject
