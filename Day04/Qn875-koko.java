
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;        
        // Find the maximum pile for the upper bound
        for (int pile : piles) {
            right = Math.max(right, pile);
        }        
        while (left < right) {
            // Safer way to calculate mid to avoid integer overflow
            int mid = left + (right - left) / 2;             
            // Compute total hours needed at speed 'mid'
            long hours = 0; 
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid; // Integer ceiling division trick
            }            
            if (hours <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }        
        return left;
    }
}