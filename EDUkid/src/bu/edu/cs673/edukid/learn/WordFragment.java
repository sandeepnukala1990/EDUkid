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
import bu.edu.cs673.edukid.R;

public class WordFragment extends Fragment implements OnClickListener,
		OnInitListener {

	public static final String ARG_IMAGE = "Image";
	public static final String ARG_WORD = "Word";

	private TextToSpeech textToSpeech;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (textToSpeech == null) {
			textToSpeech = new TextToSpeech(getActivity(), this);
		}

		return inflater.inflate(R.layout.learn_content_word_fragment,
				container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		Bundle arguments = getArguments();

		// Set content image
		ImageButton learnContentImage = (ImageButton) view
				.findViewById(R.id.learnContentImage);
		learnContentImage.setOnClickListener(this);
		learnContentImage.setImageResource(arguments.getInt(ARG_IMAGE));

		// Set content word
		TextView learnContentWord = (TextView) view
				.findViewById(R.id.learnContentWord);
		learnContentWord.setText(arguments.getString(ARG_WORD));

		learnContentWord.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		Bundle arguments = getArguments();
		String text = "";

		switch (view.getId()) {
		case R.id.learnContentImage:
		case R.id.learnContentWord:
			// TODO: first one for now... add this to word fragment
			text = arguments.getString(ARG_WORD);
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
}
