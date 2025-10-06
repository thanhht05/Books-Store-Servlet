package BO;

import java.util.Scanner;

public class APp {

	public static String sn(int n) {
		if (n > 0) {
			return "So duong";
		} else if (n < 0) {
			return "So am";
		} else {
			return "So 0";
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String songuyen = sn(n);
		System.out.println(songuyen);
	}
}
