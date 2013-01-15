package com.johnflan.enigma;

public class Start {

	public static void main(String[] args) throws Exception {
		EnigmaMachine enigmaMachine = new EnigmaMachine();
		String pt = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		String ct = enigmaMachine.encryptString(pt);
		
		System.out.println(pt);
		System.out.println(ct);
		
		pt = "NFXUHBJERGOPWAKLSIQVDTMCZYUHOBXLNCADWIVSGTKRPEMYZQJFB";
		ct = enigmaMachine.encryptString(pt);
		
		System.out.println(pt);
		System.out.println(ct);
	}

}
