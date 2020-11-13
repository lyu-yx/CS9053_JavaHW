package assignment9.PartII.queues;

import java.util.Queue;

public class StringMiddleMan extends MiddleMan {

	public StringMiddleMan(Queue<Object> in, Queue<Object> out) {
		super(in, out);
		
	}

	@Override
	public boolean isInstance(Class clazz) {
		/* this is similar to (obj instanceof String) for all intents
		 * and purposes
		 */
		if (clazz == String.class) {
			return true;
		}
		return false;
	}

}
