package eis.entrypoints.util;

import eis.entrypoints.util.dto.GenericResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BuildResponse {

    public static <T> GenericResponseDto<Object> buildResponse_Http_200(T response) {
        return GenericResponseDto.builder()
                .transactionId(UUID.randomUUID())
                .status(HttpStatus.OK)
                .message("Appointment successfully processed")
                .data(response)
                .build();
    }
}
