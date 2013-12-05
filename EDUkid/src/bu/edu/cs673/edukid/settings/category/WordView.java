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
import bu.edu.cs673.edukid.db.ImageUtils;
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

		if (word.isDefaultWord()) {
			wordImage.setImageDrawable(getResources().getDrawable(
					categoryType
							.getSettingsItemDrawableId(itemIndex, wordIndex)));
		} else {
			wordImage.setImageDrawable(categoryType.getSettingsItemDrawable(
					itemIndex, wordIndex));
		}

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
		Word w = new Word();
		String wordText = wordName.getText().toString();
		if (wordText.equalsIgnoreCase("")) {
			Toast.makeText(this, "nope!", Toast.LENGTH_LONG).show();
		} else {
			w.setWord(wordText);
			w.setWordSound(wordText);

			w.setWordImage(ImageUtils.drawableToByteArray(wordImage
					.getDrawable()));
			int databaseWordIndex = wordIndex
					- categoryType.getDefaultWordCount(itemIndex);
			categoryType.editItemWord(itemIndex, databaseWordIndex, w);

			Toast.makeText(this, "Word saved successfully!", Toast.LENGTH_LONG)
					.show();
		}
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
		int databaseWordIndex = wordIndex
				- categoryType.getDefaultWordCount(itemIndex);
		categoryType.deleteItemWord(itemIndex, databaseWordIndex);

		Toast.makeText(this,
				"'" + wordName.getText().toString() + "' Successfully Deleted",
				Toast.LENGTH_SHORT).show();

		Intent intent = new Intent(this, ItemView.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.putExtra(EDUkid.CATEGORY_TYPE, categoryType);
		intent.putExtra(EDUkid.ITEM_INDEX, itemIndex);
		startActivity(intent);
	}
}
