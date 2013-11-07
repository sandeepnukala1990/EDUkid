package bu.edu.cs673.edukid.db.model;

public class Letter {

	private long letterId;

	private String letter;

	private String letterSound;

	public long getLetterId() {
		return letterId;
	}

	public void setLetterId(long letterId) {
		this.letterId = letterId;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public String getLetterSound() {
		return letterSound;
	}

	public void setLetterSound(String letterSound) {
		this.letterSound = letterSound;
	}
}
