
public class SinglyLinkedList {

	ListNode head = null, last = null;

	public void insertNodeAtEnd(int data) {
		ListNode node = new ListNode();
		node.val = data;
		node.next = null;
		if (isEmpty()) {
			head = node;
		} else {
			last.next = node;
		}
		last = node;
	}

	private boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

	public void display() {
		ListNode node = head;
		while (node != null) {
			System.out.print(node.val + " ");
			node=node.next;
		}
	}
	public ListNode getHead() {
		return head;
	}

}
