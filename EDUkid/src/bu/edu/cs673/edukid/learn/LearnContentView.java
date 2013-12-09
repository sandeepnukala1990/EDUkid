package bu.edu.cs673.edukid.learn;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import bu.edu.cs673.edukid.EDUkid;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.model.Timer;
import bu.edu.cs673.edukid.db.model.category.CategoryType;
import bu.edu.cs673.edukid.learn.grid.LearnContentGridView;

public class LearnContentView extends FragmentActivity {

	private CategoryType categoryType;

	private Database database = Database.getInstance(this);

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
		setupTimer();
		// Setup view pager
		LearnContentViewPagerAdapter learnContentViewPagerAdapter = new LearnContentViewPagerAdapter(
				getSupportFragmentManager(), categoryType);

		ViewPager learnContentViewPager = (ViewPager) findViewById(R.id.learnContentViewPager);
		learnContentViewPager.setAdapter(learnContentViewPagerAdapter);
		learnContentViewPager.setCurrentItem(itemIndex);
	}

	private void setupTimer() {
		final Handler handler = new Handler();
		Timer timer = database.getTimer();
		long timerDuration = timer.getLearnTime();

		handler.postDelayed(new Runnable() {
			public void run() {
				AlertDialog.Builder alert = new AlertDialog.Builder(
						LearnContentView.this);

				alert.setTitle("Timed Out!");
				alert.setPositiveButton("Ok",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								database.updateTimer(true, true, database
										.getTimer().getLearnTime());
								Intent intent = new Intent(
										LearnContentView.this, EDUkid.class);
								intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
								startActivity(intent);
							}
						});
				alert.create();
				alert.show();
			}
		}, timerDuration);
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
