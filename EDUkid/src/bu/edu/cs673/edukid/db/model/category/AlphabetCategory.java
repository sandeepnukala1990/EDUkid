package bu.edu.cs673.edukid.db.model.category;

import java.util.ArrayList;
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
		if(Database.getInstance().getLetters().size()!=0)
		{
			
			return Database.getInstance().getLetters().get(itemIndex).getLetter();
		}
		return DatabaseDefaults.getAlphabet()[itemIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemCount() {
		if(Database.getInstance().getLetters().size()!=0)
		{
			
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

		return DatabaseDefaults.getDefaultAlphabetPhoneticSounds(itemIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Word[] getItemWords(int itemIndex) {
		// TODO: need a database query first
		List<Word> wordList = new ArrayList<Word>();
		for(Word defaultWord : DatabaseDefaults.getDefaultAlphabetWords(itemIndex))
		{
			wordList.add(defaultWord);
		}
		
		
		List<Word> dbWords=Database.getInstance().getWords();
		if(dbWords.size()>0)
		{
			wordList.addAll(dbWords);
			/*word = new Word[5];
			for(int i=0;i<5;i++)
			{
					if(Database.getInstance().getWords().get(i)!=null&&
							Database.getInstance().getWords().get(i).getLid()==itemIndex)
						word[i]=Database.getInstance().getWords().get(i);
			}
			if(word!=null)
				return word;*/
		}
		return wordList.toArray(new Word[0]);
		
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Word getItemWord(int itemIndex, int wordIndex) {
		// TODO: Jasjot: this is your code from Database.java. It now belongs
		// here. Uncomment this and fix it please.
		int listIndex = itemIndex;

		if (Database.getInstance().getWords().size() != 0) {
			Word alp = null;
			do {
				alp = Database.getInstance().getWords().get(listIndex);

				if (alp.getLid() == itemIndex) {
					if (alp.getThemeId() == wordIndex) {
						return alp;
					} else
					listIndex++;
				} else
					listIndex++;
			} while (alp.getLid() <= itemIndex);
			return DatabaseDefaults.getDefaultAlphabetWords(itemIndex)[wordIndex];
		} else
			// return null;
			return DatabaseDefaults.getDefaultAlphabetWords(itemIndex)[wordIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemWordCount(int itemIndex) {
		return DatabaseDefaults.getDefaultAlphabetWords(itemIndex).length;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addItemWord(int itemIndex, int wordIndex, Word word) {
		// TODO: Jasjot, implement this
		//Database.getInstance().addWords(itemIndex, wordIndex, word.getWord(), word.getWordSound(), null);
		
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
		return DatabaseDefaults.getDefaultAlphabetWords(itemIndex)[imageIndex]
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
