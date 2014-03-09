package joseph;

import java.util.Scanner;

public class JosephCircleWithLinkList {
	private class Node {
		// ǰ�����
		public Node preCursor;
		// ��̽��
		public Node succeed;
		// ���
		public int no;

		public Node(int no) {
			this.no = no;
		}

		@Override
		public String toString() {
			return no + "";
		}
	}

	private Node header;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("enter a number for n:");
		int n = input.nextInt();
		System.out.println("enter a number for s:");
		int s = input.nextInt();
		System.out.println("enter a number for m:");
		int m = input.nextInt();
		System.out.println("the weed-out sequence is:");
		new JosephCircleWithLinkList().printOutSequence(n, s, m);
	}

	public void printOutSequence(int n, int s, int m) {
		initNodes(n);
		// ��ǰ��㣬��ͷ��㿪ʼ
		Node currentCursor = header;
		// �ӵ�s���˿�ʼ����
		for (int i = 1; i < s; i++) {
			currentCursor = currentCursor.succeed;
		}
		for (int i = 0; i < n; i++) {
			// ����m�κ���̭����
			for (int j = 0; j < m - 1; j++) {
				currentCursor = currentCursor.succeed;
			}
			// ������һ���˵�λ��
			Node nextPerson = currentCursor.succeed;
			removeNode(currentCursor);
			currentCursor = nextPerson;
		}
	}

	private void initNodes(int n) {
		Node[] allNode = new Node[n];
		// ��ʼ�����н��
		for (int i = 0; i < n; i++) {
			allNode[i] = new Node(i + 1);
		}
		for (int i = 0; i < n; i++) {
			if (i > 0 && i < n - 1) {
				// ����ǰ�����
				allNode[i].preCursor = allNode[i - 1];
				// ���ú�̽��
				allNode[i].succeed = allNode[i + 1];
			}
			if (i == 0) {
				// ѭ������ͷ����ǰ��ָ��β���
				allNode[i].preCursor = allNode[n - 1];
				allNode[i].succeed = allNode[i + 1];
			}
			if (i == n - 1) {
				allNode[i].preCursor = allNode[i - 1];
				// β���ĺ��ָ��ͷ���
				allNode[i].succeed = allNode[0];
			}
		}

		header = allNode[0];
	}

	private void removeNode(Node node) {
		System.out.print(node.no + " ");
		// �øý���ǰ�����ĺ��ָ�룬ָ��ý��ĺ��
		node.preCursor.succeed = node.succeed;
		// �øýڵ�ĺ�̽���ǰ��ָ�룬ָ��ýڵ��ǰ��
		node.succeed.preCursor = node.preCursor;
		// ɾ���ýڵ�
		node = null;
	}
}
