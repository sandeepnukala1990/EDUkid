package bu.edu.cs673.edukid.settings.category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
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
		boolean canModifyCategory = categoryType.canModifyCategory();

		// Set category name
		TextView categoryName = (TextView) findViewById(R.id.categoryName);
		categoryName.setText(categoryType.getCategoryName());
		categoryName.setFocusable(canModifyCategory);
		categoryName.setFocusableInTouchMode(canModifyCategory);
		categoryName.setClickable(canModifyCategory);

		// Set category image
		ImageView categoryImage = (ImageView) findViewById(R.id.categoryImage);
		categoryImage.setImageDrawable(categoryType.getCategoryImage(this));

		// Show/hide add item button
		Button addItemButton = (Button) findViewById(R.id.addItembutton);
		addItemButton.setVisibility(categoryType.canAddItems() ? View.VISIBLE
				: View.INVISIBLE);

		// Show/hide save category button
		Button saveCategoryButton = (Button) findViewById(R.id.saveCategoryButton);
		saveCategoryButton.setVisibility(canModifyCategory ? View.VISIBLE
				: View.INVISIBLE);

		// Show/hide delete category button
		Button deleteCategoryButton = (Button) findViewById(R.id.deleteCategoryButton);
		deleteCategoryButton.setVisibility(canModifyCategory ? View.VISIBLE
				: View.INVISIBLE);

		// Setup items adapter
		List<String> listItems = Arrays.asList(categoryType.getItems());
		List<Drawable> listDrawables = new ArrayList<Drawable>();

		for (int i = 0; i < listItems.size(); i++) {
			// Show the first image for each item
			listDrawables.add(getResources().getDrawable(
					categoryType.getItemDrawableId(i, 0)));
		}

		itemsAdapter = new SettingsAdapter(this, R.layout.settings_row,
				Arrays.asList(categoryType.getItems()), listDrawables);
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

	/**
	 * Save category on click callback.
	 * 
	 * @param view
	 *            the view.
	 */
	public void onSaveCategoryClick(View view) {
		// TODO: implement this
		Toast.makeText(this, "Save category coming soon...", Toast.LENGTH_LONG)
				.show();
	}

	/**
	 * Category image on click callback.
	 * 
	 * @param view
	 *            the view.
	 */
	public void onCategoryImageClick(View view) {
		// Check to see if this image can be modified
		if (!categoryType.canModifyCategory()) {
			return;
		}

		// TODO: implement this if we leave the add category feature
		Toast.makeText(this, "Category image edit coming soon...",
				Toast.LENGTH_LONG).show();
	}

	/**
	 * Delete category on click callback.
	 * 
	 * @param view
	 *            the view.
	 */
	public void onDeleteCategoryClick(View view) {
		// TODO: implement this
		Toast.makeText(this, "Delete category coming soon...",
				Toast.LENGTH_LONG).show();
	}
}
