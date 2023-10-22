package com.AlexLongo.BlockadeRunner1776.framework;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.AlexLongo.BlockadeRunner1776.window.Game;

public class MouseInput implements MouseListener
{

	int state = Game.state;
	
	public void mouseClicked(MouseEvent e) 
	{
				
	}

	
	public void mousePressed(MouseEvent e) 
	{
		int mx = e.getX();
		int my = e.getY();
		
		if(state == 1)
		{
			// New Game Button 
			if(mx >= 38 && mx <= 242)
			{
				if(my <= 584 && my >= 530)
				{
					//New Game Button Pressed
					Game.State = Game.State.GAME;
				}
			}
			
			// Load Game Button
			if(mx >= 292 && mx <= 496)
			{
				if(my <= 584 && my >= 530)
				{
					//New Game Button Pressed
					Game.State = Game.State.PORT;	//NEEDS TO BE CHANGED!!!
				}
			}
			
			// High Scores Button
			if(mx >= 546 && mx <= 750)
			{
				if(my <= 584 && my >= 530)
				{
					//New Game Button Pressed
					Game.State = Game.State.HIGHSCORES; 
				}
			}
			
			// Credits Button
			if(mx >= 28 && mx <= 232)
			{
				if(my <= 64 && my >= 10)
				{
					//New Game Button Pressed
					Game.State = Game.State.HIGHSCORES; //NEEDS TO BE CHANGED!!!
				}
			}
		
		}	// end if state == 1
	}

	
	public void mouseReleased(MouseEvent e) 
	{
				
	}

	
	public void mouseEntered(MouseEvent e) 
	{
				
	}

	
	public void mouseExited(MouseEvent e) 
	{
				
	}
	
}
