package edu.uoc.uocleaner.model;

/** 
 * Movable interface.
 * @author Fabou Diawara Keita
 * @version 1.0  
 */
public interface Movable {

	/**
	 * Speed in which a "movable" object moves by default.
	 */
	int SPEED = 1;
	
	/**
	 * Moves the object to the new row and column position.
	 * @param row the new row index
	 * @param column the new column index
	 * @throws Exception When an incorrect value of either row or column is passed.
	 */
	void moveTo(int row, int column) throws Exception;
	
}