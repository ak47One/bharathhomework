package dummyquest;

public class Order {
	private String orderId;
	private String cutomerId;
	
	private long amount;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId  + ", amount=" + amount + "]";
	}

	public String getCutomerId() {
		return cutomerId;
	}

	public void setCutomerId(String cutomerId) {
		this.cutomerId = cutomerId;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Order(String orderId, String cutomerId, long amount) {
		super();
		this.orderId = orderId;
		this.cutomerId = cutomerId;
		this.amount = amount;
	}


}
