import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

	public static ReentrantLock lock = new ReentrantLock();

	public static Condition condition = lock.newCondition();

	public static void main(String args[]) {
		new Thread(() ->test3()).start();
		new Thread(() ->test3()).start();
		new Thread(() ->test3()).start();
	}

	public static void test3 () {
		try{
			lock.lock();
		} finally {
			lock.unlock();
		}
	}

	public static void test () {
		try{
			lock.lock();
			condition.await();
			System.out.println(1);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}

	public static void test2 () {
		try{
			lock.lock();
			condition.signalAll();
			System.out.println(1);
		} finally {
			lock.unlock();
		}
	}
}
