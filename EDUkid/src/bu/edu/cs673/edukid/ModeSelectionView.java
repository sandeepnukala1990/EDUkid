package bu.edu.cs673.edukid;

import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.model.category.CategoryType;
import bu.edu.cs673.edukid.game.GameView;
import bu.edu.cs673.edukid.learn.LearnContentView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ModeSelectionView extends Activity {

	private CategoryType categoryType;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mode_selection);

		Intent intent = getIntent();
		Bundle extras = intent.getExtras();

		categoryType = (CategoryType) extras
				.getSerializable(EDUkid.CATEGORY_TYPE);
	}

	/**
	 * Callback for the learn mode button. Opens the learn view.
	 * 
	 * @param view
	 *            the view used in the callback.
	 */
	public void onLearnModeClick(View view) {
		Intent intent = new Intent(this, LearnContentView.class);
		intent.putExtra(EDUkid.CATEGORY_TYPE, categoryType);
		startActivity(intent);
	}

	/**
	 * Callback for the game mode button. Opens the game view.
	 * 
	 * @param view
	 *            the view used in the callback.
	 */
	public void onGameModeClick(View view) {
		Intent intent = new Intent(this, GameView.class);
		// TODO: Assuming alphabet category. This needs to be changed if we
		// allow for other categories to have a game mode.
		CategoryType categoryType = Database.getInstance(this).getCategories()[0];
		intent.putExtra(EDUkid.CATEGORY_TYPE, categoryType);
		startActivity(intent);
	}
}
