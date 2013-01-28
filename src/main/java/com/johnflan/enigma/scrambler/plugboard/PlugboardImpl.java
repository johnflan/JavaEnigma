package com.johnflan.enigma.scrambler.plugboard;

import static com.johnflan.enigma.scrambler.Util.toChar;
import static com.johnflan.enigma.scrambler.Util.toInt;
import static com.johnflan.enigma.scrambler.Util.validChar;

public class PlugboardImpl implements Plugboard {
	
	private int[] plugs = new int[26];
	
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
}
