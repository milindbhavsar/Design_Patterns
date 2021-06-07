package UdemyDesignPatterns.Structural;

import java.util.ArrayList;
import java.util.List;

/* 
1. Exposing several components through a single interface
2. Provides a simple and easy to understand/user interface over large body of code

*/

class Buffer {

	private char[] characters;
	private int lineWidth;

	Buffer(int width, int height) {
		this.lineWidth = width;
		characters = new char[width * height];
	}

	public char charAt(int x, int y) {
		return characters[y * lineWidth + x];
	}
}

class ViewPort {

	private final int width;
	private final int height;
	private final int offsetX;
	private final int offsetY;
	private final Buffer buffer;

	public ViewPort(Buffer bf, int width, int height, int offsetX, int offsetY) {

		this.buffer = bf;
		this.width = width;
		this.height = height;
		this.offsetY = offsetY;
		this.offsetX = offsetX;
	}

	public char charAt(int x, int y) {
		return buffer.charAt(x + offsetX, y + offsetY);
	}

}

class Console {

	int width;
	int height;
	private List<ViewPort> list;

	public Console(int width, int height) {
		this.width = width;
		this.height = height;
		list = new ArrayList<>();
	}

	public void addViewPort(ViewPort view) {
		list.add(view);
	}

	void render() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				for (ViewPort v : list) {
					System.out.println(v.charAt(x, y));
				}
			}
		}

	}

}

class ConsoleFactory {

	public static Console getConsole(int width, int height) {
		Buffer bf = new Buffer(width, height);
		ViewPort view = new ViewPort(bf, width, height, 0, 0);
		Console console1 = new Console(width, height);
		console1.addViewPort(view);
		return console1;

	}
}

public class Facade {
	public static void main(String args[]) {
		Buffer bf = new Buffer(20, 30);
		ViewPort view = new ViewPort(bf, 20, 30, 0, 0);
		Console console1 = new Console(20, 30);
		console1.addViewPort(view);
		console1.render();

		Console console2 = ConsoleFactory.getConsole(20, 30);
		console2.render();

	}
}
