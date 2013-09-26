package bu.edu.cs673.edukid.learn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import bu.edu.cs673.edukid.EDUkid;
import bu.edu.cs673.edukid.R;

public class LearnContentView extends Activity {
	
	private LearnType learnType;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.learn_content);
		
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		
		learnType = (LearnType) extras.get("LearnType");
		
		TextView name = (TextView) findViewById(R.id.learnContentName);
		name.setText(learnType.getName());
	}
	
	public void onBackClick(View view) {
		Intent intent = new Intent(this, EDUkid.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
	}
}
