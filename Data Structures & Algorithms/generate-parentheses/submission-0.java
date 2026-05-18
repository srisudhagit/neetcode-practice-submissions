class Solution {
    Stack<Character> stack;
    List<String> output;
    public List<String> generateParenthesis(int n) {
        output = new ArrayList<>();
        stack = new Stack<>();

        backTrack(0, 0, n);

        return output;
    }

    public void backTrack(int oc, int cc, int total){
        if(oc == total && cc == total){
            output.add(stack.stream().map(s -> s.toString()).collect(Collectors.joining("")));
            return;
        }

        if(oc < total){
            stack.push('(');
            backTrack(oc+1, cc, total);
            stack.pop();
        }

        if(cc < oc){
            stack.push(')');
            backTrack(oc, cc+1, total);
            stack.pop();
        }

    }
}
