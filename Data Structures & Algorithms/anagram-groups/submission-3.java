class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) return List.of(List.of(strs[0]));

        Map<String, List<String>> result = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {

            int arr[] = new int[26];
            for (char c : strs[i].toCharArray()) {
                arr[c - 'a']++;
            }

            var key = Arrays.toString(arr);


            result.computeIfAbsent(key, k -> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(result.values());
    }
}
