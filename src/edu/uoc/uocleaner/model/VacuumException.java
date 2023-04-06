package edu.uoc.uocleaner.model;

/** 
 * Vacuum Cleaner Exception class.
 * @author Fabou Diawara Keita
 * @version 1.0  
 */
public class VacuumException extends Exception{
	
	private static final long serialVersionUID = 1L;
	/**
	 * Error message when the initial maximum capacity of the vacuum cleaner is zero or negative.
	 */
	public static final String ERROR_MAX_CAPACITY_VALUE = "[ERROR] The maximum capacity of the vacuum cleaner cannot be 0 or a negative value!!";
	/**
	 * Error message when the increment of the vacuum cleaner's capacity is a negative value.
	 */
	public static final String ERROR_INC_CAPACITY_NEGATIVE_VALUE = "[ERROR] The increment of the capacity cannot be a negative value!!";
	/**
	 * Error message when the player is trying to overflow the maximum capacity of the vacuum cleaner.
	 */
	public static final String ERROR_OVERFLOW_MAX_CAPACITY = "[ERROR] You are trying to overflow the maximum capacity of the vacuum";
	/**
	 * Error message when the current capacity of the vacuum cleaner is a negative value.
	 */
	public static final String ERROR_CAPACITY_NEGATIVE_VALUE = "[ERROR] The capacity cannot be a negative value!!";
	
	/**
	 * Default constructor.
	 */
	public VacuumException() {
		super();
	}
	
	/**
	 * Parameterized constructor.
	 * @param msg Message which must be displayed.
	 */
	public VacuumException(String msg) {
		super(msg);
	}
}