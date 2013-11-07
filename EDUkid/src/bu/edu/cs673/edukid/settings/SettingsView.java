package bu.edu.cs673.edukid.settings;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.account.AccountCreationView;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.model.Category;
import bu.edu.cs673.edukid.db.model.CategoryType;

public class SettingsView extends ListActivity implements OnItemClickListener {

	private List<String> listItems = new ArrayList<String>();

	private ArrayAdapter<String> arrayAdapter;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);

		Database database = Database.getInstance(this);

		for (Category category : database.getCategories()) {
			listItems.add(category.getName());
		}

		arrayAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, listItems);
		setListAdapter(arrayAdapter);
		getListView().setOnItemClickListener(this);

		arrayAdapter.notifyDataSetChanged();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		String listItem = listItems.get(position);
		CategoryType categoryType = CategoryType
				.valueOf(listItem.toUpperCase());

		Intent intent = new Intent(this, AddCategoryView.class);
		intent.putExtra("CategoryType", categoryType);
		startActivity(intent);
	}

	public void onAddCategoryClick(View view) {
		startActivity(new Intent(this, AddCategoryView.class));
	}

	public void onUserAccountClick(View view) {
		startActivity(new Intent(this, AccountCreationView.class));
	}
}
