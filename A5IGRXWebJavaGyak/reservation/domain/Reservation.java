package reservation.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Reservation {

	private int id;

	private boolean active;
	private boolean processed;
	private BigDecimal ammount;
	private LocalDateTime from;
	private LocalDateTime to;
	private Currency currency;
	private BookingPerson bookingperson;


	public BookingPerson getBookingperson() {
		return bookingperson;
	}

	public void setBookingperson(BookingPerson bookingperson) {
		this.bookingperson = bookingperson;
	}

	public BigDecimal getAmmount() {
		return ammount;
	}

	public void setAmmount(BigDecimal ammount) {
		this.ammount = ammount;
	}

	public LocalDateTime getFrom() {
		return from;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public void setFrom(LocalDateTime from) {
		this.from = from;
	}

	public LocalDateTime getTo() {
		return to;
	}

	public void setTo(LocalDateTime to) {
		this.to = to;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

}
