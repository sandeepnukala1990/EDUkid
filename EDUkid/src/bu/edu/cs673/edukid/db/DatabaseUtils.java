package bu.edu.cs673.edukid.db;

import android.database.Cursor;
import bu.edu.cs673.edukid.db.model.Alphabets;
import bu.edu.cs673.edukid.db.model.Category;
import bu.edu.cs673.edukid.db.model.Letter;
import bu.edu.cs673.edukid.db.model.Theme;
import bu.edu.cs673.edukid.db.model.UserAccount;
import bu.edu.cs673.edukid.db.model.Num;
import bu.edu.cs673.edukid.db.model.NumType;
import bu.edu.cs673.edukid.db.model.Number;
import bu.edu.cs673.edukid.db.model.Colour;
import bu.edu.cs673.edukid.db.model.Shape;;

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
		category.setCategoryName(cursor.getString(1));
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
	
	/**
	 * Converts a cursor object to a number object.
	 * 
	 * @param cursor
	 *            the database cursor object.
	 * @return a number object.
	 */
	public static Num convertCursorToNumber(Cursor cursor) {
		Num number = new Num();
		number.setNumberId(cursor.getLong(0));
		number.setNumber(cursor.getString(1));
		number.setNumberSound(cursor.getString(2));

		return number;

	}

	/**
	 * Converts a cursor object to a NumType object.
	 * 
	 * @param cursor
	 *            the database cursor object.
	 * @return a ntype object.
	 */
	public static NumType convertCursorToNumType(Cursor cursor) {
		NumType ntype = new NumType();
		ntype.setNumtypeId(cursor.getLong(0));
		ntype.setNumtype(cursor.getString(1));

		return ntype;
	}

	/**
	 * Converts a cursor object to an Numbers object.
	 * 
	 * @param cursor
	 *            the database cursor object.
	 * @return an num object.
	 */
	public static Number convertCursorToNumbers(Cursor cursor) {
		Number num = new Number();
		num.setnId(cursor.getLong(0));
		num.setnTypeId(cursor.getLong(1));
		num.setNumWord(cursor.getString(2));
		num.setNumSound(cursor.getString(3));
		num.setNumImage(cursor.getBlob(4));

		return num;
	}
	
	/**
	 * Converts a cursor object to a Colour object.
	 * 
	 * @param cursor
	 *            the database cursor object.
	 * @return a Colour object.
	 */
	public static Colour convertCursorToColour(Cursor cursor) {
		Colour col = new Colour();
		col.setColourId(cursor.getLong(0));
		col.setColour(cursor.getString(1));
		col.setColourImage(cursor.getBlob(2));
		col.setColourSound(cursor.getString(3));

		return col;
	}
	
	/**
	 * Converts a cursor object to a user shape object.
	 * 
	 * @param cursor
	 *            the database shape object.
	 * @return a shape object.
	 */
	public static Shape convertCursorToShape(Cursor cursor) {
		Shape shape = new Shape();
		shape.setShapeId(cursor.getLong(0));
		shape.setShape(cursor.getString(1));
		shape.setShapeImage(cursor.getBlob(2));
		shape.setShapeSound(cursor.getString(3));

		return shape;
	}
	
}
