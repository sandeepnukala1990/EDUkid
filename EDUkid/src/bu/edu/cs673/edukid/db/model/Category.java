package bu.edu.cs673.edukid.db.model;

import android.graphics.drawable.Drawable;
import bu.edu.cs673.edukid.db.ImageUtils;

public class Category {

	private long id;

	private String name;

	private Drawable image;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getImageData() {
		return ImageUtils.drawableToByteArray(image);
	}

	public void setImageData(byte[] imageData) {
		image = ImageUtils.byteArrayToDrawable(imageData);
	}
}
