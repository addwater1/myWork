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
			System.out.println("1.��¼");
			System.out.println("2.ע��");
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
			System.out.print("�����û����� ");
			this.userName = input.nextLine();
			if(check(userName) && !pd.checkUser(userName)) {
				break;
			}
			if(pd.checkUser(userName)) {
				System.out.print("�û����Ѵ���");
			}
			else {
				System.out.print("�û������Ϸ�");
			}
		}
		while(true) {
			System.out.print("�������룺 ");
			passWord = input.nextLine();
			if(check(passWord))
				break;
			System.out.print("���벻�Ϸ�");
		}
		System.out.print("ȷ�����룺 ");
		String st = input.nextLine();
		if(st.equals(passWord)) {
			isRight = true;
			pd.add(userName, passWord);
			System.out.println("ע��ɹ�");
		}
		else {
			System.out.println("ע��ʧ��");
		}
	}
	
	public void login() throws IOException, InterruptedException{
		Scanner input = new Scanner(System.in);
		System.out.print("�����û����� ");
		this.userName = input.nextLine();
		System.out.print("�������룺 ");
		this.passWord = input.nextLine();
		ProcessData pd = new ProcessData();
		if(pd.isRight(userName, passWord)) {
			isRight = true;
			System.out.println("��½�ɹ�,��Enter����");
			input.nextLine();
		}
		else {
			System.out.println("�û������������");
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
