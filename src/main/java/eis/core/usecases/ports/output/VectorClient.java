package eis.core.usecases.ports.output;

import eis.core.models.Appointment;

public interface VectorClient {

    Appointment notifyAppointment(Appointment appointment);
}
