package eis.core.usecases;

import eis.core.usecases.ports.output.EwmVendor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AppointmentVendorUseCaseImplTest {

    @InjectMocks
    private AppointmentVendorUseCaseImpl useCase;

    @Mock
    private EwmVendor ewmVendor;

    @Test
    void shouldNotifyAppointmentToVendor_whenGetMessage() {
        var data = new Object();
        doNothing().when(ewmVendor).notifyAppointment(data);
        useCase.notifyAppointment(data);
        verify(ewmVendor, times(1)).notifyAppointment(data);
    }
}