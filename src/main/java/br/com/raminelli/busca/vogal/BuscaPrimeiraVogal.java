package br.com.raminelli.busca.vogal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.com.raminelli.busca.vogal.exception.VogalNotFoundException;

public class BuscaPrimeiraVogal {
	
	private static final String VOGAL = "a|e|i|o|u|A|E|I|O|U"; 
	
	public static char firstChar(final Stream input) {
		
		final Map<Character, Integer> charMapVogal = new LinkedHashMap<Character, Integer>();
		final List<Character> listVogalValida = new ArrayList<Character>();
		
		Character charAnterior2 = null;
		Character charAnterior1 = null;
		
		while (input.hasNext()) {
			Character character = input.getNext();
			
			//armazena apenas as vogal para verificar a quantidade no final
			if(character.toString().matches(VOGAL)) {
				if (charMapVogal.containsKey(character)) {
					int count = charMapVogal.get(character);
					charMapVogal.put(character, ++count);
				} else {
					charMapVogal.put(character, 1);
				}
			}
						
			//se a vogal for valida, armazenada para verificar quantidade
			if(isVogalValida(charAnterior2, charAnterior1, character)) {
				listVogalValida.add(character);
			}
			
			//armazena char anteriores para comparar com a vogal valida 
			if (charAnterior1 != null) {
				charAnterior2 = charAnterior1;
			}
			charAnterior1 = character;
				
		}
		
		//retorna a vogal que nao se repete
		return listVogalValida.stream()
				.filter(f -> charMapVogal.get(f) == 1)
				.findFirst()
				.orElseThrow(VogalNotFoundException::new);
		
	}

	/* 
	 * Regra: character de ser vogal, charAnterior1 deve ser uma consoante, charAnterior2 deve ser uma vogal  
	 */
	private static boolean isVogalValida(Character charAnterior2, Character charAnterior1, Character character) {
		
		if(charAnterior2 == null || charAnterior1 == null || character == null) {
			return false;
		}
		
		return charAnterior2.toString().matches(VOGAL) &&
				!charAnterior1.toString().matches(VOGAL) &&
				character.toString().matches(VOGAL);
		
	}
	
}
