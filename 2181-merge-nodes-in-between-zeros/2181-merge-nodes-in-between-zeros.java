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
    public ListNode mergeNodes(ListNode head) {
        ListNode result = new ListNode();
        int sumValue = 0;
        int count = 0;
        
        ListNode listNode = head.next;
        ListNode temp = result;
        
        while(listNode != null) {
            if (listNode.val == 0) {
                temp.next = new ListNode(sumValue);
                temp = temp.next;
                sumValue = 0;
            } else {
                sumValue += listNode.val;
            }
            
            listNode = listNode.next;
        }
        
        return result.next;
    }
}