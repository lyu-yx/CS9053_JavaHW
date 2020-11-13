package assignment9.PartII.queues;

import java.util.Queue;

public class IntegerMiddleMan extends MiddleMan {

	public IntegerMiddleMan(Queue<Object> in, Queue<Object> out) {
		super(in, out);
		
	}

	@Override
	public boolean isInstance(Class clazz) {
		/* this is similar to (obj instanceof Integer) for all intents
		 * and purposes
		 */
		if (clazz == Integer.class) {
			return true;
		}
		return false;
	}

}
