package eis.adapters.restclient;

import com.google.gson.Gson;
import eis.adapters.restclient.dto.Appointment;
import eis.config.aspect.Debugger;
import eis.core.usecases.ports.output.EwmVendor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EwmVendorImpl implements EwmVendor {

    private final EwmClient ewmClient;

    @Override
    @Debugger
    public <T> void notifyAppointment(T data) {
        try {
            var appointment = processRequestBody(data);
            ewmClient.addData(appointment);
        } catch (Exception exp) {
            log.error("Error notifying appointment", exp);
        }
    }

    @NonNull
    private <T> Appointment processRequestBody(T data) {
        String input = data.toString();
        input = input.replace("Appointment[", "{").replace("]", "}");
        input = input.replace("id=", "\"id\":").replace(", warehouseId=", ", \"warehouseId\":");
        Gson gson = new Gson();
        return gson.fromJson(input, Appointment.class);
    }
}
