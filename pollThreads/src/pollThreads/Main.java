package pollThreads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		CountDownLatch lock = new CountDownLatch(10);

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
		
		ScheduledFuture<?> future = executor.scheduleAtFixedRate(() -> {
		    System.out.println("Hello World");
		    lock.countDown();
		}, 500, 100, TimeUnit.MILLISECONDS);

		lock.await(1000, TimeUnit.MILLISECONDS);
		future.cancel(true);
	}


	}
