package bu.edu.cs673.edukid.learn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.learn.grid.LearnContentGridView;

public class LearnContentView extends FragmentActivity {

	private LearnType learnType;

	private LearnContentViewPagerAdapter learnContentViewPagerAdapter;
	
	private ViewPager learnContentViewPager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.learn_content);

		Intent intent = getIntent();
		Bundle extras = intent.getExtras();

		learnType = (LearnType) extras.get("LearnType");
		int position = extras.getInt("Position");
		
		// Setup view pager
		learnContentViewPagerAdapter = new LearnContentViewPagerAdapter(
				getSupportFragmentManager(), learnType);

		learnContentViewPager = (ViewPager) findViewById(R.id.learnContentViewPager);
		learnContentViewPager.setAdapter(learnContentViewPagerAdapter);
		learnContentViewPager.setCurrentItem(position);
	}

	public void onShowAllItemsClick(View view) {
		Intent intent = new Intent(this, LearnContentGridView.class);
		intent.putExtra("LearnType", learnType);
		startActivity(intent);
	}
}
