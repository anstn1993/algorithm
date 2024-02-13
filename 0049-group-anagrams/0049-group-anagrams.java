class Solution {
    
    private Map<Character, Integer> alphabetCountMap = new HashMap<>();
    
    public List<List<String>> groupAnagrams(String[] strs) {
        for (int i = 97; i <= 122; i++) {
            alphabetCountMap.put((char)i, 0);
        }
        
        Map<String, List<String>> anagrams = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            String key = generateKey(strs[i]);
            if (!anagrams.containsKey(key)) {
                anagrams.put(key, new ArrayList<>());
            }
            anagrams.get(key).add(strs[i]);
        }
        
        // List<List<String>> result = new ArrayList<>();
        return anagrams.values().stream().collect(Collectors.toList());
    }
    
    public String generateKey(String str) {
        for (int i = 0; i < str.length(); i++) {
            alphabetCountMap.computeIfPresent(str.charAt(i), (key, value) -> value + 1);
        }
        StringBuilder key = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : alphabetCountMap.entrySet()) {
            if (!entry.getValue().equals(0)) {
                key.append(entry.getKey());
                key.append(entry.getValue());
                entry.setValue(0);
            }
        }
        return key.toString();
    }
}