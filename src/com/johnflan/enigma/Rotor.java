package com.johnflan.enigma;

public class Rotor {
	
	private char[] mapping;
	private char[] reverseMapping;
	private int[] notchPositions;
	private int rotorPosition = 0;
	private static final int ASCII_OFFSET = 65;
	
	Rotor(int startSetting, RotorType rotor) throws Exception{
		mapping = rotor.getMapping();
	}
	
	Rotor(RotorType rotor) throws Exception{

		mapping = rotor.getMapping();
		reverseMapping();
		buildNotchSteps(rotor.getNotchChars());
	}
	
	private void reverseMapping() throws Exception {
		reverseMapping = new char[26];
		for (int i = 0; i < mapping.length; i++){
			int j = charIntValue(mapping[i]);
			reverseMapping[j] = intCharValue(i);
		}
	}
	
	public char in(char charInput) throws Exception{
		int value = charIntValue(charInput);
		int convertedMapping = (value + rotorPosition) % 25;
	
		char output = mapping[convertedMapping];
		
		char convertedValue = intCharValue(charIntValue(output) - rotorPosition);
		
		System.out.println(charInput + " -> " + convertedValue);
		return convertedValue;
	}
	
	
	public char out(char charInput) throws Exception{
		
		int value = charIntValue(charInput);
		int convertedMapping = (value + rotorPosition) % 25;
		return reverseMapping[convertedMapping];
	}
	
	public boolean inNotch(){
		for (int notchPosition : notchPositions){
			if (rotorPosition == notchPosition){
				return true;
			}
		}
		return false;
	}
	
	public void stepRotor(){
		rotorPosition = ++rotorPosition % 25;
	}
	
	public void stepRotor(boolean rotorToLeftInNotch){
		if (rotorToLeftInNotch){
			rotorPosition = ++rotorPosition % 25;
		}
	}

	private int charIntValue(char input) throws Exception{
		int value = (int) input;
		value = value - ASCII_OFFSET;
		
		if (value > 25 || value < 0){
			throw new Exception("invalid cipher input");
		}
		
		return value;
	}
	
	private void buildNotchSteps(char[] notchChars){
		notchPositions = new int[notchChars.length];
		for(int i = 0; i < notchChars.length; i++){
			int notchCharLocation = (int) notchChars[i];
			notchPositions[i] = notchCharLocation - ASCII_OFFSET;
		}
	}
	
	private char intCharValue(int input){
		return (char) (input + ASCII_OFFSET);
	}
	
	public String toString(){
		return "Rotor position: " + Character.toChars(rotorPosition + ASCII_OFFSET)[0];
	}
}
