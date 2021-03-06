package linkedList;

import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_282PointToNextHigherValue {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		insert(a1);
		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			insert(a);
		}
		setArbitrary();
		Node result = mergeSort(head);
		display(result);
	}

	private static class Node {
		int data;
		Node next;
		Node arbitrary;

		public Node(int data, Node next, Node arbitrary) {
			this.data = data;
			this.next = next;
			this.arbitrary = arbitrary;
		}

	}

	static Node head;
	static Node tail;
	static int size;

	public static void insert(int data) {
		Node nn = new Node(data, null, null);
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

	public static void display(Node nn) {
		for (Node node = nn; node != null; node = node.arbitrary) {
			System.out.print(node.data + " ");
		}
		// Node result=search_Node(nn, 3);

	}

	// -------------------------------------------
	// Functional problem. You just have to write this function.
	// The display function is set on arbitrary pointer. Starting from pointer
	// returned by merge sort, it will go to the node, pointed by arbitrary node.
	// As the pointer returned by mergesort, always contains the node having smallest value and arbitrary pointer
	// takes us to the next higher value. So, it should display sorted output.
	public static void setArbitrary() {
        Node temp=head;
        while(temp!=null){
            temp.arbitrary=temp.next;
            temp=temp.next;
        }
	}

	public static Node mergeLists(Node a, Node b) {

        Node start = null;
        Node end = null;

        while (a != null && b != null) {
            if (a.data < b.data) {
                if (start == null) {
                    start = a;
                    end = a;
                    a = a.arbitrary;
                } else {
                    end.arbitrary = a;
                    end = end.arbitrary;
                    a = a.arbitrary;
                }
            } else {
                if (start == null) {
                    start = b;
                    end = b;
                    b = b.arbitrary;
                } else {
                    end.arbitrary = b;
                    end = end.arbitrary;
                    b = b.arbitrary;
                }
            }
        }

        while (a != null) {
            if (start == null) {
                start = a;
                end = a;
                a = a.arbitrary;
            } else {
                end.arbitrary = a;
                end = end.arbitrary;
                a = a.arbitrary;
            }
        }

        while (b != null) {
            if (start == null) {
                start = b;
                end = b;
                b = b.arbitrary;
            } else {
                end.arbitrary = b;
                end = end.arbitrary;
                b = b.arbitrary;
            }
        }

        return start;

    }

    public static Node mergeSort(Node node) {
        if (node == null||node.arbitrary==null) 
        { 
            return node; 
        } 
        Node middle = getMidNode(node);
        Node middleNext = middle.arbitrary;
        middle.arbitrary = null;
        Node left = mergeSort(node);
        Node right = mergeSort(middleNext);
        Node mergedList = mergeLists(left, right);
        return mergedList;


    }

    public static Node getMidNode(Node node) {
        if (node == null) {
            return null;
        }
        Node slow = node;
        Node fast = node.arbitrary;
        while (fast != null) {
            fast = fast.arbitrary;
            if (fast != null) {
                slow = slow.arbitrary;
                fast = fast.arbitrary;
            }
        }
        return slow;

    }
	// ----------------------------------------------

}