package bu.edu.cs673.edukid.db.model.category;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.DatabaseDefaults;
import bu.edu.cs673.edukid.db.model.Letter;
import bu.edu.cs673.edukid.db.model.Word;

@SuppressWarnings("serial")
public class AlphabetCategory implements CategoryType {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCategoryName() {
		return "Alphabet";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Drawable getCategoryImage(Context context) {
		return context.getResources().getDrawable(R.drawable.tiletry);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getItems() {
		return DatabaseDefaults.getAlphabet();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getItem(int itemIndex) {
		return DatabaseDefaults.getAlphabet()[itemIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemCount() {
		return DatabaseDefaults.getAlphabet().length;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getItemPhoneticSound(int itemIndex) {
		Letter letter = Database.getInstance().getLetters().get(itemIndex);

		if (letter != null) {
			String letterSound = letter.getLetterSound();

			if (letterSound != null && !letterSound.isEmpty()) {
				return letterSound;
			}
		}

		return DatabaseDefaults.getDefaultAlphabetPhoneticSounds(itemIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getItemWords(int itemIndex) {
		// TODO: need a database query first

		return DatabaseDefaults.getDefaultAlphabetWords(itemIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getItemWord(int itemIndex, int wordIndex) {
		// TODO: Jasjot: this is your code from Database.java. It now belongs
		// here. Uncomment this and fix it please.
		int listIndex = itemIndex;

		if (Database.getInstance().getAlphabets().size() != 0) {
			Word alp = null;
			do {
				alp = Database.getInstance().getAlphabets().get(listIndex);

				if (alp.getLid() == itemIndex) {
					if (alp.getThemeId() == wordIndex) {
						return alp.getWord();
					} else
						listIndex++;
				} else
					listIndex++;
			} while (alp.getLid() <= itemIndex);
			return DatabaseDefaults.getDefaultAlphabetWords(itemIndex).get(
					wordIndex);
		} else
			// return null;
			return DatabaseDefaults.getDefaultAlphabetWords(itemIndex).get(
					wordIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemWordCount(int itemIndex) {
		return DatabaseDefaults.getDefaultAlphabetWords(itemIndex).size();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addItemWord(int itemIndex, int wordIndex, Word word) {
		// TODO: Jasjot, implement this
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
		return DatabaseDefaults.getDefaultAlphabetDrawableIds(itemIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemImage(int itemIndex, int imageIndex) {
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
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canDeleteCategory() {
		return false;
	}
}
