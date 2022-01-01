package stuffs;

import java.io.IOException;
import java.util.Scanner;


public class Options {
	private String userName;
	private String passWord;
	private ProcessData pd;
	private boolean isRight = false;
	
	public Options() throws IOException, InterruptedException {

	}
	
	public void run() throws IOException, InterruptedException {
		Scanner input = new Scanner(System.in);
		int select;
		ProcessData pd = new ProcessData();
		pd.init();
		while(!isRight) {
			System.out.println("----------");
			System.out.println("1.登录");
			System.out.println("2.注册");
			System.out.println("----------");
			select = input.nextInt();
			switch (select){
			case 1:this.login();break;
			case 2:this.register();break;
			}
		}
	}
	
	public void register() throws IOException, InterruptedException {
		Scanner input = new Scanner(System.in);
		ProcessData pd = new ProcessData();
		while(true) {
			System.out.print("输入用户名： ");
			this.userName = input.nextLine();
			if(check(userName) && !pd.checkUser(userName)) {
				break;
			}
			if(pd.checkUser(userName)) {
				System.out.print("用户名已存在");
			}
			else {
				System.out.print("用户名不合法");
			}
		}
		while(true) {
			System.out.print("输入密码： ");
			passWord = input.nextLine();
			if(check(passWord))
				break;
			System.out.print("密码不合法");
		}
		System.out.print("确认密码： ");
		String st = input.nextLine();
		if(st.equals(passWord)) {
			isRight = true;
			pd.add(userName, passWord);
			System.out.println("注册成功");
		}
		else {
			System.out.println("注册失败");
		}
	}
	
	public void login() throws IOException, InterruptedException{
		Scanner input = new Scanner(System.in);
		System.out.print("输入用户名： ");
		this.userName = input.nextLine();
		System.out.print("输入密码： ");
		this.passWord = input.nextLine();
		ProcessData pd = new ProcessData();
		if(pd.isRight(userName, passWord)) {
			isRight = true;
			System.out.println("登陆成功,按Enter继续");
			input.nextLine();
		}
		else {
			System.out.println("用户名或密码错误");
		}
	}
	
	private static boolean check(String st) {
		String regExp = "^[\\w_]{6,20}$";
        if (st.matches(regExp)) {
            return true;
        }
        return false;
	}
}
