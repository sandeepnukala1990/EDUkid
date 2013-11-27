package bu.edu.cs673.edukid.settings.timer;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import bu.edu.cs673.edukid.R;

public class TimerView extends Activity {

	private String time;
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timer);
		
		Button btn=(Button) findViewById(R.id.createSaveButton);
		btn.setOnClickListener(new View.OnClickListener() {
			
		

			@Override
			public void onClick(View v) {
				
			}
					
				
			
		});
		EditText time = (EditText)findViewById(R.id.playTime);
		time.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
