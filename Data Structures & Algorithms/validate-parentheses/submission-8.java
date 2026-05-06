class Solution {
    public boolean isValid(String s) {
        var st = new int[s.length() + 1];
        int pointer = 0;

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                st[++pointer] = c;

            else {
                if (pointer == 0)
                    return false;

                if ((c == ')' && st[pointer] == '(') ||
                        (c == '}' && st[pointer] == '{') ||
                        (c == ']' && st[pointer] == '[')) {
                    pointer--;

                } else
                    return false;
            }
        }
        return pointer == 0;
    }
}
