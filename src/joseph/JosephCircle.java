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
		System.out.println("���α���̭��ȥ���˵ı������:");
		new JosephCircle().printOutSequence(n, s, m);
	}

	/**
	 * 
	 * @param n ������
	 * @param s �ӵ�s���˿�ʼ
	 * @param m ÿ��m���˾���̭һ���˳���
	 */
	public void printOutSequence(int n, int s, int m) {
		// ������Ӧ�±����ţ��������1���ˣ���Ӧ�������Ԫ���±���0
		s = s - 1;
		int[] allPeople = new int[n];
		// ��ʼ���������������±��0��ʼ
		for (int i = 0; i < n; i++) {
			allPeople[i] = 1;
		}
		// ѭ��
		while (hasMoreElement(allPeople)) {
			// ����ÿ��m�Σ�����̭�����
			int j = 0;
			int i = 0;
			for (; i < m;) {
				// �����ǰ������Ѿ�����̭�ˣ������������±�
				if (allPeople[(s + j + i) % n] == 0) {
					j++;
					continue;
				}
				i++;
			}
			// ����m�Σ������±�
			s = s + i + j - 1;
			// �������̭���˵���ţ���ű��±��1
			System.out.print(s % n + 1 + " ");
			allPeople[s % n] = 0;
			// ����һ���˿�ʼ��
			s++;
		}
	}

	// �ж��Ƿ�����
	public boolean hasMoreElement(int[] all) {
		for (int i = 0; i < all.length; i++)
			if (all[i] == 1)
				return true;
		return false;
	}
}
