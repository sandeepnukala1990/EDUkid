package bu.edu.cs673.edukid.settings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.account.AccountCreationView;

public class SettingsView extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
	}

	public void onAccountDetailsClick(View view) {
		startActivity(new Intent(this, AccountCreationView.class));
	}
}
