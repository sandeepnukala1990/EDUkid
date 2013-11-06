package bu.edu.cs673.edukid.db.model;

import bu.edu.cs673.edukid.db.ImageUtils;
import android.graphics.drawable.Drawable;

public class UserAccount {

	private long id;

	private String userName;

	private Drawable userImage;

	// TODO: sound file?
	private String userSound;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
		
	}

	public byte[] getUserImage() {
		return ImageUtils.drawableToByteArray(userImage);
	}

	public void setUserImage(byte[] imageData) {
		userImage = ImageUtils.byteArrayToDrawable(imageData);
	}

	public String getUserSound() {
		return userSound;
	}

	public void setUserSound(String userSound) {
		this.userSound = userSound;
	}
}
