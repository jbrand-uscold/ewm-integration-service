package eis.adapters.restclient;

import eis.adapters.restclient.dto.Appointment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface EwmClient {

    @PostExchange(value = "/confirm", contentType = APPLICATION_JSON_VALUE)
    <T> void addData(@RequestBody Appointment appointment);
}
