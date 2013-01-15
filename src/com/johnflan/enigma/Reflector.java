package com.johnflan.enigma;

public class Reflector {
	
	private char[] mapping;
	private static final int ASCII_OFFSET = 65;
	
	Reflector(ReflectorType reflector){
		mapping = reflector.getMapping();
	}

	public char reflect(char c) throws Exception {
		int value = charIntValue(c);
		if (value > 25 || value < 0){
			throw new Exception("invalid cipher input");
		}
		
		return mapping[value];
	}
	
	private int charIntValue(char input){
		int inputValue = (int) input;
		return inputValue - ASCII_OFFSET;
	}

}
