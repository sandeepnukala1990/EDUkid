package bu.edu.cs673.edukid.settings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.settings.category.CategoriesView;
import bu.edu.cs673.edukid.settings.useraccount.UserAccountView;

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

	/**
	 * User account on click callback.
	 * 
	 * @param view
	 *            the view.
	 */
	public void onUserAccountClick(View view) {
		startActivity(new Intent(this, UserAccountView.class));
	}

	/**
	 * Categories on click callback.
	 * 
	 * @param view
	 *            the view.
	 */
	public void onCategoriesClick(View view) {
		startActivity(new Intent(this, CategoriesView.class));
	}

	/**
	 * Timer on click callback.
	 * 
	 * @param view
	 *            the view.
	 */
	public void onTimerClick(View view) {
		Toast.makeText(this, "Timer coming soon...", Toast.LENGTH_LONG).show();
	}
}
