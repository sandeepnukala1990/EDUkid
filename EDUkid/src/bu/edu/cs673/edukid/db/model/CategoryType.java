package bu.edu.cs673.edukid.db.model;

public enum CategoryType {

	ALPHABET("Alphabet"), NUMBERS("Numbers"), SHAPES("Shapes"), COLORS("Colors"), CUSTOM(
			"");

	private String name;

	private CategoryType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}