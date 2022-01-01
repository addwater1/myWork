package stuffs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProcessData {
	private static Map<String, String> userInfo;
	
	public ProcessData() throws FileNotFoundException {
		init();
	}
	
	public void init() throws FileNotFoundException {
		userInfo = new HashMap<>();
		File file = new File("src\\data.txt");
		Scanner in = new Scanner(file);
		String[] st = null;
		while(in.hasNextLine()) {
			String line = in.nextLine();
			if(line.equals(""))continue;
			st = line.split(" ");
			userInfo.put(st[0], st[1]);
		}
		in.close();
	}
	
	public void add(String name,String pwd) throws IOException {
		userInfo.put(name, pwd);
		File file = new File("src\\data.txt");
		PrintWriter pr = new PrintWriter(new FileWriter(file, true));
		pr.println(name + " " + pwd);
		pr.close();
		
	}
	
	public boolean checkUser(String name) {
		return userInfo.containsKey(name);
	}
	
	public boolean isRight(String name,String pwd) {
		if(userInfo.containsKey(name)) 
			return userInfo.get(name).equals(pwd);
		return false;
	}
}
