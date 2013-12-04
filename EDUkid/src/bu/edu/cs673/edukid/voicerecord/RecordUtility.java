package bu.edu.cs673.edukid.voicerecord;

import java.io.IOException;

import android.media.MediaRecorder;
import android.os.Environment;

public class RecordUtility {

	MediaRecorder recorder;
	String mFileName;

	private void startRecording() {
		// micImage.setBackgroundResource(R.id.accountCreationRecorderButton);
		recorder = new MediaRecorder();
		//
		mFileName = Environment.getDataDirectory().getAbsolutePath();
		mFileName += "/audiorecordtest.3gp";
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
	public void onRecord(boolean start) {
		if (start) {
			startRecording();

		} else {
			stopRecording();
		}
	}

}
