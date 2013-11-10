package bu.edu.cs673.edukid.db;

import java.util.Collections;
import java.util.List;

import android.speech.tts.TextToSpeech;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.model.Thing;
import bu.edu.cs673.edukid.db.model.Things;
import bu.edu.cs673.edukid.db.model.category.AlphabetCategory;
import bu.edu.cs673.edukid.db.model.category.ColorsCategory;
import bu.edu.cs673.edukid.db.model.category.CategoryType;
import bu.edu.cs673.edukid.db.model.category.NumbersCategory;
import bu.edu.cs673.edukid.db.model.category.ShapesCategory;

public class DatabaseDefaults {

	private static CategoryType[] DEFAULT_CATEGORIES = new CategoryType[] {
			new AlphabetCategory(), new NumbersCategory(),
			new ShapesCategory(), new ColorsCategory() };

	// TODO: fill these in with real values
	private static Things A_THINGS = new Things(new Thing("Apple",
			R.drawable.apple), new Thing("Alligator", R.drawable.alligator),
			new Thing("Avocado", R.drawable.avocado));
	private static Things B_THINGS = new Things(new Thing("Balloons",
			R.drawable.balloons));
	private static Things C_THINGS = new Things(
			new Thing("Cow", R.drawable.cow));
	private static Things D_THINGS = new Things();
	private static Things E_THINGS = new Things();
	private static Things F_THINGS = new Things();
	private static Things G_THINGS = new Things();
	private static Things H_THINGS = new Things();
	private static Things I_THINGS = new Things();
	private static Things J_THINGS = new Things();
	private static Things K_THINGS = new Things();
	private static Things L_THINGS = new Things();
	private static Things M_THINGS = new Things();
	private static Things N_THINGS = new Things();
	private static Things O_THINGS = new Things();
	private static Things P_THINGS = new Things(
			new Thing("Pig", R.drawable.pig));
	private static Things Q_THINGS = new Things(new Thing("Quail",
			R.drawable.quail));
	private static Things R_THINGS = new Things();
	private static Things S_THINGS = new Things();
	private static Things T_THINGS = new Things();
	private static Things U_THINGS = new Things();
	private static Things V_THINGS = new Things();
	private static Things W_THINGS = new Things();
	private static Things X_THINGS = new Things();
	private static Things Y_THINGS = new Things();
	private static Things Z_THINGS = new Things();

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
	 * Gets the alphabet in string form.
	 * 
	 * @return the alphabet in string form.
	 */
	public static String[] getAlphabet() {
		return new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
				"W", "X", "Y", "Z" };
	}

	/**
	 * Gets the default words for the alphabet category.
	 * 
	 * <p>
	 * These are default static words that will be used if the user chooses not
	 * to configure a given letter.
	 * </p>
	 * 
	 * @param itemIndex
	 *            the item index.
	 * @return the default words for the alphabet category.
	 */
	public static List<String> getDefaultAlphabetWords(int itemIndex) {
		switch (itemIndex) {
		case 0:
			return A_THINGS.getWords();
		case 1:
			return B_THINGS.getWords();
		case 2:
			return C_THINGS.getWords();
		case 3:
			return D_THINGS.getWords();
		case 4:
			return E_THINGS.getWords();
		case 5:
			return F_THINGS.getWords();
		case 6:
			return G_THINGS.getWords();
		case 7:
			return H_THINGS.getWords();
		case 8:
			return I_THINGS.getWords();
		case 9:
			return J_THINGS.getWords();
		case 10:
			return K_THINGS.getWords();
		case 11:
			return L_THINGS.getWords();
		case 12:
			return M_THINGS.getWords();
		case 13:
			return N_THINGS.getWords();
		case 14:
			return O_THINGS.getWords();
		case 15:
			return P_THINGS.getWords();
		case 16:
			return Q_THINGS.getWords();
		case 17:
			return R_THINGS.getWords();
		case 18:
			return S_THINGS.getWords();
		case 19:
			return T_THINGS.getWords();
		case 20:
			return U_THINGS.getWords();
		case 21:
			return V_THINGS.getWords();
		case 22:
			return W_THINGS.getWords();
		case 23:
			return X_THINGS.getWords();
		case 24:
			return Y_THINGS.getWords();
		case 25:
			return Z_THINGS.getWords();
		default:
			return Collections.emptyList();
		}
	}

	public static List<Integer> getDefaultAlphabetDrawableIds(int itemIndex) {
		switch (itemIndex) {
		case 0:
			return A_THINGS.getDrawableIds();
		case 1:
			return B_THINGS.getDrawableIds();
		case 2:
			return C_THINGS.getDrawableIds();
		case 3:
			return D_THINGS.getDrawableIds();
		case 4:
			return E_THINGS.getDrawableIds();
		case 5:
			return F_THINGS.getDrawableIds();
		case 6:
			return G_THINGS.getDrawableIds();
		case 7:
			return H_THINGS.getDrawableIds();
		case 8:
			return I_THINGS.getDrawableIds();
		case 9:
			return J_THINGS.getDrawableIds();
		case 10:
			return K_THINGS.getDrawableIds();
		case 11:
			return L_THINGS.getDrawableIds();
		case 12:
			return M_THINGS.getDrawableIds();
		case 13:
			return N_THINGS.getDrawableIds();
		case 14:
			return O_THINGS.getDrawableIds();
		case 15:
			return P_THINGS.getDrawableIds();
		case 16:
			return Q_THINGS.getDrawableIds();
		case 17:
			return R_THINGS.getDrawableIds();
		case 18:
			return S_THINGS.getDrawableIds();
		case 19:
			return T_THINGS.getDrawableIds();
		case 20:
			return U_THINGS.getDrawableIds();
		case 21:
			return V_THINGS.getDrawableIds();
		case 22:
			return W_THINGS.getDrawableIds();
		case 23:
			return X_THINGS.getDrawableIds();
		case 24:
			return Y_THINGS.getDrawableIds();
		case 25:
			return Z_THINGS.getDrawableIds();
		default:
			return Collections.emptyList();
		}
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
	 * @param itemIndex
	 *            the item index.
	 * @return the default phonetic sounds for the alphabet category.
	 */
	public static String getDefaultAlphabetPhoneticSounds(int itemIndex) {
		switch (itemIndex) {
		case 0:
			return "ay";
		case 1:
			return "b";
		case 2:
			return "c";
		case 3:
			return "d";
		case 4:
			return "e";
		case 5:
			return "f";
		case 6:
			return "g";
		case 7:
			return "h";
		case 8:
			return "eye";
		case 9:
			return "j";
		case 10:
			return "k";
		case 11:
			return "l";
		case 12:
			return "m";
		case 13:
			return "n";
		case 14:
			return "o";
		case 15:
			return "p";
		case 16:
			return "q";
		case 17:
			return "are";
		case 18:
			return "s";
		case 19:
			return "t";
		case 20:
			return "you";
		case 21:
			return "v";
		case 22:
			return "w";
		case 23:
			return "x";
		case 24:
			return "why";
		case 25:
			return "zee";
		default:
			return "";
		}
	}
}
