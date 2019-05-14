package be.awake.bootgraphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BootGraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootGraphqlApplication.class, args);
	}

}
