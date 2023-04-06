package edu.uoc.uocleaner.model;

/** 
 * Dumpster Exception class.
 * @author Fabou Diawara Keita
 * @version 1.0  
 */
public class DumpsterException extends Exception{
	
	private static final long serialVersionUID = 1L;
	/**
	 * Error message when the load of the dumpster is negative.
	 */
	public static final String ERROR_LOAD_NEGATIVE_VALUE = "[ERROR] Load cannot be negative!!"; 
	
	/**
	 * Default constructor.
	 */
	public DumpsterException() {
		super();
	}
	
	/**
	 * Parameterized constructor.
	 * @param msg Message which must be displayed.
	 */
	public DumpsterException(String msg) {
		super(msg);
	}
}
