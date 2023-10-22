package com.AlexLongo.BlockadeRunner1776.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.AlexLongo.BlockadeRunner1776.framework.GameObject;
import com.AlexLongo.BlockadeRunner1776.framework.ObjectId;

public class GameWall extends GameObject
{

	int type;	// 0 means side, 1 means top or bottom
	
	public GameWall(float x, float y, int type, ObjectId id) 
	{
		super(x, y, id);
		this.type = type;
	}

	public void tick(LinkedList<GameObject> object) 
	{
				
	}

	public void render(Graphics g) 
	{
		if(type == 0) 
		{
			// Make these cyan when ready
			g.setColor(new Color(255, 0, 0));
			g.drawRect((int)x, (int)y, 2, 1788);
		}
		if(type == 1) 
		{
			// Make these cyan when ready
			g.setColor(new Color(255, 0, 0));
			g.drawRect((int)x, (int)y, 1788, 2);
		}
	}

	public Rectangle getBounds() 
	{
		Rectangle myRect = null;
		if(type == 0)
		{
			myRect = new Rectangle((int)x, (int)y, 2, 1788);
		}
		else if(type == 1)
		{
			myRect = new Rectangle((int)x, (int)y, 1788, 2);
		}
		
		return myRect;
	}
	
	public int getType()
	{
		return this.type;
	}
	
}
