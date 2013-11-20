package bu.edu.cs673.edukid.db.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import bu.edu.cs673.edukid.db.ImageUtils;
import bu.edu.cs673.edukid.db.model.category.CategoryType;

@SuppressWarnings("serial")
public class Category implements CategoryType {

	private long id;

	private String categoryName;

	private Drawable image;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Drawable getCategoryImage(Context context) {
		return image;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getItems() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getItem(int itemIndex) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemCount() {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getItemPhoneticSound(int itemIndex) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Word[] getItemWords(int itemIndex) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Word getItemWord(int itemIndex, int wordIndex) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemWordCount(int itemIndex) {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addItemWord(int itemIndex, Word word) {
		// TODO
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
		return -1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemTextSize() {
		return 0;
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
		return true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public byte[] getImageData() {
		return ImageUtils.drawableToByteArray(image);
	}

	public void setImageData(byte[] imageData) {
		image = ImageUtils.byteArrayToDrawable(imageData);
	}
}
