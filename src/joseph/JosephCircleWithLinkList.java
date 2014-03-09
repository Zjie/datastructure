package joseph;

import java.util.Scanner;

public class JosephCircleWithLinkList {
	private class Node {
		// 前驱结点
		public Node preCursor;
		// 后继结点
		public Node succeed;
		// 序号
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
		// 当前结点，从头结点开始
		Node currentCursor = header;
		// 从第s个人开始报数
		for (int i = 1; i < s; i++) {
			currentCursor = currentCursor.succeed;
		}
		for (int i = 0; i < n; i++) {
			// 报数m次后，淘汰此人
			for (int j = 0; j < m - 1; j++) {
				currentCursor = currentCursor.succeed;
			}
			// 保存下一个人的位置
			Node nextPerson = currentCursor.succeed;
			removeNode(currentCursor);
			currentCursor = nextPerson;
		}
	}

	private void initNodes(int n) {
		Node[] allNode = new Node[n];
		// 初始化所有结点
		for (int i = 0; i < n; i++) {
			allNode[i] = new Node(i + 1);
		}
		for (int i = 0; i < n; i++) {
			if (i > 0 && i < n - 1) {
				// 设置前驱结点
				allNode[i].preCursor = allNode[i - 1];
				// 设置后继结点
				allNode[i].succeed = allNode[i + 1];
			}
			if (i == 0) {
				// 循环链表，头结点的前驱指向尾结点
				allNode[i].preCursor = allNode[n - 1];
				allNode[i].succeed = allNode[i + 1];
			}
			if (i == n - 1) {
				allNode[i].preCursor = allNode[i - 1];
				// 尾结点的后继指向头结点
				allNode[i].succeed = allNode[0];
			}
		}

		header = allNode[0];
	}

	private void removeNode(Node node) {
		System.out.print(node.no + " ");
		// 让该结点的前驱结点的后继指针，指向该结点的后继
		node.preCursor.succeed = node.succeed;
		// 让该节点的后继结点的前驱指针，指向该节点的前驱
		node.succeed.preCursor = node.preCursor;
		// 删除该节点
		node = null;
	}
}
