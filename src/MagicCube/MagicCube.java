package MagicCube;

import java.util.Scanner;

public class MagicCube {
	private int n;
	private int[][] data;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一个数字作为矩阵的大小:");
		int n = input.nextInt();
		System.out.println("请输入起点坐标，坐标从1开始");
		System.out.println("请输入x坐标:");
		int x = input.nextInt();
		while (x > n) {
			System.out.println("x坐标必须小于n，请重新输入x坐标:");
			x = input.nextInt();
		}
		System.out.println("请输入y坐标:");
		int y = input.nextInt();
		while (y > n) {
			System.out.println("y坐标必须小于n，请重新输入y坐标:");
			y = input.nextInt();
		}
		System.out.println("矩阵如下:");
		new MagicCube(n).printCube(x, y);
	}

	public MagicCube(int n) {
		this.n = n;
		data = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				data[i][j] = 0;
			}
		}
	}

	public void printCube(int x, int y) {
		int m = x - 1;
		int j = y - 1;
		for (int i = 1; i <= n * n; i++) {
			if (data[m % n][j % n] == 0) {
				data[m % n][j % n] = i;
			} else {
				m = m + 2;
				j--;
				data[m % n][j % n] = i;
			}

			m--;
			j++;
			if (m < 0) {
				m = n - 1;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int h = 0; h < n; h++) {
				System.out.printf("%2d ", data[i][h]);
			}
			System.out.println();
		}
	}
}
