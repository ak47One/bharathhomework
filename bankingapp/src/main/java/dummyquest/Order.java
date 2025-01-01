package dummyquest;

import java.time.LocalDate;

public class Order {
	
	
	public Order(String orderId, String cutomerId, LocalDate orderDate, long amount) {
		super();
		this.orderId = orderId;
		this.cutomerId = cutomerId;
		this.orderDate = orderDate;
		this.amount = amount;
	}

	private String orderId;
	
	private String cutomerId;
	
	private LocalDate orderDate;
	
	private long amount;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCutomerId() {
		return cutomerId;
	}

	public void setCutomerId(String cutomerId) {
		this.cutomerId = cutomerId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", cutomerId=" + cutomerId + ", orderDate=" + orderDate + ", amount="
				+ amount + "]";
	}
	
	

}
