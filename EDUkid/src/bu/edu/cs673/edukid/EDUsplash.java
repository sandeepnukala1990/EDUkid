package bu.edu.cs673.edukid;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.DatabaseDefaults;
import bu.edu.cs673.edukid.db.model.CategoryType;

/**
 * The splash screen, and the entry point into the application.
 * 
 * @author Jasjot Singh
 * 
 */
public class EDUsplash extends Activity {

	private long SPLASH_DURATION = 3000;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edusplash);

		Thread Timer = new Thread() {
			public void run() {
				try {
					sleep(SPLASH_DURATION);
					Intent intent = new Intent(EDUsplash.this, EDUkid.class);
					startActivity(intent);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					finish();
				}
			}
		};

		Timer.start();
		setupDatabse();
	}

	/**
	 * Sets up the database with its default values if it does not have any.
	 */
	private void setupDatabse() {
		Database database = Database.getInstance(this);
		Resources resources = getResources();

		if (database.getCategories().size() == 0) {
			database.addCategory(CategoryType.ALPHABET.toString(),
					resources.getDrawable(R.drawable.tiletry));
			database.addCategory(CategoryType.NUMBERS.toString(),
					resources.getDrawable(R.drawable.numbersnew));
			database.addCategory(CategoryType.SHAPES.toString(),
					resources.getDrawable(R.drawable.shapesnew));
			database.addCategory(CategoryType.COLORS.toString(),
					resources.getDrawable(R.drawable.colorsnew));
		}

		if (database.getLetters().size() == 0) {
			for (String letter : DatabaseDefaults.getAlphabet()) {
				database.addLetter(letter);
			}
		}

		if (database.getThemes().size() == 0) {
			// TODO: implement this more
			database.addTheme("ANIMALS");
		}
	}
}
