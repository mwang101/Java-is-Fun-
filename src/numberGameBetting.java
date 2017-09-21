import javax.swing.JOptionPane;

public class numberGameBetting {

	public static void main(String[] args) {
		String response;
		int userNum1, userNum2;
		int games = 0;
		int wonOne = 0;
		int wonTwo = 0;
		int moneyOne = 100;
		int moneyTwo = 100;
		int betOne, betTwo;
		do {
			
			response = JOptionPane.showInputDialog("Player 1 bet an amount");
			betOne = Integer.parseInt(response);
			if (betOne < 0 || betOne > moneyOne) {
			do {
			response = JOptionPane.showInputDialog("Error! Bet another amount");
			betOne = Integer.parseInt(response);
			} while (betOne < 0 || betOne > moneyOne);
			}
			// <----------------- player 1 something ------------------>
			
			response = JOptionPane.showInputDialog("Choose a number between 0 and 10");
			userNum1 = Integer.parseInt(response);
			if (userNum1 < 0 || userNum1 > 10) {
			do {
			response = JOptionPane.showInputDialog("Error! Choose another number");
			userNum1 = Integer.parseInt(response);
			} while (userNum1 < 0 || userNum1 > 10); 
			}
			
			response = JOptionPane.showInputDialog("Player 2 bet an amount");
			betTwo = Integer.parseInt(response);
			if (betTwo > moneyTwo || betTwo < 1) {
			do {
			response = JOptionPane.showInputDialog("Error! Bet another amount");
			betTwo = Integer.parseInt(response);
			} while (betTwo > moneyTwo || betTwo < 1);
			}
			
			response = JOptionPane.showInputDialog("Choose a number between 0 and 10");
			userNum2 = Integer.parseInt(response);
			if (userNum2 < 0 || userNum2 > 10) {
			do {
			response = JOptionPane.showInputDialog("Error! Choose another number");
			userNum2 = Integer.parseInt(response);
			} while (userNum2 < 0 || userNum2 > 10);
			}
			games = games + 1;

			if (userNum1 > userNum2 && userNum1 - userNum2 <= 3) {
				System.out.println("Player 1 won!");
				wonOne = wonOne + 1;
				moneyTwo = moneyTwo - betTwo;
				System.out.println("Player 2 now has " + moneyTwo + " dollars");
				System.out.println("Player 1 has " + moneyOne + " dollars");
			} else if (userNum1 - userNum2 > 3) {
				System.out.println("Player 2 won!");
				wonTwo = wonTwo + 1;
				moneyOne = moneyOne - betOne;
				System.out.println("Player 1 now has " + moneyOne + " dollars");
				System.out.println("Player 2 has " + moneyTwo + " dollars");
			} else if (userNum2 > userNum1 && userNum2 - userNum1 <= 3) {
				System.out.println("Player 2 won!");
				wonTwo = wonTwo + 1;
				moneyOne = moneyOne - betOne;
				System.out.println("Player 1 now has " + moneyOne + " dollars");
				System.out.println("Player 2 has " + moneyTwo + " dollars");
			} else {
				System.out.println("Player 1 won!");
				wonOne = wonOne + 1;
				moneyTwo = moneyTwo - betTwo;
				System.out.println("Player 2 now has " + moneyTwo + " dollars");
				System.out.println("Player 1 has " + moneyOne + " dollars");
			}

		} while (moneyOne > 0 && moneyTwo > 0);
		if (wonOne > wonTwo) {
			System.out.println("Player 1 won overall with " + wonOne + " wins!");
		} else if (wonOne == wonTwo) {
			System.out.println("A tie! Each had " + wonTwo + " wins!");
		} else
			System.out.println("Player 2 won overall with " + wonTwo + " wins!");

	}

}
