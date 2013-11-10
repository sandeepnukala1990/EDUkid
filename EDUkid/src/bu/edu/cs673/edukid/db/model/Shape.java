package bu.edu.cs673.edukid.db.model;

import android.graphics.drawable.Drawable;
import bu.edu.cs673.edukid.db.ImageUtils;


public class Shape {

	private long shapeId;

	private String shape;

	private String shapeSound;
	
	private Drawable shapeImage;

	

	public long getShapeId() {
		return shapeId;
	}

	public void setShapeId(long shapeId) {
		this.shapeId = shapeId;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getShapeSound() {
		return shapeSound;
	}

	public void setShapeSound(String shapeSound) {
		this.shapeSound = shapeSound;
	}
	
	public byte[] getShapeImage() {
		return ImageUtils.drawableToByteArray(shapeImage);
	}

	public void setShapeImage(byte[] imageData) {
		this.shapeImage = ImageUtils.byteArrayToDrawable(imageData);
	}
}
