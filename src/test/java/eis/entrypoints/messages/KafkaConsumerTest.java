package eis.entrypoints.messages;

import eis.core.models.Appointment;
import eis.core.usecases.ports.input.IAppointmentVendorUseCase;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class KafkaConsumerTest {

    @InjectMocks
    private KafkaConsumer consumer;

    @Mock
    private IAppointmentVendorUseCase iAppointmentVendorUseCase;

    @Test
    void shouldConsumeAppointment_when_readTopic() {
        ConsumerRecord<String, Appointment> consumerRecord = new ConsumerRecord<>(
                "topic", 1, 1L, "message", new Appointment("ewm-1", "wh-1"));
        doNothing().when(iAppointmentVendorUseCase).notifyAppointment(any());
        consumer.kafkaConsumer(consumerRecord);
        verify(iAppointmentVendorUseCase, atLeastOnce()).notifyAppointment(any());
    }
}