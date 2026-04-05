class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return  false;

        var countS = new int[26];
        var countT = new int[26];

        for (var i = 0; i < s.length(); i++) {
            countS[s.charAt(i) - 'a']++;
            countT[t.charAt(i) - 'a']++;
        }

        return Arrays.equals(countS, countT);
    }
}
