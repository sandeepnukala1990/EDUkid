package bu.edu.cs673.edukid.settings.category;

import java.io.IOException;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
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

	String fname;

	private Random generator = new Random(19580427);

	private static final int TAKE_PICTURE = 1888;

	private static final int SELECT_PHOTO = 100;

	private boolean recording = false;

	private String word = "";

	private ImageView wordImage;

	private ImageView micImage;

	private ImageView galleryImage;

	private EditText textBox;

	private Boolean picture = false;

	public MediaRecorder recorder = new MediaRecorder();

	private String savedFilePath = "";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_word);
		wordImage = (ImageView) findViewById(R.id.imageView1);
		micImage = (ImageView) findViewById(R.id.AddWordSoundButton);
		galleryImage = (ImageView) findViewById(R.id.AddWordGalleryButton);
		textBox = (EditText) findViewById(R.id.editText1);

		Intent intent = getIntent();
		Bundle extras = intent.getExtras();

		categoryType = (CategoryType) extras
				.getSerializable(EDUkid.CATEGORY_TYPE);
		itemIndex = extras.getInt(EDUkid.ITEM_INDEX);

		Button createSaveButton = (Button) findViewById(R.id.AddWordAddButton);
		createSaveButton.setOnClickListener(this);
		ImageButton createUploadPhotoButton = (ImageButton) findViewById(R.id.takePictureButton);
		createUploadPhotoButton.setOnClickListener(this);
		micImage.setOnClickListener(this);
		galleryImage.setOnClickListener(this);

		// TextView balh = (TextView) findViewById(R.id.textView233);
	}

	// TODO: just temporary for now. Need to get input from the user and use
	// that instead of hardcoding.
	/*
	 * public void onAddWordClick(View view) { // TODO: do this based on user
	 * entry // TODO: hard coding these for now to add a new word. Word word =
	 * new Word(); word.setWord("TestWord"); word.setWordSound("Coming soon");
	 * word.setWordImage(ImageUtils.drawableToByteArray(getResources()
	 * .getDrawable(R.drawable.boy)));
	 * 
	 * categoryType.addItemWord(itemIndex, word);
	 * 
	 * // TODO: refresh list }
	 */

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == TAKE_PICTURE && resultCode == RESULT_OK) {
			Bitmap photo = (Bitmap) data.getExtras().get("data");
			picture = true;
			if (photo != null) {
				wordImage.setMaxHeight(400);
				wordImage.setMaxWidth(400);
				wordImage.setAdjustViewBounds(false);
				wordImage.setImageBitmap(photo);
			}
		}
		else if(requestCode == SELECT_PHOTO&&resultCode == RESULT_OK){
			Uri selectedImage = data.getData();
			String[] filePathColumn = {MediaStore.Images.Media.DATA};
			Cursor cursor = getContentResolver().query(
					selectedImage, filePathColumn, null, null, null);
			cursor.moveToFirst();

			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			String savedFilePath = cursor.getString(columnIndex);
			cursor.close();
			picture=true;
			Bitmap photo = BitmapFactory.decodeFile(savedFilePath);
			if (photo != null) {
				wordImage.setMaxHeight(400);
				wordImage.setMaxWidth(400);
				wordImage.setAdjustViewBounds(false);
				wordImage.setImageBitmap(photo);
			}
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.AddWordAddButton:
			word = ((EditText) findViewById(R.id.editText1)).getText()
			.toString();
			// long result = DATABASE_ERROR;
			Word w = new Word();

			if (word.equalsIgnoreCase("") || picture == false) {
				Toast.makeText(this, "cannot save Word!", Toast.LENGTH_LONG)
				.show();
			} else {
				w.setWord(word);
				if (savedFilePath.equalsIgnoreCase(""))
					w.setWordSound(word);
				else
					w.setWordSound(savedFilePath);

				w.setWordImage(ImageUtils.drawableToByteArray(wordImage
						.getDrawable()));
				categoryType.addItemWord(itemIndex, w);

				Toast.makeText(this, "Word saved successfully!",
						Toast.LENGTH_LONG).show();
				Intent intent = new Intent(this, ItemView.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.putExtra(EDUkid.CATEGORY_TYPE, categoryType);
				intent.putExtra(EDUkid.ITEM_INDEX, itemIndex);
				startActivity(intent);
			}
			break;

		case R.id.takePictureButton:
			ImageUtilities.startCamera(this);
			break;

		case R.id.AddWordSoundButton:
			if(textBox.getText().toString().isEmpty())
				fname="noName"+ generator.nextInt();
			else
				fname=textBox.getText().toString();
			if (recording) {
				RecordUtility.stopRecording(micImage);
				micImage.setBackgroundResource(R.drawable.playbutton);
				micImage.setEnabled(true);
			} else {
				savedFilePath = RecordUtility.startRecording(fname,
						micImage);
			}

			recording = !recording;
			break;
		case R.id.AddWordGalleryButton:
			ImageUtilities.selectPhoto(this);
		}
	}

	//	private void onRecord(boolean start) {
	//		// TODO Auto-generated method stub
	//		if (start) {
	//			startRecording();
	//
	//		} else {
	//			stopRecording();
	//		}
	//
	//	}
	//
	//	private void stopRecording() {
	//		// TODO Auto-generated method stub
	//		micImage.setBackgroundResource(R.drawable.mikebutton);
	//		recorder.stop();
	//		recorder.release();
	//		recorder = null;
	//	}
	//
	//	private void startRecording() {
	//		// TODO Auto-generated method stub
	//		micImage.setBackgroundResource(R.drawable.recordmikebutton);
	//		recorder = new MediaRecorder();
	//		mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
	//		mFileName += "/audiorecordtest.3gp";
	//		recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
	//		recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
	//		recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
	//		recorder.setOutputFile(mFileName);
	//		try {
	//			recorder.prepare();
	//		} catch (IllegalStateException e) {
	//			e.printStackTrace();
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		}
	//		recorder.start();
	//	}

	//	private void startCamera() {
	//		// TODO Auto-generated method stub
	//		picture = true;
	//		Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
	//		startActivityForResult(intent, TAKE_PICTURE);
	//}
}
