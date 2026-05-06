class Solution {
    public boolean isValid(String s) {
        if (s.length() < 2) return false;
        int[] table = new int['}' + 1];
        table['{'] = '}';
        table['['] = ']';
        table['('] = ')';

        var stack = new ArrayDeque<Character>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            var cur = table[c];
            if (cur != 0) {
               stack.addFirst(c);
            } else if (table[stack.getFirst()] == c) {
                stack.removeFirst();
            } else {
                return false;
            }


        }

        return stack.isEmpty();
    }
}
