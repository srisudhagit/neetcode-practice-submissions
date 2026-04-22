class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> eleMap = new HashMap();
        int pos = 0;
        for(int num: nums){
            int reqnum = target-num;
            if(!eleMap.containsKey(reqnum)){
                eleMap.put(num,pos);
            }else{
                return new int[]{eleMap.get(reqnum), pos};
            }
            pos++;
        }
        return new int[]{-1,-1};
    }
}
