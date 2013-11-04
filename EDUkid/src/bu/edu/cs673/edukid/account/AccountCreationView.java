package bu.edu.cs673.edukid.account;

import java.io.File;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.model.UserAccount;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class AccountCreationView extends Activity implements OnClickListener{
	
	private static final int TAKE_PICTURE = 0;
	String childName;
	public boolean accountExists;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.account_creation);

		Button createSaveButton = (Button) findViewById(R.id.createSaveButton);
		createSaveButton.setOnClickListener(this);
		ImageView createUserImage = (ImageView) findViewById(R.id.createUserImage); 
		Button createUploadPhotoButton = (Button)findViewById(R.id.createUploadPhotoButton);
		createUploadPhotoButton.setOnClickListener(this);
	}
	public void onClick(View view){
		Database database = Database.getInstance(this);
		if(view.getId()==R.id.createSaveButton){
			UserAccount userAccount = database.getUserAccounts().get(0);
			childName=((EditText) findViewById(R.id.createEditChildName)).getText().toString();
			userAccount.setUserName(childName);
		}
		else if(view.getId()==R.id.createUploadPhotoButton){
			
			imageFromCamera();
		}
	}
	public void imageFromCamera() {
	    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
	    File mImageFile = new File(Environment.getExternalStorageDirectory()+File.separator+"MyApp",  
	            "PIC"+System.currentTimeMillis()+".jpg");
	    String mSelectedImagePath = mImageFile.getAbsolutePath();
	    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mImageFile));
	    startActivityForResult(intent, TAKE_PICTURE);
	}
}
