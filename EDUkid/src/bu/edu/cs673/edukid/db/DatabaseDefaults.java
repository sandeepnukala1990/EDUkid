package bu.edu.cs673.edukid.db;

import android.speech.tts.TextToSpeech;
import bu.edu.cs673.edukid.R;
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

	// Alphabet default words
	private static Word[] A_WORDS = new Word[] {
			new Word("Apple", R.drawable.apple),
			new Word("Alligator", R.drawable.aligator),
			new Word("Avocado", R.drawable.avocado),
			new Word("Abacus", R.drawable.abacus),
			new Word("Aeroplane", R.drawable.aeroplane) };

	private static Word[] B_WORDS = new Word[] {
			new Word("Balloons", R.drawable.balloons),
			new Word("Ball", R.drawable.ball), new Word("Boy", R.drawable.boy) };

	private static Word[] C_WORDS = new Word[] {
			new Word("Cow", R.drawable.cow),
			new Word("Camera", R.drawable.camera),
			new Word("Cake", R.drawable.cake) };

	private static Word[] D_WORDS = new Word[] {
			new Word("Door", R.drawable.door),
			new Word("Duck", R.drawable.duck),
			new Word("Dolphin", R.drawable.dolphin),
			new Word("Dwarf", R.drawable.dwarf) };

	private static Word[] E_WORDS = new Word[] {
			new Word("Eagle", R.drawable.eagle),
			new Word("Earth", R.drawable.earth),
			new Word("Elephant", R.drawable.elephant) };

	private static Word[] F_WORDS = new Word[] {
			new Word("Flowers", R.drawable.flowers),
			new Word("Fan", R.drawable.fan), new Word("Fox", R.drawable.fox) };

	private static Word[] G_WORDS = new Word[] {
			new Word("Giraffe", R.drawable.giraffe),
			new Word("Girl", R.drawable.girl),
			new Word("Goat", R.drawable.goat) };

	private static Word[] H_WORDS = new Word[] {
			new Word("Helicopter", R.drawable.helicopter),
			new Word("Horse", R.drawable.horse),
			new Word("Hen", R.drawable.hen) };

	private static Word[] I_WORDS = new Word[] {
			new Word("Ice Cream", R.drawable.icecream),
			new Word("Igloo", R.drawable.igloo),
			new Word("Island", R.drawable.island) };

	private static Word[] J_WORDS = new Word[] {
			new Word("Jacket", R.drawable.jacket),
			new Word("Jug", R.drawable.jug),
			new Word("Judge", R.drawable.judge) };

	private static Word[] K_WORDS = new Word[] {
			new Word("Kite", R.drawable.kites),
			new Word("Kangaroo", R.drawable.kangaroo),
			new Word("Key", R.drawable.key) };

	private static Word[] L_WORDS = new Word[] {
			new Word("Leaf", R.drawable.leaf),
			new Word("Leopard", R.drawable.leopard),
			new Word("Lotus", R.drawable.lotus) };

	private static Word[] M_WORDS = new Word[] {
			new Word("Money", R.drawable.money),
			new Word("Monkey", R.drawable.monkey),
			new Word("Moon", R.drawable.moon) };

	private static Word[] N_WORDS = new Word[] {
			new Word("Nails", R.drawable.nail),
			new Word("Nest", R.drawable.nest),
			new Word("Noodles", R.drawable.noodles) };

	private static Word[] O_WORDS = new Word[] {
			new Word("Octopus", R.drawable.octopus),
			new Word("Oranges", R.drawable.orange),
			new Word("Owl", R.drawable.owl) };

	private static Word[] P_WORDS = new Word[] {
			new Word("Pig", R.drawable.pig),
			new Word("Pencil", R.drawable.pencils),
			new Word("Pumpkin", R.drawable.pumpkin) };

	private static Word[] Q_WORDS = new Word[] {
			new Word("Quail", R.drawable.quail),
			new Word("Queen", R.drawable.queen),
			new Word("Question", R.drawable.questionmark),
			new Word("Quiet", R.drawable.quiet) };

	private static Word[] R_WORDS = new Word[] {
			new Word("Rabbit", R.drawable.rabbit),
			new Word("Rainbow", R.drawable.rainbow),
			new Word("Rocket", R.drawable.rocket) };

	private static Word[] S_WORDS = new Word[] {
			new Word("Shoes", R.drawable.shoes),
			new Word("Snake", R.drawable.snake),
			new Word("Snail", R.drawable.snail),
			new Word("Star", R.drawable.star), new Word("Sun", R.drawable.sun) };

	private static Word[] T_WORDS = new Word[] {
			new Word("Tiger", R.drawable.tiger),
			new Word("Tomato", R.drawable.tomato),
			new Word("Train", R.drawable.train),
			new Word("Turtle", R.drawable.turtle),
			new Word("Tree", R.drawable.tree) };

	private static Word[] U_WORDS = new Word[] {
			new Word("Unicorn", R.drawable.unicorn),
			new Word("Umbrella", R.drawable.umbrella),
			new Word("UniCycle", R.drawable.unicycle),
			new Word("Urchin", R.drawable.urchin) };

	private static Word[] V_WORDS = new Word[] {
			new Word("Vase", R.drawable.vase),
			new Word("Violin", R.drawable.violin),
			new Word("Volcano", R.drawable.volcano),
			new Word("Volleyball", R.drawable.voleyball),
			new Word("Vulture", R.drawable.vulture) };

	private static Word[] W_WORDS = new Word[] {
			new Word("Whale", R.drawable.whale),
			new Word("Wagon", R.drawable.wagon),
			new Word("Wand", R.drawable.wand),
			new Word("Watch", R.drawable.watch),
			new Word("Wolf", R.drawable.wolf),
			new Word("Watermelon", R.drawable.watermelon),
			new Word("Wheel", R.drawable.wheel) };

	private static Word[] X_WORDS = new Word[] {
			new Word("X-Ray", R.drawable.xray),
			new Word("Xylophone", R.drawable.xylophone) };

	private static Word[] Y_WORDS = new Word[] {
			new Word("Yatch", R.drawable.yatch),
			new Word("Yak", R.drawable.yak),
			new Word("Yellow", R.drawable.yellow),
			new Word("Yo Yo", R.drawable.yoyo) };

	private static Word[] Z_WORDS = new Word[] {
			new Word("Zebra", R.drawable.zebra),
			new Word("Zip", R.drawable.zip),
			new Word("Zig Zag", R.drawable.zigzag),
			new Word("Zoo", R.drawable.zoo) };

	// Number default words
	private static Word[] ZERO_WORDS = new Word[] {
			new Word("Zero", R.drawable.edukidicon),
			new Word("Zero", R.drawable.edukidicon) };

	private static Word[] ONE_WORDS = new Word[] {
			new Word("One", R.drawable.onepng),
			new Word("One", R.drawable.edukidicon) };

	private static Word[] TWO_WORDS = new Word[] {
			new Word("Two", R.drawable.twopng),
			new Word("Two", R.drawable.edukidicon) };

	private static Word[] THREE_WORDS = new Word[] {
			new Word("Three", R.drawable.threepng),
			new Word("Three", R.drawable.edukidicon) };

	private static Word[] FOUR_WORDS = new Word[] {
			new Word("Four", R.drawable.fourpng),
			new Word("Four", R.drawable.edukidicon) };

	private static Word[] FIVE_WORDS = new Word[] {
			new Word("Five", R.drawable.fivepng),
			new Word("Five", R.drawable.edukidicon) };

	private static Word[] SIX_WORDS = new Word[] {
			new Word("Six", R.drawable.sixpng),
			new Word("Six", R.drawable.edukidicon) };

	private static Word[] SEVEN_WORDS = new Word[] {
			new Word("Seven", R.drawable.sevenpng),
			new Word("Seven", R.drawable.edukidicon) };

	private static Word[] EIGHT_WORDS = new Word[] {
			new Word("Eight", R.drawable.eightpng),
			new Word("Eight", R.drawable.edukidicon) };

	private static Word[] NINE_WORDS = new Word[] {
			new Word("Nine", R.drawable.ninepng),
			new Word("Nine", R.drawable.edukidicon) };

	private static Word[] TEN_WORDS = new Word[] {
			new Word("Ten", R.drawable.tenpng),
			new Word("Ten", R.drawable.edukidicon) };

	// Colors default words
	private static Word[] col0_WORDS = new Word[] { new Word("Red",
			R.drawable.edukidicon) };

	private static Word[] col1_WORDS = new Word[] { new Word("Green",
			R.drawable.edukidicon) };

	private static Word[] col2_WORDS = new Word[] { new Word("Blue",
			R.drawable.edukidicon) };

	private static Word[] col3_WORDS = new Word[] { new Word("Orange",
			R.drawable.orange) };

	private static Word[] col4_WORDS = new Word[] { new Word("Brown",
			R.drawable.edukidicon) };

	private static Word[] col5_WORDS = new Word[] { new Word("Yellow",
			R.drawable.yellow) };

	private static Word[] col6_WORDS = new Word[] { new Word("Violet",
			R.drawable.edukidicon) };

	private static Word[] col7_WORDS = new Word[] { new Word("Black",
			R.drawable.edukidicon) };

	private static Word[] col8_WORDS = new Word[] { new Word("White",
			R.drawable.edukidicon) };

	private static Word[] col9_WORDS = new Word[] { new Word("Gray",
			R.drawable.edukidicon) };

	// Shapes default words
	private static Word[] shape0_WORDS = new Word[] { new Word("Circle",
			R.drawable.edukidicon) };

	private static Word[] shape1_WORDS = new Word[] { new Word("Square",
			R.drawable.edukidicon) };

	private static Word[] shape2_WORDS = new Word[] { new Word("Diamond",
			R.drawable.edukidicon) };

	private static Word[] shape3_WORDS = new Word[] { new Word("Oval",
			R.drawable.edukidicon) };

	private static Word[] shape4_WORDS = new Word[] { new Word("Triangle",
			R.drawable.edukidicon) };

	private static Word[] shape5_WORDS = new Word[] { new Word("Pentagon",
			R.drawable.edukidicon) };

	private static Word[] shape6_WORDS = new Word[] { new Word("Hexagon",
			R.drawable.edukidicon) };

	private static Word[] shape7_WORDS = new Word[] { new Word("Star",
			R.drawable.edukidicon) };

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
		return new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10" };
	}

	public static String[] getShapes() {
		return new String[] { "Circle", "Square", "Diamond", "Oval",
				"Triangle", "Pentagon", "Hexagon", "Star" };
	}

	public static String[] getColors() {
		return new String[] { "Red", "Green", "Blue", "Orange", "Brown",
				"Yellow", "Violet", "Black", "White", "Gray" };
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
	public static Word[] getDefaultAlphabetWords(int itemIndex) {
		switch (itemIndex) {
		case 0:
			return A_WORDS;
		case 1:
			return B_WORDS;
		case 2:
			return C_WORDS;
		case 3:
			return D_WORDS;
		case 4:
			return E_WORDS;
		case 5:
			return F_WORDS;
		case 6:
			return G_WORDS;
		case 7:
			return H_WORDS;
		case 8:
			return I_WORDS;
		case 9:
			return J_WORDS;
		case 10:
			return K_WORDS;
		case 11:
			return L_WORDS;
		case 12:
			return M_WORDS;
		case 13:
			return N_WORDS;
		case 14:
			return O_WORDS;
		case 15:
			return P_WORDS;
		case 16:
			return Q_WORDS;
		case 17:
			return R_WORDS;
		case 18:
			return S_WORDS;
		case 19:
			return T_WORDS;
		case 20:
			return U_WORDS;
		case 21:
			return V_WORDS;
		case 22:
			return W_WORDS;
		case 23:
			return X_WORDS;
		case 24:
			return Y_WORDS;
		case 25:
			return Z_WORDS;
		default:
			return new Word[0];
		}
	}

	public static Word[] getDefaultnumWords(int itemIndex) {
		switch (itemIndex) {
		case 0:
			return ZERO_WORDS;
		case 1:
			return ONE_WORDS;
		case 2:
			return TWO_WORDS;
		case 3:
			return THREE_WORDS;
		case 4:
			return FOUR_WORDS;
		case 5:
			return FIVE_WORDS;
		case 6:
			return SIX_WORDS;
		case 7:
			return SEVEN_WORDS;
		case 8:
			return EIGHT_WORDS;
		case 9:
			return NINE_WORDS;
		case 10:
			return TEN_WORDS;

		default:
			return new Word[0];
		}
	}

	public static Word[] getDefaultColorWords(int itemIndex) {
		switch (itemIndex) {
		case 0:
			return col0_WORDS;
		case 1:
			return col1_WORDS;
		case 2:
			return col2_WORDS;
		case 3:
			return col3_WORDS;
		case 4:
			return col4_WORDS;
		case 5:
			return col5_WORDS;
		case 6:
			return col6_WORDS;
		case 7:
			return col7_WORDS;
		case 8:
			return col8_WORDS;
		case 9:
			return col9_WORDS;

		default:
			return new Word[0];
		}
	}

	public static Word[] getDefaultShapeWords(int itemIndex) {
		switch (itemIndex) {
		case 0:
			return shape0_WORDS;
		case 1:
			return shape1_WORDS;
		case 2:
			return shape2_WORDS;
		case 3:
			return shape3_WORDS;
		case 4:
			return shape4_WORDS;
		case 5:
			return shape5_WORDS;
		case 6:
			return shape6_WORDS;
		case 7:
			return shape7_WORDS;

		default:
			return new Word[0];
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

	public static String getDefaultNumPhoneticSounds(int itemIndex) {
		switch (itemIndex) {
		case 0:
			return "zero";
		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
		case 4:
			return "four";
		case 5:
			return "five";
		case 6:
			return "six";
		case 7:
			return "seven";
		case 8:
			return "eight";
		case 9:
			return "nine";
		case 10:
			return "ten";

		default:
			return "";
		}
	}

	public static String getDefaultColorPhoneticSounds(int itemIndex) {
		switch (itemIndex) {
		case 0:
			return "red";
		case 1:
			return "green";
		case 2:
			return "blue";
		case 3:
			return "orange";
		case 4:
			return "brown";
		case 5:
			return "yellow";
		case 6:
			return "violet";
		case 7:
			return "black";
		case 8:
			return "white";
		case 9:
			return "grey";

		default:
			return "";
		}
	}

	public static String getDefaultShapePhoneticSounds(int itemIndex) {
		switch (itemIndex) {

		case 0:
			return "circle";
		case 1:
			return "square";
		case 2:
			return "diamond";
		case 3:
			return "oval";
		case 4:
			return "triangle";
		case 5:
			return "pentagon";
		case 6:
			return "hexagon";
		case 7:
			return "star";

		default:
			return "";
		}
	}
}
