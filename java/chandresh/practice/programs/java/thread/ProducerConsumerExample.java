package chandresh.practice.programs.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Meal {
	Meal() {
		System.out.println("Meal prepared");
	}
}

class Chef implements Runnable {
	private final Restaurent restaurent;
	int mealCounter = 0;

	public Chef(Restaurent restaurent) {
		this.restaurent = restaurent;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (this.restaurent.meal != null) {
						wait();
					}
				}

				if (++mealCounter >= 10) {
					this.restaurent.exec.shutdownNow();
				}

				synchronized (this.restaurent.waiter) {
					this.restaurent.meal = new Meal();
					this.restaurent.waiter.notifyAll();
				}
			}
		} catch (InterruptedException ie) {
			System.out.println("Interrupted as running out of meals");
		}

	}

}

class Waiter implements Runnable {
	private final Restaurent restaurent;

	public Waiter(Restaurent restaurent) {
		this.restaurent = restaurent;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (this.restaurent.meal == null) {
						wait();
					}
				}
				synchronized (this.restaurent.chef) {
					this.restaurent.meal = null;
					System.out.println("Meal consumed");
					this.restaurent.chef.notifyAll();
				}

			}
		} catch (InterruptedException ie) {
			System.out.println("Interrupted");
		}
	}
}

class Restaurent {
	Meal meal;
	Chef chef = new Chef(this);
	Waiter waiter = new Waiter(this);
	ExecutorService exec = Executors.newCachedThreadPool();

	public Restaurent() {
		exec.execute(waiter);
		exec.execute(chef);
	}
}

public class ProducerConsumerExample {

	public static void main(String args[]) {
		new Restaurent();
	}
}
