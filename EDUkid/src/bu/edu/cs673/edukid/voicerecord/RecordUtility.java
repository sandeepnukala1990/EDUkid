package bu.edu.cs673.edukid.voicerecord;

import java.io.IOException;

import android.media.MediaRecorder;
import android.os.Environment;
import android.widget.ImageView;
import bu.edu.cs673.edukid.R;

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
		// TODO
	}
}
