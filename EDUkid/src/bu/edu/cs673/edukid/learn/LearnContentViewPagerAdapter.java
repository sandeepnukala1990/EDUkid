package bu.edu.cs673.edukid.learn;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.model.CategoryType;

public class LearnContentViewPagerAdapter extends FragmentStatePagerAdapter {

	private CategoryType categoryType;

	public LearnContentViewPagerAdapter(FragmentManager fragmentManager,
			CategoryType categoryType) {
		super(fragmentManager);
		this.categoryType = categoryType;
	}

	@Override
	public Fragment getItem(int itemIndex) {
		Fragment fragment = new LearnContentViewFragment();
		Bundle arguments = new Bundle();
		Database database = Database.getInstance();

		arguments.putInt(LearnContentViewFragment.ARG_ITEM_INDEX, itemIndex);

		arguments.putInt(LearnContentViewFragment.ARG_CATEGORY_TYPE,
				categoryType.ordinal());

		arguments.putString(LearnContentViewFragment.ARG_ITEM,
				database.getItem(categoryType, itemIndex));

		arguments.putString(LearnContentViewFragment.ARG_PHONETIC_SOUND,
				database.getPhoneticSound(categoryType, itemIndex));

		fragment.setArguments(arguments);

		return fragment;
	}

	@Override
	public int getCount() {
		return Database.getInstance().getItemCount(categoryType);
	}
}
