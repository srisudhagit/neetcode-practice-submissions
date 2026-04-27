/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a,b) -> a.start-b.start);
        Queue<Integer> minHeap = new PriorityQueue<>();
        for(Interval in : intervals){
            if(!minHeap.isEmpty() && minHeap.peek() <= in.start){
                minHeap.poll();
            }
            minHeap.offer(in.end);
        }
        return minHeap.size();
    }
}
