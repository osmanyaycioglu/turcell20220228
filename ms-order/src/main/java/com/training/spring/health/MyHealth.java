package com.training.spring.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.training.spring.NotifyMessage;

@Component
public class MyHealth implements HealthIndicator {

    @Override
    public Health health() {
        NotifyMessage messageLoc = new NotifyMessage();
        messageLoc.setMessage("oldu bitti");
        messageLoc.setDestination("346535343");
        return Health.down()
                     .withDetail("error",
                                 messageLoc)
                     .build();
    }

}
