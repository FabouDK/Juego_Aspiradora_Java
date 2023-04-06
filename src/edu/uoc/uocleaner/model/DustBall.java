package edu.uoc.uocleaner.model;

import java.util.ArrayList;
import java.util.Random;

/** 
 * A DustBall sprite.
 * @author Fabou Diawara Keita
 * @version 1.0  
 */
public class DustBall extends Dirt implements Movable{
	
	/**
	 * Constructor
	 * @param row Index of the row in which the dirt element is.
	 * @param column Index of the column in which the dirt element is.
	 * @throws SpriteException When the index of the row or the column is incorrect.
	 */
	public DustBall(int row, int column) throws SpriteException{
		super(row, column, Symbol.DUSTBALL, 5);		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override	
	public void moveTo(int row, int col) throws SpriteException{
		setRow(row);
		setColumn(col);
	}
	
	/**
	 * Move the dustball randomly to a valid position.
	 * @param level Object which refers to one level/room of the game.
	 * @return ArrayList with pairs (row-column) that represent the valid moves that the dustball can do from its current position.	 
	 */
	public ArrayList<int[]> moveRandomly(Level level){
		// Make a list of valid moves for this dustball
		ArrayList<int[]> validMoves = new ArrayList<int[]>();
		
		if (validMove(level,getRow() + Movable.SPEED, getColumn())){
			validMoves.add(new int[]{getRow() + Movable.SPEED, getColumn()});
		}
		if (validMove(level,getRow() -  Movable.SPEED, getColumn())){
			validMoves.add(new int[]{getRow() -  Movable.SPEED, getColumn()});
		}
		if (validMove(level,getRow(), getColumn() +  Movable.SPEED)){
			validMoves.add(new int[]{getRow(), getColumn() +  Movable.SPEED});
		}
		if (validMove(level,getRow(), getColumn() - Movable.SPEED)){
			validMoves.add(new int[]{getRow(), getColumn() - Movable.SPEED});
		}
						
		if(!validMoves.isEmpty() && (new Random()).nextFloat()>0.75) {			
					
			int index = (new Random()).nextInt(validMoves.size());
			
			try {
				level.setCell(getRow(),getColumn(),new Dirt(getRow(),getColumn()));
				moveTo(validMoves.get(index)[0],validMoves.get(index)[1]);
				level.setCell(this);
			} catch (SpriteException e) {					
				e.printStackTrace();
			}			
		}
		
		return validMoves;
	}	
	
	/**
	 * Indicates if the position (row, column) to move in the board is valid for the dustball.
	 * @param level Object which refers to one level/room of the game.
	 * @param row Index of the row where the dustball wants to move to.
	 * @param column Index of the column where the dustball wants to move to.
	 * @return True if the position is valid, otherwise it returns false.
	 */
	private boolean validMove(Level level, int row, int column){
		
    	return !(
    			row>=level.getNumRows()
    			| row <0
    			| column>=level.getNumColumns()
    			| column<0
    			| level.getCell(row, column).getSymbol() == Symbol.WALL    			
    			| level.getCell(row, column).getSymbol() == Symbol.VACUUM 
    			| level.getCell(row, column).getSymbol() == Symbol.DUSTBALL    			
    			| level.getCell(row, column).getSymbol() == Symbol.DUMPSTER    			 
    			);
    }
}