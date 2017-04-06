package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Customer extends User {

	private int balance;

	@OneToMany(mappedBy = "customer")
	private List<Account> accounts;

	public Customer() {
		super();
		this.balance = 0;
		this.accounts = new ArrayList<Account>();
	}

	public Customer(String name) {
		super(name);
		this.balance = 0;
		this.accounts = new ArrayList<Account>();
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public void addAccount(Account acc) {
		this.accounts.add(acc);
	}

	public boolean pay(int amount) {
		if (balance >= amount) {
			balance -= amount;
			return true;
		}
		return false;
	}

}
