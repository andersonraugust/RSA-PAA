package br.udesc.paa.chaves;

import java.math.BigInteger;

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
