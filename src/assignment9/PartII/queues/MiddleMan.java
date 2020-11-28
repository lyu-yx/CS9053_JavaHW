package assignment9.PartII.queues;

import java.util.Queue;

public abstract class MiddleMan implements Runnable {

	public static int DELAY = 20;
	Queue<?> in;
	Queue<Object> out;
	Object outObj;
	
	public MiddleMan(Queue<? extends Object> in, Queue<Object> out) {
		this.in = in;
		this.out = out;
		outObj = null;
	}
	
	public abstract boolean isInstance(Class clazz);
	
	@Override
	public void run() {
		while (true) {
			if (outObj == null) {
				synchronized(in) { // <-- you will uncomment this after you finish Question 1
					if ((in.peek() != null) && (isInstance(in.peek().getClass()))) {
						this.outObj = in.remove();
						
					} else {
						this.outObj = null;
						continue;
					}
				} // <-- uncomment this after you finish Question 1
			}


			if (outObj != null) {

					//System.out.println("outsize:  "+ out.size());
					/* We have our object which we've removed from the
					 * input queue. keep checking if the size of the
					 * output queue is greater than or equal to 10. Sleep and
					 * check again until that's no longer true.
					 */
					while (out.size() >= 10) {
						try {
							Thread.sleep((long) (DELAY * Math.random()));
						} catch (InterruptedException e) {

							e.printStackTrace();
						}
					}
				}

					/* if it turns out the output queue has somehow
					 * become larger than 10 again, start all over again,
					 * but keep our output object, otherwise put the
					 * output object on the queue and set the output
					 * object to null
					 */
			synchronized(out) {
					if (out.size() >= 10) {
						continue;
					} else {
						out.offer(outObj);
						if (out.contains(null)) {
							System.out.println("why did this happen?");
						}
						outObj = null;
					}

			}
			try {
				Thread.sleep((long) (DELAY*Math.random()));
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			} 
		}
		
	}
	
	
}
