package reservation.domain;

import java.math.BigDecimal;

public class Room {

	
	private boolean balcon;
	private int number;
	private int beds;
	private BigDecimal price;
	private WingType wing;

	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getBeds() {
		return beds;
	}
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public WingType getWing() {
		return wing;
	}

	public void setWing(WingType wing) {
		this.wing = wing;
	}


	public void setBeds(int beds) {
		this.beds = beds;
	}

	public boolean isBalcon() {
		return balcon;
	}

	public void setBalcon(boolean balcon) {
		this.balcon = balcon;
	}

}
