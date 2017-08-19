package br.com.raminelli.busca.vogal;

import org.junit.Assert;
import org.junit.Test;

import br.com.raminelli.busca.vogal.exception.VogalNotFoundException;

public class BuscaPrimeiraVogalTest {
	
	@Test(expected = VogalNotFoundException.class)
	public void teste_nao_existe_vogal(){
		Stream stream = new StringStream("XvbBFBdcRfm");
		BuscaPrimeiraVogal.firstChar(stream);		
	}
	
	@Test(expected = VogalNotFoundException.class)
	public void teste_vogal_repetida() {
		Stream stream = new StringStream("aAbBeBacafe");
		BuscaPrimeiraVogal.firstChar(stream);
	}
	
	@Test(expected = VogalNotFoundException.class)
	public void teste_apenas_vogal() {
		Stream stream = new StringStream("aAEIAOoiaue");
		BuscaPrimeiraVogal.firstChar(stream);		
	}
	
	@Test
	public void teste_vogal_ultima_posicao() {
		Stream stream = new StringStream("aAbBABacafe");
		char charResult = BuscaPrimeiraVogal.firstChar(stream);
		Assert.assertEquals('e', charResult);
	}
	
	@Test
	public void teste_vogal_terceira_posicao() {
		Stream stream = new StringStream("aXiBABacafe");
		char charResult = BuscaPrimeiraVogal.firstChar(stream);
		Assert.assertEquals('i', charResult);
	}

}