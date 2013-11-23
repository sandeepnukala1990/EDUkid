package bu.edu.cs673.edukid.db.defaults;

import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.model.Word;

public class ColorsDefaults {

	protected static String[] DEFAULT_COLORS = new String[] { "Red", "Green",
			"Blue", "Orange", "Brown", "Yellow", "Violet", "Black", "White",
			"Gray" };

	// TODO: replace the edukid icon with the real image
	private static Word[] RED_WORDS = new Word[] { new Word("Red",
			R.drawable.tomato) };

	// TODO: replace the edukid icon with the real image
	private static Word[] GREEN_WORDS = new Word[] { new Word("Green",
			R.drawable.green) };

	// TODO: replace the edukid icon with the real image
	private static Word[] BLUE_WORDS = new Word[] { new Word("Blue",
			R.drawable.blue) };

	// TODO: replace the edukid icon with the real image
	private static Word[] ORANGE_WORDS = new Word[] { new Word("Orange",
			R.drawable.orange) };

	// TODO: replace the edukid icon with the real image
	private static Word[] BROWN_WORDS = new Word[] { new Word("Brown",
			R.drawable.brown) };

	// TODO: replace the edukid icon with the real image
	private static Word[] YELLOW_WORDS = new Word[] { new Word("Yellow",
			R.drawable.yellow) };

	// TODO: replace the edukid icon with the real image
	private static Word[] VIOLET_WORDS = new Word[] { new Word("Violet",
			R.drawable.violet) };

	// TODO: replace the edukid icon with the real image
	private static Word[] BLACK_WORDS = new Word[] { new Word("Black",
			R.drawable.black) };

	// TODO: replace the edukid icon with the real image
	private static Word[] WHITE_WORDS = new Word[] { new Word("White",
			R.drawable.white) };

	// TODO: replace the edukid icon with the real image
	private static Word[] GRAY_WORDS = new Word[] { new Word("Gray",
			R.drawable.grey) };

	protected static Word[][] COLORS_WORDS = new Word[][] { RED_WORDS,
			GREEN_WORDS, BLUE_WORDS, ORANGE_WORDS, BROWN_WORDS, YELLOW_WORDS,
			VIOLET_WORDS, BLACK_WORDS, WHITE_WORDS, GRAY_WORDS };
}
