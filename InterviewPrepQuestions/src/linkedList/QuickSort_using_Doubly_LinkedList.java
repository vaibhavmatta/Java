package linkedList;

//A Java program to sort a linked list using Quicksort 
class QuickSort_using_Doubly_LinkedList {
	Node head;

	/* a node of the doubly linked list */
	static class Node {
		private int data;
		private Node next;
		private Node prev;

		Node(int d) {
			data = d;
			next = null;
			prev = null;
		}
	}

	Node lastNode(Node node) {
		while (node.next != null)
			node = node.next;
		return node;
	}

	Node partition(Node l, Node h) {
		int pivot = h.data;
		Node i = l.prev;
		for (Node j = l; j != h; j = j.next) {
			if (j.data <= pivot) {
				i = (i == null) ? l : i.next;
				int temp = j.data;
				j.data = i.data;
				i.data = temp;
			}
		}

		i = (i == null) ? l : i.next;
		int temp = i.data;
		i.data = h.data;
		h.data = temp;
		return i;
	}

	void _quickSort(Node l, Node h) {
		
		if (h != null && l != h && l != h.next) { // l!=h.next bcoz when two elements are left(bache hue) and are already sorted it will call a case of h.next,h on right call 
			Node partition = partition(l, h);
			_quickSort(l, partition.prev);
			_quickSort(partition.next, h);
		}
	}

	public void quickSort(Node node) {
		Node lnode = lastNode(node);
		_quickSort(node, lnode);
	}

	// A utility function to print contents of arr
	public void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	/* Function to insert a node at the beginging of the Doubly Linked List */
	void push(int new_Data) {
		Node new_Node = new Node(new_Data); /* allocate node */

		// if head is null, head = new_Node
		if (head == null) {
			head = new_Node;
			return;
		}

		/* link the old list off the new node */
		new_Node.next = head;

		/* change prev of head node to new node */
		head.prev = new_Node;

		/* since we are adding at the begining, prev is always NULL */
		new_Node.prev = null;

		/* move the head to point to the new node */
		head = new_Node;
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		QuickSort_using_Doubly_LinkedList list = new QuickSort_using_Doubly_LinkedList();

		list.push(5);
		list.push(20);
		list.push(4);
		list.push(3);
		list.push(30);

		System.out.println("Linked List before sorting ");
		list.printList(list.head);
		System.out.println("\nLinked List after sorting");
		list.quickSort(list.head);
		list.printList(list.head);

	}
}
