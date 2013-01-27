package com.johnflan.enigma.scrambler.plugboard;

public class PlugboardImpl implements Plugboard {
	
	private int[] plugs = new int[26];
	private static final int ASCII_OFFSET = 65;
	
	public PlugboardImpl(){
		for (int i = 0; i < plugs.length; i++){
			plugs[i] = -1;
		}
	}

	@Override
	public char convert(char c) {
		
		if (validChar(c)){
			int plug = toInt(c);
			if (plugs[plug] == -1){
				return c;
			} else {
				return toChar(plugs[plug]);
			}
		}
		return c;
	}

	@Override
	public Plugboard addCable(char a, char b) {
		
		if (validChar(a) && validChar(b) || a == b){
			plugs[toInt(a)] = toInt(b);
			plugs[toInt(b)] = toInt(a);
		}
		
		return this;
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
