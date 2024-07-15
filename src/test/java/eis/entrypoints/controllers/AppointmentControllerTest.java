package eis.entrypoints.controllers;

import eis.core.models.Appointment;
import eis.core.usecases.ports.input.IAppointmentNotificationUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AppointmentControllerTest {

    @InjectMocks
    private AppointmentController appointmentController;

    @Mock
    private IAppointmentNotificationUseCase appointmentNotificationUseCase;

    @Test
    void shouldNotifyAppointment_when_getAppointmentRequest() {
        var appointment = Appointment.builder().id("anyId").build();
        when(appointmentNotificationUseCase.notifyAppointment(appointment)).thenReturn(appointment);
        var response = appointmentController.notify(appointment);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}