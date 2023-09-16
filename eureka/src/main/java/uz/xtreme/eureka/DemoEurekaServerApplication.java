package uz.xtreme.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@RefreshScope
public class DemoEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEurekaServerApplication.class, args);
	}

}
