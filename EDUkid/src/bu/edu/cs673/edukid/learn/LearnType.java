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

		switch (index) {
		case 0:
			return "Apple";

			// TODO: Fix this. Just temporary.
		default:
			return "Coming Soon";
		}
	}
}