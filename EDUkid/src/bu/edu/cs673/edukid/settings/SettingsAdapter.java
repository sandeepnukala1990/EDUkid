package bu.edu.cs673.edukid.settings;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.Database;

public class SettingsAdapter extends ArrayAdapter<String> implements
		OnCheckedChangeListener {

	private Context context;

	private int resource;

	private List<String> listItems;

	private List<Drawable> listDrawables;

	private List<Boolean> listCheckBoxes;

	private int categoryIndex;

	private int itemIndex;

	public SettingsAdapter(Context context, int resource,
			List<String> listItems, List<Drawable> listDrawables) {
		this(context, resource, listItems, listDrawables, null);
	}

	public SettingsAdapter(Context context, int resource,
			List<String> listItems, List<Drawable> listDrawables,
			List<Boolean> listCheckBoxes) {
		this(context, resource, listItems, listDrawables, listCheckBoxes, -1,
				-1);
	}

	public SettingsAdapter(Context context, int resource,
			List<String> listItems, List<Drawable> listDrawables,
			List<Boolean> listCheckBoxes, int categoryIndex, int itemIndex) {
		super(context, resource, listItems);
		this.context = context;
		this.resource = resource;
		this.listItems = listItems;
		this.listDrawables = listDrawables;
		this.listCheckBoxes = listCheckBoxes;
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

		// Set image
		ImageView rowImage = (ImageView) rowView.findViewById(R.id.rowImage);
		rowImage.setImageDrawable(listDrawables.get(position));

		// Set text
		TextView rowText = (TextView) rowView.findViewById(R.id.rowText);
		rowText.setText(listItems.get(position));

		CheckBox checkBox = (CheckBox) rowView.findViewById(R.id.rowCheckBox);

		if (listCheckBoxes == null) {
			checkBox.setVisibility(View.INVISIBLE);
		} else {
			checkBox.setChecked(listCheckBoxes.get(position));
		}

		// TODO: then set this based on the new default image database table
		checkBox.setId(position);
		checkBox.setOnCheckedChangeListener(this);

		return rowView;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO: if it is a default word update the default mapping, else update
		// the word table
		Database.getInstance().updateDefaultWordMapping(categoryIndex,
				itemIndex, buttonView.getId(), isChecked);
	}
}
