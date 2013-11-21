package bu.edu.cs673.edukid.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import bu.edu.cs673.edukid.db.defaults.DatabaseDefaults;
import bu.edu.cs673.edukid.db.model.Color;
import bu.edu.cs673.edukid.db.model.Letter;
import bu.edu.cs673.edukid.db.model.Num;
import bu.edu.cs673.edukid.db.model.NumType;
import bu.edu.cs673.edukid.db.model.Number;
import bu.edu.cs673.edukid.db.model.Shape;
import bu.edu.cs673.edukid.db.model.UserAccount;
import bu.edu.cs673.edukid.db.model.Word;
import bu.edu.cs673.edukid.db.model.category.CategoryType;

/**
 * The main database class which provides "access" to the database via accessor
 * and mutator methods. This class is a singleton.
 * 
 * @author Kevin Graue
 * 
 * @see DatabaseHelper
 * 
 */
public class Database {

	private static Database DATABASE_INSTANCE = null;

	private SQLiteDatabase sqlDatabase;

	private DatabaseHelper databaseHelper;

	private String[] categoriesColumns = { DatabaseHelper.COLUMN_CATEGORY_ID,
			DatabaseHelper.COLUMN_CATEGORY_NAME,
			DatabaseHelper.COLUMN_CATEGORY_IMAGE };

	private String[] userAccountColumns = { DatabaseHelper.COLUMN_USER_ID,
			DatabaseHelper.COLUMN_USER_NAME, DatabaseHelper.COLUMN_USER_IMAGE,
			DatabaseHelper.COLUMN_USER_SOUND };

	private String[] lettersColumns = { DatabaseHelper.COLUMN_LETTERS_ID,
			DatabaseHelper.COLUMN_LETTERS_WORD,
			DatabaseHelper.COLUMN_LETTERS_SOUND };

	private String[] wordColumns = { DatabaseHelper.COLUMN_LID,
			DatabaseHelper.COLUMN_TID, DatabaseHelper.COLUMN_WORDS,
			DatabaseHelper.COLUMN_WORDS_SOUND,
			DatabaseHelper.COLUMN_WORDS_IMAGE };

	private String[] numColumns = { DatabaseHelper.COLUMN_NUMBER_ID,
			DatabaseHelper.COLUMN_NUMBER_WORD,
			DatabaseHelper.COLUMN_NUMBER_SOUND };

	private String[] numTypeColumns = { DatabaseHelper.COLUMN_TYPE_ID,
			DatabaseHelper.COLUMN_TYPE_NAME };

	private String[] nmberColumns = { DatabaseHelper.COLUMN_NID,
			DatabaseHelper.COLUMN_NTID, DatabaseHelper.COLUMN_NUMBERS,
			DatabaseHelper.COLUMN_NUMBERS_SOUND,
			DatabaseHelper.COLUMN_NUMBERS_IMAGE };

	private String[] colourColumns = { DatabaseHelper.COLUMN_COLOUR_ID,
			DatabaseHelper.COLUMN_COLOUR_WORD,
			DatabaseHelper.COLUMN_COLOUR_IMAGE,
			DatabaseHelper.COLUMN_COLOUR_SOUND };

	private String[] shapeColumns = { DatabaseHelper.COLUMN_SHAPE_ID,
			DatabaseHelper.COLUMN_SHAPE_WORD,
			DatabaseHelper.COLUMN_SHAPE_IMAGE,
			DatabaseHelper.COLUMN_SHAPE_SOUND };

	/**
	 * Gets the database singleton instance.
	 * 
	 * Note: only call this method when you know the database has already been
	 * instantiated and the application context is not available.
	 * 
	 * @return the database singleton instance.
	 * @throws NullPointerException
	 */
	public static Database getInstance() throws NullPointerException {
		if (DATABASE_INSTANCE == null) {
			throw new NullPointerException(
					"Cannot access database without instantiation!");
		}

		return DATABASE_INSTANCE;
	}

	/**
	 * Gets the database singleton instance.
	 * 
	 * Note: this is the preferred way to access the singleton instance but you
	 * need a {@link Context} to use it.
	 * 
	 * @param context
	 *            the application context.
	 * @return the database singleton instance.
	 */
	public static Database getInstance(Context context) {
		if (DATABASE_INSTANCE == null) {
			DATABASE_INSTANCE = new Database(context);
		}

		return DATABASE_INSTANCE;
	}

