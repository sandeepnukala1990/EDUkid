package bu.edu.cs673.edukid.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String EDUKID_DATABASE = "EDUkid.db";
	private static final int EDUKID_DATABASE_VERSION = 11;

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

	public DatabaseHelper(Context context) {
		super(context, EDUKID_DATABASE, null, EDUKID_DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_CATEGORIES_TABLE);
		db.execSQL(CREATE_USER_ACCOUNT_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(DROP_TABLE + TABLE_CATEGORIES);
		db.execSQL(DROP_TABLE + TABLE_USER_ACCOUNT);
		onCreate(db);
	}
}
