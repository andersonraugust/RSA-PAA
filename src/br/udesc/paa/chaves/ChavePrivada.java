/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.udesc.paa.chaves;

import java.math.BigInteger;

/**
 *
 * @author AndersonR
 */
public class ChavePrivada extends Chave {
	private BigInteger d;
	
	public ChavePrivada(BigInteger d, BigInteger n){
		this.d = d;
		super.n = n;
	}
	public BigInteger getChavePrivada() {
		return this.d;
	}
	public void setChavePrivada(BigInteger d) {
		this.d = d;
	}
}
