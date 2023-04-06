package edu.uoc.uocleaner.model;

/** 
 * A Dirt-like sprite.
 * @author Fabou Diawara Keita
 * @version 1.0  
 */
public class Dirt extends Sprite{

	/**
	 * Points which are added to the vacuum cleaner's capacity.
	 */
	int score;
	
	/**
	 * Public constructor which assigns the score to 1.
	 * @param row Index of the row in which the dirt element is.
	 * @param column Index of the column in which the dirt element is.
	 * @throws SpriteException When the index of the row or the column is incorrect.
	 */
	public Dirt(int row, int column) throws SpriteException{
		this(row,column,Symbol.DIRT,1);		
	}
	
	/**
	 * This constructor is used by subclasses in order to assign the symbol and the image of the sprite.
	 * @param row Index of the row in which the dirt element is.
	 * @param column Index of the column in which the dirt element is.
	 * @param symbol Symbol that represents the ASCII character/symbol and the image of the dirt element.	 
	 * @param score Points of the dirt.
	 * @throws SpriteException When the index of the row or the column is incorrect.
	 */	
	protected Dirt(int row, int column, Symbol symbol, int score) throws SpriteException{
		super(row,column,symbol);
		setScore(score);
	}

	/**
	 * Getter of score.
	 * @return The value of the score/points of the dirt.
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Setter of score.
	 * @param score Points to assign to the dirt element.
	 */
	protected void setScore(int score) {
		this.score = score;
	}
}