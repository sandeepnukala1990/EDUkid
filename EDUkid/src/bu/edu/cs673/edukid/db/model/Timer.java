package bu.edu.cs673.edukid.db.model;

public class Timer {

		private int expired;
		
		private int enabled;
		
		private long timeleft;
		
		private long leartime;

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

		public long getTimeleft() {
			return timeleft;
		}

		public void setTimeleft(long timeleft) {
			this.timeleft = timeleft;
		}

		public long getLeartime() {
			return leartime;
		}

		public void setLeartime(long leartime) {
			this.leartime = leartime;
		}
}
