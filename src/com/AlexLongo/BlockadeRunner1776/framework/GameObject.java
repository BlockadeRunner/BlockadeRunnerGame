package com.AlexLongo.BlockadeRunner1776.framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public abstract class GameObject 
{
	
	protected float x;						// Object's X position
	protected float y;						// Object's Y position
	protected ObjectId id;					
	protected float velocityX = 0;			// Object's velocity in the X direction
	protected float velocityY = 0;			// Object's velocity in the Y direction
	protected boolean falling = true;		// Switch for falling?
	protected boolean jumping = false;		// Switch for jumping?
	protected int facing = 1;		//1 = right, -1 = left
	
	
	/*
	 * Constructor that constructs
	 * an in game object, and sets 
	 * the object's position and 
	 * ID/Name
	 */
///////////////////////////////////////////////////////////////////
	public GameObject(float x, float y, ObjectId id)
	{
		this.x = x;
		this.y = y;
		this.id = id;
	}	// end public GameObject
///////////////////////////////////////////////////////////////////	
	
	
	// The following are Methods required for Objects in the Game

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public abstract void tick(LinkedList<GameObject> object);	// for detecting object collision
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public float getX()		// method to return x position
	{
		return x;
	}
	
	public float getY()     // method to return y position
	{
		return y;
	}
	
	public void setX(float x)	// method to set x position
	{
		this.x = x;
	}
	
	public void setY(float y)	// method to set y position
	{
		this.y = y;
	}
	
	public float getVelocityX()	// method to return x velocity
	{
		return velocityX;
	}
	
	public float getVelocityY()	// method to return y velocity
	{
		return velocityY;
	}
	
	public void setVelocityX(float velocityX)	// method to set x velocity
	{
		this.velocityX = velocityX;
	}
	
	public void setVelocityY(float velocityY)	// method to set y velocity
	{
		this.velocityY = velocityY;
	}
	
	
	public boolean isFalling()	// Switch for when an object falls
	{
		return falling;
	}


	public void setFalling(boolean falling)	// Turns on Falling switch
	{
		this.falling = falling;
	}


	public boolean isJumping()	// Switch for when an object jumps
	{
		return jumping;
	}


	public void setJumping(boolean jumping) // Turns on jumping switch
	{
		this.jumping = jumping;
	}
	
	public int getFacing()
	{
		return facing;
	}
	
	public ObjectId getId()	// returns ID/Name of an object
	{
		return id;
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
}	// end public abstract class GameObject
