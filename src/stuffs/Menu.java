package stuffs;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
	private boolean isRight = false; 
	
	public Menu() {
		
	}
	
	public void run() throws IOException {
		Scanner input = new Scanner(System.in);
		Study study = new Study();
		String select;
		while(!isRight) {
			System.out.println("-----------");
			System.out.println("1.ѧϰ");
			System.out.println("2.����");
			System.out.println("3.�˳�");
			System.out.println("-----------");
			select = input.nextLine();
			switch(select) {
			case "1" :study.run();break;
			case "2" :break;
			case "3" :isRight = true;break;
			}
		}
		System.out.println("���˳�");
	}
}
