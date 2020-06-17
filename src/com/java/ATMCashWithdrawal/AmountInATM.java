package com.java.ATMCashWithdrawal;

public class AmountInATM {
	private int balance = 50000;
	private int notes2000 = 15;
	private int notes500 = 20;
	private int notes100 = 100;

	public int getNotes2000() {
		return notes2000;
	}

	public int getNotes500() {
		return notes500;
	}

	public int getNotes100() {
		return notes100;
	}

	public void withdraw(int amount) {

		this.balance = this.balance - amount;

	}

	public int getBalance() {
		return balance;
	}

	public void decreaseNotes(int notes2000, int notes500, int notes100) {
		this.notes2000 = this.notes2000 - notes2000;
		this.notes500 = this.notes500 - notes500;
		this.notes100 = this.notes100 - notes100;
	}

	public boolean checkAmountAndWithdraw(int amount) {
		int residualAmt= amount;
		int nt2000 =0;
		int nt500 = 0;
		int nt100 = 0;
		if (amount % 100 == 0) {
			this.withdraw(amount);
			if(residualAmt !=0 && residualAmt >= 2000 && residualAmt % 2000 ==0 && this.notes2000 >= residualAmt/2000)
			{
				nt2000 = residualAmt/2000;
				residualAmt = residualAmt%2000;
			}
			if(residualAmt !=0 && residualAmt >= 500 && residualAmt % 500 ==0 && this.notes500 >= residualAmt/500)
			{
				nt500 = residualAmt/500;
				residualAmt = residualAmt%500;
			}
			if(residualAmt !=0 && residualAmt >= 100 && residualAmt % 100 ==0 && this.notes100 >= residualAmt/100)
			{
				nt100 = residualAmt/100;
				residualAmt = residualAmt%100;
			}
			if(nt2000>0 || nt500>0 || nt100>0)
			{
				decreaseNotes(nt2000,nt500,nt100);
				return true;
			}
			else
				return false;
		}
		return false;
	}
}
