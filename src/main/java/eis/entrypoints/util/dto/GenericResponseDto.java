package eis.entrypoints.util.dto;

import lombok.Builder;
import lombok.Generated;
import org.springframework.http.HttpStatus;

import java.util.UUID;

@Builder
@Generated
public record GenericResponseDto<T>(UUID transactionId, HttpStatus status, String message, T data) {
}
