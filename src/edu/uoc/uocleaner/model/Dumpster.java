package edu.uoc.uocleaner.model;

/** 
 * A Dumpster sprite.
 * @author Fabou Diawara Keita
 * @version 1.0  
 */
public class Dumpster extends Sprite{
	
	/**
	 * Points that have been loaded to the dumpster.
	 */
	private int load;
	
	{
		try{
			setLoad(0);
		}catch(DumpsterException e) {
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Constructor.
	 * @param row Index of the row in which the dumpster element is.
	 * @param column Index of the column in which the dumpster element is.
	 * @throws SpriteException When the index of the row or the column is incorrect.
	 */
	public Dumpster(int row, int column) throws SpriteException{
		super(row,column,Symbol.DUMPSTER);		
	}
	
	/**
	 * Getter of load.
	 * @return The points which have been loaded to the dumpster. 
	 */
	public int getLoad() {
		return load;
	}
	
	/**
	 * Setter of load.
	 * @param load Points that have to be loaded to the dumpster.
	 * @throws DumpsterException When the load to assign is a negative value. 
	 */
	private void setLoad(int load) throws DumpsterException{
		if(load<0) {
			throw new DumpsterException(DumpsterException.ERROR_LOAD_NEGATIVE_VALUE);
		}
		this.load = load;
	}
	
	/**
	 * Add the specified load to the dumpster's current load.
	 * @param load Quantity of load to add to the dumpster's current load.
	 * @throws DumpsterException When the load to assign is a negative value.
	 */
	public void addLoad(int load) throws DumpsterException{
		setLoad(this.getLoad()+load);
	}
}