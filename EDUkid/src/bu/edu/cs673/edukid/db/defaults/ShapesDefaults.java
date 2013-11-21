package bu.edu.cs673.edukid.db.defaults;

import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.model.Word;

public class ShapesDefaults {

	protected static String[] DEFAULT_SHAPES = new String[] { "Circle",
			"Square", "Diamond", "Oval", "Triangle", "Pentagon", "Hexagon",
			"Star" };

	// TODO: replace the edukid icon with the real image
	private static Word[] CIRCLE_WORDS = new Word[] { new Word("Circle",
			R.drawable.edukidicon) };

	// TODO: replace the edukid icon with the real image
	private static Word[] SQUARE_WORDS = new Word[] { new Word("Square",
			R.drawable.edukidicon) };

	// TODO: replace the edukid icon with the real image
	private static Word[] DIAMOND_WORDS = new Word[] { new Word("Diamond",
			R.drawable.edukidicon) };

	// TODO: replace the edukid icon with the real image
	private static Word[] OVAL_WORDS = new Word[] { new Word("Oval",
			R.drawable.edukidicon) };

	// TODO: replace the edukid icon with the real image
	private static Word[] TRIANGLE_WORDS = new Word[] { new Word("Triangle",
			R.drawable.edukidicon) };

	// TODO: replace the edukid icon with the real image
	private static Word[] PENTAGON_WORDS = new Word[] { new Word("Pentagon",
			R.drawable.edukidicon) };

	// TODO: replace the edukid icon with the real image
	private static Word[] HEXAGON_WORDS = new Word[] { new Word("Hexagon",
			R.drawable.edukidicon) };

	// TODO: replace the edukid icon with the real image
	private static Word[] STAR_WORDS = new Word[] { new Word("Star",
			R.drawable.edukidicon) };

	protected static Word[][] SHAPES_WORDS = new Word[][] { CIRCLE_WORDS,
			SQUARE_WORDS, DIAMOND_WORDS, OVAL_WORDS, TRIANGLE_WORDS,
			PENTAGON_WORDS, HEXAGON_WORDS, STAR_WORDS };
}
