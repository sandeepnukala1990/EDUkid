package bu.edu.cs673.edukid.settings;

import android.graphics.drawable.Drawable;

public class SettingsRow {

	public enum CheckedState {
		YES, NO, HIDDEN
	};

	private String item;

	private Drawable image;

	private CheckedState checkedState;

	private boolean defaultWord;

	public SettingsRow(String item, Drawable image) {
		this(item, image, false, false);
		checkedState = CheckedState.HIDDEN;
	}

	public SettingsRow(String item, Drawable image, boolean checked,
			boolean defaultWord) {
		this.item = item;
		this.image = image;
		this.checkedState = checked ? CheckedState.YES : CheckedState.NO;
		this.defaultWord = defaultWord;
	}

	public String getItem() {
		return item;
	}

	public Drawable getImage() {
		return image;
	}

	public CheckedState getCheckedState() {
		return checkedState;
	}

	public boolean isDefaultWord() {
		return defaultWord;
	}
}
