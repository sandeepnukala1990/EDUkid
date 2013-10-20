package bu.edu.cs673.edukid.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String EDUKID_DATABASE = "EDUkid.db";
	private static final int EDUKID_DATABASE_VERSION = 4;

	public static final String TABLE_CATEGORIES = "categories";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_CATEGORY = "category";
	public static final String COLUMN_IMAGE = "image";

	private static final String DATABASE_CREATE = "create table "
			+ TABLE_CATEGORIES + "(" + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_CATEGORY
			+ " text not null, " + COLUMN_IMAGE + " text not null);";

	public DatabaseHelper(Context context) {
		super(context, EDUKID_DATABASE, null, EDUKID_DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORIES);
		onCreate(db);
	}
}
