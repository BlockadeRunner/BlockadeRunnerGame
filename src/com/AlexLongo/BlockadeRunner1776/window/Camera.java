package com.AlexLongo.BlockadeRunner1776.window;

import com.AlexLongo.BlockadeRunner1776.framework.GameObject;

public class Camera 
{
	private float x;
	private float y;
	
	public Camera(float x, float y)
	{
		this.x = x;
		this.y = y;	
	}
	
	public void tick(GameObject player)
	{
		x = -(player.getX() + 40) + Game.WIDTH/2;
		y = -(player.getY() + 48) + Game.HEIGHT/2;	
	}
	
	
	//Getters and Setters
	//////////////////////////////////////////////////
	public void setX(float x)
	{
		this.x = x;
	}
	
	public void setY(float y)
	{
		this.y = y;
	}
		
	public float getX()
	{
		return x;
	}
	
		public float getY()
	{
		return y;
	}
	////////////////////////////////////////////////////
	
	
}	// end public class Camera
