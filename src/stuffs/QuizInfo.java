package stuffs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class QuizInfo {
	private String quiz;
	private String select;
	private String ans;
	
	public QuizInfo(int id) throws IOException {
		id = id % 11;
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("src\\quiz\\"+id+".txt"),"UTF-8"));
		ArrayList<String> lines = new ArrayList<>();
		for(int i = 0; i < 3; i++) {
			lines.add(in.readLine());
		}
		this.quiz = lines.get(0);
		this.select = lines.get(1);
		this.ans = lines.get(2);
		in.close();
	}
	
	public String getQuiz() {
		return quiz;
	}
	
	public String getSelect() {
		return select;
	}
	
	public String getAns() {
		return ans;
	}
}
