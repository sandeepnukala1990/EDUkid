package bu.edu.cs673.edukid.settings.timer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.Database;

public class TimerView extends Activity {

	private Database database = Database.getInstance(this);

	private static final int TIME_FACTOR = 1000 * 60;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timer);

		final ToggleButton btn = (ToggleButton) findViewById(R.id.toggleButton);
		final Button btn1 = (Button) findViewById(R.id.AddWordAddButton);
		final EditText time = (EditText) findViewById(R.id.playTime);

		long databaseTime = database.getTimer().getLearnTime();
		int userTime = convertFromDatabase(databaseTime);
		time.setText("" + userTime);

		time.setEnabled(false);
		btn1.setEnabled(false);
		if(database.getTimer().getEnabled()==1)
		{
			time.setEnabled(true);
			btn1.setEnabled(true);
			btn.setChecked(true);
		}
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				if (btn.isChecked()) {
					time.setEnabled(true);
					btn1.setEnabled(true);
				} else {
					time.setEnabled(false);
					btn1.setEnabled(false);
					database.updateTimer(false, false, database.getTimer().getLearnTime());
				}
			}
		});

		btn1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				database.updateTimer(true,false,database.getTimer().getLearnTime());
				Toast.makeText(TimerView.this, "Timer Reset! Go play !",
						Toast.LENGTH_SHORT).show();
				
			}
		});
		
		Button btn2 = (Button) findViewById(R.id.createSaveButton);
		btn2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				final int time2 = Integer.parseInt(time.getText().toString());
				long time3 = convertToDatabase(time2);
				database.updateTimer(true, false, time3);
				Toast.makeText(TimerView.this, "Saved Successfully",
						Toast.LENGTH_SHORT).show();
			}

		});

		time.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});
	}

	private int convertFromDatabase(long databaseTime) {
		return (int) (databaseTime / TIME_FACTOR);
	}

	private long convertToDatabase(int userTime) {
		return userTime * TIME_FACTOR;
	}
}
