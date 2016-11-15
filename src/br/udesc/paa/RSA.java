package br.udesc.paa;

import br.udesc.paa.chaves.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class RSA {

    private static BufferedReader arquivo;

    public static BigInteger codificar(BigInteger m, ChavePublica chave) {
        return m.modPow(chave.getChavePublica(), chave.getChave());
    }

    public static BigInteger decodificar(BigInteger c, ChavePrivada chave) {
        if (chave.getChavePrivada() != null) {
            return c.modPow(chave.getChavePrivada(), chave.getChave());
        } else {
            return null;
        }
    }

    public static StringBuilder codificar(ChavePublica chavePublica, ChavePrivada chavePrivada, String nomeArquivoEntrada, String nomeArquivoSaida) {
        String mensagem = leDados(nomeArquivoEntrada);
        StringBuilder encoded = new StringBuilder();
        try {
            int length = mensagem.length();
            byte[] bytes = mensagem.getBytes("ASCII");
            for (int i = 0; i < length; i++) {
                Byte byteAsc = bytes[i];
                BigInteger m = new BigInteger(byteAsc.toString());
                BigInteger enc = RSA.codificar(m, chavePublica); // Codifica pelo código da tabela ASCII
                encoded = encoded.append(enc + " ");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        gravaDados(nomeArquivoSaida, encoded);

        return encoded;
    }

    public static StringBuilder decodificar(String nomeArquivoEntrada, String nomeArquivoSaida, ChavePublica chavePublica, ChavePrivada chavePrivada) {
        String conteudo = leDados(nomeArquivoEntrada);
        StringBuilder decoded = new StringBuilder();
        String[] enc = conteudo.split(" ");
        for (int i = 0; i < enc.length-1; i++) {
            BigInteger dec = RSA.decodificar(new BigInteger(enc[i]), chavePrivada); // Decodifica pelo código da tabela ASCII
            decoded = decoded.append((char) dec.intValue());
        }
        gravaDados(nomeArquivoSaida, decoded);
        return decoded;
    }

    public static String leDados(String nomeArquivo) {
        String conteudo = new String();
        try {
            arquivo = new BufferedReader(new FileReader(nomeArquivo));
            StringBuilder sb = new StringBuilder();
            String linha = arquivo.readLine();

            while (linha != null) {
                sb.append(linha);
                sb.append(System.lineSeparator());
                linha = arquivo.readLine();
            }
            conteudo = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conteudo;
    }

    public static void gravaDados(String nomeArquivo, StringBuilder conteudo) {
        try {
            FileWriter fw = new FileWriter(nomeArquivo, false);

            fw.write(conteudo.toString());
            fw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
