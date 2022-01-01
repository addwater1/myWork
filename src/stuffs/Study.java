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
			System.out.println("按Enter继续");
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
			System.out.println("回答正确");
		}
		else {
			System.out.println("回答错误，正确答案： " + quiz.getAns());
		}
	}
}
