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
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.model.CategoryType;

public class LearnContentViewFragment extends Fragment implements
		OnClickListener, TextToSpeech.OnInitListener, OnPageChangeListener {

	public static final String ARG_ITEM_INDEX = "ItemIndex";
	public static final String ARG_CATEGORY_TYPE = "CategoryType";
	public static final String ARG_ITEM = "Item";
	public static final String ARG_PHONETIC_SOUND = "PhoneticSound";

	private TextToSpeech textToSpeech;

	private CategoryType categoryType;

	private int itemIndex;

	private LinearLayout wordViewPagerCircles;

	private int numberOfCircles;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (textToSpeech == null) {
			textToSpeech = new TextToSpeech(getActivity(), this);
		}

		View view = inflater.inflate(R.layout.learn_content_fragment,
				container, false);
		Bundle arguments = getArguments();

		// Get the item index
		itemIndex = arguments.getInt(ARG_ITEM_INDEX);

		// Set content item
		TextView learnContentItem = (TextView) view
				.findViewById(R.id.learnContentItem);
		learnContentItem.setOnClickListener(this);
		learnContentItem.setText(arguments.getString(ARG_ITEM));

		// Get the category type
		categoryType = CategoryType.values()[arguments
				.getInt(ARG_CATEGORY_TYPE)];

		if (categoryType == CategoryType.ALPHABET
				|| categoryType == CategoryType.NUMBERS) {
			learnContentItem.setTextSize(128);
		}

		// Set the word circles
		wordViewPagerCircles = (LinearLayout) view
				.findViewById(R.id.wordViewPagerCircles);
		numberOfCircles = Database.getInstance().getItemWordCount(categoryType,
				itemIndex);
		setCircleIndex(0);

		return view;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		ViewPager wordViewPager = (ViewPager) view
				.findViewById(R.id.wordViewPager);
		wordViewPager.setAdapter(new WordFragmentPagerAdapter(
				getChildFragmentManager(), categoryType, itemIndex));
		wordViewPager.setOnPageChangeListener(this);
	}

	@Override
	public void onClick(View view) {
		Bundle arguments = getArguments();
		String text = "";

		switch (view.getId()) {
		case R.id.learnContentItem:
			text = arguments.getString(ARG_PHONETIC_SOUND);
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

	@Override
	public void onInit(int status) {
		textToSpeech.setLanguage(Locale.getDefault());
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();

		if (textToSpeech != null) {

			textToSpeech.stop();
			textToSpeech.shutdown();
		}
	}

	@Override
	public void onPageScrollStateChanged(int state) {
		// NO-OP
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// NO-OP
	}

	@Override
	public void onPageSelected(int position) {
		setCircleIndex(position);
	}

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

	private void addFilledCircle() {
		ImageView filledCircle = new ImageView(getActivity());
		filledCircle.setImageResource(R.drawable.filled_circle);
		wordViewPagerCircles.addView(filledCircle);
	}

	private void addEmptyCircle() {
		ImageView filledCircle = new ImageView(getActivity());
		filledCircle.setImageResource(R.drawable.empty_circle);
		wordViewPagerCircles.addView(filledCircle);
	}
}
