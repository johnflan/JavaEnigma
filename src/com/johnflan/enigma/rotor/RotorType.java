package com.johnflan.enigma.rotor;

public enum RotorType {
	
	I("EKMFLGDQVZNTOWYHXUSPAIBRCJ", "Q"),
	II("AJDKSIRUXBLHWTMCQGZNPYFVOE", "E"),
	III("BDFHJLCPRTXVZNYEIWGAKMUSQO", "V"),
	IV("ESOVPZJAYQUIRHXLNFTGKDCMWB", "J"),
	V("VZBRGITYUPSDNHLXAWMJQOFECK", "Z"),
	
	//Naval Engigma Rotors
	VI("JPGVOUMFYQBENHZRDKASXLICTW", "ZM"),
	VII("NZJHGRCXMYSWBOUFAIVLPEKQDT", "ZM"),
	VIII("FKQHTLXOCBJSPDZRAMEWNIUYGV", "ZM"),
	
	//4 Rotor Naval Enigma could only use one of the
	//following in the number 4 position
	//and could only be advanced manually
	Beta("LEYJVCNIXWPBQMDRTAKZGFUHOS", ""),
	Gamma("FSOKANUERHMBTIYCWLQPZXVGJD", "");

	
	private char[] charMapping;
	private char[] notchChar;
	private int startPos = 0;
	
	RotorType(String charMapping){
		this.charMapping = charMapping.toCharArray();
	}
	
	RotorType(String charMapping, String notchChar){
		this.charMapping = charMapping.toCharArray();
		this.notchChar = notchChar.toCharArray();
	}

	
	public char[] getMapping(){
		return charMapping;
	}
	
	public char[] getNotchChars(){
		return notchChar;
	}
	
	public int getStartPosition(){
		return startPos;
	}
	
	public void setStartPosition(int startPos){
		this.startPos = startPos;
	}

}
