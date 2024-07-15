package eis.core.usecases;

import eis.core.usecases.ports.input.IAppointmentVendorUseCase;
import eis.core.usecases.ports.output.EwmVendor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentVendorUseCaseImpl implements IAppointmentVendorUseCase {

    private final EwmVendor ewmVendor;

    @Override
    public <T> void notifyAppointment(T data) {
        ewmVendor.notifyAppointment(data);
    }
}
