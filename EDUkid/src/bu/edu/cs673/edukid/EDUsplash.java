package bu.edu.cs673.edukid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.DatabaseDefaults;

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

		if (database.getLetters().size() == 0) {
			for (String letter : DatabaseDefaults.getAlphabet()) {
				database.addLetter(letter);
			}
		}

		if (database.getNums().size() == 0) {
			for (String num : DatabaseDefaults.getNumbers()) {
				database.addNums(num);
			}
		}

		if (database.getColours().size() == 0) {
			for (String col : DatabaseDefaults.getColors()) {
				database.addColour(col, null);
			}
		}

		if (database.getShapes().size() == 0) {
			for (String shape : DatabaseDefaults.getShapes()) {
				database.addShape(shape, null);
			}
		}

		if (database.getThemes().size() == 0) {
			// TODO: implement this more
			database.addTheme("ANIMALS");
		}
	}
}
