package br.udesc.paa;

import java.math.BigInteger;
import java.security.SecureRandom;

public class MillerRabin {
	private static final SecureRandom nRandom = new SecureRandom();
	
	private static boolean witness(BigInteger n, BigInteger a) {
		BigInteger n_minus_one = n.subtract(BigInteger.ONE);
		int s = n_minus_one.getLowestSetBit();
		BigInteger d = n_minus_one.shiftRight(s);
		
		BigInteger a_to_power = a.modPow(d, n);
		if (a_to_power.equals(BigInteger.ONE)) return true;
		
		for (int i = 0; i < s-1; i++) {
			if (a_to_power.equals(n_minus_one)) return true;
			a_to_power = a_to_power.multiply(a_to_power).mod(n);
		}
		if (a_to_power.equals(n_minus_one)) return true;
		
		return false;
	}
	
	public static boolean miller_rabin(BigInteger n) {
		if (n.equals(BigInteger.ZERO)) return false;
		for (int repeat = 0; repeat < 50; repeat++) {
			BigInteger a;
			do {
				a = new BigInteger(n.bitLength(), nRandom);
			} while (a.equals(BigInteger.ZERO));
			if (!witness(n, a)) return false;
		}
		return true;
	}
	
	public static BigInteger getPrimo(int nBits){
		BigInteger prime; 
		do {
			prime = new BigInteger(nBits, nRandom);
			if (prime.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) continue;
		} while (!miller_rabin(prime));
		return prime;
	}

}
