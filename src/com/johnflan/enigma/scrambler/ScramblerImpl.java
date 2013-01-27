package com.johnflan.enigma.scrambler;

import com.johnflan.enigma.scrambler.plugboard.Plugboard;
import com.johnflan.enigma.scrambler.plugboard.PlugboardImpl;
import com.johnflan.enigma.scrambler.reflector.Reflector;
import com.johnflan.enigma.scrambler.reflector.ReflectorImpl;
import com.johnflan.enigma.scrambler.reflector.ReflectorType;
import com.johnflan.enigma.scrambler.rotor.Rotor;
import com.johnflan.enigma.scrambler.rotor.RotorImpl;
import com.johnflan.enigma.scrambler.rotor.RotorType;

public class ScramblerImpl implements Scrambler{
	
	private Rotor rotor1;
	private Rotor rotor2;
	private Rotor rotor3;
	private Rotor rotor4;

	private Reflector reflector;
	private Plugboard plugBoard;

	public ScramblerImpl(RotorType rotor1, RotorType rotor2, RotorType rotor3, ReflectorType reflector) {
		configure(rotor1, rotor2, rotor3, null, reflector, null);
	}
	
	public ScramblerImpl(RotorType rotor1, RotorType rotor2, RotorType rotor3, RotorType rotor4, ReflectorType reflector) {
		configure(rotor1, rotor2, rotor3, rotor4, reflector, null);
	}
	
	public ScramblerImpl(RotorType rotor1, RotorType rotor2, RotorType rotor3, ReflectorType reflector, Plugboard plugBoard) {
		configure(rotor1, rotor2, rotor3, null, reflector, plugBoard);
	}
	
	public ScramblerImpl(RotorType rotor1, RotorType rotor2, RotorType rotor3, RotorType rotor4, ReflectorType reflector, Plugboard plugBoard) {
		configure(rotor1, rotor2, rotor3, rotor4, reflector, plugBoard);
	}
	
	private void configure(RotorType rotor1, RotorType rotor2, RotorType rotor3, RotorType rotor4, ReflectorType reflector, Plugboard plugBoard){
		if (rotor1 != null)
			this.rotor1 = new RotorImpl(rotor1);
		
		if (rotor2 != null)
			this.rotor2 = new RotorImpl(rotor2);
		
		if (rotor3 != null)
			this.rotor3 = new RotorImpl(rotor3);
		
		if (rotor4 != null)
			this.rotor4 = new RotorImpl(rotor4);
		
		if (reflector != null)
			this.reflector = new ReflectorImpl(reflector);
		
		if (plugBoard != null){
			this.plugBoard = plugBoard;
		} else{
			this.plugBoard = new PlugboardImpl();
		}
	}
	
	public char encode(char pt) {
		stepRotors();
		
		return plugBoard.convert(rotor3(plugBoard.convert(pt)));
	}
	
	private char rotor1(char c) {
		if (rotor1 == null)
			return reflector(c);
		return rotor1.out( reflector( rotor1.in(c) ));
	}
	
	private char rotor2(char c) {
		if (rotor2 == null)
			return reflector(c);
		return rotor2.out( rotor1( rotor2.in(c) ));
	}
	
	private char rotor3(char c) {
		if (rotor3 == null)
			return reflector(c);
		return rotor3.out( rotor2( rotor3.in(c) ) );
	}
	
	private char reflector(char c) {
		if (reflector == null)
			return c;
		char reflected = reflector.reflect(c);
		
		return reflected;
	}
	
	private void stepRotors(){
		
		if (rotor2.inNotch()){
			rotor1.stepRotor();
			rotor2.stepRotor();
			rotor3.stepRotor();
		} else if (rotor3.inNotch()){
			rotor2.stepRotor();
			rotor3.stepRotor();
		} else {
			rotor3.stepRotor();
		}
	}
}
