class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, cnt = 0, maxlen = 0, maxfreq = 0;
        HashMap<Character, Integer> fremap = new HashMap<>();
        for(int r = 0; r < s.length(); r++){
            char ch = s.charAt(r);
            fremap.put(ch, fremap.getOrDefault(ch, 0) + 1);
            maxfreq = Integer.max(maxfreq, fremap.get(s.charAt(r)));

            while ((r-l+1) - maxfreq > k){
                fremap.put(s.charAt(l), fremap.get(s.charAt(l)) - 1);
                l += 1;
            }

            maxlen = Integer.max(maxlen, r-l+1);
        }
        return maxlen;
    }
}
