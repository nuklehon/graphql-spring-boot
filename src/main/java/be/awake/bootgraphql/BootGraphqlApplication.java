package be.awake.bootgraphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

import javax.servlet.Filter;

@SpringBootApplication
@EnableJpaRepositories
public class BootGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootGraphqlApplication.class, args);
    }

    @Bean
    public Filter openEntityManagerInViewFilter() {
        return new OpenEntityManagerInViewFilter();
    }

}
