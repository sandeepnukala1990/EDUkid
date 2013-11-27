package bu.edu.cs673.edukid.settings.timer;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;
import bu.edu.cs673.edukid.R;

public class TimerView extends Activity {

	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timer);
		final ToggleButton btn = (ToggleButton) findViewById(R.id.toggleButton);
		final Button btn1 = (Button) findViewById(R.id.button1);
		final EditText time = (EditText) findViewById(R.id.playTime);
		time.setEnabled(false);
		btn1.setEnabled(false);
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				if (btn.isChecked()) {
					time.setEnabled(true);
					btn1.setEnabled(true);
				} else {
					time.setEnabled(false);
					btn1.setEnabled(false);
				}
			}
		});

	
		Button btn2=(Button) findViewById(R.id.createSaveButton);
		btn2.setOnClickListener(new View.OnClickListener() {
			
		

			@Override
			public void onClick(View v) {
				
			}
					
				
			
		});
		EditText time1 = (EditText)findViewById(R.id.playTime);
		time1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
