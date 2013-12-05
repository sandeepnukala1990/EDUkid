package bu.edu.cs673.edukid.settings.utils;

import java.io.IOException;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.widget.ImageView;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.model.category.CategoryType;
/**
 * The audio record and playback utilities.
 * 
 * @author Peter Trevino
 * 
 * @see RecordUtility
 * 
 */
public class RecordUtility {

	private static final String PATH = Environment
			.getExternalStorageDirectory().getAbsolutePath();

	private static MediaRecorder recorder;

	public static String startRecording(String name, ImageView image) {
		image.setBackgroundResource(R.drawable.recordmikebutton);

		recorder = new MediaRecorder();
		recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

		String savedFilePath = PATH + "/" + name + ".3gp";
		System.out.println(savedFilePath);
		recorder.setOutputFile(savedFilePath);

		try {
			recorder.prepare();
			recorder.start();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return savedFilePath;
	}

	public static void stopRecording(ImageView image) {
		image.setBackgroundResource(R.drawable.mikebutton);
		recorder.stop();
		recorder.release();
		recorder = null;
	}

	public static void playbackRecording(String path) {
		MediaPlayer mp = new MediaPlayer();

	    try {
	        mp.setDataSource(path);
	        mp.prepare();
	        mp.start();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }	}
}
