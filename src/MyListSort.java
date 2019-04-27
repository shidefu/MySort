class ListNode {
	int val;
	ListNode next = null;

	public ListNode(int val) {
		this.val = val;
	}

	public void addNode(ListNode head, int val) {
		ListNode p = head;
		while (p.next != null) {
			p = p.next;
		}
		ListNode node = new ListNode(val);
		p.next = node;
	}
}

public class MyListSort {

	public static void quickSort(ListNode head, ListNode end) {
		if (head == end)
			return;
		ListNode mid = Partition(head, end);
		quickSort(head, mid);
		quickSort(mid.next, end);
	}

	public static ListNode Partition(ListNode head, ListNode end) {
		int pivot = head.val;
		ListNode p = head;
		ListNode q = head.next;
		while (q != end) {
			if (q.val < pivot) {
				p = p.next;
				swap(p, q);
			}
			q = q.next;
		}
		swap(head, p);
		return p;
	}

	public static void swap(ListNode n1, ListNode n2) {
		int temp = n1.val;
		n1.val = n2.val;
		n2.val = temp;
	}

	public static ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode mid = getMid(head);
		ListNode next = mid.next;
		mid.next = null;
		ListNode head1 = mergeSort(head);
		ListNode head2 = mergeSort(next);
		return mergeList(head1, head2);

	}

	public static ListNode getMid(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public static ListNode mergeList(ListNode head1, ListNode head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		if (head1.val < head2.val) {
			head1.next = mergeList(head1.next, head2);
			return head1;
		} else {
			head2.next = mergeList(head1, head2.next);
			return head2;
		}
	}

	public static void main(String[] args) {
		int[] array = { 5, 3, 9, 1, 4, 0, 2, 6, 8, 7 };
		ListNode head = new ListNode(array[0]);
		for (int i = 1; i < array.length; i++) {
			head.addNode(head, array[i]);
		}
		ListNode end = head;
		while (end != null) {
			end = end.next;
		}
		//quickSort(head, end);
		//ListNode node = head;
		ListNode node = mergeSort(head);
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
	}

}
