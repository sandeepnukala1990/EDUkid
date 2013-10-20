package bu.edu.cs673.edukid.learn;

import bu.edu.cs673.edukid.R;

public enum LearnType {

	ALPHABET("ALPHABET", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
			"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
			"Y", "Z"), NUMBERS("NUMBERS"), SHAPES("SHAPES"), COLORS("COLORS"), CUSTOM(
			"");

	private String name;

	private String[] items;

	private LearnType(String name, String... items) {
		this.name = name;
		this.items = items;
	}

	public String getName() {
		return name;
	}

	public String[] getItems() {
		return items;
	}

	public String getItem(int index) {
		return items[index];
	}

	public int getDefaultImage(int index) {

		switch (index) {
		case 0:
			return R.drawable.apple;

			// TODO: Fix this. Just temporary.
		default:
			return R.drawable.edukidicon;
		}
	}

	public String[] getDefaultWords(int index) {

		// TODO: These need to be changed. Just trying these out.
		switch (index) {
		case 0:
			return new String[] { "Apple" };
		case 1:
			return new String[] { "Book" };
		case 2:
			return new String[] { "Caterpillar" };
		case 3:
			return new String[] { "Drive" };
		case 4:
			return new String[] { "Elephant" };
		case 5:
			return new String[] { "Fox" };
		case 6:
			return new String[] { "Giraffe" };
		case 7:
			return new String[] { "Hippo" };
		case 8:
			return new String[] { "Igloo" };
		case 9:
			return new String[] { "Jupiter" };
		case 10:
			return new String[] { "Key" };
		case 11:
			return new String[] { "Lion" };
		case 12:
			return new String[] { "Monkey" };
		case 13:
			return new String[] { "Nose" };
		case 14:
			return new String[] { "Office" };
		case 15:
			return new String[] { "Pencil" };
		case 16:
			return new String[] { "Quick" };
		case 17:
			return new String[] { "River" };
		case 18:
			return new String[] { "Snake" };
		case 19:
			return new String[] { "Tiger" };
		case 20:
			return new String[] { "Umbrella" };
		case 21:
			return new String[] { "Violin" };
		case 22:
			return new String[] { "Wagon" };
		case 23:
			return new String[] { "Xylophone" };
		case 24:
			return new String[] { "Yo-yo" };
		case 25:
			return new String[] { "Zebra" };
		default:
			return new String[] {};
		}
	}

	public String getItemPhoneticSound(int index) {

		// TODO: These need to be changed. Just trying these out.
		switch (index) {
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