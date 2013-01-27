package com.johnflan.enigma;

import com.johnflan.enigma.reflector.ReflectorType;
import com.johnflan.enigma.rotor.RotorType;

public class Start {

	public static void main(String[] args) throws Exception {
		
		EnigmaMachineImpl enigmaMachine = new EnigmaMachineImpl();
		String pt = "LISACHAMBERSISASECRETAGENT";
		String ct = enigmaMachine.encrypt(pt);
		
		System.out.println(pt);
		System.out.println(ct);
		
		enigmaMachine = new EnigmaMachineImpl();
		System.out.println("\nNew EnigmaMachine instance\n");
		
		System.out.println(ct);
		ct = enigmaMachine.encrypt(ct);
		System.out.println(ct);	
	}
	
	
	public void test(){
		EnigmaMachine enigmaMachine = EnigmaMachineBuilder
										.addRotor1(RotorType.I)
										.addRotor2(RotorType.II, 2)
										.addRotor3(RotorType.III)
										.addReflector(ReflectorType.Umkehrwalze_B)
										.build();
		
		enigmaMachine.encrypt("Hi");
		enigmaMachine.encrypt('t');
	}
}
