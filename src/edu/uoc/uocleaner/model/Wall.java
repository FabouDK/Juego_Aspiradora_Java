package edu.uoc.uocleaner.model;

/** 
 * A Wall sprite.
 * @author Fabou Diawara Keita
 * @version 1.0 
 */
public class Wall extends Sprite{
	
	/**
	 * Constructor.
	 * @param row Index of the row in which the wall element is.
	 * @param column Index of the column in which the wall element is.
	 * @throws SpriteException When the index of the row or the column is incorrect.
	 */
	public Wall(int row, int column) throws SpriteException{
		super(row, column, Symbol.WALL);
	}
}