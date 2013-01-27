package com.johnflan.enigma;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.johnflan.enigma.scrambler.Scrambler;
import com.johnflan.enigma.scrambler.ScramblerImpl;
import com.johnflan.enigma.scrambler.reflector.ReflectorType;
import com.johnflan.enigma.scrambler.rotor.RotorType;


public class ScramblerTest {
	
	Scrambler scrambler;
	
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
		
		resetScrambler();
		char ct = scrambler.encode(A);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, A);
	}
	
	@Test
	public void firstLetterEncryptDecryptB() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(B);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, B);
	}
	
	@Test
	public void firstLetterEncryptDecryptC() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(C);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, C);
	}
	
	@Test
	public void firstLetterEncryptDecryptD() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(D);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, D);
	}
	
	@Test
	public void firstLetterEncryptDecryptE() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(E);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, E);
	}
	
	@Test
	public void firstLetterEncryptDecryptF() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(F);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, F);
	}
	
	@Test
	public void firstLetterEncryptDecryptG() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(G);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, G);
	}
	
	@Test
	public void firstLetterEncryptDecryptH() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(H);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, H);
	}
	
	@Test
	public void firstLetterEncryptDecryptI() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(I);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, I);
	}
	
	@Test
	public void firstLetterEncryptDecryptJ() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(J);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, J);
	}
	
	@Test
	public void firstLetterEncryptDecryptK() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(K);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, K);
	}
	
	@Test
	public void firstLetterEncryptDecryptL() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(L);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, L);
	}
	
	@Test
	public void firstLetterEncryptDecryptM() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(M);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, M);
	}
	
	@Test
	public void firstLetterEncryptDecryptN() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(N);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, N);
	}
	
	@Test
	public void firstLetterEncryptDecryptO() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(O);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, O);
	}
	
	@Test
	public void firstLetterEncryptDecryptP() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(P);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, P);
	}
	
	@Test
	public void firstLetterEncryptDecryptQ() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(Q);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, Q);
	}
	
	@Test
	public void firstLetterEncryptDecryptR() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(R);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, R);
	}
	
	@Test
	public void firstLetterEncryptDecryptS() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(S);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, S);
	}
	
	@Test
	public void firstLetterEncryptDecryptT() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(T);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, T);
	}
	
	@Test
	public void firstLetterEncryptDecryptU() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(U);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, U);
	}
	
	@Test
	public void firstLetterEncryptDecryptV() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(V);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, V);
	}
	
	@Test
	public void firstLetterEncryptDecryptW() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(W);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, W);
	}
	
	@Test
	public void firstLetterEncryptDecryptX() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(X);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, X);
	}
	
	@Test
	public void firstLetterEncryptDecryptY() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(Y);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, Y);
	}
	@Test
	public void firstLetterEncryptDecryptZ() throws Exception{
		
		resetScrambler();
		char ct = scrambler.encode(Z);
		resetScrambler();
		char pt = scrambler.encode(ct);
		
		Assert.assertEquals(pt, Z);
	}
	
	
	private void resetScrambler() throws Exception{
		scrambler = new ScramblerImpl(
				RotorType.I,
				RotorType.II,
				RotorType.III,
				RotorType.IV,
				ReflectorType.C);
	}
}
