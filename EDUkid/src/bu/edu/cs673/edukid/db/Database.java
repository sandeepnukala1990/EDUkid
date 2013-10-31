package bu.edu.cs673.edukid.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import bu.edu.cs673.edukid.db.model.Category;
import bu.edu.cs673.edukid.db.model.UserAccount;

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
				categoriesColumns, null, null, null, null, null);
		cursor.moveToFirst();

		while (!cursor.isAfterLast()) {
			categories.add(convertCursorToCategory(cursor));
			cursor.moveToNext();
		}

		cursor.close();

		return categories;
	}

	public List<UserAccount> getUserAccounts() {
		List<UserAccount> userAccounts = new ArrayList<UserAccount>();

		Cursor cursor = sqlDatabase.query(DatabaseHelper.TABLE_USER_ACCOUNT,
				userAccountColumns, null, null, null, null, null);
		cursor.moveToFirst();

		while (!cursor.isAfterLast()) {
			userAccounts.add(convertCursorToUserAccount(cursor));
			cursor.moveToNext();
		}

		cursor.close();

		return userAccounts;
	}

	public void addCategory(String name, Drawable image) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(DatabaseHelper.COLUMN_CATEGORY_NAME, name);
		contentValues.put(DatabaseHelper.COLUMN_CATEGORY_IMAGE,
				ImageUtils.drawableToByteArray(image));
		sqlDatabase
				.insert(DatabaseHelper.TABLE_CATEGORIES, null, contentValues);
	}

	public void addUserAccount(String userName, Drawable userImage) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(DatabaseHelper.COLUMN_USER_NAME, userName);
		contentValues.put(DatabaseHelper.COLUMN_USER_IMAGE,
				ImageUtils.drawableToByteArray(userImage));
		contentValues.put(DatabaseHelper.COLUMN_USER_SOUND, userName);
		sqlDatabase.insert(DatabaseHelper.TABLE_USER_ACCOUNT, null,
				contentValues);
	}

	private Category convertCursorToCategory(Cursor cursor) {
		Category category = new Category();
		category.setId(cursor.getLong(0));
		category.setName(cursor.getString(1));
		category.setImageData(cursor.getBlob(2));

		return category;
	}

	private UserAccount convertCursorToUserAccount(Cursor cursor) {
		UserAccount userAccount = new UserAccount();
		userAccount.setId(cursor.getLong(0));
		userAccount.setUserName(cursor.getString(1));
		userAccount.setUserImage(cursor.getBlob(2));
		userAccount.setUserSound(cursor.getString(3));

		return userAccount;
	}
}
