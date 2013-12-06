package bu.edu.cs673.edukid.db.defaults;

import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.model.Word;

public class ShapesDefaults {

	protected static String[] DEFAULT_SHAPES = new String[] { "Circle",
			"Square","Triangle", "Rectangle"
		 };

	// TODO: replace the edukid icon with the real image
	private static Word[] CIRCLE_WORDS = new Word[] { new Word("Circle",
			R.drawable.circlepng) };

	// TODO: replace the edukid icon with the real image
	private static Word[] SQUARE_WORDS = new Word[] { new Word("Square",
			R.drawable.squarepng) };

	// TODO: replace the edukid icon with the real image
	private static Word[] TRIANGLE_WORDS = new Word[] { new Word("Triangle",
			R.drawable.trianglepng) };

	// TODO: replace the edukid icon with the real image
	private static Word[] RECTANGLE_WORDS = new Word[] { new Word("Rectangle",
			R.drawable.rectanglepng) };

	
	

	protected static Word[][] SHAPES_WORDS = new Word[][] { CIRCLE_WORDS,
			SQUARE_WORDS, TRIANGLE_WORDS,
			RECTANGLE_WORDS};
}
