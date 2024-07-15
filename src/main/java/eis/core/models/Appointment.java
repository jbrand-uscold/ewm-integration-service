package eis.core.models;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record Appointment(@NonNull String id, String warehouseId) {
}
