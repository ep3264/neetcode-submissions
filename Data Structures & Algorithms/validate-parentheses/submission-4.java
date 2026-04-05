class Solution {
    public boolean isValid(String s) {
        if (s.length() < 2) return  false;
        var map = Map.of(
                "{", "}",
                "[", "]",
                "(", ")"
        );

       Deque<String> stack = new ArrayDeque<>();
       for (String c : s.split("")) {

                if (map.get(c) != null) {
                    stack.push(c);
                } else if (!stack.isEmpty() && map.get(stack.peek()).equals(c)) {
                    stack.pop();
                } else return  false;
        }
        return  stack.isEmpty();
    }
}
