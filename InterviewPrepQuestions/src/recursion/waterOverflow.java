package recursion;

import java.util.ArrayList;

public class waterOverflow {

	public static void main(String[] args) {
		System.out.println(genIp("50361"));
	}

	public static ArrayList<String> genIp(String s) {
		list = new ArrayList<>();
		genIp(s, "", 1);
		return list;
	}

	public static ArrayList<String> list;

	public static void genIp(String s, String ans, int level) {
		if (level == 5) {
			if (s.length() == 0) {
				list.add(ans);
			}
			return;
		}
		for (int i = 1; i <= s.length(); i++) {
			String s1 = s.substring(0, i);
			String s2 = s.substring(i, s.length());
			int x = s1.length() < 5 ? Integer.parseInt(s1) : Integer.parseInt(s1.substring(0, 5));
			if (x > 255 ||(s.charAt(0) == '0'&&s1.length()>1)) {
				continue;
			} else {
				if (level == 1) {
					genIp(s2, ans+s1, level + 1);
				} else {
					genIp(s2, ans + "." + s1, level + 1);
				}
			}
		}
	}

	public static double WaterOverflow(double k, int level, int i) {
//		System.out.println(k);
		if (level == i) {
			if (k >= 1) {
				return 1;
			} else {
				return k;
			}
		}

		if (k < 0) {
			return 0;
		}

//		System.out.println(level+" "+k);
		double restWater = (k - 1) / 2;

		return WaterOverflow(restWater, level + 1, i);
	}

}
