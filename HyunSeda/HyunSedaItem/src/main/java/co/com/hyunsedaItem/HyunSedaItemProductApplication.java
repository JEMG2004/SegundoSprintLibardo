package co.com.hyunsedaItem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HyunSedaItemProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(HyunSedaItemProductApplication.class, args);
	}

}
