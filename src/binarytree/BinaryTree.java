package binarytree;

import java.util.Scanner;

public class BinaryTree {
	private Node root;
	// �������
	@SuppressWarnings("unused")
	private int depth;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("������һ��������������ǰ���������");
		System.out.println("����:7,1,1,5,6,0,6");
		System.out.println("     7");
		System.out.println("    / \\");
		System.out.println("   1   1");
		System.out.println("  / \\   \\");
		System.out.println(" 5   6   6");
		System.out.println("0����սڵ㣬��������֮����Ӣ�Ķ��Ÿ����������пո�");
		String[] ds = input.next().split(",");
		int[] data = new int[ds.length];
		for (int i = 0; i < ds.length; i++) {
			data[i] = Integer.parseInt(ds[i]);
		}
		BinaryTree bt = new BinaryTree(data);
		if (bt.isSymmetric()) {
			System.out.println("������ǶԳƵģ�");
		} else {
			System.out.println("��������ǶԳƵģ�");
		}
	}

	public boolean isSymmetric() {
		if (root.left != null && root.right != null) {
			return root.left.equals(root.right);
		} else if (root.left == null && root.right == null) {
			return true;
		} else {
			return false;
		}
	}

	private BinaryTree(int[] data) {
		// ����ǰ������Ĵ�������һ�ö�����
		Node[] nodes = new Node[data.length];
		depth = (int) (Math.log(data.length + 1) / Math.log(2));
		// ���ø��ڵ�
		root = new Node();
		root.data = data[0];
		nodes[0] = root;
		// �����ӽڵ�
		for (int i = 1; i < data.length; i++) {
			Node node = new Node();
			node.data = data[i];
			nodes[i] = node;
			if (data[i] == 0) {
				continue;
			}
			// �ҳ����ڵ㣬�����ø��ӹ�ϵ
			Node father = null;
			if (i % 2 == 1) {
				father = nodes[(i + 1) / 2 - 1];
				father.left = node;
			} else {
				father = nodes[i / 2 - 1];
				father.right = node;
			}
			node.father = father;
		}

	}

}