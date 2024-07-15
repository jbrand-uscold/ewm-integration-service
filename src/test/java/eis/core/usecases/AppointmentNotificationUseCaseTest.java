package eis.core.usecases;

import eis.core.models.Appointment;
import eis.core.usecases.ports.output.IPublisher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AppointmentNotificationUseCaseTest {

    @InjectMocks
    private AppointmentNotificationUseCase appointmentNotificationUseCase;

    @Mock
    private IPublisher publisher;

    @Test
    void shouldNotifyAppointment_when_getOneAppointment(){
        var appointment = Appointment.builder().id("anyId").build();
        when(publisher.publish(any(Appointment.class))).thenReturn(appointment);
        Appointment useCaseResponse = appointmentNotificationUseCase.notifyAppointment(appointment);
        assertEquals(appointment, useCaseResponse);
    }
}