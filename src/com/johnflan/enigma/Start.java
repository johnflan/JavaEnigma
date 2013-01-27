package com.johnflan.enigma;

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
}
