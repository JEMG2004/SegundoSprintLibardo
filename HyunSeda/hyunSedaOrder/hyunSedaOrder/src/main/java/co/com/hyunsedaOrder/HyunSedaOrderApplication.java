package co.com.hyunsedaOrder;

import co.com.hyunsedaOrder.Entity.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HyunSedaOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(HyunSedaOrderApplication.class, args);

		Order or = new Order("454001");
		or.shipment(7);

		System.out.println("Total products (Not sent state):" + or.getProductsQuantity());

		or.shipment(8);
		System.out.println("Total products (Received state):" + or.getProductsQuantity());

		or.shipment(9);
		System.out.println("Total products (Processed state):" + or.getProductsQuantity());

		or.shipment(10);
		System.out.println("Total products (Embarked state):" + or.getProductsQuantity());

		or.shipment(11);
		System.out.println("Total products (Sent state):" + or.getProductsQuantity());

		or.shipment(12);
		System.out.println("Total products (Cancelled state):" + or.getProductsQuantity());
	}

}
