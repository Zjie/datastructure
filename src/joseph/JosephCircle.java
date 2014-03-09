package joseph;

import java.util.Scanner;

public class JosephCircle {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("enter a number for n:");
		int n = input.nextInt();
		System.out.println("enter a number for s:");
		int s = input.nextInt();
		System.out.println("enter a number for m:");
		int m = input.nextInt();
		System.out.println("依次被淘汰出去的人的编号如下:");
		new JosephCircle().printOutSequence(n, s, m);
	}

	/**
	 * 
	 * @param n 总人数
	 * @param s 从第s个人开始
	 * @param m 每隔m个人就淘汰一个人出局
	 */
	public void printOutSequence(int n, int s, int m) {
		// 用来对应下标和序号，即序号是1的人，对应到数组的元素下标是0
		s = s - 1;
		int[] allPeople = new int[n];
		// 初始化总人数，数组下标从0开始
		for (int i = 0; i < n; i++) {
			allPeople[i] = 1;
		}
		// 循环
		while (hasMoreElement(allPeople)) {
			// 报数每报m次，则淘汰这个人
			int j = 0;
			int i = 0;
			for (; i < m;) {
				// 如果当前这个人已经被淘汰了，则跳过他的下标
				if (allPeople[(s + j + i) % n] == 0) {
					j++;
					continue;
				}
				i++;
			}
			// 报了m次，更新下标
			s = s + i + j - 1;
			// 输出被淘汰的人的序号，序号比下标大1
			System.out.print(s % n + 1 + " ");
			allPeople[s % n] = 0;
			// 从下一个人开始喊
			s++;
		}
	}

	// 判断是否还有人
	public boolean hasMoreElement(int[] all) {
		for (int i = 0; i < all.length; i++)
			if (all[i] == 1)
				return true;
		return false;
	}
}
