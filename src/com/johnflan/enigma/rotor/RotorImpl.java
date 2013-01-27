package com.johnflan.enigma.rotor;

public class RotorImpl implements Rotor{
	
	private char[] mapping;
	private char[] reverseMapping;
	private int[] notchPositions;
	private int rotorPosition = 0;
	private static final int ASCII_OFFSET = 65;
	
	public RotorImpl(int startSetting, RotorType rotor) {
		rotorPosition = startSetting;
		mapping = rotor.getMapping();
	}
	
	public RotorImpl(RotorType rotor){

		mapping = rotor.getMapping();
		reverseMapping();
		buildNotchSteps(rotor.getNotchChars());
	}
	
	private void reverseMapping() {
		reverseMapping = new char[26];
		for (int i = 0; i < mapping.length; i++){
			int j = charIntValue(mapping[i]);
			reverseMapping[j] = intCharValue(i);
		}
	}
	
	public char in(char charInput) {
		int value = charIntValue(charInput);
		int convertedMapping = (value + rotorPosition) % 26;
	
		char output = mapping[convertedMapping];
		
		char convertedValue = convertRotorOutputForNotchPosition(output);
		
		return convertedValue;
	}
	
	
	public char out(char charInput){
		
		int value = charIntValue(charInput);
		int convertedMapping = (value + rotorPosition) % 26;
		
		char output = reverseMapping[convertedMapping];
		char convertedValue = convertRotorOutputForNotchPosition(output);

		return convertedValue;
	}
	
	private char convertRotorOutputForNotchPosition(char outputChar) {
		int outputCharIntValue = charIntValue(outputChar);
		int convertedValue = outputCharIntValue - rotorPosition;
		
		if (convertedValue < 0){
			convertedValue = 26 + convertedValue;
		} 
		return intCharValue(convertedValue);
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

	private int charIntValue(char input){
		int value = (int) input;
		value = value - ASCII_OFFSET;

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
