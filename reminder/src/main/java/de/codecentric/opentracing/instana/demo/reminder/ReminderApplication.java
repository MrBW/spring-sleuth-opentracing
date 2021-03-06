package de.codecentric.opentracing.instana.demo.reminder;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class ReminderApplication {

    private static final Logger log = LoggerFactory.getLogger(ReminderApplication.class);

    @Bean
    public Sampler sampler() {
        return new AlwaysSampler();
    }


    public static void main(String[] args) {
        SpringApplication.run(ReminderApplication.class, args);
    }


}
