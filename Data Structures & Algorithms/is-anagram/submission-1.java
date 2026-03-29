class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] charFreq = new int[26]; // 26 lowercase letters
        
        // Increment for s, decrement for t
        for (int i = 0; i < s.length(); i++) {
            charFreq[s.charAt(i) - 'a']++;
            charFreq[t.charAt(i) - 'a']--;
        }
        
        // All counts should be 0
        for (int count : charFreq) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }
}
