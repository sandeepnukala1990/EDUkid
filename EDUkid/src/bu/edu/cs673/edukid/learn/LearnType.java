package bu.edu.cs673.edukid.learn;

public enum LearnType {

	ALPHABET("Alphabet"),
	NUMBERS("Numbers"),
	SHAPES("Shapes"),
	COLORS("Colors"),
	CUSTOM("");
	
	private String name;
	
	private LearnType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
