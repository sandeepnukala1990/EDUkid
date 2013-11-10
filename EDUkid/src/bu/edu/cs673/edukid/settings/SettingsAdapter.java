package bu.edu.cs673.edukid.settings;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

	public SettingsAdapter(Context context, int resource,
			List<String> listItems, List<Drawable> listDrawables) {
		super(context, resource, listItems);
		this.context = context;
		this.resource = resource;
		this.listItems = listItems;
		this.listDrawables = listDrawables;
	}

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

		return rowView;
	}

	@Override
	public void onItemDrag(DragNDropListView parent, View view, int position,
			long id) {
	}

	@Override
	public void onItemDrop(DragNDropListView parent, View view,
			int startPosition, int endPosition, long id) {
		String item = listItems.remove(startPosition);
		listItems.add(endPosition, item);
	}

	@Override
	public int getDragHandler() {
		return R.id.rowImage;
	}

	public List<String> getListItems() {
		return listItems;
	}
}
