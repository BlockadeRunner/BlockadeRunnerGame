package com.AlexLongo.BlockadeRunner1776.window;

import java.awt.Graphics;
import java.util.LinkedList;

import com.AlexLongo.BlockadeRunner1776.framework.GameObject;
import com.AlexLongo.BlockadeRunner1776.framework.ObjectId;

public class Handler 
{
	
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	private GameObject tempObject;
		
	/* I believe this next bit of code updates
	 * each object stored on the "LinkedList"
	 * on every tick() execution
	 */
///////////////////////////////////////////////////////	
	public void tick()
	{
		for(int i = 0; i < object.size(); i++)
		{
			tempObject = object.get(i);
			
			tempObject.tick(object);
			
		}
	}	// end public void tick()
///////////////////////////////////////////////////////
	
	
	/* I believe this next bit of code renders
	 * each object stored on the "LinkedList"
	 * on every render() execution
	 */
///////////////////////////////////////////////////////	
	public void render(Graphics g)
	{
		for(int i = 0; i < object.size(); i++)
		{
			tempObject = object.get(i);
			
			if(Game.state == 3)		// GAME
			{
				if(tempObject.getId() == ObjectId.Player)
				{
					tempObject.render(g);
				}
				if(tempObject.getId() == ObjectId.GameWall)
				{
					tempObject.render(g);
				}
			}
			
			if(Game.state == 2)		// PORT
			{
				
			}
					
		}
	}	// end public void render()
////////////////////////////////////////////////////////
	
	// Add an object to the "LinkedList"
	public void addObject(GameObject object) 
	{
		this.object.add(object);		
	}
	
	// Remove an object from the "LinkedList"
	public void removeObject(GameObject object)
	{
		this.object.remove(object);
	}
	
	
	
	
	//Old initial level creator code before imported levels
	/*
	
	// Adds white blocks in the level
	public void createLevel()
	{
		// Bottom horizontal line
		for(int xx = 0; xx < (Game.WIDTH+32) * 2; xx+= 32)
		{
			addObject(new Block(xx, Game.HEIGHT-32, ObjectId.Block));
		}
		
		
		
		// Right Vertical Line
		for(int rightWall = 0; rightWall < Game.HEIGHT + 32; rightWall+= 32)
		{
			addObject(new Block(Game.WIDTH - 32, rightWall, ObjectId.Block));
		}
		
		
		
		// Left Vertical Line
		for(int leftWall = 0; leftWall < Game.HEIGHT + 32; leftWall+= 32)
		{
			addObject(new Block(Game.WIDTH - Game.WIDTH, leftWall, ObjectId.Block));
		}
		
	 }	// end public void createLevel()

	*/



}	// end public class Handler
