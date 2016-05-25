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
public class ChavePublica extends Chave {
	private BigInteger e;

	public ChavePublica(BigInteger e, BigInteger n){
		this.e = e;
		super.n = n;
	}
	public BigInteger getChavePublica(){
		return this.e;
	}
	public void setChavePublica(BigInteger e){
		this.e = e;
	}
}
