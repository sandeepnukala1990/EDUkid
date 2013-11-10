package bu.edu.cs673.edukid.settings.category;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import bu.edu.cs673.edukid.EDUkid;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.model.category.CategoryType;
import bu.edu.cs673.edukid.settings.SettingsAdapter;

public class CategoriesView extends ListActivity implements OnItemClickListener {

	private SettingsAdapter categoryAdapter;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.categories);

		List<String> listItems = new ArrayList<String>();
		List<Drawable> listDrawables = new ArrayList<Drawable>();

		for (CategoryType category : Database.getInstance(this).getCategories()) {
			listItems.add(category.getCategoryName());
			listDrawables.add(category.getCategoryImage(this));
		}

		categoryAdapter = new SettingsAdapter(this, R.layout.settings_row,
				listItems, listDrawables);
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
		CategoryType categoryType = Database.getInstance(this).getCategories()
				.get(position);

		Intent intent = new Intent(this, CategoryView.class);
		intent.putExtra(EDUkid.CATEGORY_TYPE, categoryType);
		startActivity(intent);
	}

	/**
	 * Add category on click callback.
	 * 
	 * @param view
	 *            the view.
	 */
	public void onAddCategoryClick(View view) {
		// TODO: implement this
		Toast.makeText(this, "Add category coming soon...", Toast.LENGTH_SHORT)
				.show();
	}
}
