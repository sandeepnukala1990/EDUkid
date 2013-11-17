package bu.edu.cs673.edukid.learn;

import java.util.Locale;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import bu.edu.cs673.edukid.EDUkid;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.model.category.CategoryType;

public class WordFragment extends Fragment implements OnClickListener,
		OnInitListener {

	private CategoryType categoryType;

	private int itemIndex;

	private int wordIndex;

	private TextToSpeech textToSpeech;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (textToSpeech == null) {
			textToSpeech = new TextToSpeech(getActivity(), this);
		}

		return inflater.inflate(R.layout.learn_content_word_fragment,
				container, false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		Bundle arguments = getArguments();

		categoryType = (CategoryType) arguments
				.getSerializable(EDUkid.CATEGORY_TYPE);
		itemIndex = arguments.getInt(EDUkid.ITEM_INDEX);
		wordIndex = arguments.getInt(EDUkid.WORD_INDEX);

		// Set content image
		ImageButton learnContentImage = (ImageButton) view
				.findViewById(R.id.learnContentImage);
		learnContentImage.setOnClickListener(this);
		learnContentImage.setImageDrawable(getResources().getDrawable(
				categoryType.getItemDrawableId(itemIndex, wordIndex)));

		// Set content word
		TextView learnContentWord = (TextView) view
				.findViewById(R.id.learnContentWord);
		learnContentWord.setText(categoryType.getItemWord(itemIndex, wordIndex)
				.getWord());

		learnContentWord.setOnClickListener(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onClick(View view) {
		String text = "";

		switch (view.getId()) {
		case R.id.learnContentImage:
		case R.id.learnContentWord:
			text = categoryType.getItemWord(itemIndex, wordIndex).getWord();
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
}
