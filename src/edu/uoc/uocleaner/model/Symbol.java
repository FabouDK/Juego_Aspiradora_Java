package edu.uoc.uocleaner.model;

/** 
 * Symbol enumeration.
 * @author Fabou Diawara Keita
 * @version 1.0  
 */
public enum Symbol {

	DUSTBALL('@',"dustball.png"),
	DUMPSTER('D',"dumpster.png"),
	VACUUM('V',"huocver.png"),
	DIRT('�',"dirt.png"),
	WALL('#',""),
	CORRIDOR(' ',"");
	
	/**
	 * ASCII character of the symbol
	 */
	private char ascii;
	/**
	 * Image of the symbol
	 */
	private String image;
	
	/**
	 * Constructor
	 * @param ascii The ASCII character of the symbol.
	 * @param image Name of the image of the symbol.
	 */
	private Symbol(char ascii, String image){
		this.ascii = ascii;
		this.image = image;
	}
	
	/**
	 * Given an ASCII character, it returns the name of the symbol. 
	 * @param ascii ASCII character of the symbol.
	 * @return It returns the name of the symbol from an ASCII character. If the ASCII character does not exist, then it returns null.
	 */
	public static Symbol getName(char ascii) {
		for(var s : Symbol.values()) {
			if(s.getAscii() == ascii) return s;
		}
		return null;
	}
	/**
	 * The ASCII character of the symbol (field "ascii").
	 * @return The ASCII character of the symbol.
	 */
	public char getAscii() {
		return ascii;
	}
	
	/**
	 * The image of the symbol (field "image").
	 * @return The image of the symbol.
	 */
	public String getImage() {
		return image;
	}
	
	@Override
	/**
	 * It returns the ASCII character of the symbol.
	 * @return the ASCII character of the symbol.
	 */
	public String toString() {
		return String.valueOf(ascii);
	}
}