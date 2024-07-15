package eis.adapters.vector;

import eis.core.models.Appointment;
import eis.core.usecases.ports.output.VectorClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class VectorClientImpl implements VectorClient {

    @Override
    public Appointment notifyAppointment(Appointment appointment) {
        log.info(appointment.toString());
        return null;
    }
}
