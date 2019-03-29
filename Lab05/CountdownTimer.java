import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer {

	Timer timer;

	public CountdownTimer(int seconds) {
		timer = new Timer();
		timer.schedule(new RemindTask(), seconds * 1000);
	}

	class RemindTask extends TimerTask {
		public void run() {
			System.out.println();
			System.out.println("****************Time's up! Your final score is " + Lab05.score + " ******************");
			timer.cancel();
			System.exit(0);

		}
	}
}