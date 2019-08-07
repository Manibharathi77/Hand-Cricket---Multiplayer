package communication.twoway;

import java.io.*;
import java.net.*;

public class HandCricSS {
	static String receiveMessage, sendMessage;
	static BufferedReader keyread = new BufferedReader(new InputStreamReader(System.in));
	static BufferedReader sysread;
	static PrintWriter pw;

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		ServerSocket sc = new ServerSocket(3000);
		Socket sock = sc.accept();
		System.out.println("Server is ready. Press enter to play");
		System.out.println("WELCOME TO HAND CRICKET STIMULATION!!!");
		System.out.println("Enter the number for toss");
		sendMessage = keyread.readLine();
		OutputStream os = sock.getOutputStream();
		pw = new PrintWriter(os, true);
		pw.println(sendMessage);
		pw.flush();
		InputStream istream = sock.getInputStream();
		sysread = new BufferedReader(new InputStreamReader(istream));
		receiveMessage = sysread.readLine();
		if ((receiveMessage) != null) {
			System.out.println(receiveMessage);
		}
		int input = Integer.parseInt(sendMessage);
		int i = Integer.parseInt(receiveMessage);
		int toss = i + input;
		if (toss == 0) {
			System.out.println("you are batting!!");
			HandCricSS d = new HandCricSS();
			d.player1batting();
		} else {
			System.out.println("Player 2 is batting");
			HandCricSS d = new HandCricSS();
			d.player2batting();
		}
	}

	public void player1batting() throws Exception {
		receiveMessage = "";
		sendMessage = "";
		System.out.println("Player 1 batting method initiated(Testing)");
		int totalFirst = 0;
		while (true) {

			sendMessage = keyread.readLine();
			pw.println(sendMessage); // prints run
			pw.flush();
			receiveMessage = sysread.readLine();
			if ((receiveMessage) != null) {
				System.out.println(receiveMessage); // prints the ball
			}
			int ball = Integer.parseInt(sendMessage);
			int run = Integer.parseInt(receiveMessage);
			if (run == ball) {
				System.out.println("out!!");
				System.out.println("Runs scored " + totalFirst);
				break;
			}
			totalFirst += run;
			System.out.println("current total runs = " + totalFirst);

		}
		int totalSecond = 0;
		while (true) {
			System.out.println("Player 2 batting method initiated(Testing)");
			sendMessage = keyread.readLine();
			pw.println(sendMessage); // prints run
			pw.flush();
			receiveMessage = sysread.readLine();
			if ((receiveMessage) != null) {
				System.out.println(receiveMessage); // prints the ball
			}

			int run = Integer.parseInt(sendMessage);
			int ball = Integer.parseInt(receiveMessage);
			if (totalSecond > totalFirst) { 
				System.out.println("Match is over!!! player 2 wins");
				break;
			}
			else if (totalFirst == totalSecond) {
				
					System.out.println("Match is over!!! Draw :-( ");
					break;
			}
					else if (run == ball) {
				System.out.println("out!!");
				System.out.println("Runs scored " + totalSecond);
				System.out.println("Player 1 wins!!");
				break;
					} 
			totalSecond += run;
			System.out.println("current total runs = " + totalSecond);		
		}
	
	}

	public void player2batting() throws Exception {
		receiveMessage = "";
		sendMessage = "";
		System.out.println("Player 2 batting method initiated(Testing)");
		int totalFirst = 0 ;
		while (true) {
			
			sendMessage = keyread.readLine();
			pw.println(sendMessage); // prints ball
			pw.flush();
			receiveMessage = sysread.readLine();
			if ((receiveMessage) != null) {
				System.out.println(receiveMessage); // prints the run
			}
			int ball = Integer.parseInt(sendMessage);
			int run = Integer.parseInt(receiveMessage);
			if (run == ball) {
				System.out.println("out!!");
				System.out.println("Runs scored " + totalFirst);
				break;
			}
			totalFirst += run;
			System.out.println("current total runs = " + totalFirst);

		}
		int totalSecond = 0;
		while (true) {
			System.out.println("Player 1 batting method initiated(Testing)");
			sendMessage = keyread.readLine();
			pw.println(sendMessage); // prints run
			pw.flush();
			receiveMessage = sysread.readLine();
			if ((receiveMessage) != null) {
				System.out.println(receiveMessage); // prints the ball
			}

			int run = Integer.parseInt(sendMessage);
			int ball = Integer.parseInt(receiveMessage);
			if (totalSecond > totalFirst) { 
				System.out.println("Match is over!!! player 1 wins");
				break;
			}
			else if (totalFirst == totalSecond) {
				
					System.out.println("Match is over!!! Draw :-( ");
					break;
			}
					else if (run == ball) {
				System.out.println("out!!");
				System.out.println("Runs scored " + totalSecond);
				System.out.println("Player 2 wins!!");
				break;
					} 
			totalSecond += run;
			System.out.println("current total runs = " + totalSecond);		
		}
	}
}
