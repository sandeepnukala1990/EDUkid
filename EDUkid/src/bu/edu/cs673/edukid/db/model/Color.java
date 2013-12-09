package bu.edu.cs673.edukid.db.model;

import android.graphics.drawable.Drawable;
import bu.edu.cs673.edukid.db.ImageUtils;

public class Color {

	private long colourId;

	private String colour;

	private Drawable colourImage;

	private String colourSound;

	public long getColourId() {
		return colourId;
	}

	public void setColourId(long colourId) {
		this.colourId = colourId;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getColourSound() {
		return colourSound;
	}

	public void setColourSound(String colourSound) {
		this.colourSound = colourSound;
	}

	public byte[] getColourImage() {
		return ImageUtils.drawableToByteArray(colourImage);
	}

	public void setColourImage(byte[] imageData) {
		this.colourImage = ImageUtils.byteArrayToDrawable(imageData);
	}
}
