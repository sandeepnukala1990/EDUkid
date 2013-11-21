package bu.edu.cs673.edukid.db;

import android.database.Cursor;
import bu.edu.cs673.edukid.db.model.Color;
import bu.edu.cs673.edukid.db.model.Letter;
import bu.edu.cs673.edukid.db.model.Num;
import bu.edu.cs673.edukid.db.model.NumType;
import bu.edu.cs673.edukid.db.model.Number;
import bu.edu.cs673.edukid.db.model.Shape;
import bu.edu.cs673.edukid.db.model.UserAccount;
import bu.edu.cs673.edukid.db.model.Word;

;

/**
 * Database utility class. Provides static helper methods to convert database
 * {@link Cursor} instances to the respective POJO which represents the
 * underlying database instance.
 * 
 * @author Kevin Graue
 * 
 * @see UserAccount
 * @see Letter
 * @see Word
 * @see Num
 * @see Number
 * @see Color
 * @see Shape
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
	 * Converts a cursor object to a Word object.
	 * 
	 * @param cursor
	 *            the database cursor object.
	 * @return a Word object.
	 */
	public static Word convertCursorToWord(Cursor cursor) {
		Word word = new Word();
		word.setLetterId(cursor.getLong(0));
		word.setThemeId(cursor.getLong(1));
		word.setWord(cursor.getString(2));
		word.setWordSound(cursor.getString(3));
		word.setWordImage(cursor.getBlob(4));
		word.setDefaultWord(false);

		return word;
	}

	/**
	 * Converts a cursor object to a Num object.
	 * 
	 * @param cursor
	 *            the database cursor object.
	 * @return a Num object.
	 */
	public static Num convertCursorToNum(Cursor cursor) {
		Num num = new Num();
		num.setNumberId(cursor.getLong(0));
		num.setNumber(cursor.getString(1));
		num.setNumberSound(cursor.getString(2));

		return num;

	}

	/**
	 * Converts a cursor object to a NumType object.
	 * 
	 * @param cursor
	 *            the database cursor object.
	 * @return a NumType object.
	 */
	public static NumType convertCursorToNumType(Cursor cursor) {
		NumType numtype = new NumType();
		numtype.setNumtypeId(cursor.getLong(0));
		numtype.setNumtype(cursor.getString(1));

		return numtype;
	}

	/**
	 * Converts a cursor object to an Number object.
	 * 
	 * @param cursor
	 *            the database cursor object.
	 * @return a Number object.
	 */
	public static Number convertCursorToNumber(Cursor cursor) {
		Number number = new Number();
		number.setnId(cursor.getLong(0));
		number.setnTypeId(cursor.getLong(1));
		number.setNumWord(cursor.getString(2));
		number.setNumSound(cursor.getString(3));
		number.setNumImage(cursor.getBlob(4));

		return number;
	}

	/**
	 * Converts a cursor object to a Color object.
	 * 
	 * @param cursor
	 *            the database cursor object.
	 * @return a Color object.
	 */
	public static Color convertCursorToColor(Cursor cursor) {
		Color color = new Color();
		color.setColourId(cursor.getLong(0));
		color.setColour(cursor.getString(1));
		color.setColourImage(cursor.getBlob(2));
		color.setColourSound(cursor.getString(3));

		return color;
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
