package com.johnflan.enigma;

public enum RotorType {
	
	I("EKMFLGDQVZNTOWYHXUSPAIBRCJ", "Q"),
	II("AJDKSIRUXBLHWTMCQGZNPYFVOE", "E"),
	III("BDFHJLCPRTXVZNYEIWGAKMUSQO", "V"),
	IV("ESOVPZJAYQUIRHXLNFTGKDCMWB", "J"),
	V("VZBRGITYUPSDNHLXAWMJQOFECK", "Z"),
	VI("JPGVOUMFYQBENHZRDKASXLICTW", "ZM"),
	VII("NZJHGRCXMYSWBOUFAIVLPEKQDT", "ZM"),
	VIII("FKQHTLXOCBJSPDZRAMEWNIUYGV", "ZM"),
	Beta("LEYJVCNIXWPBQMDRTAKZGFUHOS", ""),
	Gamma("FSOKANUERHMBTIYCWLQPZXVGJD", "");
	
	private char[] charMapping;
	private char[] notchChar;
	
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

}
