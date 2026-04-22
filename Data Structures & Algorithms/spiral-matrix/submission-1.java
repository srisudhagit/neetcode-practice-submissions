class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int top = 0, bottom = rows-1, left = 0, right = cols-1;
        List<Integer> retList = new ArrayList<>();

        while(true){
            for(int i=left;i<=right;i++){
                retList.add(matrix[top][i]);
            }
            top += 1;
            for(int j=top;j<=bottom;j++){
                retList.add(matrix[j][right]);
            }
            right -= 1;
            if(left > right || top > bottom){
                break;
            }
            for(int k=right;k>=left;k--){
                retList.add(matrix[bottom][k]);
            }
            bottom -= 1;
            for(int l=bottom;l>=top;l--){
                retList.add(matrix[l][left]);
            }
            left += 1;
            if(left > right || top > bottom){
                break;
            }
        }
        return retList;
    }
}
