package stuffs;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Options start = new Options();
		Menu menu = new Menu();
		start.run();
		menu.run();
	}
	
}
