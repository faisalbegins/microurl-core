package edu.miu.microurl.microurlcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class MicroUrlCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroUrlCoreApplication.class, args);
	}

}
