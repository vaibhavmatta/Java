package linkedList;

import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_272MergeSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		insert(a1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			insert(a);
		}

		Node res=mergeSort(head);
		display(res);
//		Node node = new Node(10);
//		node.next = new Node(20);
//		node.next.next = new Node(30);
//		node.next.next.next = new Node(40);
//		node.next.next.next.next = new Node(50);
//		System.out.println(getMiddle(node).data);

//		Node node2 = new Node(5);
//		node2.next = new Node(15);
//		node2.next.next = new Node(25);
//		node2.next.next.next = new Node(35);
//		node2.next.next.next.next = new Node(45);
	}

	private static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

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

	public static void display(Node n) {
		for (Node node = n; node != null; node = node.next) {
			System.out.print(node.data + " ");
		}
	}

	public static Node sortedMerge(Node a, Node b) {
		Node start = null;
		Node end = null;

		while (a != null && b != null) {
			if (a.data < b.data) {
				if (start == null) {
					start = a;
					end = a;
					a = a.next;
				} else {
					end.next = a;
					end = end.next;
					a = a.next;
				}
			} else {
				if (start == null) {
					start = b;
					end = b;
					b = b.next;
				} else {
					end.next = b;
					end = end.next;
					b = b.next;
				}
			}
		}

		while (a != null) {
			if (start == null) {
				start = a;
				end = a;
				a = a.next;
			} else {
				end.next = a;
				end = end.next;
				a = a.next;
			}
		}

		while (b != null) {
			if (start == null) {
				start = b;
				end = b;
				b = b.next;
			} else {
				end.next = b;
				end = end.next;
				b = b.next;
			}
		}

		return start;
	}

	public static Node mergeSort(Node node) {
		if (node == null||node.next==null) 
        { 
            return node; 
        } 
		Node middle = getMiddle(node);
		Node middleNext = middle.next;
		middle.next = null;
		Node left = mergeSort(node);
		Node right = mergeSort(middleNext);
		Node mergedList = sortedMerge(left, right);
		return mergedList;
	}

	public static Node getMiddle(Node node) {
		if (node == null) {
			return null;
		}
		Node slow = node;
		Node fast = node.next;
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				slow = slow.next;
				fast = fast.next;
			}
		}
		return slow;
	}

	// Utility function to get the middle of the linked list
//	public static  Node getMiddle(Node h)  
//    { 
//        //Base case 
//        if (h == null) 
//            return h; 
//        Node fastptr = h.next; 
//        Node slowptr = h; 
//          
//        // Move fastptr by two and slow ptr by one 
//        // Finally slowptr will point to middle node 
//        while (fastptr != null) 
//        { 
//            fastptr = fastptr.next; 
//            if(fastptr!=null) 
//            { 
//                slowptr = slowptr.next; 
//                fastptr=fastptr.next; 
//            } 
//        } 
//        return slowptr; 
//    } 

}