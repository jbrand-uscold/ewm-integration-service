package eis.adapters.broker;

import eis.core.models.Appointment;
import eis.core.usecases.ports.output.IPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PublisherImpl implements IPublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public Appointment publish(Appointment appointment) {
        try {
            kafkaTemplate.send("appointment-ewm-topic", appointment.toString());
            return appointment;

        } catch (Exception exception) {
            log.error("Error while send:{}", appointment, exception);
            throw new RuntimeException();
        }
    }
}
