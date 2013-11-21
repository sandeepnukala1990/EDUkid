package bu.edu.cs673.edukid.settings.category;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import bu.edu.cs673.edukid.EDUkid;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.ImageUtils;
import bu.edu.cs673.edukid.db.model.Word;
import bu.edu.cs673.edukid.db.model.category.CategoryType;

public class AddWordView extends Activity {

	private CategoryType categoryType;

	private int itemIndex;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_word);

		Intent intent = getIntent();
		Bundle extras = intent.getExtras();

		categoryType = (CategoryType) extras
				.getSerializable(EDUkid.CATEGORY_TYPE);
		itemIndex = extras.getInt(EDUkid.ITEM_INDEX);
	}

	// TODO: just temporary for now. Need to get input from the user and use
	// that instead of hardcoding.
	public void onAddWordClick(View view) {
		// TODO: do this based on user entry
		// TODO: hard coding these for now to add a new word.
		Word word = new Word();
		word.setWord("TestWord");
		word.setWordSound("Coming soon");
		word.setWordImage(ImageUtils.drawableToByteArray(getResources()
				.getDrawable(R.drawable.boy)));

		categoryType.addItemWord(itemIndex, word);

		// TODO: refresh list
	}
}
