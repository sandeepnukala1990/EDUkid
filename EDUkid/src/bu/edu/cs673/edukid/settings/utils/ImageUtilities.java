package bu.edu.cs673.edukid.settings.utils;

import android.content.Intent;
import android.app.*;

public class ImageUtilities {
	private static final int TAKE_PICTURE = 1888;
	
	private static final int SELECT_PHOTO = 100;
	
	public static void startCamera(Activity activity) {
		Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
		activity.startActivityForResult(intent, TAKE_PICTURE);
	}
	public static void selectPhoto(Activity activity){
		Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
		photoPickerIntent.setType("image/*");
		activity.startActivityForResult(photoPickerIntent, SELECT_PHOTO);    
	}
}
