package bu.edu.cs673.edukid.settings;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import bu.edu.cs673.edukid.EDUkid;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.account.AccountCreationView;

public class SettingsView extends PreferenceActivity {

	private ArrayList<String> listItems = new ArrayList<String>();

	private ArrayAdapter<String> adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);

		initList();
	}

	public void onBackClick(View view) {
		Intent intent = new Intent(this, EDUkid.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
	}

	public void onAccountDetailsClick(View view) {
		startActivity(new Intent(this, AccountCreationView.class));
	}

	private void initList() {

		listItems.add("Test 1");
		listItems.add("Test 2");
		listItems.add("Test 3");
		listItems.add("Test 4");

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, listItems);
		setListAdapter(adapter);
	}
}
