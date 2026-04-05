class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return  false;
        var sSorted= s.chars().sorted().toArray();
        var tSorted = t.chars().sorted().toArray();
        
        for (int i = 0; i < sSorted.length; i++) {
            if (sSorted[i] != tSorted[i]) return false;
        }
        
        return  true;
    }
}
