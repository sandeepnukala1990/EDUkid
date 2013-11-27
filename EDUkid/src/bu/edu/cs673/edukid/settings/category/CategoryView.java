package bu.edu.cs673.edukid.settings.category;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import bu.edu.cs673.edukid.EDUkid;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.model.category.CategoryType;
import bu.edu.cs673.edukid.settings.SettingsAdapter;
import bu.edu.cs673.edukid.settings.SettingsRow;
import bu.edu.cs673.edukid.settings.SettingsView;

public class CategoryView extends ListActivity implements OnItemClickListener {

	private CategoryType categoryType;

	private SettingsAdapter itemsAdapter;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.category);

		Intent intent = getIntent();
		Bundle extras = intent.getExtras();

		categoryType = (CategoryType) extras
				.getSerializable(EDUkid.CATEGORY_TYPE);

		// Set category name
		TextView categoryName = (TextView) findViewById(R.id.categoryName);
		categoryName.setText(categoryType.getCategoryName());
		categoryName.setFocusable(false);
		categoryName.setFocusableInTouchMode(false);
		categoryName.setClickable(false);

		// Set category image
		ImageView categoryImage = (ImageView) findViewById(R.id.categoryImage);
		categoryImage.setImageDrawable(categoryType.getCategoryImage(this));

		// Show/hide add item button
		Button addItemButton = (Button) findViewById(R.id.addItembutton);
		addItemButton.setVisibility(categoryType.canAddItems() ? View.VISIBLE
				: View.INVISIBLE);

		// Setup items adapter
		List<SettingsRow> settingsRows = new ArrayList<SettingsRow>();
		String[] categoryItems = categoryType.getItems();
		Resources resources = getResources();

		for (int i = 0; i < categoryItems.length; i++) {
			// Show the first image for each item
			Drawable image = resources.getDrawable(categoryType
					.getSettingsItemDrawableId(i, 0));

			settingsRows.add(new SettingsRow(categoryItems[i], image));
		}

		itemsAdapter = new SettingsAdapter(this, R.layout.settings_row,
				settingsRows);
		setListAdapter(itemsAdapter);
		getListView().setOnItemClickListener(this);

		itemsAdapter.notifyDataSetChanged();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent = new Intent(this, ItemView.class);
		intent.putExtra(EDUkid.CATEGORY_TYPE, categoryType);
		intent.putExtra(EDUkid.ITEM_INDEX, position);
		startActivity(intent);
	}

	/**
	 * Add item on click callback.
	 * 
	 * @param view
	 *            the view.
	 */
	public void onAddItemClick(View view) {
		Toast.makeText(this, "Add item coming soon...", Toast.LENGTH_SHORT)
				.show();
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
