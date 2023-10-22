package com.AlexLongo.BlockadeRunner1776.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.AlexLongo.BlockadeRunner1776.framework.GameObject;
import com.AlexLongo.BlockadeRunner1776.framework.KeyInput;
import com.AlexLongo.BlockadeRunner1776.framework.MouseInput;
import com.AlexLongo.BlockadeRunner1776.framework.ObjectId;
import com.AlexLongo.BlockadeRunner1776.framework.Texture;
import com.AlexLongo.BlockadeRunner1776.objects.Block;
import com.AlexLongo.BlockadeRunner1776.objects.GameWall;
import com.AlexLongo.BlockadeRunner1776.objects.Player;

public class Game extends Canvas implements Runnable
{

	private static final long serialVersionUID = -318391021542460498L;
	
	private boolean running = false;
	private Thread thread;
	
	public static int WIDTH;
	public static int HEIGHT;
	
	// loaded image variables
	private BufferedImage mainLevel = null;
			// private BufferedImage clouds = null;
	private BufferedImage menuBackground = null;
	private BufferedImage mainLvlBkg = null;
	
	private boolean levelIsLoaded = false;
	
	
	// Handling the STATE of the Game
////////////////////////////////////////////////////////////////////////////////////////
	public static STATE State = STATE.MENU;	// for the game state and switching Menus
	public static int state = 1;
		
////////////////////////////////////////////////////////////////////////////////////////
	
	
	//Object??
	Handler handler;
	Camera cam;
	static Texture tex;
	private Menu menu;
	private HighScores highscores;
	private Port port;
	
	
	
