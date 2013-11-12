package bu.edu.cs673.edukid.db.model.category;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.DatabaseDefaults;
import bu.edu.cs673.edukid.db.model.Shape;

@SuppressWarnings("serial")
public class ShapesCategory implements CategoryType {

	@Override
	public String getCategoryName() {
		return "Shapes";
	}

	@Override
	public Drawable getCategoryImage(Context context) {
		return context.getResources().getDrawable(R.drawable.shapesnew);
	}

	@Override
	public String[] getItems() {
		// TODO: don't hardcode
		return DatabaseDefaults.getShapes();
	}

	@Override
	public String getItem(int itemIndex) {
		// TODO
		return DatabaseDefaults.getShapes()[itemIndex];
	}

	@Override
	public int getItemCount() {
		return DatabaseDefaults.getShapes().length;
	}

	@Override
	public String getItemPhoneticSound(int itemIndex) {
		// TODO
		Shape shape = Database.getInstance().getShapes().get(itemIndex);

		if (shape != null) {
			String ShapeSound = shape.getShapeSound();

			if (ShapeSound != null && !ShapeSound.isEmpty()) {
				return ShapeSound;
			}
		}

		return DatabaseDefaults.getDefaultShapePhoneticSounds(itemIndex);
	
	
	}

	@Override
	public List<String> getItemWords(int itemIndex) {
		// TODO
		return DatabaseDefaults.getDefaultShapeWords(itemIndex);
	}

	@Override
	public String getItemWord(int itemIndex, int wordIndex) {
		// TODO
		return DatabaseDefaults.getDefaultShapeWords(itemIndex).get(
				wordIndex);
	}

	@Override
	public int getItemWordCount(int itemIndex) {
		// TODO
		return DatabaseDefaults.getDefaultShapeWords(itemIndex).size();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Integer> getItemImages(int itemIndex) {
		// TODO
		return DatabaseDefaults.getDefaultShapeDrawableIds(itemIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemImage(int itemIndex, int imageIndex) {
		// TODO
		return getItemImages(itemIndex).get(imageIndex);
	}

	@Override
	public int getItemTextSize() {
		return 50;
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
