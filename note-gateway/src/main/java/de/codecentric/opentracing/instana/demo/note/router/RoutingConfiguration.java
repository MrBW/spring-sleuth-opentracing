package de.codecentric.opentracing.instana.demo.note.router;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.Routes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;

import static org.springframework.cloud.gateway.handler.predicate.RoutePredicates.method;
import static org.springframework.cloud.gateway.handler.predicate.RoutePredicates.path;

/**
 * @author Benjamin Wilms
 */
//@Configuration
public class RoutingConfiguration {

    @Bean
    public RouteLocator customRouteLocator() throws URISyntaxException {
        String url = "http://localhost:8080/".trim();
        URI uri = URI.create(url);


        return Routes.locator()
                .route("notes_by_id")
                .predicate(path("/notes/{id}"))
                .uri(uri)
                .route("notes")
                .predicate(path("/notes"))
                .uri(uri)

                .build();

    }

}
