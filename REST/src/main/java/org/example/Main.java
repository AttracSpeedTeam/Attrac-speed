package org.example;

import jakarta.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;


public class Main {
    public static final URI BASE_URI = getBaseURI();

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/api/").port(9992).build();
    }

    public static void main(String[] args) throws IOException {
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.registerClasses(AttracspeedData.class);
        resourceConfig.property(LoggingFeature.LOGGING_FEATURE_LOGGER_LEVEL_SERVER, Level.WARNING.getName());


        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, resourceConfig);
        server.start();

        System.out.println(String.format(
                "Jersey serveur est maintenant disponible à " + "%sapplication.wadl\n ", BASE_URI));

        System.in.read();
        server.shutdownNow();
    }
}