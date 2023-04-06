package edu.uoc.uocleaner.model;

/** 
 * Sprite Exception class.
 * @author Fabou Diawara Keita
 * @version 1.0  
 */
public class SpriteException extends Exception{
	
	private static final long serialVersionUID = 1L;
	/**
	 * Error message when the index of the row is negative.
	 */
	public static final String ERROR_INDEX_ROW_INCORRECT = "[ERROR] The index of row cannot be negative!!";
	/**
	 * Error message when the index of the column is negative.
	 */
	public static final String ERROR_INDEX_COLUMN_INCORRECT = "[ERROR] The index of column cannot be negative!!";
	
	/**
	 * Default constructor.
	 */
	public SpriteException() {
		super();
	}
	
	/**
	 * Parameterized constructor.
	 * @param msg Message which must be displayed.
	 */
	public SpriteException(String msg) {
		super(msg);
	}
}