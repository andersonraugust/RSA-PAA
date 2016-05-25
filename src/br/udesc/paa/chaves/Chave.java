package br.udesc.paa.chaves;
import java.math.BigInteger;

/**
 *
 * @author AndersonR
 */
public class Chave {
	protected BigInteger n;

	public BigInteger getChave() {
		return this.n;
	}
	public void setChave(BigInteger n) {
		this.n = n;
	}
}