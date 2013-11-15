package bu.edu.cs673.edukid.db.model.defaults;

import java.util.ArrayList;
import java.util.List;

import bu.edu.cs673.edukid.db.model.Word;

public class WordGroup {

	public Word[] words;

	public WordGroup(Word... words) {
		this.words = words;
	}

	public Word[] getWords() {
		return words;
	}

	// TODO
	public List<Integer> getDrawableIds() {
		List<Integer> drawableIds = new ArrayList<Integer>();

		return drawableIds;
	}
}
