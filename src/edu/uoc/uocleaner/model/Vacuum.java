package edu.uoc.uocleaner.model;

/** 
 * Vacuum Cleaner class. 
 * @author Fabou Diawara Keita
 * @version 1.0 
 */
public class Vacuum extends Sprite implements Movable{

	/**
	 * Maximum capacity of dirt that the vacuum cleaner can store.
	 */
	private final int MAX_CAPACITY;
	/**
	 * Current quantity of dirt that the vacuum cleaner is storing.
	 */
	private int capacity;
	/**
	 * The sprite that was in the cell before the vacuum cleaner.
	 */
	private Sprite under;
	
	/**
	 * Constructor.
	 * @param row Index of the row in which the vacuum cleaner is initially.
	 * @param column Index of the column in which the vacuum cleaner is initially.
	 * @param maxCapacity Maximum capacity of dirt that the vacuum cleaner can store.
	 * @throws VacuumException When the value for the vacuum cleaner's maximum capacity is zero or negative; 
	 * when the value for the vacuum cleaner's current capacity is negative or higher than the maximum capacity.
	 * @throws SpriteException When the index of either the row or the column is incorrect.
	 */
	public Vacuum(int row, int column, int maxCapacity) throws VacuumException, SpriteException{
		super(row,column, Symbol.VACUUM);
		if(maxCapacity<=0) {
			throw new VacuumException(VacuumException.ERROR_MAX_CAPACITY_VALUE);
		}
		MAX_CAPACITY = maxCapacity;
		setCapacity(0);
		setUnder(new Corridor(getRow(),getColumn()));
	}

	/**
	 * Getter of the field "capacity"
	 * @return The value of the field "capacity", i.e. the current quantity of dirt that the vacuum cleaner is storing.
	 */
	public int getCapacity() {
		return capacity;
	}
	
	/**
	 * Increases the value of "increment" the current capacity of the vacuum cleaner. 
	 * @param increment Amount to add to the current capacity of the vacuum cleaner.
	 * @throws VacuumException When the value of the passed capacity is negative or higher than the maximum capacity;
	 * When the increment value is a negative value.
	 */
	public void incCapacity(int increment) throws VacuumException{
		if(increment<0) {
			throw new VacuumException(VacuumException.ERROR_INC_CAPACITY_NEGATIVE_VALUE);
		}
		setCapacity(getCapacity()+increment);
	}	

	/**
	 * Setter of the field "capacity".
	 * @param capacity Value to assign to the field "capacity".
	 * @throws VacuumException When the value of the passed capacity is negative or higher than the maximum capacity. 
	 */
	private void setCapacity(int capacity) throws VacuumException{
		if(capacity>getMaxCapacity()) {
			throw new VacuumException(VacuumException.ERROR_OVERFLOW_MAX_CAPACITY);
		}
		
		if(capacity < 0) {
			throw new VacuumException(VacuumException.ERROR_CAPACITY_NEGATIVE_VALUE);
		}
		this.capacity = capacity;
	}
	
	/**
	 * Getter of the field "under". 
	 * @return The value of the field "under", i.e. the sprite that was in the cell before the vacuum cleaner.
	 */
	public Sprite getUnder() {
		return under;
	}
	
	/**
	 * Setter of the field "under" which stores the sprite that was in the cell before the vacuum cleaner. 
	 * @param under Sprite that was in the cell before the vacuum cleaner.
	 */
	public void setUnder(Sprite under) {
		this.under = under;
	}
	
	/**
	 * Empties the Vacuum.
	 * @throws VacuumException When the value of the passed capacity is negative or higher than the maximum capacity. 
	 */
	public void empty() throws VacuumException{		
		setCapacity(0);
	}

	/**
	 * Getter of MAX_CAPACITY.
	 * @return The value of MAX_CAPACITY.
	 */
	public int getMaxCapacity() {
		return MAX_CAPACITY;
	}	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void moveTo(int row, int column) throws SpriteException{
		setRow(row);
		setColumn(column);
	}	
}