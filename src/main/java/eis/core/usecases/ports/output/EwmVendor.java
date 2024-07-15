package eis.core.usecases.ports.output;

public interface EwmVendor {

    <T> void notifyAppointment(T data);
}
