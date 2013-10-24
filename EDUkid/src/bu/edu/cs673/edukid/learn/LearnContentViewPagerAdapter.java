package bu.edu.cs673.edukid.learn;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

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

		bundle.putInt(LearnContentViewFragment.ARG_LEARN_TYPE,
				learnType.ordinal());

		bundle.putInt(LearnContentViewFragment.ARG_IMAGE,
				learnType.getDefaultImage(i));

		bundle.putStringArray(LearnContentViewFragment.ARG_WORDS,
				learnType.getDefaultWords(i));

		bundle.putString(LearnContentViewFragment.ARG_ITEM,
				learnType.getItem(i));

		bundle.putString(LearnContentViewFragment.ARG_PHONETIC_SOUND,
				learnType.getDefaultSound(i));

		fragment.setArguments(bundle);

		return fragment;
	}

	@Override
	public int getCount() {
		return learnType.getItems().length;
	}
}
