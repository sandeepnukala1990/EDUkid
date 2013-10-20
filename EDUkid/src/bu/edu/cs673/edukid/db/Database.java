package bu.edu.cs673.edukid.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import bu.edu.cs673.edukid.db.model.Category;

public class Database {

	private static Database DATABASE_INSTANCE = null;

	private SQLiteDatabase sqlDatabase;

	private DatabaseHelper databaseHelper;

	private String[] allColumns = { DatabaseHelper.COLUMN_ID,
			DatabaseHelper.COLUMN_CATEGORY, DatabaseHelper.COLUMN_IMAGE };

	public static Database getInstance(Context context) {
		if (DATABASE_INSTANCE == null) {
			DATABASE_INSTANCE = new Database(context);
		}

		return DATABASE_INSTANCE;
	}

	private Database(Context context) {
		databaseHelper = new DatabaseHelper(context);
	}

	public void open() {
		sqlDatabase = databaseHelper.getWritableDatabase();
	}

	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<Category>();

		Cursor cursor = sqlDatabase.query(DatabaseHelper.TABLE_CATEGORIES,
				allColumns, null, null, null, null, null);
		cursor.moveToFirst();

		while (!cursor.isAfterLast()) {
			categories.add(convertCursorToCategory(cursor));
			cursor.moveToNext();
		}

		cursor.close();

		return categories;
	}

	public void addCategory(String name, Drawable image) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(DatabaseHelper.COLUMN_CATEGORY, name);
		contentValues.put(DatabaseHelper.COLUMN_IMAGE,
				ImageUtils.drawableToByteArray(image));
		sqlDatabase
				.insert(DatabaseHelper.TABLE_CATEGORIES, null, contentValues);
	}

	private Category convertCursorToCategory(Cursor cursor) {
		Category category = new Category();
		category.setId(cursor.getLong(0));
		category.setName(cursor.getString(1));
		category.setImageData(cursor.getBlob(2));

		return category;
	}
}
