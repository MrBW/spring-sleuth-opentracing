package de.codecentric.opentracing.demo.notes;

import de.codecentric.opentracing.demo.notes.persistence.NoteRepo;
import de.codecentric.opentracing.demo.notes.persistence.NoteEntity;

import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class NoteApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(NoteApplication.class);

    @Autowired
    private NoteRepo noteRepo;

    @Bean
    public Sampler sampler() {
        return new AlwaysSampler();
    }

    public static void main(String[] args) {
        SpringApplication.run(NoteApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Stream.of(
                new NoteEntity("Note 1"),
                new NoteEntity("Note 2"),
                new NoteEntity("Note 3")
            )
            .forEach(noteRepo::save);

        log.info("Number of added notes: " + noteRepo.count());

    }
}
