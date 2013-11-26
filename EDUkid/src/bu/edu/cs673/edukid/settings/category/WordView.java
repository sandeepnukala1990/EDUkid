package bu.edu.cs673.edukid.settings.category;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import bu.edu.cs673.edukid.EDUkid;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.model.Word;
import bu.edu.cs673.edukid.db.model.category.CategoryType;
import bu.edu.cs673.edukid.settings.SettingsView;

public class WordView extends Activity {

	private CategoryType categoryType;

	private int itemIndex;

	private int wordIndex;

	private TextView wordName;

	private ImageView wordImage;

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
		itemIndex = extras.getInt(EDUkid.ITEM_INDEX);
		wordIndex = extras.getInt(EDUkid.WORD_INDEX);

		Word word = categoryType.getSettingsItemWord(itemIndex, wordIndex);

		// Set word name
		wordName = (TextView) findViewById(R.id.wordName);
		wordName.setText(word.getWord());

		// Set word image
		wordImage = (ImageView) findViewById(R.id.wordImage);
		wordImage.setImageDrawable(getResources().getDrawable(
				categoryType.getItemDrawableId(itemIndex, wordIndex)));

		// Show/hide delete word button
		Button deleteWordButton = (Button) findViewById(R.id.deleteWordButton);
		deleteWordButton.setVisibility(word.isDefaultWord() ? View.INVISIBLE
				: View.VISIBLE);
	}

	/**
	 * Settings home on click callback.
	 * 
	 * @param view
	 *            the view.
	 */
	public void onSettingsHomeClick(View view) {
		Intent intent = new Intent(this, SettingsView.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
	}

	/**
	 * Save word on click callback.
	 * 
	 * @param view
	 *            the view.
	 */
	public void onSaveWordClick(View view) {
		// TODO: implement this
		Toast.makeText(this, "Save word coming soon...", Toast.LENGTH_LONG)
				.show();
		// Word word = new Word();
		// word.setWord(wordName.getText().toString());
		//
		// categoryType.addItemWord(itemIndex, wordIndex, new Word());
	}

	/**
	 * Add tag on click callback.
	 * 
	 * @param view
	 *            the view.
	 */
	public void onAddTagClick(View view) {
		// TODO: implement this
		Toast.makeText(this, "Add tag coming soon...", Toast.LENGTH_LONG)
				.show();
	}

	/**
	 * Word image on click callback.
	 * 
	 * @param view
	 *            the view.
	 */
	public void onWordImageClick(View view) {
		// TODO: implement this
		Toast.makeText(this, "Word image edit coming soon...",
				Toast.LENGTH_LONG).show();
	}

	/**
	 * Delete word on click callback.
	 * 
	 * @param view
	 *            the view.
	 */
	public void onDeleteWordClick(View view) {
		// TODO: implement this
		Toast.makeText(this, "Delete word coming soon...", Toast.LENGTH_LONG)
				.show();
	}
}
