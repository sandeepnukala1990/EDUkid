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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import bu.edu.cs673.edukid.EDUkid;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.ImageUtils;
import bu.edu.cs673.edukid.db.model.Word;
import bu.edu.cs673.edukid.db.model.category.CategoryType;
import bu.edu.cs673.edukid.settings.utils.ImageUtilities;
import bu.edu.cs673.edukid.settings.utils.RecordUtility;

public class AddWordView extends Activity implements OnClickListener {

	private CategoryType categoryType;

	private int itemIndex;

	private static final int TAKE_PICTURE = 1888;

	private static final int SELECT_PHOTO = 100;

	private String word = "";

	private ImageView wordImage;

	private ImageView micImage;

	private ImageView galleryImage;

	private ImageView playImage;

	private EditText textBox;

	private Boolean picture = false;

	private boolean recording = false;

	private String savedFilePath = "";

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

		wordImage = (ImageView) findViewById(R.id.imageView1);
		micImage = (ImageView) findViewById(R.id.AddWordSoundButton);
		galleryImage = (ImageView) findViewById(R.id.AddWordGalleryButton);
		playImage = (ImageView) findViewById(R.id.addWordPlayButton);
		textBox = (EditText) findViewById(R.id.editText1);

		if (savedFilePath == null || savedFilePath.isEmpty()) {
			playImage.setBackgroundResource(R.drawable.greyplaybutton);
			playImage.setEnabled(false);
		}

		ImageButton createSaveButton = (ImageButton) findViewById(R.id.AddWordAddButton);
		createSaveButton.setOnClickListener(this);
		ImageButton createUploadPhotoButton = (ImageButton) findViewById(R.id.takePictureButton);
		createUploadPhotoButton.setOnClickListener(this);
		micImage.setOnClickListener(this);
		galleryImage.setOnClickListener(this);
		playImage.setOnClickListener(this);
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == TAKE_PICTURE && resultCode == RESULT_OK) {
			Bitmap photo = (Bitmap) data.getExtras().get("data");
			picture = true;
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
			picture = true;
			Bitmap photo = BitmapFactory.decodeFile(savedFilePath);
			if (photo != null) {
				wordImage.setMaxHeight(300);
				wordImage.setMaxWidth(300);
				wordImage.setAdjustViewBounds(false);
				wordImage.setImageBitmap(photo);
			}
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.AddWordAddButton:
			word = textBox.getText().toString();
			Word w = new Word();

			if (word.isEmpty()) {
				Toast.makeText(this, "Please enter a word before saving.",
						Toast.LENGTH_LONG).show();
				return;
			} else if (picture == false) {
				Toast.makeText(this, "Please upload a picture before saving.",
						Toast.LENGTH_LONG).show();
				return;
			}

			// If we get here we can save the word
			w.setWord(word);

			if (savedFilePath.isEmpty()) {
				w.setWordSound("");
			} else {
				w.setWordSound(savedFilePath);
			}

			w.setWordImage(ImageUtils.drawableToByteArray(wordImage
					.getDrawable()));
			categoryType.addItemWord(itemIndex, w);

			Toast.makeText(this, "Word saved successfully!", Toast.LENGTH_LONG)
					.show();

			Intent intent = new Intent(this, ItemView.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.putExtra(EDUkid.CATEGORY_TYPE, categoryType);
			intent.putExtra(EDUkid.ITEM_INDEX, itemIndex);
			startActivity(intent);
			break;

		case R.id.takePictureButton:
			ImageUtilities.startCamera(this);
			break;

		case R.id.AddWordSoundButton:
			String wordText = textBox.getText().toString();

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
		case R.id.AddWordGalleryButton:
			ImageUtilities.selectPhoto(this);
			break;
		case R.id.addWordPlayButton:
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
}
