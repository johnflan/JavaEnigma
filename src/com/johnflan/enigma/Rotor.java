package com.johnflan.enigma;

public class Rotor {
	
	private char[] mapping;
	private int rotorSetting;
	private int startSetting;
	private static final int ASCII_OFFSET = 65;
	
	Rotor(int startSetting, RotorType rotor) throws Exception{
		this.startSetting = startSetting;
		mapping = rotor.getMapping();
	}
	
	Rotor(RotorType rotor) throws Exception{
		this.startSetting = 0;
		mapping = rotor.getMapping();
	}
	
	public char in(char charInput) throws Exception{
		int value = charIntValue(charInput);
		int convertedMapping = (value + rotorSetting) % 26;
		return mapping[convertedMapping];
	}
	
	
	public char out(char charInput) throws Exception{
		
		for (int i = 0; i < 26; i++){
			if (mapping[i] == charInput){
				return Character.toChars(i + ASCII_OFFSET)[0];
			}
		}
		
		throw new Exception("Character output mapping not found for: " + charInput);
	}
	
	public Boolean incrementCounter(){
		rotorSetting = ++rotorSetting % 26;
		return rotorSetting == startSetting ? true : false;
	}

	private int charIntValue(char input) throws Exception{
		int value = (int) input;
		value = value - ASCII_OFFSET;
		
		if (value > 25 || value < 0){
			throw new Exception("invalid cipher input");
		}
		
		return value;
	}
}
