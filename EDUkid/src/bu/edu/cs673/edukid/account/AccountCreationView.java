package bu.edu.cs673.edukid.account;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import bu.edu.cs673.edukid.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.media.*;


public class AccountCreationView extends Activity implements OnClickListener{
	private static final int TAKE_PICTURE = 0;
	private String childName;
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
		if(view.getId()==R.id.createSaveButton){
			childName=readFromFile();
			System.out.println(childName);
			childName=((EditText) findViewById(R.id.createEditChildName)).getText().toString();
			writeToFile(childName);
			childName="foobar";
			childName=readFromFile();
		}
		else if(view.getId()==R.id.createUploadPhotoButton){
			
			imageFromCamera();
		}
	}
	private void writeToFile(String data) {
		try {
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("username.txt", Context.MODE_PRIVATE));
			outputStreamWriter.write(data);
			outputStreamWriter.close();
		}
		catch (IOException e) {
			Log.e("Exception", "File write failed: " + e.toString());
		} 
	}
	private String readFromFile() {

		String ret = "";

		try {
			InputStream inputStream = openFileInput("username.txt");

			if ( inputStream != null ) {
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String receiveString = "";
				StringBuilder stringBuilder = new StringBuilder();

				while ( (receiveString = bufferedReader.readLine()) != null ) {
					stringBuilder.append(receiveString);
				}

				inputStream.close();
				ret = stringBuilder.toString();
				if(ret.compareTo("")!=0){
					accountExists=true;
				}
				else
					accountExists=false;
			}
		}
		catch (FileNotFoundException e) {
			Log.e("login activity", "File not found: " + e.toString());
		} catch (IOException e) {
			Log.e("login activity", "Can not read file: " + e.toString());
		}

		return ret;
	}
	public boolean userExists(){
		readFromFile();
		return accountExists;
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
