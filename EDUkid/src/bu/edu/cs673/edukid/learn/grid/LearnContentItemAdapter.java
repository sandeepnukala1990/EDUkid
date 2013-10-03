package bu.edu.cs673.edukid.learn.grid;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import bu.edu.cs673.edukid.learn.LearnType;

public class LearnContentItemAdapter extends BaseAdapter {

	private Context context;

	private LearnType learnType;

	public LearnContentItemAdapter(Context context, LearnType learnType) {
		this.context = context;
		this.learnType = learnType;
	}

	@Override
	public int getCount() {
		return learnType.getItems().length;
	}

	@Override
	public Object getItem(int index) {
		return null;
	}

	@Override
	public long getItemId(int index) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
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

		learnContentItem.setText(learnType.getItem(position));

		return learnContentItem;
	}
}
