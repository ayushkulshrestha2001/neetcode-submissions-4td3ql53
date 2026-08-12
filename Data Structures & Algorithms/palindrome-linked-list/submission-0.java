/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Stack<ListNode> stk = new Stack<>();
        while(slow!=null) {
            stk.push(slow);
            slow = slow.next;
        }
        
        while(!stk.isEmpty()) {
            ListNode tmp = stk.pop();
            if(tmp.val!=head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}