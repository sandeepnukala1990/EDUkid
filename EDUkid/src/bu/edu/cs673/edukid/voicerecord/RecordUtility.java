package bu.edu.cs673.edukid.voicerecord;

import java.io.IOException;

import bu.edu.cs673.edukid.R;

import android.media.MediaRecorder;
import android.os.Environment;

public class RecordUtility {

	MediaRecorder recorder;
	String mFileName;
	Boolean start=true;
	

	private void startRecording(String filename) {
		// micImage.setBackgroundResource(R.id.accountCreationRecorderButton);
		recorder = new MediaRecorder();
		mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
		mFileName += "/"+filename+".3gp";
		System.out.println(mFileName);
		recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
		recorder.setOutputFile(mFileName);
		try {
			recorder.prepare();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		recorder.start();
	}

	private void stopRecording() {
		recorder.stop();
		recorder.release();
		recorder = null;

	}
	public int recordVoice(String filename) {
		if (start) {
			startRecording(filename);
			start=false;
			return R.drawable.recordmikebutton;
		} else {
			stopRecording();
			start=true;
			return R.drawable.mikebutton;
		}
	}
	public int recordVoice(){
		stopRecording();
		start=true;
		return R.drawable.mikebutton;
	}
	public String getLastFilename(){
		return mFileName;
	}

}
