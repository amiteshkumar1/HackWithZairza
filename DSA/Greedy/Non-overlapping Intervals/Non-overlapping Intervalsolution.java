/*
Problem Statement

Given an array of intervals where intervals[i] = [start_i, end_i], find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Two intervals [a, b] and [c, d] are considered overlapping if b > c (i.e., the end of the first interval is greater than the start of the second interval).

Example
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: Remove [1,3] to make the rest non-overlapping.

Intuition

The goal is to remove the fewest intervals so that no two intervals overlap. Equivalently, we want to keep the maximum number of intervals without overlapping and then subtract that count from the total number of intervals.

Solution Approach: Greedy by Earliest Finish Time

Sort the intervals by their end time (ascending).
Sorting by earliest finishing time helps us pick intervals that leave the most room for the rest.

Initialize:

count to 1 (since we always keep at least one interval).

end to the end time of the first interval.

Iterate through intervals from the second one onward:

If the current interval's start time is at least the end of the last kept interval, we can keep it (no overlap).

Update end to the current interval’s end time and increment count.

Otherwise, skip this interval (remove it).

The minimum removals = total intervals - count of intervals kept.

Complexity Analysis

Sorting takes O(n log n) time.

One pass through intervals takes O(n) time.

Overall time complexity: O(n log n).

Space complexity: O(1) (ignoring input storage).
*/


import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // Sort intervals by ending time (ascending)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int kept = 1;  // we always keep the first interval
        int lastEnd = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            if (start >= lastEnd) {
                // No overlap with the last kept interval
                kept++;
                lastEnd = end;
            } 
            // else: overlap — skip this interval (i.e. remove it)
        }
        
        return intervals.length - kept;
    }
}
