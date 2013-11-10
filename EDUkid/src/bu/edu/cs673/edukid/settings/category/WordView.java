package bu.edu.cs673.edukid.settings.category;

import bu.edu.cs673.edukid.EDUkid;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.model.category.CategoryType;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class WordView extends ListActivity {

	private CategoryType categoryType;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.word);

		Intent intent = getIntent();
		Bundle extras = intent.getExtras();

		categoryType = (CategoryType) extras
				.getSerializable(EDUkid.CATEGORY_TYPE);
		int itemIndex = extras.getInt(EDUkid.ITEM_INDEX);
		int wordIndex = extras.getInt(EDUkid.WORD_INDEX);

		// Set word name
		TextView wordName = (TextView) findViewById(R.id.wordName);
		wordName.setText(categoryType.getItemWord(itemIndex, wordIndex));

		// Set word image
		ImageView wordImage = (ImageView) findViewById(R.id.wordImage);
		wordImage.setImageDrawable(getResources().getDrawable(
				categoryType.getItemImage(itemIndex, wordIndex)));
	}
}
