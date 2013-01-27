package com.johnflan.enigma.plugboard;

public class PlugBoardImpl implements PlugBoard {
	
	private int[] plugs = new int[26];
	private static final int ASCII_OFFSET = 65;
	
	public PlugBoardImpl(){
		for (int i = 0; i < plugs.length; i++){
			plugs[i] = -1;
		}
	}

	@Override
	public char convert(char c) {

		int plug = toInt(c);
		if (plugs[plug] == -1){
			return c;
		} else {
			return toChar(plugs[plug]);
		}
	}

	@Override
	public void addCable(char a, char b) {
		
		if (validChar(a) && validChar(b)){
			plugs[toInt(a)] = toInt(b);
			plugs[toInt(b)] = toInt(a);
		}
	}
	
	private boolean validChar(char c){
		int charValue = ((int) c) - ASCII_OFFSET;
		if (charValue < 0 || charValue > 25){
			return false;
		}
		return true;
	}
	
	private char toChar(int i){
		return (char) (i + ASCII_OFFSET);
	}
	
	private int toInt(char c){
		int intValue = (int) c;
		return intValue - ASCII_OFFSET;
	}

}
