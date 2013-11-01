package bu.edu.cs673.edukid.db.model;

public class Thing {

	private String word;

	private int drawableId;

	public Thing(String word, int drawableId) {
		this.word = word;
		this.drawableId = drawableId;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getDrawableId() {
		return drawableId;
	}

	public void setDrawableId(int drawableId) {
		this.drawableId = drawableId;
	}
}
