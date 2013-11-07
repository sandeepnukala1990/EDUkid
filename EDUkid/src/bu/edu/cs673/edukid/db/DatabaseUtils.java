package bu.edu.cs673.edukid.db;

import android.database.Cursor;
import bu.edu.cs673.edukid.db.model.Alphabets;
import bu.edu.cs673.edukid.db.model.Category;
import bu.edu.cs673.edukid.db.model.Letters;
import bu.edu.cs673.edukid.db.model.Themes;
import bu.edu.cs673.edukid.db.model.UserAccount;

/**
 * Database utility class. Provides static helper methods to convert database
 * {@link Cursor} instances to the respective POJO which represents the
 * underlying database instance.
 * 
 * @author kgraue
 * 
 * @see Category
 * @see UserAccount
 * 
 */
public class DatabaseUtils {

	/**
	 * Constructor.
	 */
	private DatabaseUtils() {
		// Static class.
	}

	/**
	 * Converts a cursor object to a category object.
	 * 
	 * @param cursor
	 *            the database cursor object.
	 * @return a category object.
	 */
	public static Category convertCursorToCategory(Cursor cursor) {
		Category category = new Category();
		category.setId(cursor.getLong(0));
		category.setName(cursor.getString(1));
		category.setImageData(cursor.getBlob(2));

		return category;
	}

	/**
	 * Converts a cursor object to user account object.
	 * 
	 * @param cursor
	 *            the database cursor object.
	 * @return a user account object.
	 */
	public static UserAccount convertCursorToUserAccount(Cursor cursor) {
		UserAccount userAccount = new UserAccount();
		userAccount.setId(cursor.getLong(0));
		userAccount.setUserName(cursor.getString(1));
		userAccount.setUserImage(cursor.getBlob(2));
		userAccount.setUserSound(cursor.getString(3));

		return userAccount;
	}

	public static Letters convertCursorToLetters(Cursor cursor) {
		Letters letter = new Letters();
		letter.setLetterid(cursor.getLong(0));
		letter.setLetter(cursor.getString(1));
		letter.setLettersound(cursor.getString(2));
		return letter;

	}

	public static Themes convertCursorToThemes(Cursor cursor) {
		Themes theme = new Themes();
		theme.setThemeid(cursor.getLong(0));
		theme.setTheme(cursor.getString(1));
		return theme;
	}

	public static Alphabets convertCursorToAlphabets(Cursor cursor) {
		Alphabets alpha = new Alphabets();
		alpha.setLid(cursor.getLong(0));
		alpha.setTid(cursor.getLong(1));
		alpha.setWords(cursor.getString(2));
		alpha.setWordsound(cursor.getString(3));
		alpha.setWordimg(cursor.getBlob(4));

		return alpha;
	}
}
