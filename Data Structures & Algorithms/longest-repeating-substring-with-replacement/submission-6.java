class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // Add the new character entering the window
            count[s.charAt(right) - 'A']++;
            
            // Update the count of the most frequent character in the current window
            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);

            // Check if the current window is invalid
            // (Total characters in window) - (Count of most frequent character) > k
            int windowLength = right - left + 1;
            if (windowLength - maxFreq > k) {
                // The window is invalid, so we shrink it from the left
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // Update the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}