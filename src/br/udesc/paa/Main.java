package br.udesc.paa;

import br.udesc.paa.chaves.ChavePrivada;
import br.udesc.paa.chaves.Chaves;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        //recebe numero de bits inicial, numero de bits máximo e numero de execuções.
        //testaGeracaoChaves(32, 2048, 10);
        //recebe numero de bits inicial, numero de bits máximo e numero de execuções.
        //testaForcaBruta(32, 64, 10);
        
        Chaves chave = new Chaves();
        chave = Chaves.gerar(64);
        
        //Codifica arquivo
        RSA.codificar(chave.getChavePublica(), chave.getChavePrivada(), "entrada.txt", "codificado.txt");
        //Utiliza força bruta para achar o d
        BigInteger d = ForcaBruta.quebraN(chave.getChavePublica().getChave(), chave.getChavePublica().getChavePublica());
        //Decodifica o arquivo com a chave privada encontrada
        RSA.decodificar("codificado.txt", "decodificado.txt", chave.getChavePublica(), new ChavePrivada(d, chave.getChavePublica().getChave()));
    }

    public static void testaGeracaoChaves(Integer numBits, Integer numBitsMaximo, Integer numeroExecucoes) {
        // Número de execuções inicial
        Integer i = 0;
        // Vetor para armazenar tempos de execução
        long tempos[] = new long[numeroExecucoes];
        try {
            Chaves chaves = new Chaves();
            //Valor de bits máximo
            while (numBits <= numBitsMaximo) {
                //Criar chaves
                long tempoInicial = System.currentTimeMillis();
                chaves = Chaves.gerar(numBits);
                tempos[i] = (System.currentTimeMillis() - tempoInicial);
                System.out.println("Número de bits: " + numBits);
                System.out.println("chave publica: e = " + chaves.getChavePublica().getChavePublica() + ", n = " + chaves.getChavePublica().getChave());
                System.out.println("chave privada: d = " + chaves.getChavePrivada().getChavePrivada() + ", n = " + chaves.getChavePrivada().getChave());
                System.out.println("Tempo de execução: " + tempos[i]);
                System.out.println("----------------------------------------------------");
                i = i + 1;
                if (i.equals(numeroExecucoes)) {
                    //Calcula a média de tempo de geraçao da chave de n bits
                    long media = (tempos[0] + tempos[1] + tempos[2] + tempos[3] + tempos[4] + tempos[5] + tempos[6]
                            + tempos[7] + tempos[8] + tempos[9]) / 10;
                    System.out.println("Média de tempo de execução para " + numBits + " bits: " + media);
                    System.out.println("////////////////////////////////////");
                    System.out.println("");
                    //Regra para incrementar a execução
                    numBits = numBits + 512;
                    i = 0;

                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public static void testaForcaBruta(Integer numBits, Integer numBitsMaximo, Integer numeroExecucoes) {
        // Número de execuções inicial
        Integer i = 0;
        // Vetor para armazenar tempos de execução
        long tempos[] = new long[numeroExecucoes];
        try {
            //Valor de bits máximo
            while (numBits <= numBitsMaximo) {
                //Criar chaves

                Chaves chaves = new Chaves();
                chaves = Chaves.gerar(numBits);
                System.out.println("Número de bits: " + numBits);
                System.out.println("chave publica: e = " + chaves.getChavePublica().getChavePublica() + ", n = " + chaves.getChavePublica().getChave());
                long tempoInicial = System.currentTimeMillis();                
                //preenche a privada com o valor retornado pela quebra
                System.out.println("chave privada: d = " + ForcaBruta.quebraN(chaves.getChavePublica().getChave(), chaves.getChavePublica().getChavePublica())
                        + ", n = " + chaves.getChavePrivada().getChave());           
                tempos[i] = (System.currentTimeMillis() - tempoInicial);
                System.out.println("Tempo de execução: " + tempos[i]);
                System.out.println("----------------------------------------------------");
                i = i + 1;
                
                if (i.equals(numeroExecucoes)) {
                    //Calcula a média de tempo de quebra da chave de n bits
                    long media = (tempos[0] + tempos[1] + tempos[2] + tempos[3] + tempos[4] + tempos[5] + tempos[6]
                            + tempos[7] + tempos[8] + tempos[9]) / 10;
                    System.out.println("Média de tempo de execução para " + numBits + " bits: " + media);
                    System.out.println("////////////////////////////////////");
                    System.out.println("");
                    //Regra para incrementar a execução
                    numBits = numBits + 4;
                    i = 0;

                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
}
