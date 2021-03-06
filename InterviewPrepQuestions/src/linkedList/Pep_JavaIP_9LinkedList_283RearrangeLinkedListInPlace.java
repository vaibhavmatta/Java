package linkedList;

import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_283RearrangeLinkedListInPlace {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		insert(a1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			insert(a);
		}

		rearrange();
		display();

	}

	private static class Node {
		int data;
		Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

	}

	static Node head;
	static Node tail;
	static int size;

	public static void insert(int data) {

		Node nn = new Node(data, null);
		if (head == null) {
			head = nn;
			tail = nn;
		} else {
			tail.next = nn;
			tail = nn;
		}
		size++;
	}

	public static Node search_Node(Node head, int k) {
		while (head != null) {
			if (head.data == k) {
				return head;
			}
			head = head.next;
		}
		return null;
	}

	public static void display() {
		for (Node node = head; node != null; node = node.next) {
			System.out.print(node.data + " ");
		}
	}

	private static class heapmover {
		Node left;
	}

	// -----------------------------------------------
	// Functional Problem. Only this function is needed to be written.
	private static void rearrange() {
		heapmover hp = new heapmover();
		hp.left = head;
		System.out.println(size);
		helper(hp, head, 0);
	}

	private static void helper(heapmover hp, Node right, int floor) {

		if (right == null) {
			return;
		}
		helper(hp, right.next, floor + 1);
//        if(floor>=size/2){
//            hp.left.next=null;
//            return;
//        }
		if (floor > size / 2) {
			Node temp = hp.left.next;
			hp.left.next = right;
			right.next = temp;
			hp.left=temp;
		}else if(floor==size/2) {
			right.next=null;
		}
	}

	// ----------------------------------------------------------------

}