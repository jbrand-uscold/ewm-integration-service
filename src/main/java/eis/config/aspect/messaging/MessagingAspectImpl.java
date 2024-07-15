package eis.config.aspect.messaging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MessagingAspectImpl {

    @Before("@annotation(eis.config.aspect.messaging.MessagingLog)")
    public void logBefore(final JoinPoint joinPoint) {
        log.info("Executing before @MessagingLog method: {}", joinPoint.getSignature().getName());
        log.info("Executing before @MessagingLog Args: {}", joinPoint.getArgs());
    }
}
