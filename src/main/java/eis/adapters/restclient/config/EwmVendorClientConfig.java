package eis.adapters.restclient.config;

import eis.adapters.restclient.EwmClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class EwmVendorClientConfig {

    @Bean
    public EwmClient getEwmClient() {
        var client = WebClient.builder()
                .baseUrl("http://localhost:8081/v1/appointments")
                .build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(WebClientAdapter.create(client)).build();
        return factory.createClient(EwmClient.class);
    }
}
