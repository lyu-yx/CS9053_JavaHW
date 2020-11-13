package assignment9.PartI.divisors;

import java.util.AbstractMap;
import java.util.Map.Entry;

public class CountDivisors {

	public static int countDivisors(long val) {
		int divisorCount = 0;

        for (long testDivisor = 2; testDivisor <= val/2; testDivisor++) {
            if ( val % testDivisor == 0 )
                divisorCount++;
        }
        
        return divisorCount;
	}
	
	public static Entry<Long, Long> maxDivisors(long from, long to) {
		
		long maxDivisors = 0;
		long numFound = 0;
		long numberTested = 0;
		for (long num = from; num <= to; num++) {
			int divisors = countDivisors(num);
			if (divisors >= maxDivisors) {
				maxDivisors = divisors;
				numFound = num;
			}
			numberTested++;
            if (numberTested == 1000) {
                System.out.print('.');
                numberTested = 0;
            }
			
		}
		Entry<Long,Long> result = new AbstractMap.SimpleEntry<Long,Long>(numFound, maxDivisors);
		
		return result;
	}
	
	public static void main(String[] args) 
	{
		Entry<Long,Long> result = maxDivisors(100000, 200000);
		System.out.println("\n" + result);
	}
}