	private void init()
	{
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		tex = new Texture();
		menu = new Menu();
		highscores = new HighScores();
		port = new Port();
		
		State = STATE.MENU;
		state = 1;
		
		//Loading external images
		BufferedImageLoader loader = new BufferedImageLoader();
			// mainLevel = loader.loadImage(4, 4, "res/main_level.png");	  // loading the level
			// clouds = loader.loadImage(512, 256, "res/bkg_clouds.png");	// loading clouds
		menuBackground = loader.loadImage(512, 512, "res/bkg_menuFitted.png");	//loading menu background
		mainLvlBkg = loader.loadImage(2048, 2048, "res/main_level_bkg.png");	//loading Game background
		
		
		handler = new Handler();	// Sets up a new handler to remember, tick, and render all objects?
		
		cam = new Camera(0, 0);
		
		// handler.addObject(new Player(100, 100, handler, ObjectId.Player));	// adds a player to the handler
		
		// handler.createLevel();	//adds a horizontal string of blocks to handler
		
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(new MouseInput());
	}
	
	
	public synchronized void start()
	{
		if(running)
		{
			return;
		}
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	
	/* This next bit of code 
	 * runs the game at 60 FPS
	 * and is called the 
	 * Game Loop.
	 */

///////////////////////////////////////////////////////////////////////////////////////////////////
	public void run()
	{
		init();
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}	// end public void run()
	
	private void tick()
	{
		if(State == STATE.GAME)
		{	
			state = 3;
			
			// Commented out for now because I'm trying new boundaries
			
			if (levelIsLoaded == false)
			{
				// Commented out for now because I'm trying new boundaries
				// LoadImageLevel(mainLevel);
				
				
				// New Boundaries
				LoadGameBoundaries();
				handler.addObject(new Player(256, 256, handler, ObjectId.Player));
				levelIsLoaded = true;
			}
			
						
			handler.tick();
			for(int i = 0; i < handler.object.size(); i++)
			{
				if(handler.object.get(i).getId() == ObjectId.Player)
				{
					cam.tick(handler.object.get(i));
				}
				
				if(state == 1)
				{
					if(handler.object.get(i).getId() == ObjectId.Player)
					{
						handler.removeObject(handler.object.get(i));
					}
					if(handler.object.get(i).getId() == ObjectId.GameWall)
					{
						handler.removeObject(handler.object.get(i));
					}
					
					
				}
					
			}	// end for loop
			

			
		}	// end if (state == STATE.GAME)
		
		else if (State == STATE.MENU)
		{
			state = 1;
			// TBD enter menu tick() code
		}
		
		else if (State == STATE.PORT)
		{
			state = 2;
			// TBD enter port tick() code
		}
		else if (State == STATE.HIGHSCORES)
		{
			state = 4;
			// TBD enter port tick() code
		}
		
		
	}	// end private void tick()
	
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		
		
		/* Everything drawn in the 
		 * game is drawn here
		 * between these bars: 
		 */
		//////////////////////////////////////////////////
		
		if(State == STATE.GAME  || state == 3)
		{
			// Old, Plain, Cyan-Colored, Non-moving Background
			// g.setColor(new Color(25, 191, 224));
			// g.fillRect(0,  0,  getWidth(),  getHeight());
			
			//	Background to cover up menu frame
			g.setColor(new Color(25, 191, 224));	// CHANGE THIS to the right shade of blue eventually
			g.fillRect(0,  0,  2048,  2048);
			
			g2d.translate(cam.getX(), cam.getY());	// begin of cam
			
			// This next bit of code must stay above the handler so that it renders in the background
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					//FYI this Code is broken it weirdly spawns millions of clouds in the upper right hand corner for some reason
					/*
					for(int xx = 0; xx < clouds.getWidth() * 5; xx += clouds.getWidth()) // the " * 5 " is the number of them you want in the game
					{
						g.drawImage(clouds,	xx, 50, this);
					}
					*/
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			g.drawImage(mainLvlBkg, 0, 0, null);
			
			handler.render(g);
			
			g2d.translate(-cam.getX(), -cam.getY());	// end of cam
			
			
			//////////////////////////////////////////////////
			g.dispose();
			bs.show();
		
		}	// end if(state == STATE.GAME)
		
		else if(State == STATE.MENU || state == 1)
		{
			//DRAW MENU BACKGROUND HERE:			
			
			//g.drawImage(level, 0, 0, this);
			
			g.drawImage(menuBackground, -1, 0, this);
			
			menu.render(g);
			
			
			g.dispose();	// ABSOLUTELY NECESSARY FOR IT TO ACTUALLY RENDER
			bs.show();		// ABSOLUTELY NECESSARY FOR IT TO ACTUALLY RENDER
		}
		
		else if (State == STATE.PORT)
		{
			
			port.render(g);
			g.dispose();	// ABSOLUTELY NECESSARY FOR IT TO ACTUALLY RENDER
			bs.show();		// ABSOLUTELY NECESSARY FOR IT TO ACTUALLY RENDER
		}
		
		else if(State == STATE.HIGHSCORES)
		{
			//DRAW HIGHSCORES BACKGROUND HERE:			
				
			highscores.render(g);
			
			
			g.dispose();	// ABSOLUTELY NECESSARY FOR IT TO ACTUALLY RENDER
			bs.show();		// ABSOLUTELY NECESSARY FOR IT TO ACTUALLY RENDER
		}
		
		
	}	// end private void render()
	

///////////////////////////////////////////////////////////////////////////////////////////////////	
	/* END GAME LOOP CODE */
	
	
	
	private void LoadImageLevel(BufferedImage image)
	{
		
		{
			int w = mainLevel.getWidth();
			int h = mainLevel.getHeight();
			
			System.out.println("width, height: " + w + " " + h);
			
			for(int xx = 0; xx < h; xx++)
			{
				for(int yy = 0; yy < w; yy++)
				{
					int pixel = image.getRGB(xx,  yy);
					int red = (pixel >> 16) & 0xff;
					int green = (pixel >> 8) & 0xff;
					int blue = (pixel) & 0xff;
					
					if(red == 64 && green == 64 & blue == 64)
					{
						handler.addObject(new Block(xx*32, yy*32, 0, ObjectId.Block));
					}
					
					if(red == 0 && green == 0 & blue == 255)
					{
						handler.addObject(new Player(xx*32, yy*32, handler, ObjectId.Player));
					}
					
				}
			}
		}
		
	}
	
	private void LoadGameBoundaries()
	{
		handler.addObject(new GameWall(130, 130, 0, ObjectId.GameWall));
		handler.addObject(new GameWall(1918, 130, 0, ObjectId.GameWall));
		handler.addObject(new GameWall(130, 130, 1, ObjectId.GameWall));
		handler.addObject(new GameWall(130, 1918, 1, ObjectId.GameWall));
	}
	
	
	
	public static Texture getInstance()
	{
		return tex;
	}
	
	
	public static void main(String args[])
	{
		new Window(800, 600, "Blockade Runner 1776", new Game());
		
	}	// end main
	
}
