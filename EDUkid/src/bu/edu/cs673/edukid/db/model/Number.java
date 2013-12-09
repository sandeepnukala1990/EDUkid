package bu.edu.cs673.edukid.db.model;

import android.graphics.drawable.Drawable;
import bu.edu.cs673.edukid.db.ImageUtils;

public class Number {

	private long nId;

	private long nTypeId;

	private String numWord;

	private String numSound;

	private Drawable numImage;

	public long getnId() {
		return nId;
	}

	public void setnId(long nId) {
		this.nId = nId;
	}

	public long getnTypeId() {
		return nTypeId;
	}

	public void setnTypeId(long nTypeId) {
		this.nTypeId = nTypeId;
	}

	public String getNumWord() {
		return numWord;
	}

	public void setNumWord(String numWord) {
		this.numWord = numWord;
	}

	public String getNumSound() {
		return numSound;
	}

	public void setNumSound(String numSound) {
		this.numSound = numSound;
	}

	public byte[] getNumImage() {
		return ImageUtils.drawableToByteArray(numImage);
	}

	public void setNumImage(byte[] imageData) {
		this.numImage = ImageUtils.byteArrayToDrawable(imageData);
	}
}
