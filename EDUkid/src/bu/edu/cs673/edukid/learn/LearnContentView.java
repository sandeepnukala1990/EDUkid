package bu.edu.cs673.edukid.learn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import bu.edu.cs673.edukid.EDUkid;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.model.category.CategoryType;
import bu.edu.cs673.edukid.learn.grid.LearnContentGridView;

public class LearnContentView extends FragmentActivity {

	private CategoryType categoryType;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.learn_content);

		Intent intent = getIntent();
		Bundle extras = intent.getExtras();

		categoryType = (CategoryType) extras
				.getSerializable(EDUkid.CATEGORY_TYPE);
		int itemIndex = extras.getInt(EDUkid.ITEM_INDEX);

		// Setup view pager
		LearnContentViewPagerAdapter learnContentViewPagerAdapter = new LearnContentViewPagerAdapter(
				getSupportFragmentManager(), categoryType);

		ViewPager learnContentViewPager = (ViewPager) findViewById(R.id.learnContentViewPager);
		learnContentViewPager.setAdapter(learnContentViewPagerAdapter);
		learnContentViewPager.setCurrentItem(itemIndex);
	}

	/**
	 * Show grid on click callback.
	 * 
	 * @param view
	 *            the view.
	 */
	public void onShowGridClick(View view) {
		Intent intent = new Intent(this, LearnContentGridView.class);
		intent.putExtra(EDUkid.CATEGORY_TYPE, categoryType);
		startActivity(intent);
	}
}
