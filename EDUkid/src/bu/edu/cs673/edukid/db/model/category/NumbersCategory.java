package bu.edu.cs673.edukid.db.model.category;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.DatabaseHelper;
import bu.edu.cs673.edukid.db.defaults.DatabaseDefaults;
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
	public int getCategoryId() {
		return Category.NUMBERS.ordinal();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Drawable getCategoryImage(Context context) {
		return context.getResources().getDrawable(R.drawable.numbers_selector);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addItem(String item) {
		// TODO
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

		return DatabaseDefaults.getDefaultNumberPhoneticSounds()[itemIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getDefaultWordCount(int itemIndex) {
		return DatabaseDefaults.getDefaultNumberWords()[itemIndex].length;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Word[] getSettingsItemWords(int itemIndex) {
		// TODO
		return DatabaseDefaults.getDefaultNumberWords()[itemIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Word getSettingsItemWord(int itemIndex, int wordIndex) {
		// TODO
		return DatabaseDefaults.getDefaultNumberWords()[itemIndex][wordIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Word[] getLearnItemWords(int itemIndex) {
		// TODO: for now, getting all the words. fix this.
		return getSettingsItemWords(itemIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Word getLearnItemWord(int itemIndex, int wordIndex) {
		return getLearnItemWords(itemIndex)[wordIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLearnItemWordCount(int itemIndex) {
		// TODO
		return DatabaseDefaults.getDefaultNumberWords()[itemIndex].length;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addItemWord(int itemIndex, Word word) {
		// Database.getInstance().addNumbers(itemIndex, "", "", null);
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
	public void deleteItemWord(int itemIndex, int wordIndex) {
		// TODO
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getSettingsItemDrawableId(int itemIndex, int imageIndex) {
		// TODO
		return DatabaseDefaults.getDefaultNumberWords()[itemIndex][imageIndex]
				.getDrawableId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Drawable getSettingsItemDrawable(int itemIndex, int imageIndex) {
		List<Drawable> drawableList = new ArrayList<Drawable>();

		List<Word> databaseWords = Database.getInstance().getWords(
				DatabaseHelper.generateWordsSelection(itemIndex));

		if (databaseWords.size() > 0) {
			for (Word databaseWord : databaseWords) {
				drawableList.add(databaseWord.getWordDrawable());
			}
		}

		return drawableList.get(imageIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLearnItemDrawableId(int itemIndex, int imageIndex) {
		return getLearnItemWords(itemIndex)[imageIndex].getDrawableId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Drawable getLearnItemDrawable(int itemIndex, int imageIndex) {
		return getLearnItemWords(itemIndex)[imageIndex].getWordDrawable();
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
	public boolean hasGameMode() {
		return false;
	}
}
