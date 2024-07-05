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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int result[] = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        int previousNumber = head.val;
        ListNode node = head.next;
        List<Integer> distanceList = new ArrayList<>();
        int i = 1;
        
        while(node.next != null) {
            if (node.val < previousNumber && node.val < node.next.val) {
                distanceList.add(i);
            }
            
            if (node.val > previousNumber && node.val > node.next.val) {
                distanceList.add(i);
            }
            
            i++;
            previousNumber = node.val;
            node = node.next;
        }
        
        if (distanceList.size() < 2) {
            return new int[] {-1, -1};
        }
        
        for (int j = 1; j < distanceList.size(); j++) {
            result[0] = Math.min(result[0], distanceList.get(j) - distanceList.get(j-1));
            result[1] = Math.max(result[0], distanceList.get(j) - distanceList.get(0));
        }
        
        return result;
    }
}