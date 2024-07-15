package eis.core.usecases;

import eis.config.aspect.Debugger;
import eis.core.models.Appointment;
import eis.core.usecases.ports.input.IAppointmentNotificationUseCase;

import eis.core.usecases.ports.output.IPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentNotificationUseCase implements IAppointmentNotificationUseCase {

    private final IPublisher IPublisher;

    @Override
    @Debugger
    public Appointment notifyAppointment(Appointment appointment) {
        return IPublisher.publish(appointment);
    }
}
