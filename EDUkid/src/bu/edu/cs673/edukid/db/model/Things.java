package bu.edu.cs673.edukid.db.model;

import java.util.ArrayList;
import java.util.List;

public class Things {

	public Thing[] things;

	public Things(Thing... things) {
		this.things = things;
	}

	public List<String> getWords() {
		List<String> words = new ArrayList<String>();

		for (Thing thing : things) {
			words.add(thing.getWord());
		}

		return words;
	}

	public List<Integer> getDrawableIds() {
		List<Integer> drawableIds = new ArrayList<Integer>();

		for (Thing thing : things) {
			drawableIds.add(thing.getDrawableId());
		}

		return drawableIds;
	}
}
