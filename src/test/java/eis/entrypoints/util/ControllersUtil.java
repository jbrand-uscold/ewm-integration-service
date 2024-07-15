package eis.entrypoints.util;

import eis.core.models.Appointment;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ControllersUtil {

    public static Appointment buildAppointment() {
        return Appointment.builder()
                .id(UUID.randomUUID().toString())
                .warehouseId(UUID.randomUUID().toString())
                .build();
    }
}
