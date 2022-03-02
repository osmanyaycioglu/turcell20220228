package a.b.c;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AbcFeatureConfig {

    @Bean
    public Greet greetBean() {
        return new Greet();
    }

}
