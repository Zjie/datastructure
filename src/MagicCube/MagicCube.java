package MagicCube;

import java.util.Scanner;

public class MagicCube {
	private int n;
	private int[][] data;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("������һ��������Ϊ����Ĵ�С:");
		int n = input.nextInt();
		System.out.println("������������꣬�����1��ʼ");
		System.out.println("������x����:");
		int x = input.nextInt();
		while (x > n) {
			System.out.println("x�������С��n������������x����:");
			x = input.nextInt();
		}
		System.out.println("������y����:");
		int y = input.nextInt();
		while (y > n) {
			System.out.println("y�������С��n������������y����:");
			y = input.nextInt();
		}
		System.out.println("��������:");
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
