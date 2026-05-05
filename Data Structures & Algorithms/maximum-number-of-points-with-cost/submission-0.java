class Solution {
    public long maxPoints(int[][] points) {
        int rows = points.length, cols = points[0].length;
        int score = 0;
        long[] currRow = new long[cols];
        for(int i = 0; i < cols; i++){
            currRow[i] = points[0][i];
        }
        
        for(int i = 1;i < rows;i++){
            long[] left = new long[cols];
            long[] right = new long[cols];

            left[0] = currRow[0];
            for(int c = 1; c < cols; c++){
                left[c] = Math.max(currRow[c] , left[c-1]-1);
            }

            right[cols-1] = currRow[cols-1];
            for(int c = cols-2; c >= 0; c--){
                right[c] = Math.max(currRow[c] , right[c+1]-1);
            }

            long[] nextRow = new long[cols];
            for(int c = 0;c < cols;c++){
                nextRow[c] = Math.max(left[c], right[c]) + points[i][c];
            }
            currRow = nextRow;
        }
        long max = 0;
        for(long val: currRow) max = Math.max(max, val);
        return max;
    }
}