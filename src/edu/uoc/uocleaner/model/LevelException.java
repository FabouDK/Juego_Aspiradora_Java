package edu.uoc.uocleaner.model;

/** 
 * Level Exception class.
 * @author Fabou Diawara Keita
 * @version 1.0  
 */
public class LevelException extends Exception{	
	
	private static final long serialVersionUID = 1L;
	/**
	 * Error message when the number of rows is 0 or smaller.
	 */
	public static final String ERROR_NUM_ROWS_INCORRECT = "[ERROR] The number of rows cannot be 0 or smaller!!";
	/**
	 * Error message when the number of columns is 0 or smaller.
	 */
	public static final String ERROR_NUM_COLUMNS_INCORRECT = "[ERROR] The number of columns cannot be 0 or smaller!!";
	/**
	 * Error message when the number of turns is negative.
	 */
	public static final String ERROR_NUM_TURNS_INCORRECT = "[ERROR] The turns cannot be negative!!";
	/**
	 * Error message when the time is negative.
	 */
	public static final String ERROR_NUM_TIME_INCORRECT = "[ERROR] The time cannot be negative!!";
	/**
	 * Error message when there is not only one vacuum cleaner in the current level.
	 */
	public static final String ERROR_NUM_VACUUMS = "[ERROR] There must only be one vacuum cleaner!!";
	/**
	 * Error message when there are not any dumpster in the current level.
	 */
	public static final String ERROR_NO_DUMPSTERS = "[ERROR] There must be one dumpster at least!!";
	/**
	 * Error message when there is not any kind of dirt (or dustball).
	 */
	public static final String ERROR_NO_DIRT = "[ERROR] There must be one dirt at least!!";
	
	/**
	 * Default constructor.
	 */
	public LevelException() {
		super();
	}
	
	/**
	 * Parameterized constructor.
	 * @param msg Message which must be displayed.
	 */
	public LevelException(String msg) {
		super(msg);
	}
}