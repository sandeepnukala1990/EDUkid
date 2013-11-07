package bu.edu.cs673.edukid.account;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.ImageUtils;
import bu.edu.cs673.edukid.db.model.UserAccount;

/**
 * The view which contains the user account information. The user account can be
 * seen and edited here.
 * 
 * @author Peter Trevino
 * 
 * @see UserAccount
 * 
 */
public class AccountCreationView extends Activity implements OnClickListener {

	private static final int TAKE_PICTURE = 1888;

	private static final long DATABASE_ERROR = -1;

	private String userName;

	private ImageView userImage;

	private Database database = Database.getInstance(this);

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.account_creation);
		userImage = (ImageView) findViewById(R.id.createUserImage);

		// Populate user account info from database (if any)
		List<UserAccount> userAccounts = database.getUserAccounts();

		if (userAccounts.size() == 1) {
			UserAccount userAccount = userAccounts.get(0);

			// Set user name
			EditText userNameTextField = ((EditText) findViewById(R.id.createEditChildName));
			userNameTextField.setText(userAccount.getUserName());

			// Set user image
			userImage.setImageDrawable(ImageUtils
					.byteArrayToDrawable(userAccount.getUserImage()));
		}

		// Add listeners
		Button createSaveButton = (Button) findViewById(R.id.createSaveButton);
		createSaveButton.setOnClickListener(this);
		Button createUploadPhotoButton = (Button) findViewById(R.id.createUploadPhotoButton);
		createUploadPhotoButton.setOnClickListener(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.createSaveButton:
			saveUserAccount();
			break;
		case R.id.createUploadPhotoButton:
			// TODO: we should have other options other than the camera like
			// picking from the camera roll
			startCamera();
			break;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == TAKE_PICTURE && resultCode == RESULT_OK) {
			Bitmap photo = (Bitmap) data.getExtras().get("data");

			if (photo != null) {
				userImage.setImageBitmap(photo);
			}
		}
	}

	/**
	 * Saves the user account in the database.
	 */
	private void saveUserAccount() {
		userName = ((EditText) findViewById(R.id.createEditChildName))
				.getText().toString();
		List<UserAccount> userAccounts = database.getUserAccounts();
		long result = DATABASE_ERROR;

		if (userAccounts.size() == 0) {
			result = database.addUserAccount(userName, userImage.getDrawable());
		} else if (userAccounts.size() == 1) {
			UserAccount userAccount = userAccounts.get(0);
			userAccount.setUserName(userName);
			userAccount.setUserImage(ImageUtils.drawableToByteArray(userImage
					.getDrawable()));
			result = database.editUserAccount(userAccount);
		} else {
			// TODO: implement more than 1 user. Should not get here now.
		}

		if (result != DATABASE_ERROR) {
			Toast.makeText(this, "User account saved successfully!",
					Toast.LENGTH_LONG).show();
		} else {
			// TODO: inform user of error
		}
	}

	/**
	 * Starts the front facing camera to take a picture.
	 */
	private void startCamera() {
		Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
		startActivityForResult(intent, TAKE_PICTURE);
	}
}
