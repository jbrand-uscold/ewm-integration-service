package eis.core.usecases.ports.input;

import eis.core.models.Appointment;

public interface IAppointmentNotificationUseCase {
    Appointment notifyAppointment(Appointment appointment);
}
