import java.util.*;

public class MinStepForAnagram {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter String to be changed: ");
		String t = sc.next();
		System.out.print("Enter the reference String: ");
		String s = sc.next();

		int freqt[] = new int[26];
		int freqs[] = new int[26];

		for (char ch : s.toCharArray()) {
			freqs[ch - 'a']++;
		}

		for (char ch : t.toCharArray()) {
			freqt[ch - 'a']++;
		}

		int steps = 0;
		for (int i = 0; i < 26; i++) {
			steps += Math.abs(freqs[i] - freqt[i]);
		}

		System.out.print(steps / 2);
		sc.close();
	}
}