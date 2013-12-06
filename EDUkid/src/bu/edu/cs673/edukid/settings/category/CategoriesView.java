package bu.edu.cs673.edukid.settings.category;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import bu.edu.cs673.edukid.EDUkid;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.model.category.CategoryType;
import bu.edu.cs673.edukid.settings.SettingsAdapter;
import bu.edu.cs673.edukid.settings.SettingsRow;
import bu.edu.cs673.edukid.settings.SettingsView;

public class CategoriesView extends ListActivity implements OnItemClickListener {

	private SettingsAdapter categoryAdapter;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.categories);

		List<SettingsRow> settingsRows = new ArrayList<SettingsRow>();

		for (CategoryType category : Database.getInstance(this).getCategories()) {
			settingsRows.add(new SettingsRow(category.getCategoryName(),
					category.getCategoryImage(this)));
		}

		categoryAdapter = new SettingsAdapter(this, R.layout.settings_row,
				settingsRows);
		setListAdapter(categoryAdapter);
		getListView().setOnItemClickListener(this);

		categoryAdapter.notifyDataSetChanged();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		CategoryType categoryType = Database.getInstance(this).getCategories()[position];

		Intent intent = new Intent(this, CategoryView.class);
		intent.putExtra(EDUkid.CATEGORY_TYPE, categoryType);
		startActivity(intent);
	}

	/**
	 * Settings home on click callback.
	 * 
	 * @param view
	 *            the view.
	 */
	public void onSettingsHomeClick(View view) {
		Intent intent = new Intent(this, SettingsView.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
	}
}
