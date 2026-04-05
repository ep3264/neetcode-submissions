class Solution {
    public boolean isValid(String s) {
        if (s.length() < 2) return  false;
        var map = Map.of(
                '{', '}',
                '[', ']',
                '(', ')'
        );

       Deque<Character> stack = new ArrayDeque<>();
       for (Character c : s.toCharArray()) {

                if (map.get(c) != null) {
                    stack.push(c);
                } else if (!stack.isEmpty() && map.get(stack.peek()).equals(c)) {
                    stack.pop();
                } else return  false;
        }
        return  stack.isEmpty();
    }
}
