package bu.edu.cs673.edukid.db.model.category;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.defaults.DatabaseDefaults;
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
		if (Database.getInstance().getLetters().size() != 0) {

			return Database.getInstance().getLetters().get(itemIndex)
					.getLetter();
		}
		return DatabaseDefaults.getAlphabet()[itemIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemCount() {
		if (Database.getInstance().getLetters().size() != 0) {

			return Database.getInstance().getLetters().size();
		}
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

		return DatabaseDefaults.getDefaultAlphabetPhoneticSounds()[itemIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Word[] getSettingsItemWords(int itemIndex) {
		List<Word> wordList = new ArrayList<Word>();

		for (Word defaultWord : DatabaseDefaults
				.getDefaultAlphabetWords(itemIndex)) {
			wordList.add(defaultWord);
		}

		List<Word> dbWords = Database.getInstance().getWords();
		if (dbWords.size() > 0) {
			for (Word dbWord : dbWords) {
				if (dbWord.getLid() == itemIndex) {
					wordList.add(dbWord);
				}
			}
		}

		return wordList.toArray(new Word[0]);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Word getSettingsItemWord(int itemIndex, int wordIndex) {
		return getSettingsItemWords(itemIndex)[wordIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Word[] getLearnItemWords(int itemIndex) {
		// TODO: for now, getting all the words. fix this.
		List<Word> learnWords = new ArrayList<Word>();

		for (Word settingsItemWord : getSettingsItemWords(itemIndex)) {
			learnWords.add(settingsItemWord);
		}

		return learnWords.toArray(new Word[0]);
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
		return getSettingsItemWords(itemIndex).length;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addItemWord(int itemIndex, Word word) {
		Database.getInstance().addWord(itemIndex, word);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void editItemWord(int itemIndex, int wordIndex, Word word) {
		Database.getInstance().editWord(itemIndex, wordIndex, word);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemDrawableId(int itemIndex, int imageIndex) {
		List<Integer> drawableList = new ArrayList<Integer>();

		for (Word defaultWord : DatabaseDefaults
				.getDefaultAlphabetWords(itemIndex)) {
			drawableList.add(defaultWord.getDrawableId());
		}

		List<Word> dbWords = Database.getInstance().getWords();

		if (dbWords.size() > 0) {
			for (Word dbWord : dbWords) {
				if (dbWord.getDrawableId() == 0) {
					drawableList.add(R.drawable.edukidicon);
				} else {
					drawableList.add(dbWord.getDrawableId());
				}
			}
		}

		return drawableList.get(imageIndex);
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
	public boolean hasGameMode() {
		return true;
	}
}
