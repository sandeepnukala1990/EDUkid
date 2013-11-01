package bu.edu.cs673.edukid.learn;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.model.CategoryType;

public class WordFragmentPagerAdapter extends FragmentPagerAdapter {

	private CategoryType categoryType;

	private int itemIndex;

	public WordFragmentPagerAdapter(FragmentManager fragmentManager,
			CategoryType categoryType, int itemIndex) {
		super(fragmentManager);
		this.categoryType = categoryType;
		this.itemIndex = itemIndex;
	}

	@Override
	public Fragment getItem(int wordIndex) {
		Fragment fragment = new WordFragment();
		Bundle arguments = new Bundle();
		Database database = Database.getInstance();

		// TODO: should be a database query
		arguments.putInt(WordFragment.ARG_IMAGE,
				database.getItemImage(categoryType, itemIndex, wordIndex));

		// TODO: should be a database query
		arguments.putString(WordFragment.ARG_WORD,
				database.getItemWord(categoryType, itemIndex, wordIndex));

		fragment.setArguments(arguments);

		return fragment;
	}

	@Override
	public int getCount() {
		return Database.getInstance().getItemWordCount(categoryType, itemIndex);
	}
}
