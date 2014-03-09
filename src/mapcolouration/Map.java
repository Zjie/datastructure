package mapcolouration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Map {
	private List<Vector> allVectors;
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("����������ĸ���:");
		int num = input.nextInt();
		Map map = new Map(getData(num));
		map.paintVector();
	}

	public void paintVector() {
		// ѭ�������еĽ�㶼Ϳ����ɫ
		for (Vector v : allVectors) {
			paintVector(v);
		}
		if (isFinished()) {
			System.out.println("ÿ��������ɫ�ֱ��ǣ�");
			for (Vector v : allVectors) {
				System.out.println(v.number + ":" + v.color);
			}
		} else {
			System.out.println("�޷���4����ɫ����Щ��������ĿҪ�������ɫ");
		}
	}

	private void paintVector(Vector vector) {
		List<Color> colors = vector.getUsableColors();
		// ����Ѿ��޷�ѡ��һ����ɫ����������ɫ��˵����������޷�����Ҫ�󣬻�����һ��������ɫ
		if (colors == null || colors.size() == 0) {
			return;
		}
		// ����ܸ�������Ϳһ����ɫ���ݹ����¼�����ɫ
		for (Color color : colors) {
			vector.color = color;
			vector.isColored = true;

			for (Vector v : vector.neighbours) {
				if (v.isColored) {
					continue;
				}
				paintVector(v);
			}
		}
	}

	public Map(int[][] data) {
		Vector[] vectors = new Vector[data.length];
		// ��ʼ�����н��
		for (int i = 0; i < vectors.length; i++) {
			vectors[i] = new Vector();
			vectors[i].number = i + 1;
		}
		// ���ý����ϵ
		for (int i = 0; i < data.length; i++) {
			List<Vector> neighbours = new ArrayList<Vector>();
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] == 1) {
					neighbours.add(vectors[j]);
				}
			}
			vectors[i].neighbours = neighbours;
		}
		allVectors = Arrays.asList(vectors);
	}

	// �ж��Ƿ�ȫ������Ѿ�����ɫ
	public boolean isFinished() {
		for (Vector v : allVectors) {
			if (!v.isColored) {
				return false;
			}
			for (Vector subV : v.neighbours) {
				if (subV.color.equals(v.color)) {
					return false;
				}
			}
		}
		return true;
	}

	public static int[][] getData(int num) {
		int[][] data = new int[num][num];
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				data[i][j] = 0;
			}
		}
		System.out.println("����������֮��Ĺ�ϵ");
		System.out.println("����:1,2");
		System.out.println("��ʾ����1������2�����ӣ��������޷����");
		System.out.println("����\"end\"����ֹ������ϵ���ݵ�����");
		boolean hasNext = true;
		while (hasNext) {
			String tmpStr = input.next();
			if (tmpStr.equals("end")) {
				hasNext = false;
			} else {
				String[] d = tmpStr.split(",");
				int x = Integer.parseInt(d[0]);
				int y = Integer.parseInt(d[1]);
				if (x > num || y > num) {
					System.out.println("����������Ų��ܳ���" + num);
					continue;
				}
				data[x - 1][y - 1] = 1;
				data[y - 1][x - 1] = 1;
			}
		}
		return data;
	}
}
