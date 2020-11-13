package assignment9.PartII.queues;

import java.util.Queue;

public class Consumer implements Runnable {

	public static final int DELAY = 400;
	
	Queue<Object> in;
	
	public Consumer(Queue<Object> in) {
		this.in = in;
	}
	
	@Override
	public void run() {
		Object a = null;
		Object b = null;
		while (true) {
			synchronized(in) {
				/* we set object a first, then set object b.
				 * Once they've both been set, "add" them together,
				 * either arithmetically, if they're numbers, or
				 * concatenating them according to their string representations.
				 */
				if (in.peek() != null) {
					Object obj = in.remove();
					if (a == null) {
						a = obj;
					} else if (b == null) {
						b = obj;
					}

					if ((a != null) && (b != null)) {
						System.out.print(this.toString() + ": ");
						if (a instanceof Number) {
							System.out.println( String.format("%f" ,((Number)a).doubleValue() + ((Number)b).doubleValue()));
						} else {
							System.out.println(a.toString() +" "+ b.toString());
						}
						a = null;
						b = null;
					}
				}
			}
			try {
				Thread.sleep((long) (Math.random()*DELAY));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
