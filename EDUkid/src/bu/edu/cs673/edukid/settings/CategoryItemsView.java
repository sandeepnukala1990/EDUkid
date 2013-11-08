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
import android.widget.Toast;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.model.CategoryType;
import bu.edu.cs673.edukid.db.model.Letter;

public class CategoryItemsView extends ListActivity implements
		OnItemClickListener {

	private List<String> listItems = new ArrayList<String>();

	private ArrayAdapter<String> arrayAdapter;

	private CategoryType categoryType;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.category_items);

		Intent intent = getIntent();
		Bundle extras = intent.getExtras();

		categoryType = (CategoryType) extras.get("CategoryType");

		Database database = Database.getInstance(this);

		// TODO: add other types smarter
		if (categoryType == CategoryType.ALPHABET) {
			for (Letter letter : database.getLetters()) {
				listItems.add(letter.getLetter());
			}
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
		// TODO
	}

	public void onAddCategoryItemClick(View view) {
		// TODO
		Toast.makeText(this, "Add Category Item", Toast.LENGTH_LONG).show();
	}
}
