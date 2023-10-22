package com.AlexLongo.BlockadeRunner1776.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.AlexLongo.BlockadeRunner1776.framework.GameObject;
import com.AlexLongo.BlockadeRunner1776.framework.ObjectId;
import com.AlexLongo.BlockadeRunner1776.framework.Texture;
import com.AlexLongo.BlockadeRunner1776.window.Animation;
import com.AlexLongo.BlockadeRunner1776.window.Game;
import com.AlexLongo.BlockadeRunner1776.window.Handler;

public class Player extends GameObject
{

	private float width = 48;	// Width of collision box around Player
	private float height = 96;	// Height of collision box around Player
	
	private float gravity = 0.5f;	// Gravity (accelerates the longer an object falls)
	private final float MAX_SPEED = 10;	// Max Speed Constant
	
	
	private Handler handler;	// imports handler from the handler class?
	
	Texture tex = Game.getInstance(); 	
	
	private Animation playerWalk;
	private Animation playerWalkLeft;
	
	public Player(float x, float y, Handler handler, ObjectId id) 
	{
		super(x, y, id);
		this.handler = handler;
		
		playerWalk = new Animation(5, tex.player[1], tex.player[2], tex.player[3], tex.player[4], tex.player[5], tex.player[6]);
		playerWalkLeft = new Animation(5, tex.player[8], tex.player[9], tex.player[10], tex.player[11], tex.player[12], tex.player[13]);
	}


	public void tick(LinkedList<GameObject> object) 
	{
		x += velocityX;	// Moves the Player
		y += velocityY; // Moves the Player
		
		
		// Facing
		
		/*
		if(velocityX < 0)
		{
			facing = -1;
		}
		else if (velocityX > 0)
		{
			facing = 1;
		}
		
		*/
		
		
		// GRAVITY
		
		/*
		
		if(falling || jumping)
		{
			velocityY += gravity;
			
			// the following if statement prevents player from falling too fast 
			if(velocityY > MAX_SPEED)
			{
				velocityY = MAX_SPEED;
			}
		}
		
		*/
		
		Collision(object);
		
		playerWalk.runAnimation();
		playerWalkLeft.runAnimation();
		
	}	// end tick()
	
	private void Collision(LinkedList<GameObject> object)
	{
		for (int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.GameWall)
			{
				// Top Collision
				if(getBoundsTop().intersects(tempObject.getBounds()))
				{
					y = tempObject.getY() + 5; 
					velocityY = 0;
				}
				
				// Bottom Collision
				if(getBounds().intersects(tempObject.getBounds()))
				{
					y = tempObject.getY() - height; // in case the player hits the block too fast this resets the player to the top of the block 
					velocityY = 0;
				}
				
				// Right Side Collision
				if(getBoundsRight().intersects(tempObject.getBounds()))
				{
					x = tempObject.getX() - width; 
					velocityX = 0;
				}
				
				// Left Side Collision
				if(getBoundsLeft().intersects(tempObject.getBounds()))
				{
					x = tempObject.getX() + 5; 
					velocityX = 0;
				}
				
			}
			
			
			if(tempObject.getId() == ObjectId.Block)
			{
				if(getBoundsTop().intersects(tempObject.getBounds()))
				{
					y = tempObject.getY() + 32; 
					velocityY = 0;
					
				}
				
				// This is if just our top half collides
				////////////////////////////////////////////////////////
				if(getBoundsTop().intersects(tempObject.getBounds()))
				{
					y = tempObject.getY() + 32; 
					velocityY = 0;
					
				}
				////////////////////////////////////////////////////////
				
				
				
				// This is if just our bottom half collides
				////////////////////////////////////////////////////////
				if(getBounds().intersects(tempObject.getBounds()))
				{
					y = tempObject.getY() - height; // in case the player hits the block too fast this resets the player to the top of the block 
					velocityY = 0;
					falling = false;
					jumping = false;
				}
				else	// any time the player is not touching the block, gravity is turned on
				{
					falling = true;
				}
				////////////////////////////////////////////////////////
				
				// This is if just our Right side collides
				////////////////////////////////////////////////////////
				if(getBoundsRight().intersects(tempObject.getBounds()))
				{
					x = tempObject.getX() - width; 
					
					
				}
				////////////////////////////////////////////////////////
				
				// This is if just our Left side collides
				////////////////////////////////////////////////////////
				if(getBoundsLeft().intersects(tempObject.getBounds()))
				{
					x = tempObject.getX() + 35; 
					
					
				}
				////////////////////////////////////////////////////////
				
				
			}
		}
	}
	
	


	public void render(Graphics g) // Handles Player Graphics
	{
		
		 g.setColor(Color.blue);
		
		 
		//Animated Sprite Character
		
		/*
		 
		if(jumping)
		{
			if (facing == 1)
			{
				g.drawImage(tex.player_jump[2], (int)x, (int)y, 48, 96, null);
			}
			else if(facing == -1)
			{
				g.drawImage(tex.player_jump[3], (int)x, (int)y, 48, 96, null);
			}
		}
		
		else
		{
			if(velocityX != 0)
			{
				if(facing == 1)
				{
					playerWalk.drawAnimation(g, (int) x, (int) y, 48, 96);
				}
				else
				{
					playerWalkLeft.drawAnimation(g, (int) x, (int) y, 48, 96);
				}
			}
			else
			{
				if(facing == 1)
				{
					g.drawImage(tex.player[0], (int)x, (int)y, 48, 96, null); // the 48 and 96 scale the image to fit the collision boxes
				}
				else if (facing == -1)
				{
					g.drawImage(tex.player[7], (int)x, (int)y, 48, 96, null); // the 48 and 96 scale the image to fit the collision boxes
				}
				
			}	// end else
		}	// end else
		
		*/
		
		
		
		// Displays player as a rectangle
		g.fillRect((int)x, (int)y, (int)width, (int)height);
		
		
		
		//Displays collision boxes
		
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.red);
		g2d.draw(getBounds());
		g2d.draw(getBoundsRight());
		g2d.draw(getBoundsLeft());
		g2d.draw(getBoundsTop());
		
	}

	public Rectangle getBounds() 	// For the bottom Collision Box
	{
		return new Rectangle((int) ((int)x + (width / 2) - ((width / 2) / 2)), (int) ((int)y + (height / 2)), (int)width/2, (int)height/2);
	}
	
	public Rectangle getBoundsTop() // For the Top Collision Box
	{
		return new Rectangle((int) ((int)x + (width / 2) - ((width / 2) / 2)), (int)y, (int)width/2, (int)height/2);
	}
	
	public Rectangle getBoundsRight() // For the Right Collision Box
	{
		return new Rectangle((int) ((int)x + width - 5), (int)y + 5, (int)5, (int)height - 10);
	}
	
	public Rectangle getBoundsLeft() // For the Left Collision Box
	{
		return new Rectangle((int)x, (int)y + 5, (int)5, (int)height - 10);
	}
	
	
}	// end public class Player
