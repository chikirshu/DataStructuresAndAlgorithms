
public class PalindromeLinkedList {

	public static void main(String[] args) {
		PalindromeLinkedList p = new PalindromeLinkedList();
		SinglyLinkedList l = new SinglyLinkedList();
		//ListNode head= new ListNode(1);
		l.insertNodeAtEnd(1);
		l.insertNodeAtEnd(2);
		l.insertNodeAtEnd(3);
		l.insertNodeAtEnd(4);
		l.insertNodeAtEnd(5);
		//l.display();
		//System.out.println(p.isPalindrome(l.getHead()));
		ListNode head =  p.swapNodes(l.getHead(),2);
		l.display();
		
	}

	public boolean isPalindrome(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = null;
		ListNode next = null;
		ListNode crnt = null;
		ListNode head2 = null;
		boolean flg = true;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		head2 = slow;
		fast = slow;// will reuse as a temp
		crnt=slow;
		while (crnt != null) {
			next = crnt.next;
			//fast=slow.next;
			crnt.next = prev;
			prev = crnt;
			//fast = slow.next;
			crnt = next;
		}
		crnt = prev;
		System.out.println("\nList2:");
		while (crnt != null) {
			System.out.print(crnt.val + " ");
			crnt = crnt.next;
		}
		head2 = prev;
		while (head2 != null) {
			if (head.val != head2.val) {
				flg = false;
				// System.out.print(head.val+" "+head2.val);
				break;
			}
			head = head.next;
			head2 = head2.next;
		}
		return flg;
	}
	
	public ListNode swapNodes(ListNode head, int k) {
        ListNode crnt= head;
        ListNode prevStart = null, next=null, temp=head, swap=null;
        int cnt=0,length=0;
        
        while(crnt!=null){
            crnt=crnt.next;
            length++;
        }
        
        while(crnt!=null){
            if(cnt==k-1){
                swap=crnt;
                prevStart=temp;
            }
            
            if(cnt==length-k){
                next=crnt.next;
                prevStart.next=crnt;
                crnt.next=swap.next;
                swap.next=next;
                temp.next=swap;
                break;
            }
            
            if(prevStart==null || next==null){
                temp=crnt;
            }
            cnt++;
            crnt=crnt.next;
        }
        return head;
    }

}
