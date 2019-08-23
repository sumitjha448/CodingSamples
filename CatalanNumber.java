package com.java.dp;

import java.util.ArrayList;

public class CatalanNumber {

	public static void main(String[] args) {
		int n = 4;
		int dp[] = new int[n];
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			int sum = 0;
			ArrayList<Integer> arr = new ArrayList<>();
			arr.add(i);
			for (int j = 0; j < i; j++) {
				sum += dp[j] * dp[i - 1 - j];
			}
			dp[i] = sum;
		}

		for (int i = 0; i < 10; i++)
			System.out.println(dp[i]);
	}

}
