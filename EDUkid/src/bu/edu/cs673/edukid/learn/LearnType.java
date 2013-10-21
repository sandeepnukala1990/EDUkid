package bu.edu.cs673.edukid.learn;

import bu.edu.cs673.edukid.R;

public enum LearnType {

	ALPHABET("ALPHABET", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
			"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
			"Y", "Z"), NUMBERS("Numbers", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"), SHAPES("Shapes"), COLORS("Colors"), CUSTOM(
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

	public String[] getDefaultWords(int index) {

		switch (this) {
		case ALPHABET:
			return getAlphabetWords(index);
		case NUMBERS:
			return getNumbersWords(index);
		case SHAPES:
			return getShapeWords(index);
		case COLORS:
			return getColorWords(index);
		 
			// TODO: Fix this. Just temporary.
		default:
			return new String[] { };
		}
	}
	public String getDefaultSound(int index)
	{
		switch (this)
		{
		case ALPHABET:
			return getWordPhoneticSound( index);
		case NUMBERS:
			return getNumberPhoneticSound(index);
		case SHAPES:
			return getShapePhoneticSound(index);
		case COLORS:
			return getColorPhoneticSound(index);
		default:
			return "";
		}
	}
	public int getDefaultImage(int index) {

		switch (this) {
		case ALPHABET:
			return getAlphabetImage(index);
		case NUMBERS:
			return getNumbersImage(index);
		case SHAPES:
			return getShapeImage(index);
		case COLORS:
			return getColorImage(index);
			// TODO: Fix this. Just temporary.
		default:
			return R.drawable.edukidicon;
		}
	}
	private int getShapeImage(int index)
	{
		switch (index) {
		

			// TODO: Fix this. Just temporary.
		default:
			return R.drawable.edukidicon;
		}
	}
	private int getColorImage(int index)
	{
		switch (index) {
		

			// TODO: Fix this. Just temporary.
		default:
			return R.drawable.edukidicon;
		}
	}
	private int getAlphabetImage(int index)
	{
		switch (index) {
		case 0:
			return R.drawable.apple;

			// TODO: Fix this. Just temporary.
		default:
			return R.drawable.edukidicon;
		}
	}
	
	private int getNumbersImage(int index)
	{
		switch (index) {
		case 0:
			return R.drawable.mickey_mouse;

			// TODO: Fix this. Just temporary.
		default:
			return R.drawable.edukidicon;
		}
	}

	public String[] getShapeWords(int index) {

		// TODO: These need to be changed. Just trying these out.
		switch (index) {
		case 0:
			return new String[] { "Circle" };
		case 1:
			return new String[] { "Oval" };
		case 2:
			return new String[] {  "Triangle"};
		case 3:
			return new String[] { "Diamond" };
		case 4:
			return new String[] { "Square" };
		case 5:
			return new String[] { "Rectangle" };
		case 6:
			return new String[] {  "Star" };
		case 7:
			return new String[] {"Pentagon"};
		case 8:
			return new String[] {  "Hexagon" };
	
		default:
			return new String[] { };
		}
	}
	public String[] getColorWords(int index) {

		// TODO: These need to be changed. Just trying these out.
		switch (index) {
		case 0:
			return new String[] { "White" };
		case 1:
			return new String[] { "Black" };
		case 2:
			return new String[] { "Red" };
		case 3:
			return new String[] { "Orange" };
		case 4:
			return new String[] { "Yellow"};
		case 5:
			return new String[] { "Green" };
		case 6:
			return new String[] { "Blue" };
		case 7:
			return new String[] { "Indigo" };
		case 8:
			return new String[] { "Violet" };
	
		
		default:
			return new String[] { };
		}
	}
	public String[] getNumbersWords(int index) {

		// TODO: These need to be changed. Just trying these out.
		switch (index) {
		case 0:
			return new String[] { "Zero" };
		case 1:
			return new String[] { "One" };
		case 2:
			return new String[] { "Two" };
		case 3:
			return new String[] { "Three" };
		case 4:
			return new String[] { "Four" };
		case 5:
			return new String[] { "Five" };
		case 6:
			return new String[] { "Six" };
		case 7:
			return new String[] { "Seven" };
		case 8:
			return new String[] { "Eight" };
		case 9:
			return new String[] { "Nine" };
		
		default:
			return new String[] { };
		}
	}
	
	public String[] getAlphabetWords(int index) {

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

	public String getWordPhoneticSound(int index) {

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
	public String getShapePhoneticSound(int index) {

		// TODO: These need to be changed. Just trying these out.
		switch (index) {
		case 0:
			return "circle";
		case 1:
			return "oval";
		case 2:
			return "triangle";
		case 3:
			return "diamond";
		case 4:
			return "square";
		case 5:
			return "rectangle";
		case 6:
			return "star";
		case 7:
			return "pentagon";
		case 8:
			return "hexagon";
		
		default:
			return "";
		}
	}
	public String getColorPhoneticSound(int index) {

		// TODO: These need to be changed. Just trying these out.
		switch (index) {
		case 0:
			return "white";
		case 1:
			return "Black";
		case 2:
			return "red";
		case 3:
			return "orange";
		case 4:
			return "yellow";
		case 5:
			return "green";
		case 6:
			return "blue";
		case 7:
			return "indigo";
		case 8:
			return "violet";
		
		default:
			return "";
		}
	}
	public String getNumberPhoneticSound(int index) {

		// TODO: These need to be changed. Just trying these out.
		switch (index) {
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
		
		default:
			return "";
		}
	}
}