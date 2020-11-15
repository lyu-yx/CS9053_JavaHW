package assignment9.PartI.divisors;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//
//My computer has 2 core 4 thread which means
//if we devided this task into more than 4 thread
//there should be no significant different.While
//smaller amount of thread below 4 has impact.


public class ThreadedMaxDivisors implements Runnable {
	
	private long min;
	private long max;
	
	private  long divisorsNum;
	private  long maxNum;
	
	//private static long currValue;
	
	public ThreadedMaxDivisors(long min, long max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public void run() {

		Entry result = CountDivisors.maxDivisors(min, max);
		divisorsNum = (long)result.getValue();
		maxNum = (long)(result.getKey());

	}
	

	public static void main(String[] args) {
		
		long min = 100_000;
		long max = 200_000;
		long resultDivisorNum = 0;
		long resultNum = 0;
		long interval = 1000;
		Set<Thread> threadSet = new HashSet<Thread>();
		Set<ThreadedMaxDivisors> divisorsSet = new HashSet<ThreadedMaxDivisors>();
		long startTime = System.currentTimeMillis();
		ExecutorService executor = Executors.newCachedThreadPool();
		for (long i = min; i < max; i += interval) {
			ThreadedMaxDivisors currThread = new ThreadedMaxDivisors(i, i + interval - 1);
			divisorsSet.add(currThread);
			executor.execute(currThread);
		}


		executor.shutdown();

		while (!executor.isTerminated()) {
		}
		System.out.println("done!");
		// at this point, all threads have been completed, since we
		// called the "join()" method on all the threads we created,
		// which forces the code to wait until the thread is finished
		// before we continue
		
		for (ThreadedMaxDivisors tmd : divisorsSet) {
			// presumably you've recorded the results of
			// each ThreadedMaxDivisors run. Pick
			// the largest number with the largest number of
			// divisors
			//System.out.println("inside" + tmd.maxNum + "  =  " + tmd.divisorsNum);
			if (tmd.divisorsNum >= resultDivisorNum) {
				resultDivisorNum = tmd.divisorsNum;
				resultNum = tmd.maxNum;
				if (tmd.divisorsNum == resultDivisorNum && tmd.maxNum > resultNum) {
					resultNum = tmd.maxNum;
				}
			}
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("\n" + resultNum + "= " + resultDivisorNum);
		System.out.println("Threaded elapsed time: " + (endTime - startTime));
		
		
		
		startTime = System.currentTimeMillis();
		Entry<Long,Long> e = CountDivisors.maxDivisors(min, max);
		
		long number = e.getKey();
		long numDivisors = e.getValue();
		
		System.out.println("\n" + number + "= " + numDivisors);
		endTime = System.currentTimeMillis();
		
		System.out.println("Non-threaded elapsed time: " + (endTime - startTime));
		
		
		
		
	}
}
