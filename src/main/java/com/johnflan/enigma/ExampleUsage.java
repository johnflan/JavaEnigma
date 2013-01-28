package com.johnflan.enigma;

import com.johnflan.enigma.scrambler.plugboard.Plugboard;
import com.johnflan.enigma.scrambler.plugboard.PlugboardImpl;
import com.johnflan.enigma.scrambler.reflector.ReflectorType;
import com.johnflan.enigma.scrambler.rotor.RotorType;

public class ExampleUsage {

	public static void main(String[] args) throws Exception {
		
		Plugboard plugboard = new PlugboardImpl();
		plugboard.addCable('A', 'H').addCable('Q', 'C').addCable('P', 'Z');
		
		EnigmaMachine enigmaMachine = EnigmaMachineBuilder
				.addRotor1(RotorType.I, 'H')
				.addRotor2(RotorType.II, 'A')
				.addRotor3(RotorType.III, 'A')
				.addReflector(ReflectorType.B)
				.addPlugBoard(plugboard)
				.build();
		
		String pt = "SETECASTRONOMY";
		String ct = enigmaMachine.encrypt(pt);
		
		System.out.println(pt);
		System.out.println(ct);
	}
}
