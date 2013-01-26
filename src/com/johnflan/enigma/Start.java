package com.johnflan.enigma;

public class Start {

	public static void main(String[] args) throws Exception {
		
		EnigmaMachine enigmaMachine = new EnigmaMachine();
		String pt = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		String ct = enigmaMachine.encryptString(pt);
		
		System.out.println(pt);
		System.out.println(ct);
		
		enigmaMachine = new EnigmaMachine();
		System.out.println("\nNew EnigmaMachine instance\n");
		
		System.out.println(ct);
		ct = enigmaMachine.encryptString(ct);
		System.out.println(ct);
		
		System.out.println("\nfor B");
		
		enigmaMachine = new EnigmaMachine();
		pt = "B";
		ct = enigmaMachine.encryptString(pt);
		
		System.out.println(pt);
		System.out.println(ct);
		
		enigmaMachine = new EnigmaMachine();
		pt = "F";
		ct = enigmaMachine.encryptString(pt);
		
		System.out.println(pt);
		System.out.println(ct);
		
		System.out.println("\nfor C");
		enigmaMachine = new EnigmaMachine();
		pt = "C";
		ct = enigmaMachine.encryptString(pt);
		
		System.out.println(pt);
		System.out.println(ct);
		
		enigmaMachine = new EnigmaMachine();
		pt = "X";
		ct = enigmaMachine.encryptString(pt);
		
		System.out.println(pt);
		System.out.println(ct);
		
		
	}

}
