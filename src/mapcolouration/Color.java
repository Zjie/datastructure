package mapcolouration;

import java.util.List;
import java.util.ArrayList;

public class Color {
	public static final Color RED = new Color(1, "red");
	public static final Color YELLOW = new Color(2, "yellow");
	public static final Color GREEN = new Color(3, "green");
	public static final Color PINK = new Color(4, "pink");
	private int value;
	private String name;
	private static Color[] allColors = { RED, YELLOW, GREEN, PINK };

	public static List<Color> getAllColors() {
		List<Color> tmp = new ArrayList<Color>(4);
		for (int i = 0; i < allColors.length; i++) {
			tmp.add(allColors[i]);
		}
		return tmp;
	}

	private Color(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		Color other = (Color) o;
		return value == other.value;
	}
}
