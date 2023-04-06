package edu.uoc.uocleaner.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/** 
 * Level/Room class. 
 * @author Fabou Diawara Keita
 * @version 1.0 
 */
public class Level{
	/**
	 * Number of rows of the board.
	 */
	private int numRows;
	/**
	 * Number of columns of the board.
	 */
	private int numColumns;
	/**
	 * Representation of the 2D board.
	 */
	private Sprite[][] board;
	/**
	 * Name of the background image for the GUI app.
	 */
	private String imageBackground;
	/**
	 * Number of turns which the player has in order to beat the level.
	 */
	private int turns;	
	/**
	 * Maximum time which the player has in order to beat the level.
	 */
	private int time;
		
	/**
	 * Constructor 
	 * @param fileName Name of the configuration file which has all the information of the level.
	 * @throws FileNotFoundException When it is impossible to open the configuration file.
	 * @throws LevelException When the number of rows or columns are zero or negative; 
	 * when the number of turns or time is negative; when there is not only one vacuum cleaner; when there are not dumpsters; 
	 * when there are not dirts or dustballs.
	 * @throws VacuumException When the value for the vacuum cleaner's capacity is zero or negative.
	 * @throws SpriteException When the index of either the row or the column is incorrect.
	 */
	public Level(String fileName) throws FileNotFoundException, LevelException, VacuumException, SpriteException {
		char[] line = null;
		boolean isDumpster = false, isDirt = false;
		int numVacuums = 0;		
		
		Scanner sc = new Scanner(new File(fileName));

		// find the number of rows and columns       
        setNumRows(Integer.parseInt(sc.nextLine()));
        setNumColumns(Integer.parseInt(sc.nextLine()));
        setImageBackground(sc.nextLine());
        setTurns(Integer.parseInt(sc.nextLine()));
        setTime(Integer.parseInt(sc.nextLine()));
        
        board = new Sprite[numRows][numColumns];           
        for (int row = 0; row < numRows; row++) {
        	line = sc.nextLine().toCharArray();        	
			for (int column = 0; column < numColumns; column++) {				
				board[row][column] = SpriteFactory.getSprite(row,column,Symbol.getName(line[column]));				
				if(board[row][column] instanceof Dirt) isDirt = true;
				if(board[row][column] instanceof Vacuum) numVacuums++;
				if(board[row][column] instanceof Dumpster) isDumpster = true;								
			}			
        }        
        
        sc.close();       
                
        if(numVacuums!=1) {
        	throw new LevelException(LevelException.ERROR_NUM_VACUUMS);
        }
        
        if(!isDumpster) {
        	throw new LevelException(LevelException.ERROR_NO_DUMPSTERS);
        }
        
        if(!isDirt) {
        	throw new LevelException(LevelException.ERROR_NO_DIRT);
        }        
	}	
	
	/**
	 * This method returns a 1-D list with all the sprites which are in the board. 
	 * The rows are concatenated in a sequential order. 
	 * @return 1-D board in the format of a List. 
	 */
	public List<Sprite> get1DBoard() {
		ArrayList<Sprite> list = new ArrayList<Sprite>();
		
	    for (Sprite[] row : board) {
	        list.addAll(Arrays.asList(row));
	    }
	    	
		return list;
	}

	/**
	 * Given a row, this method analyzes it and put it into the range of [0, maxRow) 
	 * @param row Index to put into the valid range.
	 * @return Index of the row within the valid range. 
	 */
	private int putRowInRange(int row) {
		if(row<0) return 0;
		else if(row>=board.length) return board.length-1;
		else return row;	
	}
	
	/**
	 * Given a column, this method analyzes it and put it into the range of [0, maxColumn) 
	 * @param column Index to put into the valid range.
	 * @return Index of the column within the valid range. 
	 */
	private int putColumnInRange(int column) {
		if(column<0) return 0;
		else if(column>=board[0].length) return board[0].length-1;
		else return column;
	}
	
	/**
	 * Retrieve the sprite which is in the cell (row, column).
	 * If the index "row" or "column" is invalid, then the index is put in the range of [0,max).
	 * @param row  Index of the row to retrieve.
	 * @param column Index of the column to retrieve.
	 * @return Sprite which is in the cell (row, column).
	 */
	public Sprite getCell(int row, int column) {
		row = putRowInRange(row);
		column = putColumnInRange(column);
		return board[row][column];
	}
	
