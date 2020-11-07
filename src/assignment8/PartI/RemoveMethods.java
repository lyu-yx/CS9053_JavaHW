package assignment8.PartI;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RemoveMethods {

	public static void remAllStack(Stack<Object> stack, Object item) {
		Stack<Object> stackTemp = new Stack<>();
		Object itemTemp;
		if (stack.size() == 0) {
			System.out.println("Empty stack");
			return;
		} else if (stack.contains(item) == false) {
			return;
		} else {
			int stackSize = stack.size();
			for (int i = 0; i < stackSize; i++) {
				itemTemp = stack.pop();
				if (item.equals(itemTemp) == false) {
					stackTemp.push(itemTemp);
				}
			}
			stackSize = stackTemp.size();
			for (int i = 0; i < stackSize; i++) {
				stack.push(stackTemp.pop());
			}
		}
	}
	
	public static void remAllQueue(Queue<Object> queue, Object item) {
		if (queue.size() == 0) {
			System.out.println("Empty queue");
			return;
		} else if (queue.contains(item) == false) {
			return;
		} else {
			Object queueElement;
			int queueSize = queue.size();
			for (int i = 0; i < queueSize; i++) {
				queueElement = queue.poll();
				if (!item.equals(queueElement)) {
					queue.offer(queueElement);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Stack<Object> stk = new Stack<Object>();
		stk.push(new Integer(24));
		stk.push(new Integer(2));
		stk.push(new Integer(9));
		stk.push(new Integer(2));
		stk.push(new Integer(7));
		stk.push(new Integer(10));
		stk.push(new Integer(16));
		System.out.println("begin: stk is " + stk);
		RemoveMethods.remAllStack(stk, new Integer(2));
		System.out.println("end: stk is " + stk);
		RemoveMethods.remAllStack(stk, new Integer(24));
		System.out.println("end: stk is " + stk);
		
		Queue<Object> q = new LinkedList<>(); // you should probably find a concrete class for this
		q.offer(new Integer(24));
		q.offer(new Integer(2));
		q.offer(new Integer(9));
		q.offer(new Integer(2));
		q.offer(new Integer(7));
		q.offer(new Integer(10));
		q.offer(new Integer(16));
		System.out.println("begin: q is " + q);
		RemoveMethods.remAllQueue(q, new Integer(2));
		System.out.println("end: q is " + q);
		RemoveMethods.remAllQueue(q, new Integer(24));
		System.out.println("end: q is " + q);
		
	}
}