	/**
	 * Singleton class. Prevents instantiation from others.
	 * 
	 * @param context
	 *            the context.
	 */
	private Database(Context context) {
		databaseHelper = new DatabaseHelper(context);
		sqlDatabase = databaseHelper.getWritableDatabase();
	}

	/**
	 * Gets a list of all the categories (the 4 main categories plus any
	 * additional categories added by the user).
	 * 
	 * @return a list of all categories.
	 */
	public List<CategoryType> getCategories() {
		List<CategoryType> categories = new ArrayList<CategoryType>();

		// Add the default categories (these aren't in the database)
		for (CategoryType defaultCategory : DatabaseDefaults
				.getDefaultCategories()) {
			categories.add(defaultCategory);
		}

		Cursor cursor = sqlDatabase.query(DatabaseHelper.TABLE_CATEGORIES,
				categoriesColumns, null, null, null, null, null);
		cursor.moveToFirst();

		// Add the user-entered categories from the database
		while (!cursor.isAfterLast()) {
			categories.add(DatabaseUtils.convertCursorToCategory(cursor));
			cursor.moveToNext();
		}

		cursor.close();

		return categories;
	}

	/**
	 * Adds a category to the database.
	 * 
	 * @param categoryType
	 *            the category type
	 * @param context
	 *            the context.
	 */
	public void addCategory(CategoryType categoryType, Context context) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(DatabaseHelper.COLUMN_CATEGORY_NAME,
				categoryType.getCategoryName());
		contentValues.put(DatabaseHelper.COLUMN_CATEGORY_IMAGE, ImageUtils
				.drawableToByteArray(categoryType.getCategoryImage(context)));
		sqlDatabase
				.insert(DatabaseHelper.TABLE_CATEGORIES, null, contentValues);
	}

	/**
	 * Gets a list of the letters in the database.
	 * 
	 * @return a list of the letters in the database.
	 */
	public List<Letter> getLetters() {
		List<Letter> letters = new ArrayList<Letter>();

		Cursor cursor = sqlDatabase.query(DatabaseHelper.TABLE_LETTERS,
				lettersColumns, null, null, null, null, null);
		cursor.moveToFirst();

		while (!cursor.isAfterLast()) {
			letters.add(DatabaseUtils.convertCursorToLetter(cursor));
			cursor.moveToNext();
		}

		cursor.close();

		return letters;
	}

	/**
	 * Adds a letter to the database.
	 * 
	 * @param letter
	 *            the letter to add.
	 */
	public void addLetter(String letter) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(DatabaseHelper.COLUMN_LETTERS_WORD, letter);

		// By default, do not add a sound. If the user chooses to add a sound
		// letter then it will be taken care of with the editLetter() method.
		contentValues.put(DatabaseHelper.COLUMN_LETTERS_SOUND, "");
		sqlDatabase.insert(DatabaseHelper.TABLE_LETTERS, null, contentValues);
	}

	/**
	 * Edits a letter in the database.
	 * 
	 * @param letter
	 *            the letter to edit.
	 */
	public void editLetter(int letterIndex, Letter letter) {
		// TODO: implement this
	}

	/**
	 * Gets a list of the alphabets in the database.
	 * 
	 * @return a list of the alphabets in the database.
	 */
	public List<Word> getWords() {
		List<Word> alpha = new ArrayList<Word>();

		Cursor cursor = sqlDatabase.query(DatabaseHelper.TABLE_WORDS,
				wordColumns, null, null, null, null, null);
		cursor.moveToFirst();

		while (!cursor.isAfterLast()) {
			alpha.add(DatabaseUtils.convertCursorToWord(cursor));
			cursor.moveToNext();
		}

		cursor.close();

		return alpha;
	}

	/**
	 * Adds an alphabets to the database.
	 * 
	 * @param letterId
	 *            the letter id.
	 * @param themeId
	 *            the the theme id.
	 * @param alphabetWord
	 *            the alphabet word.
	 * @param alphabetSound
	 *            the alphabet sound.
	 * @param alphabetImage
	 *            the alphabet image.
	 */
	public void addWord(int letterId, Word word) {
		int themeId = 0;

		for (int i = 0; i < getWords().size(); i++) {
			if (getWords().get(i).getLid() == letterId) {
				themeId++;
			}
		}

		ContentValues contentValues = new ContentValues();
		contentValues.put(DatabaseHelper.COLUMN_LID, letterId);
		contentValues.put(DatabaseHelper.COLUMN_TID, themeId);
		contentValues.put(DatabaseHelper.COLUMN_WORDS, word.getWord());
		contentValues.put(DatabaseHelper.COLUMN_WORDS_SOUND,
				word.getWordSound());
		contentValues.put(DatabaseHelper.COLUMN_WORDS_IMAGE,
				ImageUtils.drawableToByteArray(word.getWordDrawable()));

		sqlDatabase.insert(DatabaseHelper.TABLE_WORDS, null, contentValues);
	}

	/**
	 * Edits a word in the database.
	 * 
	 * @param itemIndex
	 *            the item index.
	 * @param wordIndex
	 *            the word index.
	 * @param word
	 *            the new word to replace with the existing one.
	 */
	public void editWord(int itemIndex, int wordIndex, Word word) {
		// TODO: Jasjot, implement this
	}

	/**
	 * Gets a list of the user accounts in the database.
	 * 
	 * @return a list of the user accounts in the database.
	 */
	public List<UserAccount> getUserAccounts() {
		List<UserAccount> userAccounts = new ArrayList<UserAccount>();
		Cursor cursor = sqlDatabase.query(DatabaseHelper.TABLE_USER_ACCOUNT,
				userAccountColumns, null, null, null, null, null);
		cursor.moveToFirst();

		while (!cursor.isAfterLast()) {
			UserAccount userAccount = DatabaseUtils
					.convertCursorToUserAccount(cursor);
			userAccounts.add(userAccount);
			cursor.moveToNext();
		}

		cursor.close();

		return userAccounts;
	}

	/**
	 * Adds a user account to the database.
	 * 
	 * @param userName
	 *            the user name.
	 * @param userSound
	 *            the user sound.
	 * @param userImage
	 *            the user image.
	 * @return the row ID of the newly inserted row, or -1 if an error occurred
	 */
	public long addUserAccount(String userName, String userSound,
			Drawable userImage) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(DatabaseHelper.COLUMN_USER_NAME, userName);
		contentValues.put(DatabaseHelper.COLUMN_USER_IMAGE,
				ImageUtils.drawableToByteArray(userImage));
		contentValues.put(DatabaseHelper.COLUMN_USER_SOUND, userSound);

		return sqlDatabase.insert(DatabaseHelper.TABLE_USER_ACCOUNT, null,
				contentValues);
	}

	/**
	 * Edits a user account in the already in the database.
	 * 
	 * @param userAccount
	 *            the user account.
	 * @return the row ID of the newly inserted row, or -1 if an error occurred
	 */
	public long editUserAccount(UserAccount userAccount) {
		sqlDatabase.delete(DatabaseHelper.TABLE_USER_ACCOUNT,
				DatabaseHelper.COLUMN_USER_ID + " = ?",
				new String[] { String.valueOf(userAccount.getId()) });
		return addUserAccount(userAccount.getUserName(),
				userAccount.getUserSound(),
				ImageUtils.byteArrayToDrawable(userAccount.getUserImage()));
	}

	public List<Num> getNums() {
		List<Num> num = new ArrayList<Num>();

		Cursor cursor = sqlDatabase.query(DatabaseHelper.TABLE_NUMBER,
				numColumns, null, null, null, null, null);
		cursor.moveToFirst();

		while (!cursor.isAfterLast()) {
			num.add(DatabaseUtils.convertCursorToNum(cursor));
			cursor.moveToNext();
		}

		cursor.close();

		return num;
	}

	/**
	 * Adds a numbers to the database.
	 * 
	 * @param num
	 *            the number to add.
	 */
	public void addNums(String num) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(DatabaseHelper.COLUMN_NUMBER_WORD, num);
		contentValues.put(DatabaseHelper.COLUMN_NUMBER_SOUND, num);
		sqlDatabase.insert(DatabaseHelper.TABLE_NUMBER, null, contentValues);
	}

	/**
	 * Gets a list of the numbers and images in the database.
	 * 
	 * @return a list of the numbers and images in the database.
	 */
	public List<Number> getNumbers() {
		List<Number> number = new ArrayList<Number>();

		Cursor cursor = sqlDatabase.query(DatabaseHelper.TABLE_NUMBERS,
				nmberColumns, null, null, null, null, null);
		cursor.moveToFirst();

		while (!cursor.isAfterLast()) {
			number.add(DatabaseUtils.convertCursorToNumber(cursor));
			cursor.moveToNext();
		}

		cursor.close();

		return number;
	}

	/**
	 * Adds an numbers and images to the database.
	 * 
	 * @param nId
	 *            the num id.
	 * @param ntId
	 *            the number type id.
	 * @param numWord
	 *            the number word.
	 * @param numSound
	 *            the number sound.
	 * @param numImage
	 *            the number image.
	 */
	public void addNumbers(int nId, int ntId, String numberWord,
			String numberSound, Drawable numberImage) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(DatabaseHelper.COLUMN_NID, nId);
		contentValues.put(DatabaseHelper.COLUMN_NTID, ntId);
		contentValues.put(DatabaseHelper.COLUMN_NUMBERS, numberWord);
		contentValues.put(DatabaseHelper.COLUMN_NUMBERS_SOUND, numberSound);
		contentValues.put(DatabaseHelper.COLUMN_NUMBERS_IMAGE,
				ImageUtils.drawableToByteArray(numberImage));

		sqlDatabase.insert(DatabaseHelper.TABLE_NUMBERS, null, contentValues);
	}

	/**
	 * Gets a list of the NumTypes in the database.
	 * 
	 * @return a list of the NumTypes in the database.
	 */
	public List<NumType> getNumTypes() {
		List<NumType> ntype = new ArrayList<NumType>();

		Cursor cursor = sqlDatabase.query(DatabaseHelper.TABLE_NUM_TYPE,
				numTypeColumns, null, null, null, null, null);
		cursor.moveToFirst();

		while (!cursor.isAfterLast()) {
			ntype.add(DatabaseUtils.convertCursorToNumType(cursor));
			cursor.moveToNext();
		}

		cursor.close();

		return ntype;
	}

	/**
	 * Adds a NumTypes to the database.
	 * 
	 * @param type
	 *            the NumTypes to add.
	 */
	public void addNumType(String type) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(DatabaseHelper.COLUMN_TYPE_NAME, type);
		sqlDatabase.insert(DatabaseHelper.TABLE_NUM_TYPE, null, contentValues);
	}

	/**
	 * Gets a list of the colors in the database.
	 * 
	 * @return a list of the colors in the database.
	 */
	public List<Color> getColors() {
		List<Color> colours = new ArrayList<Color>();
		Cursor cursor = sqlDatabase.query(DatabaseHelper.TABLE_COLOUR,
				colourColumns, null, null, null, null, null);
		cursor.moveToFirst();

		while (!cursor.isAfterLast()) {
			colours.add(DatabaseUtils.convertCursorToColor(cursor));
			cursor.moveToNext();
		}

		cursor.close();

		return colours;
	}

	/**
	 * Adds a color to the database.
	 * 
	 * @param color
	 *            the color name.
	 * @param colorSound
	 *            the color sound.
	 * @param colorImage
	 *            the color image.
	 * @return the row ID of the newly inserted row, or -1 if an error occurred
	 */
	public long addColor(String color, String colorSound, Drawable colorImage) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(DatabaseHelper.COLUMN_COLOUR_WORD, color);
		contentValues.put(DatabaseHelper.COLUMN_COLOUR_IMAGE,
				ImageUtils.drawableToByteArray(colorImage));
		contentValues.put(DatabaseHelper.COLUMN_COLOUR_SOUND, colorSound);
		return sqlDatabase.insert(DatabaseHelper.TABLE_COLOUR, null,
				contentValues);
	}

	/**
	 * Gets a list of the shapes in the database.
	 * 
	 * @return a list of the shapes in the database.
	 */
	public List<Shape> getShapes() {
		List<Shape> shape = new ArrayList<Shape>();
		Cursor cursor = sqlDatabase.query(DatabaseHelper.TABLE_SHAPE,
				shapeColumns, null, null, null, null, null);
		cursor.moveToFirst();

		while (!cursor.isAfterLast()) {
			shape.add(DatabaseUtils.convertCursorToShape(cursor));
			cursor.moveToNext();
		}

		cursor.close();

		return shape;
	}

	/**
	 * Adds a shape to the database.
	 * 
	 * @param shape
	 *            the shape name.
	 * @param shapeSound
	 *            the shape sound.
	 * @param shapeImage
	 *            the shape image.
	 * @return the row ID of the newly inserted row, or -1 if an error occurred
	 */
	public long addShape(String shape, String shapeSound, Drawable shapeImage) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(DatabaseHelper.COLUMN_SHAPE_WORD, shape);
		contentValues.put(DatabaseHelper.COLUMN_SHAPE_IMAGE,
				ImageUtils.drawableToByteArray(shapeImage));
		contentValues.put(DatabaseHelper.COLUMN_SHAPE_SOUND, shapeSound);
		return sqlDatabase.insert(DatabaseHelper.TABLE_SHAPE, null,
				contentValues);
	}

}
