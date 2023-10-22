package com.AlexLongo.BlockadeRunner1776.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.AlexLongo.BlockadeRunner1776.objects.Bullet;
import com.AlexLongo.BlockadeRunner1776.window.Game;
import com.AlexLongo.BlockadeRunner1776.window.Handler;

public class KeyInput extends KeyAdapter
{
	private boolean D_key_down = false;
	private boolean A_key_down = false;
	private boolean W_key_down = false;
	private boolean S_key_down = false;
	
	// Original Code that has a sticky aspect to the player
	
//////////////////////////////////////////////////////////////////////////////////////
	Handler handler;
	
	public KeyInput(Handler handler)
	{
		this.handler = handler;    
	}
	
	public void keyPressed(KeyEvent e)	// handles what happens when a key is pressed
	{
		int key = e.getKeyCode();
		
		if(Game.state == 3)
		{
			for(int i =0; i < handler.object.size(); i++)
			{
				GameObject  tempObject = handler.object.get(i);
				
				if(tempObject.getId() == ObjectId.Player)
				{
					if(key == KeyEvent.VK_D)
					{
						tempObject.setVelocityX(5);
						D_key_down = true;
					}
					
					if(key == KeyEvent.VK_A)
					{
						tempObject.setVelocityX(-5);
						A_key_down = true;
					}
					
					if (key == KeyEvent.VK_W)	
					{
						tempObject.setVelocityY(-5);
						W_key_down = true;
					}
					
					if (key == KeyEvent.VK_S)	
					{
						tempObject.setVelocityY(5);
						S_key_down = true;
					}
					
					if(key == KeyEvent.VK_SPACE)
					{
						handler.addObject(new Bullet(tempObject.getX(), tempObject.getY() + 48, ObjectId.Bullet, tempObject.getFacing() * 10 ));
					}
				}
			}	// end for loop
							
		}	// end if
			
		
		// Escape Key will close program?
		///////////////////////////////////////
		if(key == KeyEvent.VK_ESCAPE)
		{
			System.exit(1);
		}
		///////////////////////////////////////
		
	}	// end public void KeyPressed
	
	public void keyReleased(KeyEvent e)	// handles what happens when a key is released
	{
		int key = e.getKeyCode();
		
		for(int i =0; i < handler.object.size(); i++)
		{
			GameObject  tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Player)
			{
				if(key == KeyEvent.VK_D  && A_key_down == false)
				{
					tempObject.setVelocityX(0);
					D_key_down = false;
				}
				
				if(key == KeyEvent.VK_A  && D_key_down == false)
				{
					tempObject.setVelocityX(0);
					A_key_down = false;
				}
				
				if(key == KeyEvent.VK_W  && S_key_down == false)
				{
					tempObject.setVelocityY(0);
					W_key_down = false;
				}
				
				if(key == KeyEvent.VK_S  && W_key_down == false)
				{
					tempObject.setVelocityY(0);
					S_key_down = false;
				}
				
				if(key == KeyEvent.VK_D  && A_key_down == true)
				{
					tempObject.setVelocityX(-5);
					D_key_down = false;
				}
				
				if(key == KeyEvent.VK_A  && D_key_down == true)
				{
					tempObject.setVelocityX(5);
					A_key_down = false;
				}
				
				if(key == KeyEvent.VK_W  && S_key_down == true)
				{
					tempObject.setVelocityY(5);
					W_key_down = false;
				}
				
				if(key == KeyEvent.VK_S  && W_key_down == true)
				{
					tempObject.setVelocityY(-5);
					S_key_down = false;
				}
				
				
								
			}	// end if
		}	// end for loop
	}	// end public void keyReleased()

///////////////////////////////////////////////////////////////////////////////////////////
 

}	// end public class KeyInput
