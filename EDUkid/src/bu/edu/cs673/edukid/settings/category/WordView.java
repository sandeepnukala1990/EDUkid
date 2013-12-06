package bu.edu.cs673.edukid.settings.category;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import bu.edu.cs673.edukid.EDUkid;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.ImageUtils;
import bu.edu.cs673.edukid.db.model.Word;
import bu.edu.cs673.edukid.db.model.category.CategoryType;
import bu.edu.cs673.edukid.settings.SettingsView;
import bu.edu.cs673.edukid.settings.utils.ImageUtilities;
import bu.edu.cs673.edukid.settings.utils.RecordUtility;

public class WordView extends Activity implements OnClickListener {

	private static final int TAKE_PICTURE = 1888;

	private static final int SELECT_PHOTO = 100;

	private CategoryType categoryType;

	private int itemIndex;

	private int wordIndex;

	private TextView wordName;

	private ImageView wordImage;

	private ImageView cameraImage;

	private ImageView galleryImage;

	private ImageView micImage;

	private ImageView playImage;

	private boolean recording = false;

	private String savedFilePath = "";

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

		cameraImage = (ImageView) findViewById(R.id.wordViewCameraButton);
		galleryImage = (ImageView) findViewById(R.id.wordViewGalleryButton);
		micImage = (ImageView) findViewById(R.id.wordViewMicButton);
		playImage = (ImageView) findViewById(R.id.wordViewPlayButton);

		savedFilePath = word.getWordSound();

		if (savedFilePath == null || savedFilePath.isEmpty()) {
			playImage.setBackgroundResource(R.drawable.greyplaybutton);
			playImage.setEnabled(false);
		} else {
			playImage.setBackgroundResource(R.drawable.playbutton);
			playImage.setEnabled(true);
		}

		// Add listeners
		cameraImage.setOnClickListener(this);
		galleryImage.setOnClickListener(this);
		micImage.setOnClickListener(this);
		playImage.setOnClickListener(this);

		// Show/hide delete word button and 4 buttons for images/recording
		if (word.isDefaultWord()) {
			Button deleteWordButton = (Button) findViewById(R.id.deleteWordButton);
			deleteWordButton.setVisibility(View.INVISIBLE);

			LinearLayout linearLayout = (LinearLayout) findViewById(R.id.wordViewLinearLayout);
			linearLayout.setVisibility(View.INVISIBLE);
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.wordViewCameraButton:
			ImageUtilities.startCamera(this);
			break;
		case R.id.wordViewGalleryButton:
			ImageUtilities.selectPhoto(this);
			break;
		case R.id.wordViewMicButton:
			String wordText = wordName.getText().toString();

			if (wordText.isEmpty()) {
				Toast.makeText(this, "Please enter a word before recording.",
						Toast.LENGTH_LONG).show();
				return;
			}

			if (recording) {
				RecordUtility.stopRecording(micImage);
				playImage.setBackgroundResource(R.drawable.playbutton);
				playImage.setEnabled(true);
			} else {
				savedFilePath = RecordUtility
						.startRecording(wordText, micImage);
			}

			recording = !recording;
			break;
		case R.id.wordViewPlayButton:
			if (savedFilePath == null)
				Toast.makeText(
						this,
						"No audio recorded, please use the record button to record the word audio.",
						Toast.LENGTH_LONG).show();
			else {
				RecordUtility.playbackRecording(savedFilePath);
			}
			break;
		}
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == TAKE_PICTURE && resultCode == RESULT_OK) {
			Bitmap photo = (Bitmap) data.getExtras().get("data");
			if (photo != null) {
				wordImage.setMaxHeight(300);
				wordImage.setMaxWidth(300);
				wordImage.setAdjustViewBounds(false);
				wordImage.setImageBitmap(photo);
			}
		} else if (requestCode == SELECT_PHOTO && resultCode == RESULT_OK) {
			Uri selectedImage = data.getData();
			String[] filePathColumn = { MediaStore.Images.Media.DATA };
			Cursor cursor = getContentResolver().query(selectedImage,
					filePathColumn, null, null, null);
			cursor.moveToFirst();

			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			String savedFilePath = cursor.getString(columnIndex);
			cursor.close();
			Bitmap photo = BitmapFactory.decodeFile(savedFilePath);
			if (photo != null) {
				wordImage.setMaxHeight(300);
				wordImage.setMaxWidth(300);
				wordImage.setAdjustViewBounds(false);
				wordImage.setImageBitmap(photo);
			}
		}
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

		if (wordText.isEmpty()) {
			Toast.makeText(this, "Please enter a word before saving.",
					Toast.LENGTH_LONG).show();
		} else {
			w.setWord(wordText);
			w.setWordSound(savedFilePath);
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
