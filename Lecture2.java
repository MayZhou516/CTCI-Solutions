// Lecture 2 Questions and Solutions

// CTCI 2.2: Find the nth to last element of a linked list
static Node nthToLast(Node list, int n) {
	// if the list is null or n is too small, you simply want to return null
	if (list == null || n < 1) {
		return null;
	}
	
	// set currentNode to the head of the list given
	// the head of the list is the same as the list
	Node currentNode = list;

	Node currentLastNode = list;
	// loop through all the way until n
	// at the end of this loop, currentLastNode will be n away from the start
	for (int i = 1; i < n; i ++) {
		if (currentListNode.next == null) {
			return null;
		}
		currentLastNode = currentLastNode.next;
	}

	// start with the other pointer still at head, currentLastNode is n away from end
	// move the two pointers, and eventually the original pointer at the head will be n away
	while (currentLastNode.next != null) {
		currentNode = currentNode.next;
		currentLastNode = currentLastNode.next;
	}
	return currentNode;
} 

// CTCI 2.4: Adding together two linked lists
// given two linked lists representing reversed numbers, return a linked list
// representing the sum of the two numbers
static Node add(Node a, Node b, int carryout) {
  /* BASE CASE: Both lists are empty. Checking the carry value also takes care
  * of both Nodes being null because you have reached the end of the lists. */
  if (a==null && b==null && carryout==0) return null;

  Node result = new Node(); // the head of the entire Linked List result
  int carryin = carryout;

  // These separate statements take care of cases like 42 + 9

  if (a != null) carryin = carryin + a.data;

  if (b != null) carryin = carryin + b.data;

  // If 4 + 9 is 13, you only want to store 3 and carry over the 1

  result.data = carryin % 10; 

  Node next_a = if (a.next != null) a.next else null;
  Node next_b = if (b.next != null) b.next else null;

  result.next = add(next_a, next_b, carryin / 10);

  return result;
}
  
// CTCI 2.5: Detecting a cycle in a linked list

// optimized solution
LinkedListNode findBeginning(LinkedListNode head) {
	LinkedListNode slow = head;
	LinkedListNode fast = head;

	// goes through the entire linked list, and it breaks when the two nodes collide together
	while (fast != null && fast.next != null) {
		slow = slow.next;
		fast = fast.next.next;
		if (slpw == fast) {
			break;
		}
	}

	// if either the next node, or the next next node for fast is null, it means that there is no cycle
	if (fast == null || fast.next == null) {
		return null;
	}

	// when the first while loop exited, and if there is a cycle, then currently the fast and slow node 
	// are together, meaning that however many nodes away from the beginning of the loop, is now far
	// away the slow and the fast node are
	// move both of them towards where the cycle occurs
	slow = head;
	while (slow != fast) {
		slow = slow.next;
		fast = fast.next;
	}

	return fast
}