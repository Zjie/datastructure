package findpath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CowBoyAndWeaver {
	public static void main(String[] args) {
		Map m = new Map(9, 9, getBarrier());
		m.setWeaver(new Node(3, 8));
		Node cowboy = new Node(3, 3);
		Queue<Node> nodeList = new LinkedList<Node>();
		nodeList.offer(cowboy);

		Node finalNode = null;
		boolean cowboyMeetWeaver = false;
		while (!nodeList.isEmpty() && !cowboyMeetWeaver) {
			Node curNode = nodeList.poll();
			curNode.setNextNode(m.getNextReachableNodes(curNode));
			for (Node n : curNode.getNextNode()) {
				n.setFatherNode(curNode);
				nodeList.offer(n);
				// 如果在下一步能找到织女，则推出循环
				if (m.meetTheWeaver(curNode, n)) {
					finalNode = n;
					cowboyMeetWeaver = true;
					break;
				}
			}
		}
		
		if (finalNode != null) {
			List<String> route = new ArrayList<String>();
			do {
				route.add(finalNode.toString());
				finalNode = finalNode.getFatherNode();
			} while (finalNode != null);
			StringBuilder sb = new StringBuilder();
			for (int i = route.size() - 1; i > 0; i--) {
				sb.append(route.get(i) + "->");
			}
			sb.append(route.get(0));
			System.out.print(sb.toString());
		} else {
			System.out.print("牛郎无法找到织女");
		}
	}

	public static List<Node> getBarrier() {
		List<Node> barrier = new ArrayList<Node>();
		barrier.add(new Node(2, 2));
		barrier.add(new Node(2, 8));
		barrier.add(new Node(3, 6));
		barrier.add(new Node(4, 1));
		barrier.add(new Node(5, 4));
		barrier.add(new Node(7, 3));
		barrier.add(new Node(7, 9));
		barrier.add(new Node(8, 5));
		barrier.add(new Node(8, 6));
		return barrier;
	}
}
