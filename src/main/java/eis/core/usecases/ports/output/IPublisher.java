package eis.core.usecases.ports.output;

import eis.core.models.Appointment;

public interface IPublisher {

    Appointment publish(Appointment appointment);
}
