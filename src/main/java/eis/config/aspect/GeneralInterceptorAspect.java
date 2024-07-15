package eis.config.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class GeneralInterceptorAspect {

    @Before("@annotation(eis.config.aspect.Debugger)")
    public void logBefore(final JoinPoint joinPoint) {
        log.info("Executing before @Debugger method: {}", joinPoint.getSignature().getName());
        log.info("Executing before @Debugger Args: {}", joinPoint.getArgs());
    }

    @After("@annotation(eis.config.aspect.Debugger)")
    public void logAfter(final JoinPoint joinPoint) {
        log.info("Executing after @Debugger method: {}", joinPoint.getSignature().getName());
        log.info("Executing after @Debugger response: {}", joinPoint.getArgs());
    }
}
