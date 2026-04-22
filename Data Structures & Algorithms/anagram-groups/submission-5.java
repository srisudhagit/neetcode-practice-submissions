class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> keyMap = new HashMap<>();
        for(String str : strs){
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortArr = new String(charArr);
            keyMap.putIfAbsent(sortArr, new ArrayList<>());
            keyMap.get(sortArr).add(str);
        }
        return new ArrayList<>(keyMap.values());
    }
}
