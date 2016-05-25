/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.udesc.paa;

import br.udesc.paa.chaves.*;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

/**
 *
 * @author AndersonR
 */
public class RSA {
    	
	public static BigInteger codificar(BigInteger m , ChavePublica chave){
		return m.modPow(chave.getChavePublica(), chave.getChave());
	}
	
	public static BigInteger decodificar(BigInteger c , ChavePrivada chave){
		if (chave.getChavePrivada()!= null) 
			return c.modPow(chave.getChavePrivada(), chave.getChave());
		else
			return null;
	}

	public static StringBuilder codificar(ChavePublica chavePublica, ChavePrivada chavePrivada, String mensagem) {
		StringBuilder encoded = new StringBuilder();
		try {
			int length = mensagem.length();
			byte[] bytes = mensagem.getBytes("ASCII");
			for (int i = 0; i< length; i++) {
				Byte byteAsc = bytes[i];
				BigInteger m = new BigInteger(byteAsc.toString());
				BigInteger enc = RSA.codificar(m, chavePublica); // Encode password (ASCII table)
				encoded = encoded.append(enc+" ");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}   
		return encoded;
	}
	
	public static StringBuilder decodificar(ChavePublica chavePublica, ChavePrivada chavePrivada, String senha) {
		StringBuilder decoded = new StringBuilder();
		String[] enc = senha.split(" ");
		for (int i = 0; i< enc.length; i++) {
			BigInteger dec = RSA.decodificar(new BigInteger(enc[i]), chavePrivada); // Decode password (ASCII table)
			decoded = decoded.append((char)dec.intValue());
		}
		return decoded;
	}
	
}
