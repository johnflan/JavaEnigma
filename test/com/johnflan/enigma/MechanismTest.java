package com.johnflan.enigma;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.johnflan.enigma.reflector.ReflectorType;
import com.johnflan.enigma.rotor.RotorType;
import com.johnflan.enigma.scrambler.Scrambler;


public class MechanismTest {
	
	Scrambler mechanism;
	
	private static final char A = 'A';
	private static final char B = 'B';
	private static final char C = 'C';
	private static final char D = 'D';
	private static final char E = 'E';
	private static final char F = 'F';
	private static final char G = 'G';
	private static final char H = 'H';
	private static final char I = 'I';
	private static final char J = 'J';
	private static final char K = 'K';
	private static final char L = 'L';
	private static final char M = 'M';
	private static final char N = 'N';
	private static final char O = 'O';
	private static final char P = 'P';
	private static final char Q = 'Q';
	private static final char R = 'R';
	private static final char S = 'S';
	private static final char T = 'T';
	private static final char U = 'U';
	private static final char V = 'V';
	private static final char W = 'W';
	private static final char X = 'X';
	private static final char Y = 'Y';
	private static final char Z = 'Z';
	
	@Test
	public void firstLetterEncryptDecryptA() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(A);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, A);
	}
	
	@Test
	public void firstLetterEncryptDecryptB() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(B);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, B);
	}
	
	@Test
	public void firstLetterEncryptDecryptC() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(C);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, C);
	}
	
	@Test
	public void firstLetterEncryptDecryptD() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(D);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, D);
	}
	
	@Test
	public void firstLetterEncryptDecryptE() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(E);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, E);
	}
	
	@Test
	public void firstLetterEncryptDecryptF() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(F);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, F);
	}
	
	@Test
	public void firstLetterEncryptDecryptG() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(G);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, G);
	}
	
	@Test
	public void firstLetterEncryptDecryptH() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(H);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, H);
	}
	
	@Test
	public void firstLetterEncryptDecryptI() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(I);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, I);
	}
	
	@Test
	public void firstLetterEncryptDecryptJ() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(J);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, J);
	}
	
	@Test
	public void firstLetterEncryptDecryptK() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(K);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, K);
	}
	
	@Test
	public void firstLetterEncryptDecryptL() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(L);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, L);
	}
	
	@Test
	public void firstLetterEncryptDecryptM() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(M);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, M);
	}
	
	@Test
	public void firstLetterEncryptDecryptN() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(N);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, N);
	}
	
	@Test
	public void firstLetterEncryptDecryptO() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(O);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, O);
	}
	
	@Test
	public void firstLetterEncryptDecryptP() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(P);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, P);
	}
	
	@Test
	public void firstLetterEncryptDecryptQ() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(Q);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, Q);
	}
	
	@Test
	public void firstLetterEncryptDecryptR() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(R);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, R);
	}
	
	@Test
	public void firstLetterEncryptDecryptS() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(S);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, S);
	}
	
	@Test
	public void firstLetterEncryptDecryptT() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(T);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, T);
	}
	
	@Test
	public void firstLetterEncryptDecryptU() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(U);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, U);
	}
	
	@Test
	public void firstLetterEncryptDecryptV() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(V);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, V);
	}
	
	@Test
	public void firstLetterEncryptDecryptW() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(W);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, W);
	}
	
	@Test
	public void firstLetterEncryptDecryptX() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(X);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, X);
	}
	
	@Test
	public void firstLetterEncryptDecryptY() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(Y);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, Y);
	}
	@Test
	public void firstLetterEncryptDecryptZ() throws Exception{
		
		resetMechanism();
		char ct = mechanism.encode(Z);
		resetMechanism();
		char pt = mechanism.encode(ct);
		
		Assert.assertEquals(pt, Z);
	}
	
	
	private void resetMechanism() throws Exception{
		
		mechanism = new Scrambler(
				RotorType.I,
				RotorType.II,
				RotorType.III,
				ReflectorType.Umkehrwalze_C,
				null);
	}

}
