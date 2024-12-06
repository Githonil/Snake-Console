package com.githonil.snake;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This class represents a Snake game.
 * 
 * @author Githonil
 */
public class Game {

	/**
	 * This attribut represents the snake.
	 */
	private Snake snake;



	/**
	 * This attribut represents the apple.
	 */
	private Apple apple;



	/**
	 * This attribut represents the width of the game.
	 */
	private int width;


	/**
	 * This attribut represents the height of the game.
	 */
	private int height;



	/**
	 * This attribut is used to print the game (it's width * height).
	 */
	private int length;



	/**
	 * This attribut represents if the game is running.
	 */
	private boolean running;



	/**
	 * This attribut represents the input event.
	 */
	private Timer input;
	
	
	
	/**
	 * The game's constructor.
	 * 
	 * @param width The width of the game.
	 * @param height The height of the game.
	 */
	public Game(int width, int height) {
		this.snake = new Snake(0, 0, 0);
		this.apple = new Apple(width, height, 0);
		this.width = width;
		this.height = height;
		this.length = width * height;
		this.running = true;
		this.input = new Timer();
		
		respawn();
	}
	
	
	
	/**
	 * This method checks if the snake is in a wall.
	 * 
	 * @return Return true if the snake is in the wall, false otherwise.
	 */
	private boolean inWall() {
		return snake.getLocationX() < 0 || snake.getLocationX() >= width || snake.getLocationY() < 0 || snake.getLocationY() >= height;
	}
	
	
	
	/**
	 * This method checks if the snake eat the apple.
	 * 
	 * @return return true if the snake eat the apple, false otherwise.
	 */
	private boolean collide() {
		return snake.getLocationX() == apple.getLocationX() && snake.getLocationY() == apple.getLocationY();
	}
	
	
	
	/**
	 * This method respawns the apple.
	 */
	private void respawn() {
		while(collide())
			apple.respawn();
	}
	
	
	
	/**
	 * This method updates the game.
	 */
	private void update() {
		if (collide()) {
			snake.addTail();
			respawn();
		}
		snake.move();
		if (snake.bit()) {
			running = false;
		}
		if (inWall()) {
			running = false;
		}
	}
	
	
	
	/**
	 * This method starts the game.
	 */
	public void run() {
		snake.setVelocity(0, 1, 0);

		input.schedule(new Input(this), 0, 1);
		
		while(running) {
			try {
				Thread.sleep(750);
			}
			catch(InterruptedException e) {}
			
			for(int i = 0; i < height; i++)
				System.out.println();
			System.out.println(this);
			System.out.println("Up : Z; Down : S; Right : D; Left : Q\nThe direction :");
			update();
		}
		
		input.cancel();
		
		System.out.println("The game is done, please press Enter for quit.");
	}
	
	
	
	/**
	 * This method prints the game.
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder((length + 4) * 2);
		
		for(int i = 0; i < width + 2; i++) {
			string.append("#");
			if (i != width + 1) string.append('|');
		}
		
		string.append('\n');
		
		for(int y = 0; y < width; y++) {
			for(int x = 0; x < height; x++) {
					
				if (x == 0) string.append("#|");
				
				if (x == snake.getLocationX() && y == snake.getLocationY()) {
					string.append('X');
				}
				else if (x == apple.getLocationX() && y == apple.getLocationY()) {
					string.append('*');
				}
				else {
					string.append(' ');
				}
				
				{
					final int xx = x;
					final int yy = y;
					snake.forEach((e) -> {
						if (xx == e.getLocationX() && yy == e.getLocationY())
							string.setCharAt(string.length() - 1, '0');
					});
				}
				
				string.append('|');
				
				if (x == (width - 1)) string.append("#\n");
			}
		}
		
		for(int i = 0; i < width + 2; i++) {
			string.append("#");
			if (i != width + 1) string.append('|');
		}
		
		return string.toString();
	}



	/**
	 * This sub-class represents the input event.
	 */
	private class Input extends TimerTask {
		
		/**
		 * This attribut represents the input flux.
		 */
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		


		/**
		 * This attribut represents the link between the input and the game.
		 */
		private Game game;
		


		/**
		 * The input event's constructor.
		 * 
		 * @param game The link between the input and the game.
		 */
		public Input(Game game) {
			this.game = game;
		}
		


		/**
		 * The event handler of the input event.
		 */
		@Override
		public void run() {
			if(game.running) {
				try {
					String direction = scan.readLine().toUpperCase();
					switch(direction) {
						case "Z":
							game.snake.setVelocity(0, -1, 0);
							break;
							
						case "D":
							game.snake.setVelocity(1, 0, 0);
							break;
							
						case "S":
							game.snake.setVelocity(0, 1, 0);
							break;
							
						case "Q":
							game.snake.setVelocity(-1, 0, 0);
							break;
							
						default:
							break;
					}
				}
				catch(IOException e) {}
			}
		}
	}

}
