package binarytree;

import java.util.Scanner;

public class BinaryTree {
	private Node root;
	// 树的深度
	@SuppressWarnings("unused")
	private int depth;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一个完整二叉树的前序遍历数组");
		System.out.println("例如:7,1,1,5,6,0,6");
		System.out.println("     7");
		System.out.println("    / \\");
		System.out.println("   1   1");
		System.out.println("  / \\   \\");
		System.out.println(" 5   6   6");
		System.out.println("0代表空节点，两个数字之间用英文逗号隔开，不能有空格；");
		String[] ds = input.next().split(",");
		int[] data = new int[ds.length];
		for (int i = 0; i < ds.length; i++) {
			data[i] = Integer.parseInt(ds[i]);
		}
		BinaryTree bt = new BinaryTree(data);
		if (bt.isSymmetric()) {
			System.out.println("这棵树是对称的！");
		} else {
			System.out.println("这棵树不是对称的！");
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
		// 按照前序遍历的次序，生成一棵二叉树
		Node[] nodes = new Node[data.length];
		depth = (int) (Math.log(data.length + 1) / Math.log(2));
		// 设置根节点
		root = new Node();
		root.data = data[0];
		nodes[0] = root;
		// 设置子节点
		for (int i = 1; i < data.length; i++) {
			Node node = new Node();
			node.data = data[i];
			nodes[i] = node;
			if (data[i] == 0) {
				continue;
			}
			// 找出父节点，并设置父子关系
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