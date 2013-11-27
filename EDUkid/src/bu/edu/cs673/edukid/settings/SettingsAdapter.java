package bu.edu.cs673.edukid.settings;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.DatabaseHelper;
import bu.edu.cs673.edukid.db.model.DefaultWordMapping;
import bu.edu.cs673.edukid.db.model.Word;

public class SettingsAdapter extends ArrayAdapter<String> implements
		OnCheckedChangeListener {

	private Context context;

	private int resource;

	private List<SettingsRow> settingsRows;

	private int categoryIndex;

	private int itemIndex;

	/**
	 * Constructor.
	 * 
	 * <p>
	 * Used for the generic settings lists that don't require a check box.
	 * </p>
	 * 
	 * @param context
	 *            the context.
	 * @param resource
	 *            the list resource id.
	 * @param settingsRows
	 *            the settings row objects in the list.
	 */
	public SettingsAdapter(Context context, int resource,
			List<SettingsRow> settingsRows) {
		this(context, resource, settingsRows, -1, -1);
	}

	/**
	 * Constructor.
	 * 
	 * <p>
	 * Used for the complex settings lists that do require a check box.
	 * </p>
	 * 
	 * @param context
	 *            the context.
	 * @param resource
	 *            the list resource id.
	 * @param settingsRows
	 *            the settings row objects in the list.
	 * @param categoryIndex
	 *            the category index.
	 * @param itemIndex
	 *            the item index.
	 */
	public SettingsAdapter(Context context, int resource,
			List<SettingsRow> settingsRows, int categoryIndex, int itemIndex) {
		super(context, resource);

		for (SettingsRow settingsRow : settingsRows) {
			add(settingsRow.getItem());
		}

		this.context = context;
		this.resource = resource;
		this.settingsRows = settingsRows;
		this.categoryIndex = categoryIndex;
		this.itemIndex = itemIndex;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater layoutInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = layoutInflater.inflate(resource, parent, false);

		SettingsRow settingsRow = settingsRows.get(position);

		// Set image
		ImageView rowImage = (ImageView) rowView.findViewById(R.id.rowImage);
		rowImage.setImageDrawable(settingsRow.getImage());

		// Set text
		TextView rowText = (TextView) rowView.findViewById(R.id.rowText);
		rowText.setText(settingsRow.getItem());

		CheckBox checkBox = (CheckBox) rowView.findViewById(R.id.rowCheckBox);

		switch (settingsRow.getCheckedState()) {
		case YES:
			checkBox.setChecked(true);
			break;
		case NO:
			checkBox.setChecked(false);
			break;
		case HIDDEN:
		default:
			checkBox.setVisibility(View.INVISIBLE);
			break;
		}

		checkBox.setId(position);
		checkBox.setOnCheckedChangeListener(this);

		return rowView;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * <p>
	 * Note: this will only get called if the complex constructor above is
	 * called.
	 * </p>
	 */
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		Database database = Database.getInstance();
		int rowIndex = buttonView.getId();

		if (settingsRows.get(rowIndex).isDefaultWord()) {
			database.updateDefaultWordMapping(categoryIndex, itemIndex,
					buttonView.getId(), isChecked);
		} else {
			List<DefaultWordMapping> defaultWordMappings = database
					.getDefaultWordMapping(DatabaseHelper
							.generateDefaultMappingSelection(categoryIndex,
									itemIndex));
			int databaseRowIndex = rowIndex - defaultWordMappings.size();

			Word word = database.getWords(
					DatabaseHelper.generateWordsSelection(itemIndex,
							databaseRowIndex)).get(0);
			word.setChecked(isChecked);
			database.updateWord(itemIndex, databaseRowIndex, word);
		}
	}
}
