package dummyquest;

import java.util.ArrayList;
import java.util.List;

public class UltramineTSK1 {
	public static void main(String[] args) {
		List<Customer> cusList = new ArrayList<>();
		List<Order> orderList = new ArrayList<>();
		
//		orderList.add(new Order("O101", "C1", LocalDate.of(01, 04, 2024), 8500));
//		orderList.add(new Order("O102", "C4", LocalDate.of(13, 07, 2024), 11500));
//		orderList.add(new Order("O103", "C2", LocalDate.of(21, 10, 2024), 800));
//		orderList.add(new Order("O104", "C3", LocalDate.of(30, 05, 2024), 13000));
//		orderList.add(new Order("O105", "C5", LocalDate.of(18, 01, 2024), 500));
//		orderList.add(new Order("O106", "C1", LocalDate.of(15, 11, 2024), 200));

		orderList.add(new Order("O101", "C1",8500));
		orderList.add(new Order("O102", "C4",11500));
		orderList.add(new Order("O103", "C2",800));
		orderList.add(new Order("O104", "C3",13000));
		orderList.add(new Order("O105", "C5", 500));
		orderList.add(new Order("O106", "C1",200));

		Customer c1 = new Customer("C1", "Bharath", "eagerBharath@gmail.com");
		Customer c2 = new Customer("C2", "jagan", "jagan@gmail.com");
		Customer c3 = new Customer("C3", "kamalam", "kamalam@gmail.com");
		Customer c4 = new Customer("C4", "arul", "arul@gmail.com");
		Customer c5 = new Customer("C5", "sasi", "sasi@gmail.com");
		
		cusList.add(c1);
		cusList.add(c2);
		cusList.add(c3);
		cusList.add(c4);
		cusList.add(c5);

		for (Customer cus : cusList) {
			for (Order ord : orderList) {
				if (ord.getCutomerId().equals(cus.getCusId())) {
					cus.setOrder(ord);
				}
			}

		}
		System.out.println(cusList);
	}
}



