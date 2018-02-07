// Lecture 3 Questions and Solutions

// CTCI 3.2: Stack Min, design a stack which, in addition to push and pop, has a function which 
// returns the minimum element
// push, pop, and min should all operate in O(1) time

// The solution should be a stack that keeps track of min values,
// using the extend keyword so that you can use all attributes found normally in a stack
// basically this min stack behaves so that it keeps the minimum value of the stack
// at the top of the stack, and when it's popped off, it means that the original
// stack must've also popped that value off, etc
public class StackWithMin2 extends Stack<Integer> {
	Stack<Integer> s2;
	public StackWithMin2() {
		s2 = new Stack<Integer>();
	}

	// for push, you want to push the value onto the stack keeping track of mins
	// only if it is smaller than the current min() value
	// you always want to use super.push(value); regardless of whether
	// or not it's a min value
	public void push(int value) {
		if (value <= min()) {
			s2.push(value);
		}
		super.push(value);
	}

	// you only want to pop values off of the stack keep track of mins
	// if the value you're popping is the same as the minimum value
	// because then the minimum value will increase because
	// you're popping off the minimum value from the normal stack
	public Integer pop() {
		int value = super.pop();
		if (value == min()) {
			s2.pop();
		}
		return value;
	}

	// min() simply returns what the minimum value is on the stack
	// which is the same as peek() onto a stack where the value at the top
	// is the minimum value
	public int min() {
		if (s2.empty()) {
			return Integer.MAX_VALUE;
		} else {
			return s2.peek();
		}
	}
}

// CTCI 3.4: Queue via Stacks: implement a queue using stacks
// Using two stacks, you can have one behave like a normal stack
// and when you need to dequeue or peek, just pop off all the elements
// from the normal stack into a second stack, where the order will be reversed
// and will behave as if the original stack is a queue

public class MyQueue<T> {
	Stack<T> s1, s2;
	public MyQueue() {
		s1 = new Stack<T>();
		s2 = new Stack<T>();
	}

	// just a function that returns size
	public int size() {
		return s1.size() + s2.size();
	}

	// the same as enqueue, so all you need to do when you add something to a queue
	// is to add it to the beginning, which since you will eventualyl reverse the stack
	// you can just push it to the top of the stack like normal
	public void add(T value) {
		s1.push(value);
	}

	// when you peek() at the stack, if the second stack, which is the stack that
	// is the queue version of s1, as long as it's not empty, it's the first
	// element in the queue
	// if it is empty, then you need to pop of all the elements using a while loop from s1
	// into s2, which is now behaving like a queue 
	public T peek() {
		if(!s2.empty()) {
			return s2.peek();
		}
		while(!s1.empty()) {
			s2.push(s1.pop());
		}
		return s2.peek();
	}

	// same reasoning as above
	public T remove() {
		if(!s2.empty()) {
			return s2.pop();
		}
		while(!s1.empty()) {
			s2.push(s1.pop());
		}
		return s2.pop();
	}
} 

// CTCI 3.6: Sort Stack: sort a stack using two stacks
// the general solution is that you have two stacks
// you want to pop a value off of the stack you're putting in
// now you want to push all of those values 
public static Stack<Integer> sort(Stack<Integer>s) {
	Stack<Integer> r = new Stack<Integer>();
	while(!s.isEmpty()) {
		int tmp = s.pop();
		while(!r.isEmpty() && r.peek() > tmp) {
			s.push(r.pop());
		}
		r.push(tmp);
	}
	return r;
}

boolean isPalindrome(LinkedListNode head) {
	LinkedListNode fast = head;
	LinkedListNode slow = head;
	Stack <Integer> stack = new Stack <Integer>();
	while(fast != null && fast.next != null) {
		stack.push(slow.data);
		slow = slow.next;
		fast = fast.next.next;
	}
	if(fast != null) {
		slow = slow.next;
	}
	while (slow != null) {
		int top = stack.pop();
		if(top != slow.data) {
			return false;
		}
		slow = slow.next;
	}
	return true;
}


