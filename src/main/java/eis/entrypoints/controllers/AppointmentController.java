package eis.entrypoints.controllers;

import eis.core.models.Appointment;
import eis.core.usecases.ports.input.IAppointmentNotificationUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static eis.entrypoints.util.BuildResponse.buildResponse_Http_200;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/appointments")
public class AppointmentController {

    private final IAppointmentNotificationUseCase IAppointmentNotificationUseCase;

    @PostMapping("/notify")
    public ResponseEntity<Object> notify(@RequestBody Appointment appointment) {
        var response = IAppointmentNotificationUseCase.notifyAppointment(appointment);
        return new ResponseEntity<>(buildResponse_Http_200(response), HttpStatus.OK);
    }
}
