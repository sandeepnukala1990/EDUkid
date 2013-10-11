package bu.edu.cs673.edukid.account;

import bu.edu.cs673.edukid.R;
import android.app.Activity;
import android.os.Bundle;
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
			System.out.println(childName.toString());
		}
	}
}
