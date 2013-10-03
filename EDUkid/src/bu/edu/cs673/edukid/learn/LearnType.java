package bu.edu.cs673.edukid.learn;

import bu.edu.cs673.edukid.R;

public enum LearnType {

	ALPHABET("Alphabet", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
			"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
			"Y", "Z"), NUMBERS("Numbers"), SHAPES("Shapes"), COLORS("Colors"), CUSTOM(
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

	public String getDefaultWord(int index) {

		// TODO: These need to be changed. Just trying these out.
		switch (index) {
		case 0:
			return "Apple";
		case 1:
			return "Book";
		case 2:
			return "Caterpillar";
		case 3:
			return "Drive";
		case 4:
			return "Elephant";
		case 5:
			return "Fox";
		case 6:
			return "Giraffe";
		case 7:
			return "Hippo";
		case 8:
			return "Igloo";
		case 9:
			return "Jupiter";
		case 10:
			return "Key";
		case 11:
			return "Lion";
		case 12:
			return "Monkey";
		case 13:
			return "Nose";
		case 14:
			return "Office";
		case 15:
			return "Pencil";
		case 16:
			return "Quick";
		case 17:
			return "River";
		case 18:
			return "Snake";
		case 19:
			return "Tiger";
		case 20:
			return "Umbrella";
		case 21:
			return "Violin";
		case 22:
			return "Wagon";
		case 23:
			return "Xylophone";
		case 24:
			return "Yo-yo";
		case 25:
			return "Zebra";
		default:
			return "";
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