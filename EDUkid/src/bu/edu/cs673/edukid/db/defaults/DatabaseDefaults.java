package bu.edu.cs673.edukid.db.defaults;

import android.speech.tts.TextToSpeech;
import bu.edu.cs673.edukid.db.model.Word;
import bu.edu.cs673.edukid.db.model.category.AlphabetCategory;
import bu.edu.cs673.edukid.db.model.category.CategoryType;
import bu.edu.cs673.edukid.db.model.category.ColorsCategory;
import bu.edu.cs673.edukid.db.model.category.NumbersCategory;
import bu.edu.cs673.edukid.db.model.category.ShapesCategory;

public class DatabaseDefaults {

	private static CategoryType[] DEFAULT_CATEGORIES = new CategoryType[] {
			new AlphabetCategory(), new NumbersCategory(),
			new ShapesCategory(), new ColorsCategory() };

	/**
	 * Constructor.
	 */
	private DatabaseDefaults() {
		// Static class.
	}

	public static CategoryType[] getDefaultCategories() {
		return DEFAULT_CATEGORIES;
	}

	/**
	 * Gets the default alphabet in string form.
	 * 
	 * @return the default alphabet in string form.
	 */
	public static String[] getAlphabet() {
		return AlphabetDefaults.DEFAULT_ALPHABET;
	}

	/**
	 * Gets the defaults numbers in string form.
	 * 
	 * @return the default numbers in string form.
	 */
	public static String[] getNumbers() {
		return NumbersDefaults.DEFAULT_NUMBERS;
	}

	/**
	 * Gets the defaults shapes in string form.
	 * 
	 * @return the default shapes in string form.
	 */
	public static String[] getShapes() {
		return ShapesDefaults.DEFAULT_SHAPES;
	}

	/**
	 * Gets the defaults colors in string form.
	 * 
	 * @return the default colors in string form.
	 */
	public static String[] getColors() {
		return ColorsDefaults.DEFAULT_COLORS;
	}

	/**
	 * Gets the default words for the alphabet category.
	 * 
	 * <p>
	 * These are default static words that will be used if the user chooses not
	 * to configure a given letter.
	 * </p>
	 * 
	 * @return the default words for the alphabet category.
	 */
	public static Word[][] getDefaultAlphabetWords() {
		return AlphabetDefaults.ALPHABET_WORDS;
	}

	public static Word[][] getDefaultNumberWords() {
		return NumbersDefaults.NUMBER_WORDS;
	}

	public static Word[][] getDefaultShapeWords() {
		return ShapesDefaults.SHAPES_WORDS;
	}

	public static Word[][] getDefaultColorWords() {
		return ColorsDefaults.COLORS_WORDS;
	}

	/**
	 * Gets the default phonetic sounds for the alphabet category.
	 * 
	 * <p>
	 * These are default phonetic sounds that will be used in conjunction with
	 * {@link TextToSpeech} if the user chooses not to use a special recording
	 * for a given letter.
	 * </p>
	 * 
	 * @return the default phonetic sounds for the alphabet category.
	 */
	public static String[] getDefaultAlphabetPhoneticSounds() {
		return AlphabetDefaults.ALPHABET_PHONETIC_SOUNDS;
	}

	public static String[] getDefaultNumberPhoneticSounds() {
		return getNumbers();
	}

	public static String[] getDefaultColorPhoneticSounds() {
		return getColors();
	}

	public static String[] getDefaultShapePhoneticSounds() {
		return getShapes();
	}
}
