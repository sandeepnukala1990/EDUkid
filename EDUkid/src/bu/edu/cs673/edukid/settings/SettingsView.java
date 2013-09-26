package bu.edu.cs673.edukid.settings;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import bu.edu.cs673.edukid.MainView;
import bu.edu.cs673.edukid.R;

public class SettingsView extends PreferenceActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
	}
	
	public void onBackClick(View view) {
		Intent intent = new Intent(this, MainView.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
	}
}
