import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static CountDownLatch latch = new CountDownLatch(3);

	public static void main(String args[]) {
		new Thread(() ->test()).start();
		new Thread(() ->test()).start();
		new Thread(() ->test()).start();
		latch.countDown();
		latch.countDown();
		latch.countDown();
		System.out.println(1);

	}

	public static void test () {
		try {
			latch.await();
			System.out.println(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
