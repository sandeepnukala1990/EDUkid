package bu.edu.cs673.edukid.game;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import bu.edu.cs673.edukid.EDUkid;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.defaults.DatabaseDefaults;
import bu.edu.cs673.edukid.db.model.category.CategoryType;



public class GameView extends Activity{
	private CategoryType categoryType; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.temp_game);
		
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();

		categoryType = (CategoryType) extras
				.getSerializable(EDUkid.CATEGORY_TYPE);
		
		Random rand = new Random();		
		
		TextView alphabet = (TextView) findViewById(R.id.gamemodeAlphabet);
		ImageButton image1= (ImageButton) findViewById(R.id.gameImage1);
		ImageButton image2= (ImageButton) findViewById(R.id.gameImage2);
		ImageButton image3= (ImageButton) findViewById(R.id.gameImage3);
		ImageButton image4= (ImageButton) findViewById(R.id.gameImage4);
		
		
		Database.getInstance(this);
		
		
		//sets image to that of mainID of letter
		//int image1ID= categoryType.getLearnItemDrawableId(MainID, 0);		
		//image1.setImageResource(image1ID);
		
		int[] letterTracker = new int[4];
		int imageID;
		for(int i=0; i<4; i++){
			
			int option=rand.nextInt(26);
			letterTracker[i]= option;
			
			switch(i){
			
			case 0: imageID= categoryType.getLearnItemDrawableId(option, 0);		
					image1.setImageResource(imageID);
					break;
					
			case 1: imageID= categoryType.getLearnItemDrawableId(option, 0);		
					image2.setImageResource(imageID);
					break;
					
			case 2: imageID= categoryType.getLearnItemDrawableId(option, 0);		
					image3.setImageResource(imageID);
					break;
			
			case 3: imageID= categoryType.getLearnItemDrawableId(option, 0);		
					image4.setImageResource(imageID);
					break;
			
			}
				
		}
		

		int MainID=letterTracker[rand.nextInt(3)];
		String letter = DatabaseDefaults.getAlphabet()[MainID];
		alphabet.setText(letter);
		//this set the letter to C for MainID=2
		
		
	}
	
	public void onImageClick(View view) {
		Toast.makeText(this, "Add item coming soon...", Toast.LENGTH_SHORT)
				.show();
	}
	
	
}
