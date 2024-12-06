package com.githonil.snake;

/**
 * This is the main class.
 * 
 * @author Githonil
 */
public class Main {

	/**
	 * This is the main method.
	 * 
	 * @param args The arguments of the main method.
	 */
	public static void main(String[] args) {
		Game g = new Game(10, 10);
		try {
			new ProcessBuilder("cmd", "/c", "@echo off && mode 23, 16 && cls").inheritIO().start();
		}
		catch(Exception e) {}
		g.run();
	}
}
