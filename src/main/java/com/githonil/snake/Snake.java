package com.githonil.snake;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.LinkedList;

/**
 * This class represents a snake.
 * 
 * @author Githonil
 */
public class Snake {

	/**
	 * This attribut represents the coordinate X of the snake.
	 */
	private int locationX;



	/**
	 * This attribut represents the coordinate Y of the snake.
	 */
	private int locationY;



	/**
	 * This attribut represents the coordinate Z of the snake.
	 */
	private int locationZ;
	


	/**
	 * This attribut represents the velocity X of the snake.
	 */
	private int velocityX;



	/**
	 * This attribut represents the velocity Y of the snake.
	 */
	private int velocityY;



	/**
	 * This attribut represents the velocity Z of the snake.
	 */
	private int velocityZ;
	



	/**
	 * This attribut represents the tail of the Snake.
	 */
	private LinkedList<Part> tail;
	
	
	
	/**
	 * The snake's constructor.
	 * 
	 * @param locationX The coordinate X of the snake.
	 * @param locationY The coordinate Y of the snake.
	 * @param locationZ The coordinate Z of the snake.
	 */
	public Snake(int locationX, int locationY, int locationZ) {
		this.locationX = locationX;
		this.locationY = locationY;
		this.locationZ = locationZ;
		
		this.velocityX = 0;
		this.velocityY = 0;
		this.velocityZ = 0;
		
		this.tail = new LinkedList<Part>();
	}
	
	
	
	/**
	 * This methods add a part of the snake's tail
	 */
	public void addTail() {
		tail.add(new Part(locationX, locationY, locationZ));
	}
	
	
	
	/**
	 * This method computes the snake's mouvement
	 */
	public void move() {
		addTail();
		tail.remove();
		locationX += velocityX;
		locationY += velocityY;
		locationZ += velocityZ;
	}
	
	
	
	/**
	 * This method checks if the snake eat himself.
	 * 
	 * @return Return true if the snake eat himself, false otherwise.
	 */
	public boolean bit() {
		for(int i = 0; i < tail.size(); i++) {
			Part coord = tail.get(i);
			if (locationX == coord.getLocationX() && locationY == coord.getLocationY() && locationZ == coord.getLocationZ()) return true;
		}
		return false;
	}
	
	
	
	/**
	 * This method changes the snake's velocity.
	 * 
	 * @param velocityX The velocity in X.
	 * @param velocityY The velocity in X.
	 * @param velocityZ The velocity in Z.
	 */
	public void setVelocity(int velocityX, int velocityY, int velocityZ) {
		this.velocityX = velocityX;
		this.velocityY = velocityY;
		this.velocityZ = velocityZ;
	}
	
	
	
	/**
	 * This method returns the coordinate X of the snake.
	 * 
	 * @return Return the coordinate X of the snake.
	 */
	public int getLocationX() {
		return locationX;
	}
	
	
	
	/**
	 * This method returns the coordinate Y of the snake.
	 * 
	 * @return Return the coordinate Y of the snake.
	 */
	public int getLocationY() {
		return locationY;
	}
	
	
	
	/**
	 * This method returns the coordinate Z of the snake.
	 * 
	 * @return Return the coordinate Z of the snake.
	 */
	public int getLocationZ() {
		return locationZ;
	}
	
	
	
	/**
	 * This method returns a part of the snake's tail.
	 * 
	 * @param index The index of the snake's tail part.
	 * @return Return a part of the snake's tail.
	 */
	public Part getTail(int index) {
		return tail.get(index);
	}
	
	
	
	/**
	 * This method returns the size of the snake's tail.
	 * 
	 * @return Return the size of the snake's tail.
	 */
	public int getSize() {
		return tail.size();
	}
	
	
	
	/**
	 * The foreach for the snake's (bad coding).
	 * 
	 * @param action The action in the foreach.
	 */
	public void forEach(Consumer<Part> action) {
		tail.forEach(action);
	}
	
	
	
	/**
	 * This method returns the hash code of the snake.
	 * 
	 * @return Return the hash code of the snake.
	 */
	@Override
	public int hashCode() {
		int code = Objects.hash(locationX, locationY, velocityX, velocityY, tail);
		return code;
	}
	


	/**
	 * This method checks if the snake is the same thing as an object.
	 * 
	 * @param o The object to compare with the snake.
	 * @return Return true if the snake is the object, false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		return this.hashCode() == o.hashCode();
	}
	
	
	
	/**
	 * This sub-class is a part of the snake's tail.
	 */
	public class Part {
		
		/**
	 	 * This attribut represents the coordinate X of the snake's tail.
	 	 */
		private int locationX;


		/**
	 	 * This attribut represents the coordinate Y of the snake's tail.
	 	 */
		private int locationY;


		/**
	 	 * This attribut represents the coordinate Z of the snake's tail.
	 	 */
		private int locationZ;
		


		/**
		 * The snake part's constructor.
		 * 
		 * @param locationX The coordinate X of the snake's part.
		 * @param locationY The coordinate Y of the snake's part.
		 * @param locationZ The coordinate Z of the snake's part.
		 */
		public Part(int locationX, int locationY, int locationZ) {
			this.locationX = locationX;
			this.locationY = locationY;
			this.locationZ = locationZ;
		}
		
		
		
		/**
		 * This method returns the coordinate X of the snake's part.
		 * 
		 * @return Return the coordinate X of the snake's part.
		 */
		public int getLocationX() {
			return locationX;
		}
		
		
		
		/**
		 * This method returns the coordinate Y of the snake's part.
		 * 
		 * @return Return the coordinate Y of the snake's part.
		 */
		public int getLocationY() {
			return locationY;
		}
		
		
		
		/**
		 * This method returns the coordinate Z of the snake's part.
		 * 
		 * @return Return the coordinate Z of the snake's part.
		 */
		public int getLocationZ() {
			return locationZ;
		}
	}
}
