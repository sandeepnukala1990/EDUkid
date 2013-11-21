package bu.edu.cs673.edukid.db.model.category;

import android.content.Context;
import android.graphics.drawable.Drawable;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.Database;
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

		return DatabaseDefaults.getDefaultNumberPhoneticSounds()[itemIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Word[] getItemWords(int itemIndex) {
		// TODO
		return DatabaseDefaults.getDefaultnumWords(itemIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Word getItemWord(int itemIndex, int wordIndex) {
		// TODO
		return DatabaseDefaults.getDefaultnumWords(itemIndex)[wordIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemWordCount(int itemIndex) {
		// TODO
		return DatabaseDefaults.getDefaultnumWords(itemIndex).length;
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
	public int getItemDrawableId(int itemIndex, int imageIndex) {
		// TODO
		return DatabaseDefaults.getDefaultnumWords(itemIndex)[imageIndex]
				.getDrawableId();
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
	public boolean canModifyCategory() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasGameMode() {
		return false;
	}
}
