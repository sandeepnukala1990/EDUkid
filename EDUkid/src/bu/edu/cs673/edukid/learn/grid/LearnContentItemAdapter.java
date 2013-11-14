package bu.edu.cs673.edukid.learn.grid;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import bu.edu.cs673.edukid.db.model.category.CategoryType;

public class LearnContentItemAdapter extends BaseAdapter {

	private Context context;

	private CategoryType categoryType;

	/**
	 * Constructor.
	 * 
	 * @param context
	 *            the context.
	 * @param categoryType
	 *            the category type.
	 */
	public LearnContentItemAdapter(Context context, CategoryType categoryType) {
		this.context = context;
		this.categoryType = categoryType;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getCount() {
		return categoryType.getItemCount();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getItem(int index) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long getItemId(int index) {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public View getView(int itemIndex, View convertView, ViewGroup parent) {
		TextView learnContentItem;

		if (convertView == null) {
			learnContentItem = new TextView(context);
			learnContentItem
					.setLayoutParams(new GridView.LayoutParams(100, 100));
			learnContentItem.setGravity(Gravity.CENTER);
			learnContentItem.setTextSize(50);
		} else {
			learnContentItem = (TextView) convertView;
		}

		learnContentItem.setText(categoryType.getItem(itemIndex));

		return learnContentItem;
	}
}
