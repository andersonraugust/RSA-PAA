package br.udesc.paa;

import java.math.BigInteger;

public class EuclidesEstendido {

    public static BigInteger[] maiorDivisorComum(BigInteger a, BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return new BigInteger[]{a, BigInteger.ONE, BigInteger.ZERO};
        }
        BigInteger[] vals = maiorDivisorComum(n, a.mod(n));
        BigInteger d = vals[0];
        BigInteger x = vals[2];
        BigInteger y = vals[1].subtract((a.divide(n).multiply(x)));
        return new BigInteger[]{d, x, y};
    }

    public static BigInteger inversoModular(BigInteger a, BigInteger n) {
        BigInteger[] vals = maiorDivisorComum(a, n);
        BigInteger d = vals[0];
        BigInteger b = BigInteger.ONE;
        BigInteger x0 = vals[1];
        if (d.mod(b).equals(BigInteger.ZERO)) {
            return x0.multiply(b.divide(d)).mod(n);
        }
        return BigInteger.ZERO;
    }

}
