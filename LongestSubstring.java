import java.util.Scanner;
import java.util.Arrays;

public class LongestSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str = sc.next();

        int[] lastIndex = new int[26]; // To track last index of each character
        Arrays.fill(lastIndex, -1); // Initialize all to -1 (not seen)

        int maxLen = 0;
        int start = 0; // Start index of current substring

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int idx = ch - 'a';

            // If character was seen and is inside the current window
            if (lastIndex[idx] >= start) {
                start = lastIndex[idx] + 1; // Move the start ahead of the repeated char
            }

            lastIndex[idx] = i; // Update last seen index
            maxLen = Math.max(maxLen, i - start + 1);
        }

        System.out.println("Length of the longest substring without repeating characters: " + maxLen);
    }
}
