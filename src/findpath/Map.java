package findpath;

import java.util.ArrayList;
import java.util.List;

public class Map {
	private int m;
	private int n;
	private List<Node> allNodes = new ArrayList<Node>();
	private List<Node> barrier;
	private Node cowBoy;
	private Node weaver;

	public Map(int m, int n, List<Node> nodes) {
		this.m = m;
		this.n = n;
		barrier = nodes;
		// ��
		for (int i = 1; i <= m; i++) {
			// ��
			for (int j = 1; j <= n; j++) {
				allNodes.add(new Node(i, j));
			}
		}
	}

	public List<Node> getNextReachableNodes(Node node) {
		pickNodeByXY(node.getX(), node.getY());
		List<Node> result = new ArrayList<Node>();
		// �ҵ���ǰ�ڵ������ߵ����ϱߵĽڵ�
		setUpperNode(node, result);
		// �ҵ���ǰ�ڵ������ߵ�����ߵĽڵ�
		setLeftNode(node, result);
		// �ҵ���ǰ�ڵ������ߵ����ұߵĽڵ�
		setRightNode(node, result);
		// �ҵ���ǰ�ڵ������ߵ����±ߵĽڵ�
		setBottomNode(node, result);
		return result;
	}

	public boolean meetTheWeaver(Node currentNode, Node nextNode) {
		int x = currentNode.getX() - nextNode.getX();
		int y = currentNode.getY() - nextNode.getY();
		if (x != 0) {
			if (weaver.getY() != currentNode.getY())
				return false;
			if (x > 0) {
				return currentNode.getX() >= weaver.getX()
						&& weaver.getX() >= nextNode.getX();
			} else {
				return currentNode.getX() <= weaver.getX()
						&& weaver.getX() <= nextNode.getX();
			}
		} else {
			if (weaver.getX() != currentNode.getX())
				return false;
			if (y > 0) {
				return currentNode.getY() >= weaver.getY()
						&& weaver.getY() >= nextNode.getY();
			} else {
				return currentNode.getY() <= weaver.getY()
						&& weaver.getY() <= nextNode.getY();
			}
		}
	}

	private void setUpperNode(Node node, List<Node> result) {
		if (node.getX() <= 1)
			return;
		Node upperNode = null;
		// ɸѡ���뵱ǰ�ڵ��Ϸ����������ͬһ���ϵ��ϰ��ڵ�
		for (Node n : barrier) {
			// ����ϰ��ڵ�͵�ǰ�ڵ㲻��ͬһ���ϣ����������ϰ��ڵ�
			if (n.getY() != node.getY())
				continue;
			// ���ͬһ���ϵ��ϰ��ﲻ�ڵ�ǰ�ڵ�֮�ϣ�������
			if (n.getX() >= node.getX()) {
				continue;
			}
			if (upperNode == null || upperNode.getX() < n.getX())
				upperNode = n;
		}

		// �����еĽڵ㼯��ѡ��δ�����ʹ��ģ�����һ���ܱ����ʵ��Ľڵ�
		Node nextNode = null;
		if (upperNode != null) {
			if (node.getX() - upperNode.getX() > 1)
				nextNode = pickNodeByXY(upperNode.getX() + 1, upperNode.getY());
		} else {
			// �Ϸ����ϰ���
			nextNode = pickNodeByXY(1, node.getY());
		}
		if (nextNode != null) {
			result.add(nextNode);
		}
	}

	private void setBottomNode(Node node, List<Node> result) {
		if (node.getX() >= m)
			return;
		Node bottomNode = null;
		for (Node n : barrier) {
			if (n.getY() != node.getY())
				continue;
			if (n.getX() <= node.getX())
				continue;
			if (bottomNode == null || n.getX() < bottomNode.getX())
				bottomNode = n;
		}
		Node nextNode = null;
		if (bottomNode != null) {
			if (bottomNode.getX() - node.getX() > 1)
				nextNode = pickNodeByXY(bottomNode.getX() - 1,
						bottomNode.getY());
		} else {
			nextNode = pickNodeByXY(m, node.getY());
		}
		if (nextNode != null) {
			result.add(nextNode);
		}
	}

	private void setLeftNode(Node node, List<Node> result) {
		if (node.getY() <= 1)
			return;
		Node leftNode = null;
		for (Node n : barrier) {
			if (n.getX() != node.getX())
				continue;
			if (n.getY() >= node.getY())
				continue;
			if (leftNode == null || leftNode.getY() < n.getY()) {
				leftNode = n;
			}
		}
		Node nextNode = null;
		if (leftNode != null) {
			if (node.getY() - leftNode.getY() > 1)
				nextNode = pickNodeByXY(leftNode.getX(), leftNode.getY() + 1);
		} else {
			nextNode = pickNodeByXY(node.getX(), 1);
		}
		if (nextNode != null) {
			result.add(nextNode);
		}
	}

	private void setRightNode(Node node, List<Node> result) {
		if (node.getY() >= n)
			return;
		Node rightNode = null;
		for (Node n : barrier) {
			if (n.getX() != node.getX())
				continue;
			if (n.getY() <= node.getY())
				continue;
			if (rightNode == null || n.getY() < rightNode.getY())
				rightNode = n;
		}
		// �����еĽڵ㼯��ѡ��δ�����ʹ��ģ�����һ���ܱ����ʵ��Ľڵ�
		Node nextNode = null;
		if (rightNode != null) {
			if (rightNode.getY() - node.getY() > 1)
				nextNode = pickNodeByXY(rightNode.getX(), rightNode.getY() - 1);
		} else {
			nextNode = pickNodeByXY(node.getX(), n);
		}
		if (nextNode != null) {
			result.add(nextNode);
		}
	}

	private Node pickNodeByXY(int x, int y) {
		for (Node n : allNodes) {
			if (n.getX() == x && n.getY() == y && !n.isVisit()) {
				n.setVisit(true);
				return n;
			}
		}
		return null;
	}

	public Node getCowBoy() {
		return cowBoy;
	}

	public void setCowBoy(Node cowBoy) {
		this.cowBoy = cowBoy;
	}

	public Node getWeaver() {
		return weaver;
	}

	public void setWeaver(Node weaver) {
		this.weaver = weaver;
	}

}
