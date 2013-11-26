package bu.edu.cs673.edukid.db.model;

import android.graphics.drawable.Drawable;
import bu.edu.cs673.edukid.db.ImageUtils;

public class Word {

	private long letterId;

	private long wordId;

	private String word;

	private String wordSound;

	private int drawableId;

	private Drawable wordImage;

	private boolean defaultWord;

	private boolean checked;

	public Word() {

	}

	public Word(String word, int drawableId) {
		this.word = word;
		this.drawableId = drawableId;
		defaultWord = true;
		checked = true;
	}

	public long getLid() {
		return letterId;
	}

	public void setLetterId(long letterId) {
		this.letterId = letterId;
	}

	public long getWordId() {
		return wordId;
	}

	public void setWordId(long wordId) {
		this.wordId = wordId;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getWordSound() {
		return wordSound;
	}

	public void setWordSound(String wordSound) {
		this.wordSound = wordSound;
	}

	public byte[] getWordImage() {
		return ImageUtils.drawableToByteArray(wordImage);
	}

	public int getDrawableId() {
		return drawableId;
	}

	public void setDrawableId(int drawableId) {
		this.drawableId = drawableId;
	}

	public Drawable getWordDrawable() {
		return wordImage;
	}

	public void setWordImage(byte[] imageData) {
		wordImage = ImageUtils.byteArrayToDrawable(imageData);
	}

	public void setDefaultWord(boolean defaultWord) {
		this.defaultWord = defaultWord;
	}

	public boolean isDefaultWord() {
		return defaultWord;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isChecked() {
		return checked;
	}
}
