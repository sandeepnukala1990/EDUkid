package bu.edu.cs673.edukid.db.model;



public class Letters {
	private long letterid;

	private String letter;

	private String lettersound;

	public long getLetterid() {
		return letterid;
	}

	public void setLetterid(long letterid) {
		this.letterid = letterid;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public String getLettersound() {
		return lettersound;
	}

	public void setLettersound(String lettersound) {
		this.lettersound = lettersound;
	}

}
