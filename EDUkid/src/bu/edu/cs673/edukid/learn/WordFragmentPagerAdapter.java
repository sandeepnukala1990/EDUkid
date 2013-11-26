package bu.edu.cs673.edukid.learn;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import bu.edu.cs673.edukid.EDUkid;
import bu.edu.cs673.edukid.db.model.category.CategoryType;

public class WordFragmentPagerAdapter extends FragmentPagerAdapter {

	private CategoryType categoryType;

	private int itemIndex;

	/**
	 * Constructor.
	 * 
	 * @param fragmentManager
	 *            the fragment manager.
	 * @param categoryType
	 *            the category type.
	 * @param itemIndex
	 *            the item index.
	 */
	public WordFragmentPagerAdapter(FragmentManager fragmentManager,
			CategoryType categoryType, int itemIndex) {
		super(fragmentManager);
		this.categoryType = categoryType;
		this.itemIndex = itemIndex;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Fragment getItem(int wordIndex) {
		Fragment fragment = new WordFragment();
		Bundle arguments = new Bundle();

		arguments.putSerializable(EDUkid.CATEGORY_TYPE, categoryType);

		arguments.putInt(EDUkid.ITEM_INDEX, itemIndex);

		arguments.putInt(EDUkid.WORD_INDEX, wordIndex);

		fragment.setArguments(arguments);

		return fragment;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getCount() {
		return categoryType.getLearnItemWordCount(itemIndex);
	}
}
