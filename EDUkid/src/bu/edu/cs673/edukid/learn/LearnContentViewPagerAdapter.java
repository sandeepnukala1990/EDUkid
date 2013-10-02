package bu.edu.cs673.edukid.learn;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import bu.edu.cs673.edukid.R;

public class LearnContentViewPagerAdapter extends FragmentStatePagerAdapter {

	private LearnType learnType;

	public LearnContentViewPagerAdapter(FragmentManager fragmentManager,
			LearnType learnType) {
		super(fragmentManager);
		this.learnType = learnType;
	}

	@Override
	public Fragment getItem(int i) {
		Fragment fragment = new LearnContentViewFragment();
		Bundle bundle = new Bundle();

		bundle.putInt(LearnContentViewFragment.ARG_IMAGE,
				learnType.getDefaultImage(i));

		bundle.putString(LearnContentViewFragment.ARG_WORD,
				learnType.getDefaultWord(i));

		bundle.putString(LearnContentViewFragment.ARG_ITEM,
				learnType.getItem(i));
		fragment.setArguments(bundle);

		return fragment;
	}

	@Override
	public int getCount() {
		return learnType.getItems().length;
	}

	public static class LearnContentViewFragment extends Fragment {

		public static final String ARG_IMAGE = "Image";
		public static final String ARG_WORD = "Word";
		public static final String ARG_ITEM = "Item";

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View view = inflater.inflate(R.layout.learn_content_fragment,
					container, false);
			Bundle bundle = getArguments();

			// Set content image
			ImageButton learnContentButton = (ImageButton) view
					.findViewById(R.id.learnContentImage);
			learnContentButton.setImageResource(bundle.getInt(ARG_IMAGE));

			// Set content word
			TextView learnContentWord = (TextView) view
					.findViewById(R.id.learnContentWord);
			learnContentWord.setText(bundle.getString(ARG_WORD));

			// Set content item
			TextView learnContentItem = (TextView) view
					.findViewById(R.id.learnContentItem);
			learnContentItem.setText(bundle.getString(ARG_ITEM));

			return view;
		}
	}
}
