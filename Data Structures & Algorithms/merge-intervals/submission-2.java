class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (n1, n2) -> Integer.compare(n1[0], n2[0]));
        List<int[]> output = new ArrayList<>();

        output.add(intervals[0]);

        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];
            int lastend = output.get(output.size()-1)[1];

            if(start <= lastend){
                output.get(output.size()-1)[1] = Math.max(end, lastend);
            }else{
                output.add(new int[]{start,end});
            }
        }
        return output.toArray(new int[output.size()][]);
    }
}
