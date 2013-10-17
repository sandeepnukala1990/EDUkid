package bu.edu.cs673.edukid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class EDUsplash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edusplash);
		
		Thread Timer = new Thread()
		{
			public void run(){
				try{
					sleep(3000);
					Intent intent = new Intent(EDUsplash.this, EDUkid.class);
					startActivity(intent);
				}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			finally{
				finish();
			}
		
			}
		
		};
		Timer.start();
	}
}
