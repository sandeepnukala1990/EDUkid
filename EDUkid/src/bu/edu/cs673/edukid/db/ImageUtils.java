package bu.edu.cs673.edukid.db;

import java.io.ByteArrayOutputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class ImageUtils {

	public static byte[] drawableToByteArray(Drawable d) {
		if (d != null) {
			Bitmap imageBitmap = ((BitmapDrawable) d).getBitmap();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
			byte[] byteData = baos.toByteArray();

			return byteData;
		} else
			return null;

	}

	public static Drawable byteArrayToDrawable(byte[] data) {
		if (data == null) {
			return null;
		} else {
			return new BitmapDrawable(null, BitmapFactory.decodeByteArray(data,
					0, data.length));
		}
	}
}
