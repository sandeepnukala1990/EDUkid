package bu.edu.cs673.edukid.settings.category;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import bu.edu.cs673.edukid.EDUkid;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.model.category.CategoryType;

public class CategoriesView extends ListActivity implements OnItemClickListener {

	private List<String> listItems = new ArrayList<String>();

	private ArrayAdapter<String> arrayAdapter;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.categories);

		for (CategoryType category : Database.getInstance(this).getCategories()) {
			listItems.add(category.getCategoryName());
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
		CategoryType categoryType = Database.getInstance(this).getCategories()
				.get(position);

		Intent intent = new Intent(this, CategoryItemsView.class);
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
		startActivity(new Intent(this, AddCategoryView.class));
	}
}
