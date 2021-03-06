package arrays;

import java.util.*;
import java.lang.*;
import java.io.*;

class Quadruple {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int k = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			quadruple(arr, k);
			System.out.println();
		}
	}

	public static void quadruple(int[] arr, int sum) {
		HashSet<String> set=new HashSet<>();
		ArrayList<String> list = new ArrayList<>();
		boolean bl = false;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int left = j + 1;
				int right = arr.length - 1;
				while (left < right) {
					int currSum = arr[i] + arr[j] + arr[left] + arr[right];
					if (currSum < sum) {
						left++;
					} else if (currSum > sum) {
						right--;
					} else {
						bl = true;
						String str = arr[i] + " " + arr[j] + " " + arr[left] + " " + arr[right] + " $";
						if(set.contains(str)==false) {
							list.add(str);
							set.add(str);
						}
						left++;
						right--;
					}
				}
			}
		}
		if (bl == false) {
			System.out.print("-1");
		}else {
			for(String str:list) {
				System.out.print(str);
			}
		}
	}
}

