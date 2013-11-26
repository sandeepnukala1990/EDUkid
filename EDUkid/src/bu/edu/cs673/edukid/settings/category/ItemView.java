package bu.edu.cs673.edukid.settings.category;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import bu.edu.cs673.edukid.EDUkid;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.model.Word;
import bu.edu.cs673.edukid.db.model.category.CategoryType;
import bu.edu.cs673.edukid.settings.SettingsAdapter;
import bu.edu.cs673.edukid.settings.SettingsView;

public class ItemView extends ListActivity implements OnItemClickListener {

	private CategoryType categoryType;

	private int itemIndex;

	private SettingsAdapter wordsAdapter;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item);

		Intent intent = getIntent();
		Bundle extras = intent.getExtras();

		categoryType = (CategoryType) extras
				.getSerializable(EDUkid.CATEGORY_TYPE);
		itemIndex = extras.getInt(EDUkid.ITEM_INDEX);

		// Set item name
		TextView itemName = (TextView) findViewById(R.id.itemName);
		itemName.setText(categoryType.getItem(itemIndex));

		// Set item sound
		// TODO

		// Show/hide delete item button
		Button deleteItemButton = (Button) findViewById(R.id.deleteItemButton);
		deleteItemButton
				.setVisibility(categoryType.canAddItems() ? View.VISIBLE
						: View.INVISIBLE);

		// Setup adapter
		setupWordList();
		getListView().setOnItemClickListener(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onResume() {
		super.onResume();
		setupWordList();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent = new Intent(this, WordView.class);
		intent.putExtra(EDUkid.CATEGORY_TYPE, categoryType);
		intent.putExtra(EDUkid.ITEM_INDEX, itemIndex);
		intent.putExtra(EDUkid.WORD_INDEX, position);
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
	 * Save item on click callback.
	 * 
	 * @param view
	 *            the view.
	 */
	public void onSaveItemClick(View view) {
		// TODO: implement this
		Toast.makeText(this, "Save item coming soon...", Toast.LENGTH_LONG)
				.show();
	}

	/**
	 * Add word on click callback.
	 * 
	 * @param view
	 *            the view.
	 */
	public void onAddWordClick(View view) {
		Intent intent = new Intent(this, AddWordView.class);
		intent.putExtra(EDUkid.CATEGORY_TYPE, categoryType);
		intent.putExtra(EDUkid.ITEM_INDEX, itemIndex);
		startActivity(intent);
	}

	private void setupWordList() {
		Word[] words = categoryType.getSettingsItemWords(itemIndex);

		List<String> listItems = new ArrayList<String>();
		List<Drawable> listDrawables = new ArrayList<Drawable>();
		List<Boolean> listCheckBoxes = new ArrayList<Boolean>();

		for (int i = 0; i < words.length; i++) {
			Word word = words[i];

			listItems.add(word.getWord());
			listDrawables.add(getResources().getDrawable(
					categoryType.getSettingsItemDrawableId(itemIndex, i)));
			listCheckBoxes.add(word.isChecked());
		}

		wordsAdapter = new SettingsAdapter(this, R.layout.settings_row,
				listItems, listDrawables, listCheckBoxes,
				categoryType.getCategoryId(), itemIndex);
		setListAdapter(wordsAdapter);
		wordsAdapter.notifyDataSetChanged();
	}
}
