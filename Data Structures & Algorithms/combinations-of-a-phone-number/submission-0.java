class Solution {
    List<String> output;
    Map<Integer, String> numStrMap;
    public List<String> letterCombinations(String digits) {
        output = new ArrayList<>();
        if(digits.length() == 0) return output;
        numStrMap = new HashMap<>();
        numStrMap.put(2, "abc");
        numStrMap.put(3, "def");
        numStrMap.put(4, "ghi");
        numStrMap.put(5, "jkl");
        numStrMap.put(6, "mno");
        numStrMap.put(7, "pqrs");
        numStrMap.put(8, "tuv");
        numStrMap.put(9, "wxyz");
        backtrack(0, "", digits);
        return output;
    }

    public void backtrack(int pos, String sb, String digits){
        if(pos == digits.length()){
            output.add(sb);
            return;
        }
        int dig = digits.charAt(pos) - '0';
        String currStr = numStrMap.get(dig);
        for(int i = 0;i < currStr.length(); i++){
            backtrack(pos+1, sb+currStr.charAt(i), digits);
        }
    }
}
