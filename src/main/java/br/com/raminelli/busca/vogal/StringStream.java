package br.com.raminelli.busca.vogal;

public class StringStream implements Stream {

	private String text;
	private int index;
	private int length;
	//private int vogalIndex;
	
	public StringStream(String text) {
		this.text = text;
		this.length = text.length();		
	}
	
	public char getNext() {
		return this.text.charAt(this.index++);
	}

	public boolean hasNext() {
		return this.length > index;
		//return this.index <= this.text.length() && this.vogalIndex == -1 || this.index <= this.vogalIndex;
	}
	
	//private Predicate<? super String> filtraVogalUnica(List<String> chars) {
	//	return s -> s.matches(VOGAL_MATCHER) && chars.stream().filter(v -> v.equals(s)).count() == 1;
	//}

}
