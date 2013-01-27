package com.johnflan.enigma.reflector;

public class ReflectorImpl implements Reflector{
	
	private char[] mapping;
	private static final int ASCII_OFFSET = 65;
	
	public ReflectorImpl(ReflectorType reflector){
		mapping = reflector.getMapping();
	}

	public char reflect(char c){
		int value = charIntValue(c);
		
		return mapping[value];
	}
	
	private int charIntValue(char input){
		int inputValue = (int) input;
		return inputValue - ASCII_OFFSET;
	}

}
