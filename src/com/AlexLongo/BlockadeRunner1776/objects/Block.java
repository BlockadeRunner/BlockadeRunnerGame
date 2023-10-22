package com.AlexLongo.BlockadeRunner1776.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.AlexLongo.BlockadeRunner1776.framework.GameObject;
import com.AlexLongo.BlockadeRunner1776.framework.ObjectId;
import com.AlexLongo.BlockadeRunner1776.framework.Texture;
import com.AlexLongo.BlockadeRunner1776.window.Game;

public class Block extends GameObject
{

	Texture tex = Game.getInstance();
	private int type;
	
	/*Block Constructor*/
//////////////////////////////////////////////////////////
	public Block(float x, float y, int type, ObjectId id) 
	{
		super(x, y, id);
		this.type = type;
	}
/////////////////////////////////////////////////////////

	public void tick(LinkedList<GameObject> object) 
	{
		
	}


	public void render(Graphics g) 
	{
		if(type == 0)	// dirt block
		{
			g.drawImage(tex.block[0], (int)x, (int)y, null);
		}
		
		if(type == 1)	// grass block
		{
			g.drawImage(tex.block[1], (int)x, (int)y, null);
		}
		
		if(type == 2) 
		{
			// Draws bottom level of blocks in old white version
						
			g.setColor(Color.white);
			g.drawRect((int)x, (int)y, 32, 32);		
		}
		
		
	}	// end render(Graphics g)


	public Rectangle getBounds() 
	{
		return new Rectangle((int)x, (int)y, 32, 32);
	}



}	// end public class Block
