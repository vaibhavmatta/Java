package string;

import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;

class LongestDistinct {
	public static void main(String[] args) {
		BigInteger a=new BigInteger("1111111111111111111111111111111111111111111");
		BigInteger b=new BigInteger("1");
//		Scanner scn = new Scanner(System.in);
//		int t = scn.nextInt();
//		while (t-- > 0) {
//			String str = scn.next();
//			longestDistinctCharacters(str);
//		}
	}

	public static void longestDistinctCharacters(String str) {
		int maxLen = 0;
		for (int i = 0; i < str.length(); i++) {
			HashMap<Character, Integer> hmap = new HashMap<>();
			for (int j = i + 1; j <= str.length(); j++) {
				if (hmap.containsKey(str.charAt(j - 1))) {
					i = hmap.get(str.charAt(j - 1));
					break;
				}
				hmap.put(str.charAt(j - 1), j - 1);
				if (j - i > maxLen) {
					maxLen = j - i;
				}

			}
		}

		System.out.println(maxLen);
	}
}