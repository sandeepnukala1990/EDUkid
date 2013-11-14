package bu.edu.cs673.edukid.learn;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import bu.edu.cs673.edukid.EDUkid;
import bu.edu.cs673.edukid.db.model.category.CategoryType;

public class LearnContentViewPagerAdapter extends FragmentStatePagerAdapter {

	private CategoryType categoryType;

	public LearnContentViewPagerAdapter(FragmentManager fragmentManager,
			CategoryType categoryType) {
		super(fragmentManager);
		this.categoryType = categoryType;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Fragment getItem(int itemIndex) {
		Fragment fragment = new LearnContentViewFragment();
		Bundle arguments = new Bundle();

		arguments.putSerializable(EDUkid.CATEGORY_TYPE, categoryType);

		arguments.putInt(EDUkid.ITEM_INDEX, itemIndex);

		fragment.setArguments(arguments);

		return fragment;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getCount() {
		return categoryType.getItemCount();
	}
}
