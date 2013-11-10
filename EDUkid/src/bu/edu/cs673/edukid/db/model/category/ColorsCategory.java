package bu.edu.cs673.edukid.db.model.category;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.DatabaseDefaults;

@SuppressWarnings("serial")
public class ColorsCategory implements CategoryType {

	@Override
	public String getCategoryName() {
		return "Colors";
	}

	@Override
	public Drawable getCategoryImage(Context context) {
		return context.getResources().getDrawable(R.drawable.colorsnew);
	}

	@Override
	public String[] getItems() {
		// TODO: don't hardcode
		return new String[] { "Red", "White", "Blue", "Green", "Black" };
	}

	@Override
	public String getItem(int itemIndex) {
		// TODO
		return "" + itemIndex;
	}

	@Override
	public int getItemCount() {
		return 5;
	}

	@Override
	public String getItemPhoneticSound(int itemIndex) {
		// TODO
		return "";
	}

	@Override
	public List<String> getItemWords(int itemIndex) {
		// TODO
		return DatabaseDefaults.getDefaultAlphabetWords(itemIndex);
	}

	@Override
	public String getItemWord(int itemIndex, int wordIndex) {
		// TODO
		return DatabaseDefaults.getDefaultAlphabetWords(itemIndex).get(
				wordIndex);
	}

	@Override
	public int getItemWordCount(int itemIndex) {
		// TODO
		return DatabaseDefaults.getDefaultAlphabetWords(itemIndex).size();
	}

	@Override
	public int getItemImage(int itemIndex, int imageIndex) {
		// TODO
		return DatabaseDefaults.getDefaultAlphabetDrawableIds(itemIndex).get(
				imageIndex);
	}

	@Override
	public int getItemTextSize() {
		return 50;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canAddItems() {
		return true;
	}
}
