package assignment2.part3;

/* You're going to sum up the numbers 0 to 100 but you are
 * going to skip any number divisible by 10. 
 */
public class SumZeroToOneHundredSkipTens {

	public static void main(String[] args) {
		
		// you can use any kind of loop you want
		// have a counter that counts from 0 to 100
		
		int sum = 0;
		
		// the first loop has the structure of 
		// if (counter is not divisible by 10)
		// then
		//    sum += counter;
		for (int counter = 0; counter <= 100; counter++){
			if (counter % 10 != 0) {
				sum += counter;
			}
		}
		System.out.println("SUM calculated by for loop is: " + sum);
		sum = 0;
		// the second loop has the structure of:
		// if (counter is divisible by 10)
		// then
		//  continue
		// and then it adds the counter to the sum if that condition does not execute
		for (int counter = 0; counter <= 100; counter++){
			if (counter % 10 == 0) {
				continue;
			} else {
				sum += counter;
			}
		}
		System.out.println("SUM controled by continue is: " + sum);
	}
}

