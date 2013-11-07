package bu.edu.cs673.edukid.db;

import android.database.Cursor;
import bu.edu.cs673.edukid.db.model.Alphabets;
import bu.edu.cs673.edukid.db.model.Category;
import bu.edu.cs673.edukid.db.model.Letter;
import bu.edu.cs673.edukid.db.model.Theme;
import bu.edu.cs673.edukid.db.model.UserAccount;

/**
 * Database utility class. Provides static helper methods to convert database
 * {@link Cursor} instances to the respective POJO which represents the
 * underlying database instance.
 * 
 * @author Kevin Graue
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
	 * Converts a cursor object to a user account object.
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

	/**
	 * Converts a cursor object to a letter object.
	 * 
	 * @param cursor
	 *            the database cursor object.
	 * @return a letter object.
	 */
	public static Letter convertCursorToLetter(Cursor cursor) {
		Letter letter = new Letter();
		letter.setLetterId(cursor.getLong(0));
		letter.setLetter(cursor.getString(1));
		letter.setLetterSound(cursor.getString(2));

		return letter;

	}

	/**
	 * Converts a cursor object to a theme object.
	 * 
	 * @param cursor
	 *            the database cursor object.
	 * @return a theme object.
	 */
	public static Theme convertCursorToTheme(Cursor cursor) {
		Theme theme = new Theme();
		theme.setThemeId(cursor.getLong(0));
		theme.setTheme(cursor.getString(1));

		return theme;
	}

	/**
	 * Converts a cursor object to an alphabets object.
	 * 
	 * @param cursor
	 *            the database cursor object.
	 * @return an alphabets object.
	 */
	public static Alphabets convertCursorToAlphabets(Cursor cursor) {
		Alphabets alphabets = new Alphabets();
		alphabets.setLetterId(cursor.getLong(0));
		alphabets.setThemeId(cursor.getLong(1));
		alphabets.setWord(cursor.getString(2));
		alphabets.setWordSound(cursor.getString(3));
		alphabets.setWordImage(cursor.getBlob(4));

		return alphabets;
	}
}
