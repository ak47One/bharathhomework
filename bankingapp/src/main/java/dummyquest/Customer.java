package dummyquest;

import java.util.ArrayList;
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
		public void setOrder(Order ord) {
			this.order.add(ord);
		}
		
		public Customer(String cusId, String name, String email) {
			this.cusId = cusId;
			this.name = name;
			this.email = email;	
		 this.order = new ArrayList<>();
		}
		@Override
		public String toString() {
		    StringBuilder sb = new StringBuilder();
		    sb.append("Customer cusId=").append(cusId)
		      .append(", name=").append(name)
		      .append(", email=").append(email)
		      .append(", orders=\n");

		    for (Order ord : order) {
		        sb.append("  ").append(ord.toString()).append("\n");
		    }

		    sb.append(" ");
		    return sb.toString();
		}

	}



