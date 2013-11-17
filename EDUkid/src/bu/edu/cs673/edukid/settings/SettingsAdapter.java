package bu.edu.cs673.edukid.settings;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import bu.edu.cs673.edukid.R;

import com.terlici.dragndroplist.DragNDropAdapter;
import com.terlici.dragndroplist.DragNDropListView;

public class SettingsAdapter extends ArrayAdapter<String> implements
		DragNDropAdapter {

	private Context context;

	private int resource;

	private List<String> listItems;

	private List<Drawable> listDrawables;

	private List<Boolean> listCheckBoxes;

	public SettingsAdapter(Context context, int resource,
			List<String> listItems, List<Drawable> listDrawables) {
		this(context, resource, listItems, listDrawables, null);
	}

	public SettingsAdapter(Context context, int resource,
			List<String> listItems, List<Drawable> listDrawables,
			List<Boolean> listCheckBoxes) {
		super(context, resource, listItems);
		this.context = context;
		this.resource = resource;
		this.listItems = listItems;
		this.listDrawables = listDrawables;
		this.listCheckBoxes = listCheckBoxes;
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
			checkBox.setVisibility(listCheckBoxes.get(position) ? View.VISIBLE
					: View.INVISIBLE);
		}

		// TODO: set this based on the default status
		// TODO: then set this based on the new default image database table
		// Set check box
		checkBox.setChecked(true);

		return rowView;
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
		String item = listItems.remove(startPosition);
		listItems.add(endPosition, item);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getDragHandler() {
		// TODO: if we use this, then make a drag icon with 3 horizontal lines
		return R.id.rowImage;
	}

	public List<String> getListItems() {
		return listItems;
	}
}
