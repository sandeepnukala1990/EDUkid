package bu.edu.cs673.edukid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import bu.edu.cs673.edukid.learn.LearnContentView;
import bu.edu.cs673.edukid.learn.LearnType;
import bu.edu.cs673.edukid.settings.SettingsView;

public class MainView extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		setupLearnButtons();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onClick(View v) {
		LearnType learnType;
		
		switch (v.getId()) {
		case R.id.learnAlphabetButton:
			learnType = LearnType.ALPHABET;
			break;
		case R.id.learnNumbersButton:
			learnType = LearnType.NUMBERS;
			break;
		case R.id.learnShapesButton:
			learnType = LearnType.SHAPES;
			break;
		case R.id.learnColorsButton:
			learnType = LearnType.COLORS;
			break;
		default:
			// TODO: need to send which custom type to the learn content view
			learnType = LearnType.CUSTOM;
			break;
		}
		
		Intent intent = new Intent(this, LearnContentView.class);
		intent.putExtra("LearnType", learnType);
		startActivity(intent);
	}
	
	private void setupLearnButtons() {
		ImageButton learnAlphabetButton = (ImageButton) findViewById(R.id.learnAlphabetButton);
		learnAlphabetButton.setOnClickListener(this);
		
		ImageButton learnNumbersButton = (ImageButton) findViewById(R.id.learnNumbersButton);
		learnNumbersButton.setOnClickListener(this);
		
		ImageButton learnShapesButton = (ImageButton) findViewById(R.id.learnShapesButton);
		learnShapesButton.setOnClickListener(this);
		
		ImageButton learnColorsButton = (ImageButton) findViewById(R.id.learnColorsButton);
		learnColorsButton.setOnClickListener(this);
	}

	public void onExitClick(View view) {
		finish();
	}
	
	public void onSettingsClick(View view) {
		startActivity(new Intent(this, SettingsView.class));
	}
}
