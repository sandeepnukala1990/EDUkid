package bu.edu.cs673.edukid.db.model;

import android.graphics.drawable.Drawable;
import bu.edu.cs673.edukid.db.ImageUtils;

public class Alphabets {
	private long lid;
	
	private long tid;

	private String words;
	
	private String wordsound;
	
	private Drawable wordimg;

	public long getLid() {
		return lid;
	}

	public void setLid(long lid) {
		this.lid = lid;
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public String getWordsound() {
		return wordsound;
	}

	public void setWordsound(String wordsound) {
		this.wordsound = wordsound;
	}

	public byte[] getWordimg() {
		return ImageUtils.drawableToByteArray(wordimg);
	}

	public void setWordimg(byte[] imageData) {
		this.wordimg = ImageUtils.byteArrayToDrawable(imageData);;
	}
}
