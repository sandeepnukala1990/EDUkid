package bu.edu.cs673.edukid;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.learn.LearnType;

public class EDUsplash extends Activity {

	private long SPLASH_DURATION = 3000;

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

	private void setupDatabse() {
		Database database = Database.getInstance(this);
		database.open();
		Resources resources = getResources();

		if (database.getUserAccounts().size() == 0) {
			database.addUserAccount("Jasjot",
					resources.getDrawable(R.drawable.mickey_mouse));
		}

		if (database.getAllCategories().size() == 0) {

			database.addCategory(LearnType.ALPHABET.toString(),
					resources.getDrawable(R.drawable.tiletry));
			database.addCategory(LearnType.NUMBERS.toString(),
					resources.getDrawable(R.drawable.numbersnew));
			database.addCategory(LearnType.SHAPES.toString(),
					resources.getDrawable(R.drawable.shapesnew));
			database.addCategory(LearnType.COLORS.toString(),
					resources.getDrawable(R.drawable.colorsnew));
		}
	}
}
