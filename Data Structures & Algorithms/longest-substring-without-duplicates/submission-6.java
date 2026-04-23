class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxlen = 0;
        HashSet<Character> hset = new HashSet<>();

        while(right < s.length() && left <= right){
            char currele = s.charAt(right);
            while(left <= right && hset.contains(currele)){
                    hset.remove(s.charAt(left));
                    left += 1;
            }
            hset.add(currele);
            maxlen = Integer.max(maxlen,right-left+1);
            right += 1;
        }
        return maxlen;
    }
}
