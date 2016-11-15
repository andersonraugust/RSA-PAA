package br.udesc.paa.chaves;

import br.udesc.paa.EuclidesEstendido;
import br.udesc.paa.MillerRabin;
import java.math.BigInteger;

public class Chaves {
        private ChavePublica chavePublica;
	private ChavePrivada chavePrivada;
	
	public ChavePublica getChavePublica() {
		return this.chavePublica;
	}
	public void setChavePublica(ChavePublica chavePublica) {
		this.chavePublica = chavePublica;
	}
	public ChavePrivada getChavePrivada() {
		return this.chavePrivada;
	}
	public void setChavePrivada(ChavePrivada chavePrivada) {
		this.chavePrivada = chavePrivada;
	}
	
	public static Chaves gerar(Integer lengthBitKey){
		Chaves chave = new Chaves();
		BigInteger p = MillerRabin.getPrimo(lengthBitKey/2);
                BigInteger q;
                do {
                    q = MillerRabin.getPrimo(lengthBitKey/2);
                } while (p.equals(q));
		
		BigInteger n = p.multiply(q);
		q = q.subtract(BigInteger.ONE);
		p = p.subtract(BigInteger.ONE);
		
		BigInteger e = MillerRabin.getPrimo(15);
		BigInteger d = EuclidesEstendido.inversoModular(e, q.multiply(p));
		
		ChavePublica chavePublica = new ChavePublica(e,n);
		ChavePrivada chavePrivada = new ChavePrivada(d,n);
		chave.setChavePrivada(chavePrivada);
		chave.setChavePublica(chavePublica);
		return chave;
	}

}
