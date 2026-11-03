import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: Sort intervals by starting value
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Store the merged intervals
        List<int[]> result = new ArrayList<>();

        // Step 3: Take the first interval
        int start = intervals[0][0];
        int end = intervals[0][1];

        // Step 4: Check remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // If intervals overlap
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            }

            // If they don't overlap
            else {
                result.add(new int[]{start, end});

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // Add the last interval
        result.add(new int[]{start, end});

        // Convert List to int[][]
        return result.toArray(new int[result.size()][]);
    }
}