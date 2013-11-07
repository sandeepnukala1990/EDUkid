package bu.edu.cs673.edukid.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * This class defines the database schema and contract.
 * 
 * @author Kevin Graue
 * 
 */
public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String EDUKID_DATABASE = "EDUkid.db";
	private static final int EDUKID_DATABASE_VERSION = 21;

	private static final String DROP_TABLE = "DROP TABLE IF EXISTS ";

	public static final String TABLE_CATEGORIES = "categories";
	public static final String COLUMN_CATEGORY_ID = "_id";
	public static final String COLUMN_CATEGORY_NAME = "category";
	public static final String COLUMN_CATEGORY_IMAGE = "image";

	public static final String TABLE_USER_ACCOUNT = "useraccount";
	public static final String COLUMN_USER_ID = "uid";
	public static final String COLUMN_USER_NAME = "username";
	public static final String COLUMN_USER_IMAGE = "userimage";
	public static final String COLUMN_USER_SOUND = "usersound";

	public static final String TABLE_LETTERS = "letter";
	public static final String COLUMN_LETTERS_ID = "letterid";
	public static final String COLUMN_LETTERS_WORD = "letterword";
	public static final String COLUMN_LETTERS_SOUND = "lettersound";

	public static final String TABLE_THEME = "theme";
	public static final String COLUMN_THEME_ID = "themeid";
	public static final String COLUMN_THEME_NAME = "themename";

	public static final String TABLE_ALPHABET = "alphabet";
	public static final String COLUMN_LID = "lid";
	public static final String COLUMN_TID = "tid";
	public static final String COLUMN_WORDS = "words";
	public static final String COLUMN_WORDS_SOUND = "wordssound";
	public static final String COLUMN_WORDS_IMAGE = "wordsimage";

	private static final String CREATE_CATEGORIES_TABLE = "create table "
			+ TABLE_CATEGORIES + "(" + COLUMN_CATEGORY_ID
			+ " integer primary key autoincrement, " + COLUMN_CATEGORY_NAME
			+ " text not null, " + COLUMN_CATEGORY_IMAGE + " text not null);";

	// TODO: sound is text. investigate this.
	private static final String CREATE_USER_ACCOUNT_TABLE = "create table "
			+ TABLE_USER_ACCOUNT + "(" + COLUMN_USER_ID
			+ " integer primary key autoincrement, " + COLUMN_USER_NAME
			+ " text not null, " + COLUMN_USER_IMAGE + " text not null, "
			+ COLUMN_USER_SOUND + " text not null);";

	private static final String CREATE_LETTERS_TABLE = "create table "
			+ TABLE_LETTERS + "(" + COLUMN_LETTERS_ID
			+ " integer primary key autoincrement, " + COLUMN_LETTERS_WORD
			+ " text , " + COLUMN_LETTERS_SOUND + " text );";

	private static final String CREATE_THEME_TABLE = "create table "
			+ TABLE_THEME + "(" + COLUMN_THEME_ID
			+ " integer primary key autoincrement, " + COLUMN_THEME_NAME
			+ " text not null);";

	private static final String CREATE_ALPHABET_TABLE = "create table "
			+ TABLE_ALPHABET + "(" + COLUMN_LID + " integer, " + COLUMN_TID
			+ " integer , " + COLUMN_WORDS + " text , " + COLUMN_WORDS_SOUND
			+ " text, " + COLUMN_WORDS_IMAGE + " text );";

	/**
	 * Constructor.
	 * 
	 * @param context
	 *            the context.
	 */
	public DatabaseHelper(Context context) {
		super(context, EDUKID_DATABASE, null, EDUKID_DATABASE_VERSION);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_CATEGORIES_TABLE);
		db.execSQL(CREATE_USER_ACCOUNT_TABLE);
		db.execSQL(CREATE_LETTERS_TABLE);
		db.execSQL(CREATE_THEME_TABLE);
		db.execSQL(CREATE_ALPHABET_TABLE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(DROP_TABLE + TABLE_CATEGORIES);
		db.execSQL(DROP_TABLE + TABLE_USER_ACCOUNT);
		db.execSQL(DROP_TABLE + TABLE_LETTERS);
		db.execSQL(DROP_TABLE + TABLE_THEME);
		db.execSQL(DROP_TABLE + TABLE_ALPHABET);

		onCreate(db);
	}
}
