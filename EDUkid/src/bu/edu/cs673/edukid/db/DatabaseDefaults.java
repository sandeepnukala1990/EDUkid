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
			R.drawable.apple), new Thing("Alligator", R.drawable.aligator),
			new Thing("Avocado", R.drawable.avocado), new Thing("Abacus", R.drawable.abacus), new Thing("Aeroplane", R.drawable.aeroplane));

	private static Things B_THINGS = new Things(new Thing("Balloons",
			R.drawable.balloons), new Thing("Ball", R.drawable.ball), new Thing("Boy", R.drawable.boy));

	private static Things C_THINGS = new Things(
			new Thing("Cow", R.drawable.cow), new Thing("Camera", R.drawable.camera), new Thing("Cake", R.drawable.cake));

	
	private static Things D_THINGS = new Things(new Thing("Door", R.drawable.door), new Thing("Duck", R.drawable.duck), new Thing("Dolphin", R.drawable.dolphin), new Thing("Dwarf", R.drawable.dwarf));

	
	private static Things E_THINGS = new Things(new Thing("Eagle", R.drawable.eagle), new Thing("Earth", R.drawable.earth), new Thing("Elephant", R.drawable.elephant));

	
	private static Things F_THINGS = new Things(new Thing("Flowers", R.drawable.flowers), new Thing("Fan", R.drawable.fan), new Thing("Fox", R.drawable.fox));

	
	private static Things G_THINGS = new Things(new Thing("Giraffe", R.drawable.giraffe), new Thing("Girl", R.drawable.girl), new Thing("Goat", R.drawable.goat));

	
	private static Things H_THINGS = new Things(new Thing("Helicopter", R.drawable.helicopter), new Thing("Horse", R.drawable.horse), new Thing("Hen", R.drawable.hen));

	
	private static Things I_THINGS = new Things(new Thing("Ice Cream", R.drawable.icecream), new Thing("Igloo", R.drawable.igloo), new Thing("Island", R.drawable.island));

	
	private static Things J_THINGS = new Things(new Thing("Jacket", R.drawable.jacket), new Thing("Jug", R.drawable.jug), new Thing("Judge", R.drawable.judge));

	
	private static Things K_THINGS = new Things(new Thing("Kite", R.drawable.kites), new Thing("Kangaroo", R.drawable.kangaroo), new Thing("Key", R.drawable.key));

	
	private static Things L_THINGS = new Things(new Thing("Leaf", R.drawable.leaf), new Thing("Leopard", R.drawable.leopard), new Thing("Lotus", R.drawable.lotus));

	
	private static Things M_THINGS = new Things(new Thing("Money", R.drawable.money), new Thing("Monkey", R.drawable.monkey), new Thing("Moon", R.drawable.moon));

	
	private static Things N_THINGS = new Things(new Thing("Nails", R.drawable.nail), new Thing("Nest", R.drawable.nest), new Thing("Noodles", R.drawable.noodles));

	
	private static Things O_THINGS = new Things(new Thing("Octopus", R.drawable.octopus), new Thing("Oranges", R.drawable.orange), new Thing("Owl", R.drawable.owl));

	private static Things P_THINGS = new Things(new Thing("Pig", R.drawable.pig), new Thing("Pencil", R.drawable.pencils), new Thing("Pumpkin", R.drawable.pumpkin));

	private static Things Q_THINGS = new Things(new Thing("Quail",
			R.drawable.quail), new Thing("Queen", R.drawable.queen), new Thing("Question", R.drawable.questionmark), new Thing("Quiet", R.drawable.quiet));

	private static Things R_THINGS = new Things(new Thing("Rabbit", R.drawable.rabbit), new Thing("Rainbow", R.drawable.rainbow), new Thing("Rocket", R.drawable.rocket));

	
	private static Things S_THINGS = new Things(new Thing("Shoes", R.drawable.shoes), new Thing("Snake", R.drawable.snake), new Thing("Snail", R.drawable.snail), new Thing("Star", R.drawable.star), new Thing("Sun", R.drawable.sun));

	
	private static Things T_THINGS = new Things(new Thing("Tiger", R.drawable.tiger), new Thing("Tomato", R.drawable.tomato), new Thing("Train", R.drawable.train), new Thing("Turtle", R.drawable.turtle), new Thing("Tree", R.drawable.tree));

	
	private static Things U_THINGS = new Things(new Thing("Unicorn", R.drawable.unicorn), new Thing("Umbrella", R.drawable.umbrella), new Thing("UniCycle", R.drawable.unicycle), new Thing("Urchin", R.drawable.urchin));

	
	private static Things V_THINGS = new Things(new Thing("Vase", R.drawable.vase), new Thing("Violin", R.drawable.violin), new Thing("Volcano", R.drawable.volcano), new Thing("Volleyball", R.drawable.voleyball), new Thing("Vulture", R.drawable.vulture));

	
	private static Things W_THINGS = new Things(new Thing("Whale", R.drawable.whale), new Thing("Wagon", R.drawable.wagon), new Thing("Wand", R.drawable.wand), new Thing("Watch", R.drawable.watch), new Thing("Wolf", R.drawable.wolf), new Thing("Watermelon", R.drawable.watermelon), new Thing("Wheel", R.drawable.wheel));

	
	private static Things X_THINGS = new Things(new Thing("X-Ray", R.drawable.xray), new Thing("Xylophone", R.drawable.xylophone));

	
	private static Things Y_THINGS = new Things(new Thing("Yatch", R.drawable.yatch), new Thing("Yak", R.drawable.yak), new Thing("Yellow", R.drawable.yellow), new Thing("Yo Yo", R.drawable.yoyo));

	
	private static Things Z_THINGS = new Things(new Thing("Zebra", R.drawable.zebra), new Thing("Zip", R.drawable.zip), new Thing("Zig Zag", R.drawable.zigzag), new Thing("Zoo", R.drawable.zoo));

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
	 * Gets the number in string form.
	 * 
	 * @return the number in string form.
	 */
	public static String[] getNumbers() {
		return new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
	}
	
	public static String[] getShapes(){
		return new String[]{"circle","square", "diamond", "oval", "triangle", "pentagon", 
				"hexagon","star"};
	}
	
	public static String[] getColours(){
		return new String[]{"red","green", "blue", "orange", "brown", "yellow", 
				"violet", "black", "white", "grey"};
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
