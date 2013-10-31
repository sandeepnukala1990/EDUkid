package bu.edu.cs673.edukid.learn;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class WordFragmentPagerAdapter extends FragmentPagerAdapter {

	private LearnType learnType;

	private int index;

	public WordFragmentPagerAdapter(FragmentManager fragmentManager,
			LearnType learnType, int index) {
		super(fragmentManager);
		this.learnType = learnType;
		this.index = index;
	}

	@Override
	public Fragment getItem(int i) {
		Fragment fragment = new WordFragment();
		Bundle arguments = new Bundle();

		// TODO: should be a database query
		arguments.putInt(WordFragment.ARG_IMAGE, learnType.getDefaultImage(i));

		// TODO: should be a database query
		arguments.putString(WordFragment.ARG_WORD,
				learnType.getAlphabetWords(index)[i]);

		fragment.setArguments(arguments);

		return fragment;
	}

	@Override
	public int getCount() {
		return learnType.getAlphabetWords(index).length;
	}
}
