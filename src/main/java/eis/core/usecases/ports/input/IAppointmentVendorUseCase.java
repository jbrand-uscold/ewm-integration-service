package eis.core.usecases.ports.input;

public interface IAppointmentVendorUseCase {

    <T> void notifyAppointment(T data);
}
