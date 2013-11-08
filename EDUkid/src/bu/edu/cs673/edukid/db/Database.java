package bu.edu.cs673.edukid.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import bu.edu.cs673.edukid.db.model.Alphabets;
import bu.edu.cs673.edukid.db.model.Category;
import bu.edu.cs673.edukid.db.model.CategoryType;
import bu.edu.cs673.edukid.db.model.Letter;
import bu.edu.cs673.edukid.db.model.Theme;
import bu.edu.cs673.edukid.db.model.UserAccount;

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

	private String[] themesColumns = { DatabaseHelper.COLUMN_THEME_ID,
			DatabaseHelper.COLUMN_THEME_NAME };

	private String[] alphabetsColumns = { DatabaseHelper.COLUMN_LID,
			DatabaseHelper.COLUMN_TID, DatabaseHelper.COLUMN_WORDS,
			DatabaseHelper.COLUMN_WORDS_SOUND,
			DatabaseHelper.COLUMN_WORDS_IMAGE };

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
	public List<Category> getCategories() {
		List<Category> categories = new ArrayList<Category>();

		Cursor cursor = sqlDatabase.query(DatabaseHelper.TABLE_CATEGORIES,
				categoriesColumns, null, null, null, null, null);
		cursor.moveToFirst();

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
	 * @param name
	 *            the category name.
	 * @param image
	 *            the category image.
	 */
	public void addCategory(String name, Drawable image) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(DatabaseHelper.COLUMN_CATEGORY_NAME, name);
		contentValues.put(DatabaseHelper.COLUMN_CATEGORY_IMAGE,
				ImageUtils.drawableToByteArray(image));
		sqlDatabase
				.insert(DatabaseHelper.TABLE_CATEGORIES, null, contentValues);
	}
	
	/**
	 * Gets an item from the database based on the {@link CategoryType} and its
	 * index.
	 * 
	 * <p>
	 * Note: an item in this context could be represented by a letter in the
	 * alphabet (0 is A, 1 is B, 2 is C, and so on).
	 * </p>
	 * 
	 * @param categoryType
	 *            the category type.
	 * @param itemIndex
	 *            the item index.
	 * @return the item in string form.
	 */
	public String getItem(CategoryType categoryType, int itemIndex) {
		switch (categoryType) {
		case ALPHABET:
			Letter letter = getLetters().get(itemIndex);
			return letter.getLetter();
		case NUMBERS:
		case SHAPES:
		case COLORS:
		case CUSTOM:
			// TODO: should be a database query because we can add to these
			// categories or create new categories (custom)
			return "";
		default:
			return "";
		}
	}

	/**
	 * Returns the number of items in a given category.
	 * 
	 * @param categoryType
	 *            the category type.
	 * @return the number of items in a given category.
	 */
	public int getItemCount(CategoryType categoryType) {
		switch (categoryType) {
		case ALPHABET:
			return DatabaseDefaults.getAlphabet().length;
		case NUMBERS:
		case SHAPES:
		case COLORS:
		case CUSTOM:
			// TODO: should be a database query because we can add to these
			// categories or create new categories (custom)
			return 0;
		default:
			// Should never get here.
			return 0;
		}
	}

	/**
	 * Gets the associated words for a given item.
	 * 
	 * @param categoryType
	 *            the category type.
	 * @param itemIndex
	 *            the item index.
	 * @return the words for a given item.
	 */
	private List<String> getItemWords(CategoryType categoryType, int itemIndex) {
		switch (categoryType) {
		case ALPHABET:
			// TODO: check the database first, then use the defaults if we get
			// nothing back from the query (custom words from user).
			return DatabaseDefaults.getDefaultAlphabetWords(itemIndex);
		case NUMBERS:
		case SHAPES:
		case COLORS:
		case CUSTOM:
			// TODO: database query then default
			return Collections.emptyList();
		default:
			// Should never get here.
			return Collections.emptyList();
		}
	}

	/**
	 * Gets the specific word given an item index, word index, and category.
	 * 
	 * @param categoryType
	 *            the category type.
	 * @param itemIndex
	 *            the item index.
	 * @param wordIndex
	 *            the word index.
	 * @return the specific word given an item index, word index, and category.
	 */
	public String getItemWord(CategoryType categoryType, int itemIndex,
			int wordIndex) {
		switch (categoryType) {
		case ALPHABET: {
			int listIndex = itemIndex;

			if (getAlphabets().size() != 0) {
				Alphabets alp = null;
				do {
					alp = getAlphabets().get(listIndex);

					if (alp.getLid() == itemIndex) {
						if (alp.getThemeId() == wordIndex) {
							return alp.getWord();
						} else
							listIndex++;
					} else
						listIndex++;
				} while (alp.getLid() <= itemIndex);
				return getItemWords(categoryType, itemIndex).get(wordIndex);
			} else
				// return null;
				return getItemWords(categoryType, itemIndex).get(wordIndex);
		}

		case NUMBERS:
		case SHAPES:
		case COLORS:
		default:
			// Should never get here.
			break;
		}
		return null;
		// return getItemWords(categoryType, itemIndex).get(wordIndex);
	}

	/**
	 * Gets the item word count for a given category.
	 * 
	 * @param categoryType
	 *            the category type.
	 * @param itemIndex
	 *            the item index.
	 * @return the item word count for a given category.
	 */
	public int getItemWordCount(CategoryType categoryType, int itemIndex) {
		return getItemWords(categoryType, itemIndex).size();
	}

	/**
	 * Gets the item image given an item index, an image index, and category.
	 * 
	 * @param categoryType
	 *            the category type.
	 * @param itemIndex
	 *            the item index.
	 * @param imageIndex
	 *            the image index.
	 * @return the item image given an item index, an image index, and category.
	 */
	public int getItemImage(CategoryType categoryType, int itemIndex,
			int imageIndex) {
		switch (categoryType) {
		case ALPHABET:
			// TODO: check the database first, then use the defaults if we get
			// nothing back from the query (voice recording from user).
			return DatabaseDefaults.getDefaultAlphabetDrawableIds(itemIndex)
					.get(imageIndex);
		case NUMBERS:
		case SHAPES:
		case COLORS:
		case CUSTOM:
			// TODO: database query then default
			return -1;
		default:
			// Should never get here.
			return -1;
		}
	}

	/**
	 * Gets the phonetic sound given an item index and a category.
	 * 
	 * @param categoryType
	 *            the category type.
	 * @param itemIndex
	 *            the item index.
	 * @return the phonetic sound given an item index and a category.
	 */
	public String getPhoneticSound(CategoryType categoryType, int itemIndex) {
		switch (categoryType) {
		case ALPHABET:
			// TODO: check the database first, then use the defaults if we get
			// nothing back from the query (voice recording from user).
			// return
			// DatabaseDefaults.getDefaultAlphabetPhoneticSounds(itemIndex);
			Letter letter = getLetters().get(itemIndex);
			return letter.getLetterSound();
		case NUMBERS:
		case SHAPES:
		case COLORS:
			// TODO: database query then default
			return "";
		default:
			// Should never get here.
			return "";
		}
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
	 * @param userImage
	 *            the user image.
	 * @return the row ID of the newly inserted row, or -1 if an error occurred
	 */
	public long addUserAccount(String userName, Drawable userImage) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(DatabaseHelper.COLUMN_USER_NAME, userName);
		contentValues.put(DatabaseHelper.COLUMN_USER_IMAGE,
				ImageUtils.drawableToByteArray(userImage));
		// TODO: need to add the user sound here
		contentValues.put(DatabaseHelper.COLUMN_USER_SOUND, userName);
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
				ImageUtils.byteArrayToDrawable(userAccount.getUserImage()));
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
		contentValues.put(DatabaseHelper.COLUMN_LETTERS_SOUND, letter);
		sqlDatabase.insert(DatabaseHelper.TABLE_LETTERS, null, contentValues);
	}

	/**
	 * Gets a list of the alphabets in the database.
	 * 
	 * @return a list of the alphabets in the database.
	 */
	public List<Alphabets> getAlphabets() {
		List<Alphabets> alpha = new ArrayList<Alphabets>();

		Cursor cursor = sqlDatabase.query(DatabaseHelper.TABLE_ALPHABET,
				alphabetsColumns, null, null, null, null, null);
		cursor.moveToFirst();

		while (!cursor.isAfterLast()) {
			alpha.add(DatabaseUtils.convertCursorToAlphabets(cursor));
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
	public void addAlphabets(int letterId, int themeId, String alphabetWord,
			String alphabetSound, Drawable alphabetImage) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(DatabaseHelper.COLUMN_LID, letterId);
		contentValues.put(DatabaseHelper.COLUMN_TID, themeId);
		contentValues.put(DatabaseHelper.COLUMN_WORDS, alphabetWord);
		contentValues.put(DatabaseHelper.COLUMN_WORDS_SOUND, alphabetSound);
		contentValues.put(DatabaseHelper.COLUMN_WORDS_IMAGE,
				ImageUtils.drawableToByteArray(alphabetImage));

		sqlDatabase.insert(DatabaseHelper.TABLE_ALPHABET, null, contentValues);
	}

	/**
	 * Gets a list of the themes in the database.
	 * 
	 * @return a list of the themes in the database.
	 */
	public List<Theme> getThemes() {
		List<Theme> themes = new ArrayList<Theme>();

		Cursor cursor = sqlDatabase.query(DatabaseHelper.TABLE_THEME,
				themesColumns, null, null, null, null, null);
		cursor.moveToFirst();

		while (!cursor.isAfterLast()) {
			themes.add(DatabaseUtils.convertCursorToTheme(cursor));
			cursor.moveToNext();
		}

		cursor.close();

		return themes;
	}

	/**
	 * Adds a theme to the database.
	 * 
	 * @param theme
	 *            the theme to add.
	 */
	public void addTheme(String theme) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(DatabaseHelper.COLUMN_THEME_NAME, theme);
		sqlDatabase.insert(DatabaseHelper.TABLE_THEME, null, contentValues);
	}
}
