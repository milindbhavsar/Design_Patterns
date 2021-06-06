package UdemyDesignPatterns.Structural;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class GraphicObject {
	protected String name = "Group";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GraphicObject() {
	}

	public String color;
	public List<GraphicObject> children = new ArrayList<>();

	private void print(StringBuilder stringBuilder, int depth) {
		stringBuilder.append(String.join("", Collections.nCopies(depth, "*"))).append(depth > 0 ? " " : "")
				.append((color == null || color.isEmpty()) ? "" : color + " ").append(getName())
				.append(System.lineSeparator());
		for (GraphicObject child : children)
			child.print(stringBuilder, depth + 1);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		print(sb, 0);
		return sb.toString();
	}
}

class Circlee extends GraphicObject {
	public Circlee(String color) {
		name = "Circle";
		this.color = color;
	}
}

class Squaree extends GraphicObject {
	public Squaree(String color) {
		name = "Square";
		this.color = color;
	}
}

public class Composite {
	public static void main(String[] args) {
		GraphicObject drawing = new GraphicObject();
		drawing.setName("My Drawing");
		drawing.children.add(new Squaree("Red"));
		drawing.children.add(new Circlee("Yellow"));

		GraphicObject group = new GraphicObject();
		group.children.add(new Circlee("Blue"));
		group.children.add(new Squaree("Blue"));
		drawing.children.add(group);

		System.out.println(drawing);
	}
}
