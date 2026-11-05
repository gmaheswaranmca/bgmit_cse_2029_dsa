
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
               ListNode first = head;
			   ListNode second = slow;
			   while(first != second) {
				   first = first.next;
				   second= second.next;
			   }
			   return first;
			}
        }
        return null;
    }
}