	/**
	 * Sets the "sprite" in the specific cell indicated by sprite's row and column.
	 * @param sprite Sprite to put into the cell indicated by sprite's row and sprite's column.
	 * @throws SpriteException When either the row index or the column index are negative.
	 */
	public void setCell(Sprite sprite) throws SpriteException{
		setCell(sprite.getRow(),sprite.getColumn(),sprite);
	}
	
	/**
	 * Sets the sprite in a specific (row,column) cell. Updates sprite's row and column information with 
	 * the data of the parameters "row" and "column". Likewise, it puts the indexes in range of [0,board.max).
	 * @param row Index of the row in which the sprite must be.
	 * @param column Index of the column in which the sprite must be.
	 * @param sprite Sprite to put into the (row,column) cell.
	 * @throws SpriteException When either the row index or the column index are negative. 
	 */
	public void setCell(int row, int column, Sprite sprite) throws SpriteException{
		row = putRowInRange(row);
		column = putColumnInRange(column);
		sprite.setRow(row);
		sprite.setColumn(column);
		board[row][column] = sprite;
	}	
	
	/**
	 * Getter of numRows.
	 * @return Value of the field "numRows".
	 */
	public int getNumRows() {
		return numRows;
	}
	
	/**
	 * Setter of numRows.
	 * @param numRows The new value to assign to the field "numRows".
	 * @throws LevelException When the value of the parameter "numRows" is zero or negative.
	 */
	private void setNumRows(int numRows) throws LevelException{
		if(numRows <= 0) {
			throw new LevelException(LevelException.ERROR_NUM_ROWS_INCORRECT);
		}
		
		this.numRows = numRows;
	}
	
	/**
	 * Getter of numColumns.
	 * @return Value of the field "numColumns".
	 */
	public int getNumColumns() {
		return numColumns;
	}
	
	/**
	 * Setter of numColumns.
	 * @param numColumns The new value to assign to the field "numColumns".
	 * @throws LevelException When the value of the parameter "numColumns" is zero or negative.
	 */
	private void setNumColumns(int numColumns) throws LevelException{
		if(numColumns <= 0) {
			throw new LevelException(LevelException.ERROR_NUM_COLUMNS_INCORRECT);
		}
		this.numColumns = numColumns;
	}	
	
	/**
	 * Getter of imageBackground.
	 * @return Value of the field "imageBackground".
	 */
	public String getImageBackground() {
		return imageBackground;
	}
	
	/**
	 * Setter of imageBackground. 
	 * @param imageBackground Value to assign to the field "imageBackground".	 
	 */
	private void setImageBackground(String imageBackground) {
		this.imageBackground = imageBackground;
	}
	
	/**
	 * Getter of turns.
	 * @return Value of the field "turns".
	 */
	public int getTurns() {
		return turns;
	}
	
	/**
	 * Setter of turns. 
	 * @param turns Value to assign to the field "turns".
	 * @throws LevelException When the value of the parameter "turns" is negative.
	 */
	private void setTurns(int turns) throws LevelException{
		if(turns<0) {
			throw new LevelException(LevelException.ERROR_NUM_TURNS_INCORRECT);
		}
		this.turns = turns;
	}
	
	/**
	 * Decreases one unit the value of the filed "turns".
	 * @throws LevelException When the value of the parameter "turns" is negative.
	 */
	public void decTurns() throws LevelException {
		setTurns(getTurns()-1);
	}
	
	/**
	 * Getter of time.
	 * @return Value of the field "time".
	 */
	public int getTime() {
		return time;
	}
	
	/**
	 * Setter of time. 
	 * @param time Value to assign to the field "time".
	 * @throws LevelException When the value of the parameter "time" is negative.
	 */
	private void setTime(int time) throws LevelException {
		if(time<0) {
			throw new LevelException(LevelException.ERROR_NUM_TIME_INCORRECT);
		}
		this.time = time;
	}
	
	/**
	 * Decreases one unit the value of time.
	 * @throws LevelException When the value of the parameter "turns" is negative.
	 */
	public void decTime() throws LevelException {		
		setTime(getTime()-1);
	}
	
	/**
	 * Returns a String with board's information.
	 * @return Text-based board.
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		for(int row = 0; row<numRows; row++) {
			for(int column = 0; column<numColumns; column++) {				
				str.append(board[row][column]);
			}
			str.append("\n");
		}
		
		return str.toString();		
	}
}
