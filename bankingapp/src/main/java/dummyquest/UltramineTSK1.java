package dummyquest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class UltramineTSK1 {

	public List<Customer> getCustomerList() {

		List<Customer> cusList = new ArrayList<>();

		Customer c1 = new Customer();
		c1.setCusId("C1");
		c1.setName("Bharath");
		c1.setEmail("eagerBharath@gmail.com");

		Customer c2 = new Customer();
		c2.setCusId("C2");
		c2.setName("jagan");
		c2.setEmail("jagan@gmail.com");

		Customer c3 = new Customer();
		c3.setCusId("C3");
		c3.setName("kamalam");
		c3.setEmail("kamalam@gmail.com");

		Customer c4 = new Customer();
		c4.setCusId("C4");
		c4.setName("arul");
		c4.setEmail("arul@gmail.com");

		Customer c5 = new Customer();
		c5.setCusId("C5");
		c5.setName("sasi");
		c5.setEmail("sasi@gmail.com");

		cusList.add(c1);
		cusList.add(c2);
		cusList.add(c3);
		cusList.add(c4);
		cusList.add(c5);

		return cusList;

	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * List<Order> orderList = new ArrayList<>();
	 * 
	 * // To create a LocalDate the format is // LocalDate.of(Year, Month, Date,
	 * Hours, Minutes, Seconds);
	 * 
	 * orderList.add(new Order("O101", "C1", LocalDate.of(2024, 9, 1), 8500));
	 * orderList.add(new Order("O102", "C4", LocalDate.of(2024, 7, 13), 11500));
	 * orderList.add(new Order("O103", "C2", LocalDate.of(2024, 9, 1), 9100));
	 * orderList.add(new Order("O104", "C3", LocalDate.of(2024, 05, 30), 13000));
	 * orderList.add(new Order("O105", "C5", LocalDate.of(2024, 9, 1), 500));
	 * orderList.add(new Order("O106", "C1", LocalDate.of(2024, 9, 1), 10200));
	 * 
	 * // The specific date to the check for orders LocalDate fltDate =
	 * LocalDate.of(2024, 9, 1);
	 * 
	 * // Using traditional for loop to filter the order list List<Order>
	 * finalOrderList = new ArrayList<>(); for (Order ord : orderList) { if
	 * (ord.getOrderDate().equals(fltDate) && ord.getAmount() >= 8000) {
	 * finalOrderList.add(ord); } }
	 * 
	 * 
	 * 
	 * for (Customer cus : cusList) { for (Order ord : orderList) { if
	 * (ord.getCutomerId().equals(cus.getCusId())) { cus.setOrder(ord); } } }
	 * 
	 * 
	 * 
	 * UltramineTSK1 tsk = new UltramineTSK1();
	 * 
	 * List<Customer> cusList = tsk.getCustomerList(); List<Customer>
	 * finalCustomeList = new ArrayList<>();
	 * 
	 * for (Customer cus : cusList) { List<Order> tempOrdLst = new ArrayList<>();
	 * for (Order ord : finalOrderList) { if
	 * (ord.getCutomerId().equals(cus.getCusId())) { // cus.setOrder(ord);
	 * 
	 * // Add order to the customer temp order list tempOrdLst.add(ord); } } // now
	 * adding the customer if (!tempOrdLst.isEmpty()) { cus.setOrder(tempOrdLst);
	 * finalCustomeList.add(cus); }
	 * 
	 * }
	 * 
	 * System.out.println(cusList);
	 * System.out.println("Print the filtered customer list");
	 * System.out.println(finalCustomeList); }
	 */
}
