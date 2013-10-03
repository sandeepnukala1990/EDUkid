package bu.edu.cs673.edukid.learn.grid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.learn.LearnContentView;
import bu.edu.cs673.edukid.learn.LearnType;

public class LearnContentGridView extends Activity implements
		OnItemClickListener {

	private LearnType learnType;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.learn_content_grid);

		Intent intent = getIntent();
		Bundle extras = intent.getExtras();

		learnType = (LearnType) extras.get("LearnType");

		GridView gridview = (GridView) findViewById(R.id.learnContentGrid);
		gridview.setAdapter(new LearnContentItemAdapter(this, learnType));
		gridview.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent = new Intent(this, LearnContentView.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.putExtra("LearnType", learnType);
		intent.putExtra("Position", position);
		startActivity(intent);
	}
}
