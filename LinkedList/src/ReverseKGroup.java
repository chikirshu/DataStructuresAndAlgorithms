import java.util.LinkedList;
import java.util.Queue;

public class ReverseKGroup {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		ListNode resNode = reverseKGroup(head, 3);

		while (resNode != null) {
			System.out.print(resNode.val + " ");
			resNode = resNode.next;
		}

	}

	public static ListNode reverseKGroup(ListNode head, int k) {

		if (k == 1) {
			return head;
		}

		ListNode temp = head;
		ListNode resHead = null;
		ListNode prev = null;
		ListNode crnt = head;
		ListNode last = null;
		Queue<ListNode> startNodes = new LinkedList<>();
		Queue<ListNode> endNodes = new LinkedList<>();
		int cntk = 1, cnt = 0, i = 0, remNodes = 0, firstIter = 0;

		while (crnt != null) {
			if (cnt % k == 0) {
				endNodes.add(crnt);
			}
			cnt++;
			last = crnt;
			crnt = crnt.next;
		}

		if (cnt % k != 0) {
			endNodes.remove(last);
			remNodes = cnt % k;
		}

		crnt = head;

		while (crnt != null) {
			if (i <= cnt - remNodes) {
				if (cntk <= k) {
					temp = crnt.next;
					crnt.next = prev;
					prev = crnt;
					crnt = temp;
					cntk++;
					i++;
				} else {
					if (firstIter == 0) {
						resHead = prev;
						firstIter++;
					} else {
						startNodes.add(prev);
					}

					if (i < cnt - remNodes) {
						cntk = 1;
						prev = null;
					} else {
						break;
					}
				}
			}
		}

		while (endNodes.size() > 1) {
			temp = endNodes.poll();
			temp.next = startNodes.poll();
		}

		if (endNodes.size() == 1) {
			endNodes.poll().next = crnt;
		}

		return resHead;
	}

}
