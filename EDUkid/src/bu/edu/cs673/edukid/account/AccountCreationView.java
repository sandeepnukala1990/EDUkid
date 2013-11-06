package bu.edu.cs673.edukid.account;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.List;

import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.model.UserAccount;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.media.*;

//testcommit
public class AccountCreationView extends Activity implements OnClickListener {
	private static final int TAKE_PICTURE = 1888;
	private String childName;
	private ImageView imageView;
	public boolean accountExists;
	Database database = Database.getInstance(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.account_creation);
		imageView = (ImageView) findViewById(R.id.createUserImage);
		Button createSaveButton = (Button) findViewById(R.id.createSaveButton);
		createSaveButton.setOnClickListener(this);
		ImageView createUserImage = (ImageView) findViewById(R.id.createUserImage);
		Button createUploadPhotoButton = (Button) findViewById(R.id.createUploadPhotoButton);
		createUploadPhotoButton.setOnClickListener(this);
	}

	public void onClick(View view) {
		if (view.getId() == R.id.createSaveButton) {
			childName = ((EditText) findViewById(R.id.createEditChildName))
					.getText().toString();
			Collection<UserAccount> blah = database.getUserAccounts().values();
			UserAccount userAccount = (UserAccount) blah.toArray()[0];
			userAccount.setUserName(childName);
			database.editUserAccount(userAccount);
		} else if (view.getId() == R.id.createUploadPhotoButton) {

			imageFromCamera();
		}
	}

	public void imageFromCamera() {
		Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
		// File mImageFile = new
		// File(Environment.getExternalStorageDirectory()+File.separator+"MyApp",
		// "PIC"+System.currentTimeMillis()+".jpg");
		// String mSelectedImagePath = mImageFile.getAbsolutePath();
		// intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mImageFile));
		startActivityForResult(intent, TAKE_PICTURE);
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == TAKE_PICTURE && resultCode == RESULT_OK) {
			Bitmap photo = (Bitmap) data.getExtras().get("data");
			if (photo != null) {
				imageView.setImageBitmap(photo);
			}
		}
	}
}
