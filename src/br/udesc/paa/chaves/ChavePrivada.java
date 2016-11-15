package br.udesc.paa.chaves;

import java.math.BigInteger;

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
