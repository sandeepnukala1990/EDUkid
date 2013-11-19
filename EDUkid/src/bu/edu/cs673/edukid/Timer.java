package bu.edu.cs673.edukid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.TextView;

public class Timer extends Activity {
	private TextView timerValue;

	private long startTime = 0L;

	private Handler customHandler = new Handler();

	long timeInMilliseconds = 0L;

	long timeSwapBuff = 0L;

	long updatedTime = 0L;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edukid);
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				AlertDialog.Builder alert = new AlertDialog.Builder(Timer.this);
				alert.setTitle("Timed OUT! Go to bed");
				alert.setPositiveButton("Ok",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO

							}
						});
				alert.create();
				alert.show();
			}
		}, 180000);
		timerValue = (TextView) findViewById(R.id.timerValue);

		startTime = SystemClock.uptimeMillis();
		updateTimerThread.run();


}private Runnable updateTimerThread = new Runnable() {

	public void run() {

		timeInMilliseconds = SystemClock.uptimeMillis() - startTime;

		updatedTime = timeSwapBuff + timeInMilliseconds;

		int secs = (int) (updatedTime / 1000);

		int mins = secs / 60;

		secs = secs % 60;

		int milliseconds = (int) (updatedTime % 1000);

		timerValue.setText("" + mins + ":"

		+ String.format("%02d", secs) + ":"

		+ String.format("%03d", milliseconds));

		customHandler.postDelayed(this, 0);

	}

};
}
