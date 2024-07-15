package eis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
public class EwmIntegrationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EwmIntegrationServiceApplication.class, args);
    }

}
