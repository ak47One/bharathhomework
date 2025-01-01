package dummyquest;

import java.util.List;


public class Customer {
	
	private String cusId;
	
	private String name;
	
	private String email;
	
	private List<Order> order;

	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Customer [cusId=" + cusId + ", name=" + name + ", email=" + email + ", order=" + order + "]";
	}

	public Customer(String cusId, String name, String email, List<Order> order) {
		super();
		this.cusId = cusId;
		this.name = name;
		this.email = email;
		this.order = order;
	}

	public Customer() {
	}
	
	

}
