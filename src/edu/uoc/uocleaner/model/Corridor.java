package edu.uoc.uocleaner.model;


/** 
 * A Corridor sprite. 
 * @author Fabou Diawara Keita
 * @version 1.0  
 */
public class Corridor extends Sprite{

	/**
	 * Constructor.
	 * @param row Index of the row in which the corridor element is.
	 * @param column Index of the column in which the corridor element is.
	 * @throws SpriteException When the index of the row or the column is incorrect.
	 */
	public Corridor(int row, int column) throws SpriteException{
		super(row, column, Symbol.CORRIDOR);
	}	
}