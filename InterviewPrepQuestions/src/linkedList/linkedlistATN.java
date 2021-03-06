package linkedList;

//Java program to add two linked lists 

public class linkedlistATN {
	class node {
		int val;
		node next;

		public node(int val) {
			this.val = val;
		}
	}

	// Function to print linked list
	void printlist(node head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	node head1, head2, result;
	int carry;

	/* A utility function to push a value to linked list */
	void push(int val, int list) {
		node newnode = new node(val);
		if (list == 1) {
			newnode.next = head1;
			head1 = newnode;
		} else if (list == 2) {
			newnode.next = head2;
			head2 = newnode;
		} else {
			newnode.next = result;
			result = newnode;
		}

	}

	int getsize(node head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}

	void addlists() {
		int num1 = 0;
		while (head1 != null) {
			num1 = num1 * 10;
			num1 += head1.val;
			head1 = head1.next;
		}

		int num2 = 0;
		while (head2 != null) {
			num2 = num2 * 10;
			num2 += head2.val;
			head2 = head2.next;
		}
		result=null;

		int ans = num1 + num2;
		while (ans > 0) {
			node n = new node(ans % 10);
			n.next=result;
			result = n;
			ans=ans/10;
		}
		System.out.println(num1 + " " + num2);

	}

	// Driver program to test above functions
	public static void main(String args[]) {
		linkedlistATN list = new linkedlistATN();
		list.head1 = null;
		list.head2 = null;
		list.result = null;
		list.carry = 0;
		int arr1[] = { 9, 9, 9 };
		int arr2[] = { 1, 8 };

		// Create first list as 9->9->9
		for (int i = arr1.length - 1; i >= 0; --i)
			list.push(arr1[i], 1);

		// Create second list as 1->8
		for (int i = arr2.length - 1; i >= 0; --i)
			list.push(arr2[i], 2);

		list.addlists();

		list.printlist(list.result);
	}
}

//This code is contributed by Rishabh Mahrsee 
