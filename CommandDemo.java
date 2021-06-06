/*
 * 1. ordinary Java statements are perishable
   2. want an object that represents an operation
   3. uses : GUI commands ,multi level undo redo ,macro recording
   4. Contains all the info necessary  for the action to be taken
   5. An object which represents an instruction to perform a particular action
 * 
 * 
 */


package UdemyDesignPatterns.behavioural;

import java.util.ArrayList;
import java.util.List;

class BankAccounttt {
	private int balance;
	private int overdraft = -500;

	public void deposit(int amount) {
		balance += amount;
		System.out.println("Deposited " + amount + ", balance is now " + balance);
	}

	public void withdraw(int amount) {
		if (balance - amount >= overdraft) {
			balance -= amount;
			System.out.println("Withdrew " + amount + ", balance is now " + balance);
		} else {
			System.out.println("Cannot withdraw balance is low " + balance);
		}

	}

	@Override
	public String toString() {
		return "BankAccount {balance= " + balance + "}";

	}

}

interface Command {
	void call();
}

class BankAccountCommand implements Command {

	private BankAccounttt account;
	private Action action;
	private int amount;

	public enum Action {
		DEPOSIT, WITHDRAW;
	}

	BankAccountCommand(BankAccounttt ba, Action action, int amount) {
		this.account = ba;
		this.action = action;
		this.amount = amount;
	}

	@Override
	public void call() {
		switch (action) {
		case DEPOSIT:
			account.deposit(amount);
			break;
		case WITHDRAW:
			account.withdraw(amount);
			break;
		}
	}

}

public class CommandDemo {

	public static void main(String args[]) {
		BankAccounttt ba = new BankAccounttt();
		System.out.println(ba);

		List<BankAccountCommand> commands = new ArrayList<>();
		commands.add(new BankAccountCommand(ba, BankAccountCommand.Action.DEPOSIT, 100));
		commands.add(new BankAccountCommand(ba, BankAccountCommand.Action.WITHDRAW, 1000));
		commands.add(new BankAccountCommand(ba, BankAccountCommand.Action.WITHDRAW, 50));

		for (BankAccountCommand cm : commands) {
			cm.call();
			System.out.println(ba);
		}
	}

}
