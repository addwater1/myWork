package stuffs;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Study {
	private QuizInfo quiz;
	private String select;
	
	public Study() throws IOException {

	}
	
	public void run() throws IOException {
		Scanner in = new Scanner(System.in);
		for(int i = 0; i < 5; i++) {
			setQuiz();
			select = in.nextLine();
			select = select.toUpperCase();
			judge();
			System.out.println("��Enter����");
			in.nextLine();
		}
	}
	
	private void setQuiz() throws IOException {
		Random rand = new Random();
		int id = rand.nextInt(100);
		quiz = new QuizInfo(id);
		System.out.println(quiz.getQuiz());
		System.out.println(quiz.getSelect());
	}
	
	private void judge() {
		if(select.equals(quiz.getAns())) {
			System.out.println("�ش���ȷ");
		}
		else {
			System.out.println("�ش������ȷ�𰸣� " + quiz.getAns());
		}
	}
}
