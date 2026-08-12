class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Edge case: if s1 is longer than s2, a permutation is impossible
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int window = s1.length();

        // Build the initial frequency arrays for the first 'window' characters
        for (int i = 0; i < window; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        // Check if the very first window is a match
        if (Arrays.equals(count1, count2)) {
            return true;
        }

        // Slide the window across the rest of s2
        for (int i = window; i < s2.length(); i++) {
            // Add the new character entering the window on the right
            count2[s2.charAt(i) - 'a']++;
            
            // Remove the old character leaving the window on the left
            count2[s2.charAt(i - window) - 'a']--;

            // Compare the arrays
            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }

        return false;
    }
}