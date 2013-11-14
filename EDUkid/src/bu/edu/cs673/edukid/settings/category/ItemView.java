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
import android.widget.TextView;
import android.widget.Toast;
import bu.edu.cs673.edukid.EDUkid;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.model.category.CategoryType;
import bu.edu.cs673.edukid.settings.SettingsAdapter;

import com.terlici.dragndroplist.DragNDropListView;
import com.terlici.dragndroplist.DragNDropListView.OnItemDragNDropListener;

public class ItemView extends ListActivity implements OnItemClickListener,
		OnItemDragNDropListener {

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

		// Setup items adapter
		Resources resources = getResources();
		List<String> listItems = categoryType.getItemWords(itemIndex);
		List<Drawable> listDrawables = new ArrayList<Drawable>();

		for (int i = 0; i < listItems.size(); i++) {
			int drawableId = categoryType.getItemImage(itemIndex, i);
			listDrawables.add(resources.getDrawable(drawableId));
		}

		DragNDropListView wordList = (DragNDropListView) findViewById(android.R.id.list);
		wordsAdapter = new SettingsAdapter(this, R.layout.settings_row,
				categoryType.getItemWords(itemIndex), listDrawables);
		setListAdapter(wordsAdapter);

		wordList.setDragNDropAdapter(wordsAdapter);

		wordList.setOnItemClickListener(this);
		wordList.setOnItemDragNDropListener(this);

		wordsAdapter.notifyDataSetChanged();
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
	 * {@inheritDoc}
	 */
	@Override
	public void onItemDrag(DragNDropListView parent, View view, int position,
			long id) {
		// NO-OP
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onItemDrop(DragNDropListView parent, View view,
			int startPosition, int endPosition, long id) {
		// TODO: change the order in database
		System.out.println("-- id: " + id);
		System.out.println("-- start: " + startPosition);
		System.out.println("-- end: " + endPosition);
		System.out.println("-------------------");

		for (String listItem : wordsAdapter.getListItems()) {
			System.out.println("\t** list item: " + listItem);
		}

		System.out.println("-------------------");
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
		// TODO: implement this
		Toast.makeText(this, "Add word coming soon...", Toast.LENGTH_LONG)
				.show();
	}
}
