package reservation.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BookingPerson extends User {

	
	private BigDecimal balance;
	private String name;
	private int accountNumber;
	private LocalDate birth;
	private Currency currency;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
		public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}


}
