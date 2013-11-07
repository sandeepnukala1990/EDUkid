package bu.edu.cs673.edukid.db;

import java.io.ByteArrayOutputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * This static class provides image utility helper methods.
 * 
 * @author Kevin Graue
 * 
 */
public class ImageUtils {

	/**
	 * Constructor.
	 */
	private ImageUtils() {
		// Static class.
	}

	/**
	 * Converts a {@link Drawable} into a byte array.
	 * 
	 * @param drawable
	 *            the drawable to convert.
	 * @return a byte array.
	 */
	public static byte[] drawableToByteArray(Drawable drawable) {
		if (drawable != null) {
			Bitmap imageBitmap = ((BitmapDrawable) drawable).getBitmap();
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			imageBitmap.compress(Bitmap.CompressFormat.PNG, 100,
					byteArrayOutputStream);
			byte[] byteData = byteArrayOutputStream.toByteArray();

			return byteData;
		}

		return null;
	}

	/**
	 * Converts a byte array into a {@link Drawable}.
	 * 
	 * @param data
	 *            the byte array data.
	 * @return a drawable.
	 */
	public static Drawable byteArrayToDrawable(byte[] data) {
		if (data == null) {
			return null;
		}

		return new BitmapDrawable(null, BitmapFactory.decodeByteArray(data, 0,
				data.length));
	}
}
