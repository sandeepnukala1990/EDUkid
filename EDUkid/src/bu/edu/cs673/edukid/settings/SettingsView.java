package bu.edu.cs673.edukid.settings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.account.AccountCreationView;

public class SettingsView extends Activity implements OnItemClickListener {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
	}

	public void onUserAccountClick(View view) {
		startActivity(new Intent(this, AccountCreationView.class));
	}

	public void onCategoriesClick(View view) {
		startActivity(new Intent(this, CategoriesView.class));
	}

	public void onTimerClick(View view) {
		// TODO
	}
}
