package com.java.ATMCashWithdrawal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATMWithdrawalFacility {
	public static void main(String[] args) throws IOException {
		/*
		 * Transaction atm = new Transaction(); Thread husband = new Thread(atm); Thread
		 * wife = new Thread(atm); husband.setName("Husband Thread");
		 * wife.setName("Wife Thread"); husband.start(); wife.start();
		 */
		String input = "";
		boolean keep_going = true;
		AmountInATM a1 = new AmountInATM();
		while (keep_going) {
			input = "";
			System.out.println("Welcome to my program! Would you like to:");
			System.out.println("1. Withdraw Money.");
			System.out.println("2. Check Balance and Number of notes present in ATM.");
			System.out.println("3. Exit.");
			System.out.println(">");
			System.out.print("> ");
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader buffer = new BufferedReader(isr);
			try {
				input = buffer.readLine();
				// buffer.close() ;
			} catch (IOException e) {
				System.out.println(e);
			}
			switch (Integer.parseInt(input)) {
			case 1:
				System.out.println("Please enter amount in multiples of 100");
				BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
				int amount = Integer.parseInt(inp.readLine());
				boolean withdrawn = a1.checkAmountAndWithdraw(amount);
				if (withdrawn)
					System.out.println("Amount " + amount + " withdrawn successfully.");
				else
					System.out.println("This Amount " + amount + " cannot be withdrawn.");
				break;
			case 2:
				System.out.println("Balance remaining in ATM: " + a1.getBalance());
				System.out.println("2000 rupee notes present: " + a1.getNotes2000());
				System.out.println("500 rupee notes present: " + a1.getNotes500());
				System.out.println("100 rupee notes present: " + a1.getNotes100());
				break;
			case 3:
				keep_going = false;
				break;
			default:
				System.out.println(input + " is not a valid option. Please try again.");
			}
		}
	}
}
