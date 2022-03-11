package com.training.spring.resillience;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.Retry.EventPublisher;
import io.github.resilience4j.retry.Retry.Metrics;
import io.github.resilience4j.retry.RetryRegistry;

@Component
public class RetryTestCL implements CommandLineRunner {

    @Autowired
    private Caller                 caller;

    @Autowired
    private RetryRegistry          rere;

    @Autowired
    private CircuitBreakerRegistry cbr;


    @Override
    public void run(final String... argsParam) throws Exception {
        CircuitBreaker circuitBreakerLoc = this.cbr.circuitBreaker("mycb");
        io.github.resilience4j.circuitbreaker.CircuitBreaker.Metrics metrics2Loc = circuitBreakerLoc.getMetrics();
        io.github.resilience4j.circuitbreaker.CircuitBreaker.EventPublisher eventPublisher2Loc = circuitBreakerLoc.getEventPublisher();
        eventPublisher2Loc.onStateTransition(s -> System.out.println("State changed : " + s.getStateTransition()));
        for (int iLoc = 0; iLoc < 200; iLoc++) {
            String startTestLoc = null;
            try {
                startTestLoc = this.caller.startTest("test " + iLoc);
            } catch (Exception eLoc) {
                System.out.println("Error : " + eLoc.getMessage());
                try {
                    Thread.sleep(2000);
                } catch (Exception e2Loc) {
                }
            } finally {
                System.out.println(iLoc
                                   + " state : "
                                   + circuitBreakerLoc.getState()
                                   + " Result : "
                                   + startTestLoc
                                   + " failedCalls : "
                                   + metrics2Loc.getNumberOfFailedCalls()
                                   + " SuccessfulCalls : "
                                   + metrics2Loc.getNumberOfSuccessfulCalls()
                                   + " NotPermittedCalls : "
                                   + metrics2Loc.getNumberOfNotPermittedCalls());
            }

        }

    }

    public void run2(final String... argsParam) throws Exception {
        Optional<Retry> findLoc = this.rere.find("xyzretry");
        Retry retryLoc = findLoc.get();
        Metrics metricsLoc = retryLoc.getMetrics();
        EventPublisher eventPublisherLoc = retryLoc.getEventPublisher();
        eventPublisherLoc.onRetry(r -> System.out.println("OnRetry : " + r.getNumberOfRetryAttempts()));
        eventPublisherLoc.onSuccess(r -> System.out.println("OnSuccess : " + r.getNumberOfRetryAttempts()));
        System.out.println();
        for (int iLoc = 0; iLoc < 20; iLoc++) {
            try {
                System.out.println("Result : "
                                   + this.caller.startTest("test " + iLoc)
                                   + " sr : "
                                   + metricsLoc.getNumberOfSuccessfulCallsWithRetryAttempt());
            } catch (Exception eLoc) {
                System.out.println("Error : " + eLoc.getMessage());
            }

        }

    }

}
