package bu.edu.cs673.edukid.account;

import java.io.IOException;
import java.io.OutputStreamWriter;

import bu.edu.cs673.edukid.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class AccountCreationView extends Activity implements OnClickListener{
	private String childName;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.account_creation);
		
		Button createSaveButton = (Button) findViewById(R.id.createSaveButton);
		createSaveButton.setOnClickListener(this);
	}
	public void onClick(View view){
		if(view.getId()==R.id.createSaveButton){
			childName=((EditText) findViewById(R.id.createEditChildName)).getText().toString();
			System.out.println(childName);
//			writeToFile(childName);
		}
	}
//	private void writeToFile(String data) {
//	    try {
//	        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("config.txt", Context.MODE_PRIVATE));
//	        outputStreamWriter.write(data);
//	        outputStreamWriter.close();
//	    }
//	    catch (IOException e) {
//	        Log.e("Exception", "File write failed: " + e.toString());
//	    } 
//	}
}
