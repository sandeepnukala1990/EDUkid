package bu.edu.cs673.edukid.db.model;

public class DefaultWordMapping {

	private long categoryId;

	private long itemId;

	private long wordId;

	private boolean checked;

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public long getWordId() {
		return wordId;
	}

	public void setWordId(long wordId) {
		this.wordId = wordId;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
