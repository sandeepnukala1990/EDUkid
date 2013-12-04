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
	private TextView correctScore;
	private TextView wrongScore;
	private int correct=0;
	private int wrong=0;
	int MainID; //to store Letter for the Question
	int[] letterTracker; //Array containing the letters for each button
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.temp_game);
		
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();

		categoryType = (CategoryType) extras
				.getSerializable(EDUkid.CATEGORY_TYPE);
		
		Database.getInstance(this);
		correctScore = (TextView) findViewById(R.id.correctScore);
		wrongScore = (TextView) findViewById(R.id.wrongScore);
		
		setQuestions();
		//this set the letter to C for MainID=2
		
		
	}
	
	public void setQuestions(){

		Random rand = new Random();		
		
		TextView alphabet = (TextView) findViewById(R.id.gamemodeAlphabet);
		ImageButton image1= (ImageButton) findViewById(R.id.gameImage1);
		ImageButton image2= (ImageButton) findViewById(R.id.gameImage2);
		ImageButton image3= (ImageButton) findViewById(R.id.gameImage3);
		ImageButton image4= (ImageButton) findViewById(R.id.gameImage4);
		
	
		letterTracker = new int[4];
		int imageID;
		for(int i=0; i<4; i++){
			
			int option=rand.nextInt(26);
			//check for repeated letter after 1st letter is set
			if((letterTracker[i]==option)){
				option=rand.nextInt(26);
			}
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
		

		MainID=letterTracker[rand.nextInt(3)];
		String letter = DatabaseDefaults.getAlphabet()[MainID];
		alphabet.setText(letter);
	}
	
	public void onImageClick1(View view) {
		if(MainID==letterTracker[0]){	
			correct++;
			correctScore.setText(""+correct);
		Toast.makeText(this, "Correct Answer! Well Done! ", Toast.LENGTH_SHORT)
				.show();
		}
		else{
			wrong++;
			wrongScore.setText(""+wrong);
			Toast.makeText(this, "Wrong Answer!Try Again :) ", Toast.LENGTH_SHORT)
			.show();
		}
	}
	
	public void onImageClick2(View view) {		
		if(MainID==letterTracker[1]){	
			correct++;
			correctScore.setText(""+correct);
			Toast.makeText(this, "Correct Answer!", Toast.LENGTH_SHORT)
					.show();
			}
		else{
			wrong++;
			wrongScore.setText(""+wrong);
			Toast.makeText(this, "Wrong Answer!Try Again :) ", Toast.LENGTH_SHORT)
			.show();
		}
	}
	
	public void onImageClick3(View view) {
		if(MainID==letterTracker[2]){
			correct++;
			correctScore.setText(""+correct);
			Toast.makeText(this, "Correct Answer!", Toast.LENGTH_SHORT)
					.show();
			}
		else{
			wrong++;
			wrongScore.setText(""+wrong);
			Toast.makeText(this, "Wrong Answer!Try Again :) ", Toast.LENGTH_SHORT)
			.show();
		}
	}
	
	public void onImageClick4(View view) {
		if(MainID==letterTracker[3]){	
			correct++;
			correctScore.setText(""+correct);
			Toast.makeText(this, "Correct Answer!", Toast.LENGTH_SHORT)
					.show();
			}
		else{
			wrong++;
			wrongScore.setText(""+wrong);
			Toast.makeText(this, "Wrong Answer!Try Again :) ", Toast.LENGTH_SHORT)
			.show();
		}
	}
	
	public void onRefreshClick(View view){
		setQuestions();
	}
	
	
}
