package br.udesc.paa;

import java.math.BigInteger;

public class ForcaBruta {

    public ForcaBruta(BigInteger n, BigInteger e) {
    }

    public static BigInteger quebraN(BigInteger n, BigInteger e) {
        BigInteger i = sqrt(n);
        BigInteger dois = new BigInteger("2");
        BigInteger phi = new BigInteger("0");
        while (i.compareTo(dois) >= 0) {
            if (n.mod(i).equals(BigInteger.ZERO)) {
                BigInteger p = n.divide(i);
                BigInteger q = n.divide(p);
                phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
                System.out.println("n = " + n + "\np = " + p + "\nq = " + q);
                break;
            }
            i = i.subtract(BigInteger.ONE);
        }
        
        return EuclidesEstendido.inversoModular(e, phi);
        
    }

    static BigInteger sqrt(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
        while (b.compareTo(a) >= 0) {
            BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
            if (mid.multiply(mid).compareTo(n) > 0) {
                b = mid.subtract(BigInteger.ONE);
            } else {
                a = mid.add(BigInteger.ONE);
            }
        }
        return a.subtract(BigInteger.ONE);
    }

}
