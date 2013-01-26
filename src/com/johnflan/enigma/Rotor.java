package com.johnflan.enigma;

public class Rotor {
	
	private char[] mapping;
	private char[] reverseMapping;
	private int[] notchSteps;
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
		int convertedMapping = (value + rotorSetting) % 25;
		return mapping[convertedMapping];
	}
	
	
	public char out(char charInput) throws Exception{
		
		int value = charIntValue(charInput);
		int convertedMapping = (value + rotorSetting) % 25;
		return reverseMapping[convertedMapping];
	}
	
	public Boolean incrementCounter(){
		rotorSetting = ++rotorSetting % 25;
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
	
	private void buildNotchSteps(char[] notchChars){
		notchSteps = new int[notchChars.length];
		for(int i = 0; i < notchChars.length; i++){
			int notchCharLocation = (int) notchChars[i];
			notchSteps[i] = notchCharLocation - ASCII_OFFSET;
		}
	}
	
	private char intCharValue(int input){
		return (char) (input + ASCII_OFFSET);
	}
}
