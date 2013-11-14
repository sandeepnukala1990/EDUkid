package bu.edu.cs673.edukid.db.model.category;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.DatabaseDefaults;
import bu.edu.cs673.edukid.db.model.Num;
import bu.edu.cs673.edukid.db.model.Word;

@SuppressWarnings("serial")
public class NumbersCategory implements CategoryType {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCategoryName() {
		return "Numbers";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Drawable getCategoryImage(Context context) {
		return context.getResources().getDrawable(R.drawable.numbersnew);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getItems() {
		// TODO: don't hardcode
		return DatabaseDefaults.getNumbers();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getItem(int itemIndex) {
		return DatabaseDefaults.getNumbers()[itemIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemCount() {
		return DatabaseDefaults.getNumbers().length;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getItemPhoneticSound(int itemIndex) {
		// TODO
		Num num = Database.getInstance().getNums().get(itemIndex);

		if (num != null) {
			String NumberSound = num.getNumberSound();

			if (NumberSound != null && !NumberSound.isEmpty()) {
				return NumberSound;
			}
		}

		return DatabaseDefaults.getDefaultNumPhoneticSounds(itemIndex);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getItemWords(int itemIndex) {
		// TODO
		return DatabaseDefaults.getDefaultnumWords(itemIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getItemWord(int itemIndex, int wordIndex) {
		// TODO
		return DatabaseDefaults.getDefaultnumWords(itemIndex).get(wordIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemWordCount(int itemIndex) {
		// TODO
		return DatabaseDefaults.getDefaultnumWords(itemIndex).size();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addItemWord(int itemIndex, int wordIndex, Word word) {
		Database.getInstance().addNumbers(itemIndex, wordIndex, "", "", null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void editItemWord(int itemIndex, int wordIndex, Word word) {
		// TODO: Jasjot, implement this
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Integer> getItemImages(int itemIndex) {
		// TODO
		return DatabaseDefaults.getDefaultnumDrawableIds(itemIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemImage(int itemIndex, int imageIndex) {
		// TODO
		return getItemImages(itemIndex).get(imageIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemTextSize() {
		return 128;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canAddItems() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canDeleteCategory() {
		return false;
	}
}
