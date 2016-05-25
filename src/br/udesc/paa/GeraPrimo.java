package br.udesc.paa;

/**
 *
 * @author AndersonR
 */
public class GeraPrimo extends java.util.Random {
    private int n;
    
    public GeraPrimo() {
        do {
            this.n = Math.abs(super.nextInt());
        } while (!verificaPrimalidade(n));
    }
    
    public int getPrimo() {
        return n;
    }
    
    private boolean verificaPrimalidade(int n) {
        int contador = 1;
        
        for (int i = 1; i < n / 2; i++) {
            if (n % i == 0)
                contador++;
                
            if (contador == 3) return false;
        }
        return true;
    }
}