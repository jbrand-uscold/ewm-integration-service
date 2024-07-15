package eis.entrypoints.messages;

import eis.config.aspect.messaging.MessagingLog;
import eis.core.usecases.ports.input.IAppointmentVendorUseCase;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final IAppointmentVendorUseCase iAppointmentVendorUseCase;

    @MessagingLog
    @KafkaListener(topics = "appointment-ewm-topic", groupId = "appointment-ewm")
    public <K, V> void kafkaConsumer(ConsumerRecord<K, V> consumerRecord) {
        var message = consumerRecord.value();
        iAppointmentVendorUseCase.notifyAppointment(message);
    }
}
