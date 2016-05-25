package br.udesc.paa;

/**
 *
 * @author AndersonR
 */
public class ForcaBruta {
    
    public ForcaBruta(long n) {
        quebraN(n);
    }
    public void quebraN(long n) {
        for (long i = 2; i < n/2; i++) {
            if (n % i == 0) {
                System.out.println("p = " + i + "; q = " + n/i);
                break;
            }
        }
    }
}
