
package org.onebeartoe.boot.inventory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) 
    {
        return args -> 
        {
            log.info("Preloading " + repository.save(new Product("Long Boot", "5")));
            log.info("Preloading " + repository.save(new Product("Dress Boot", "2")));
            log.info("Preloading " + repository.save(new Product("Cowboy Boot", "9")));
            log.info("Preloading " + repository.save(new Product("Spring Boot", "12")));
            log.info("Preloading " + repository.save(new Product("Das Boot", "12")));
        };
    }
}
