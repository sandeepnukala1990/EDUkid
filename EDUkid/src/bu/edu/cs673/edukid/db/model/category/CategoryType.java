package bu.edu.cs673.edukid.db.model.category;

import java.io.Serializable;
import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;

public interface CategoryType extends Serializable {

	/**
	 * Gets the category name.
	 * 
	 * @return the category name.
	 */
	String getCategoryName();

	/**
	 * Gets the category image.
	 * 
	 * @param context
	 *            the context.
	 * @return the category image.
	 */
	Drawable getCategoryImage(Context context);

	/**
	 * Gets the items from the database.
	 * 
	 * @return the items from the database.
	 */
	String[] getItems();

	/**
	 * Gets an item from the database with the given item index.
	 * 
	 * <p>
	 * Note: an item in this context could be represented by a letter in the
	 * alphabet (0 is A, 1 is B, 2 is C, and so on).
	 * </p>
	 * 
	 * @param itemIndex
	 *            the item index.
	 * @return the item in string form.
	 */
	String getItem(int itemIndex);

	/**
	 * Returns the number of items for this category type.
	 * 
	 * @return the number of items for this category type.
	 */
	int getItemCount();

	/**
	 * Gets the phonetic sound with the given item index.
	 * 
	 * @param itemIndex
	 *            the item index.
	 * @return the phonetic sound with the given item index.
	 */
	String getItemPhoneticSound(int itemIndex);

	/**
	 * Gets the associated words for a given item.
	 * 
	 * @param itemIndex
	 *            the item index.
	 * @return the associated words for a given item.
	 */
	List<String> getItemWords(int itemIndex);

	/**
	 * Gets the specific word given an item index and word index.
	 * 
	 * @param itemIndex
	 *            the item index.
	 * @param wordIndex
	 *            the word index.
	 * @return the specific word given an item index and word index.
	 */
	String getItemWord(int itemIndex, int wordIndex);

	/**
	 * Gets the item word count for this category type.
	 * 
	 * @param itemIndex
	 *            the item index.
	 * @return the item word count for this category type.
	 */
	int getItemWordCount(int itemIndex);

	/**
	 * Gets the item image given the item index and image index.
	 * 
	 * @param itemIndex
	 *            the item index.
	 * @param imageIndex
	 *            the image index.
	 * @return the item image given the item index and image index.
	 */
	int getItemImage(int itemIndex, int imageIndex);

	/**
	 * Gets the item text size that will be used when shown on the screen.
	 * 
	 * @return the item text size that will be used when shown on the screen.
	 */
	int getItemTextSize();

	/**
	 * Returns true if this category type is able to add items, false otherwise.
	 * 
	 * @return true if this category type is able to add items, false otherwise.
	 */
	boolean canAddItems();
}
