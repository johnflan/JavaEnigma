package com.johnflan.enigma.scrambler;

public class Util {
	
	private static final int ASCII_OFFSET = 65;
	
	public static int toInt(char input){
		int value = (int) input;
		value = value - ASCII_OFFSET;

		return value;
	}
	
	public static char toChar(int input){
		return (char) (input + ASCII_OFFSET);
	}
	
	public static boolean validChar(char c){
		int charValue = ((int) c) - ASCII_OFFSET;
		if (charValue < 0 || charValue > 25){
			return false;
		}
		return true;
	}

}
