package in.strikes.CRUDspringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;


@SpringBootApplication
public class CruDspringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruDspringBootDemoApplication.class, args);
		System.out.println("hello world");
	}

}
