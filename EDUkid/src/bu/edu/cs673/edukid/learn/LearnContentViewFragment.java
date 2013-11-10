package bu.edu.cs673.edukid.learn;

import java.util.Locale;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bu.edu.cs673.edukid.EDUkid;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.model.category.CategoryType;

public class LearnContentViewFragment extends Fragment implements
		OnClickListener, TextToSpeech.OnInitListener, OnPageChangeListener {

	private TextToSpeech textToSpeech;

	private CategoryType categoryType;

	private int itemIndex;

	private LinearLayout wordViewPagerCircles;

	private int numberOfCircles;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (textToSpeech == null) {
			textToSpeech = new TextToSpeech(getActivity(), this);
		}

		View view = inflater.inflate(R.layout.learn_content_fragment,
				container, false);
		Bundle arguments = getArguments();

		// Get the category type
		categoryType = (CategoryType) arguments
				.getSerializable(EDUkid.CATEGORY_TYPE);

		// Get the item index
		itemIndex = arguments.getInt(EDUkid.ITEM_INDEX);

		// Set content item
		TextView learnContentItem = (TextView) view
				.findViewById(R.id.learnContentItem);
		learnContentItem.setOnClickListener(this);
		learnContentItem.setText(categoryType.getItem(itemIndex));

		learnContentItem.setTextSize(categoryType.getItemTextSize());

		// Set the word circles
		wordViewPagerCircles = (LinearLayout) view
				.findViewById(R.id.wordViewPagerCircles);
		numberOfCircles = categoryType.getItemWordCount(itemIndex);
		setCircleIndex(0);

		return view;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		ViewPager wordViewPager = (ViewPager) view
				.findViewById(R.id.wordViewPager);
		wordViewPager.setAdapter(new WordFragmentPagerAdapter(
				getChildFragmentManager(), categoryType, itemIndex));
		wordViewPager.setOnPageChangeListener(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onClick(View view) {
		String text = "";

		switch (view.getId()) {
		case R.id.learnContentItem:
			text = categoryType.getItemPhoneticSound(itemIndex);
			break;
		default:
			return;
		}

		try {
			textToSpeech.stop();
			textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onInit(int status) {
		textToSpeech.setLanguage(Locale.getDefault());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onDestroyView() {
		super.onDestroyView();

		if (textToSpeech != null) {

			textToSpeech.stop();
			textToSpeech.shutdown();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onPageScrollStateChanged(int state) {
		// NO-OP
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// NO-OP
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onPageSelected(int position) {
		setCircleIndex(position);
	}

	/**
	 * Sets the circle index to inform the user which image they are viewing if
	 * there is more than 1.
	 * 
	 * @param index
	 *            the circle index.
	 */
	private void setCircleIndex(int index) {
		wordViewPagerCircles.removeAllViews();

		if (numberOfCircles > 1) {
			for (int i = 0; i < numberOfCircles; i++) {
				if (i == index) {
					addFilledCircle();
				} else {
					addEmptyCircle();
				}
			}
		}
	}

	/**
	 * Adds a filled circle to the row of circles.
	 */
	private void addFilledCircle() {
		ImageView filledCircle = new ImageView(getActivity());
		filledCircle.setImageResource(R.drawable.filled_circle);
		wordViewPagerCircles.addView(filledCircle);
	}

	/**
	 * Adds an empty circle to the row of circles.
	 */
	private void addEmptyCircle() {
		ImageView filledCircle = new ImageView(getActivity());
		filledCircle.setImageResource(R.drawable.empty_circle);
		wordViewPagerCircles.addView(filledCircle);
	}
}
