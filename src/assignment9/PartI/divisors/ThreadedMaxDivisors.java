package assignment9.PartI.divisors;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class ThreadedMaxDivisors implements Runnable {
	
	private long min;
	private long max;
	
	private static int divisorsNum;
	private static int maxNum;
	
	private static long currValue;
	
	public ThreadedMaxDivisors(long min, long max) {
		this.min = min;
		this.max = max;
		this.currValue = min;
	}
	
	
	@Override
	
	public void run() {
	
		int divisors = CountDivisors.countDivisors(currValue);
		if (divisors >= divisorsNum) {
			divisorsNum = divisors;
			maxNum = (int) (currValue);
		}
		currValue++;
	   	//System.out.println(currValue);
	

	}
	

	public static void main(String[] args) {
		
		long min = 5000;
		long max = 20000;
		int resultDivisorNum = 0;
		int resultNum = 0;
		Set<Thread> threadSet = new HashSet<Thread>();
		Set<ThreadedMaxDivisors> divisorsSet = new HashSet<ThreadedMaxDivisors>();
		long startTime = System.currentTimeMillis();
		for (long i = min; i < max; i++) {
			ThreadedMaxDivisors currThread = new ThreadedMaxDivisors(min, max);
			threadSet.add(new Thread(currThread));
			divisorsSet.add(currThread);
			//System.out.println(threadSet.size());
		
		}
		
		/* join() tells a thread to wait until it's complete before the rest of the code and proceed.
		 * if we do that for all the threads, then then we can get the results of the threads once
		 * all of them are done
		 */
		for (Thread t: threadSet) {
			try {
				t.start();
				t.join();
				//System.out.print("Done");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// at this point, all threads have been completed, since we
		// called the "join()" method on all the threads we created,
		// which forces the code to wait until the thread is finished
		// before we continue
		
		for (ThreadedMaxDivisors tmd : divisorsSet) {
			// presumably you've recorded the results of
			// each ThreadedMaxDivisors run. Pick
			// the largest number with the largest number of
			// divisors
			
			if (tmd.divisorsNum >= resultDivisorNum) {
				resultDivisorNum = tmd.divisorsNum;
				resultNum = tmd.maxNum;
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
