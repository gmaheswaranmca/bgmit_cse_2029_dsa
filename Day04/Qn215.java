import java.util.PriorityQueue;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Create Min Heap (PriorityQueue is a min-heap by default in Java)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();        
        // For each element
        for (int num : nums) {
            // Insert into heap
            minHeap.add(num);            
            // If heap size > k, remove smallest
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }        
        // Return heap top
        return minHeap.peek();
    }
}