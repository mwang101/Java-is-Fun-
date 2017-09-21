import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class rockPaperScissors {

	public static void main(String[] args) {
		int userNum = 0, comNum;
		int wins = 0;
		int count = 0;
		int health = 20;
		int MAX_HEALTH = 20;
		do {
			comNum = (int) (Math.random() * 3);
			String[] options = { "rock", "paper", "scissors" };
			int chooseOption = JOptionPane.showOptionDialog(null, "Rock paper or scissors?", "Choose Option",
					JOptionPane.WARNING_MESSAGE, 0, null, options, options[0]);
			userNum = chooseOption;
			System.out.println(+userNum);
			if (comNum == 0 && userNum == 1) {
				System.out.println("Computer played rock. You win!");
				wins = wins + 1;
				count = count + 1;
				if (health < 20) {
					health = health + 2;
				}
			} else if (comNum == 0 && userNum == 2) {
				System.out.println("Computer played rock. You lose!");
				count = count + 1;
				health = health - 5;
			} else if (comNum == 1 && userNum == 0) {
				System.out.println("Computer played paper. You lose!");
				count = count + 1;
				health = health - 5;
			} else if (comNum == 1 && userNum == 2) {
				System.out.println("Computer played paper. You win!");
				wins = wins + 1;
				count = count + 1;
				if (health < 20) {
					health = health + 2;
				}
			} else if (comNum == 2 && userNum == 0) {
				System.out.println("Computer played scissors. You win!");
				wins = wins + 1;
				count = count + 1;
				if (health < 20) {
					health = health + 2;
				}
			} else if (comNum == 2 && userNum == 1) {
				System.out.println("Computer played scissors. You lose!");
				count = count + 1;
				health = health - 5;
			} else {
				System.out.println("A tie!");
				count = count + 1;
			}
			System.out.print("Health : [");
			for (int i = 0; i < health; i++) {
				System.out.print("*");
			}
			for (int i = 0; i < (MAX_HEALTH - health); i++) {
				System.out.print(" ");
			}
			System.out.println("]");

		} while (health > 0);
		System.out.println("You won " + wins + " times over " + count + " games!");
		double score = (int) ((wins * 200) / count);
		System.out.println("You scored " + score + " points!");

		writeScore(score);
		System.out.println("High score is: " + getScore());

	}

	public static void writeScore(double score) {
		if (score > getScore()) {
			try {
				PrintWriter writer = new PrintWriter("/Users/student/Desktop/Workspace_Michael/TwoPlayerGame/scores.txt", "UTF-8");
				writer.println(score);
				writer.close();
			} catch (IOException e) {
			
			}
		}
	}

	public static double getScore() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("/Users/student/Desktop/Workspace_Michael/TwoPlayerGame/scores.txt"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String everything = sb.toString();
			return Double.parseDouble(everything);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}  
}
