class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1. Find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Push second half into stack
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = slow.next;
        slow.next = null; // break the list

        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        // 3. Merge using stack
        ListNode first = head;

        while (!stack.isEmpty()) {
            ListNode next = first.next;
            ListNode top = stack.pop();

            first.next = top;
            top.next = next;

            first = next;
        }
    }
}