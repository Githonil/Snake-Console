package com.githonil.snake;

import java.util.Objects;

/**
 * This class representes an apple.
 * 
 * @author Githonil
 */
public class Apple {

	/**
	 * This attribut represents the max coordinate in width where the apple can spwawn.
	 */
	private int maxWorldWidth;



	/**
	 * This attribut represents the max coordinate in height where the apple can spwawn.
	 */
	private int maxWorldHeight;


	/**
	 * This attribut represents the max coordinate in depth where the apple can spwawn.
	 */
	private int maxWorldDepth;



	/**
	 * This attribut represents the coordinate of the apple in X.
	 */
	private int locationX;



	/**
	 * This attribut represents the coordinate of the apple in Y.
	 */
	private int locationY;



	/**
	 * This attribut represents the coordinate of the apple in Z.
	 */
	private int locationZ;
	
	
	
	/**
	 * The apple's constructor.
	 * 
	 * @param maxWidth The max width of an apple.
	 * @param maxHeight The max height of an apple.
	 * @param maxDepth The max depth of an apple.
	 */
	public Apple(int maxWidth, int maxHeight, int maxDepth) {
		this.maxWorldWidth = maxWidth;
		this.maxWorldHeight = maxHeight;
		this.maxWorldDepth = maxDepth;
		this.locationX = (int)(Math.random() * maxWidth);
		this.locationY = (int)(Math.random() * maxHeight);
		this.locationZ = (int)(Math.random() * maxDepth);
	}
	
	
	
	/**
	 * This method cans respawn an apple.
	 */
	public void respawn() {
		locationX = (int)(Math.random() * maxWorldWidth);
		locationY = (int)(Math.random() * maxWorldHeight);
		this.locationZ = (int)(Math.random() * maxWorldDepth);
	}
	
	
	
	/**
	 * This method returns the coordinate X of an apple.
	 * 
	 * @return Return the coordinate X of an apple.
	 */
	public int getLocationX() {
		return locationX;
	}
	
	
	
	/**
	 * This method returns the coordinate Y of an apple.
	 * 
	 * @return Return the coordinate Y of an apple.
	 */
	public int getLocationY() {
		return locationY;
	}
	
	
	
	/**
	 * This method returns the coordinate Z of an apple.
	 * 
	 * @return Return the coordinate Z of an apple.
	 */
	public int getLocationZ() {
		return locationZ;
	}
	
	
	
	/**
	 * This method returns the hash code of the apple.
	 * 
	 * @return Return the hash code of the apple.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(locationX, locationY);
	}
	


	/**
	 * This method checks if the apple is the same thing as an object.
	 * 
	 * @param o The object to compare with the apple.
	 * @return Return true if the apple is the object, false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		return this.hashCode() == o.hashCode();
	}
}
