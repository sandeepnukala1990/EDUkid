package bu.edu.cs673.edukid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.defaults.DatabaseDefaults;
import bu.edu.cs673.edukid.db.model.Word;

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
		setupDefaultWordMappings();
	}

	/**
	 * Sets up the database with its default values if it does not have any.
	 */
	private void setupDatabse() {
		Database database = Database.getInstance(this);

		if (database.getLetters().size() == 0) {
			for (String letter : DatabaseDefaults.getAlphabet()) {
				database.addLetter(letter.toString());
			}
		}

		if (database.getNums().size() == 0) {
			for (String num : DatabaseDefaults.getNumbers()) {
				database.addNums(num);
			}
		}

		if (database.getColors().size() == 0) {
			for (String color : DatabaseDefaults.getColors()) {
				database.addColor(color, color, null);
			}
		}

		if (database.getShapes().size() == 0) {
			for (String shape : DatabaseDefaults.getShapes()) {
				database.addShape(shape, shape, null);
			}
		}
	}

	// TODO
	private void setupDefaultWordMappings() {
		if (Database.getInstance(this).getDefaultWordMapping(null).size() == 0) {
			setupDefaultWordMapping(0,
					DatabaseDefaults.getDefaultAlphabetWords());
			setupDefaultWordMapping(1, DatabaseDefaults.getDefaultNumberWords());
			setupDefaultWordMapping(2, DatabaseDefaults.getDefaultShapeWords());
			setupDefaultWordMapping(3, DatabaseDefaults.getDefaultColorWords());
		}
	}

	// TODO
	private void setupDefaultWordMapping(int categoryIndex, Word[][] wordsArray) {
		Database database = Database.getInstance(this);

		for (int itemIndex = 0; itemIndex < wordsArray.length; itemIndex++) {
			Word[] words = wordsArray[itemIndex];

			for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
				database.addDefaultWordMapping(categoryIndex, itemIndex,
						wordIndex, true);
			}
		}
	}
}
