package br.com.raminelli.busca.vogal.exception;

@SuppressWarnings("serial")
public class VogalNotFoundException extends RuntimeException {
	
	public VogalNotFoundException(){
		super("Vogal não localizada no texto informado!");
	}
	
}
