package bu.edu.cs673.edukid.db.model;

public class Timer {

	private int expired;

	private int enabled;

	private long learnTime;

	public int getExpired() {
		return expired;
	}

	public void setExpired(int expired) {
		this.expired = expired;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public long getLearnTime() {
		return learnTime;
	}

	public void setLearnTime(long learnTime) {
		this.learnTime = learnTime;
	}
}
