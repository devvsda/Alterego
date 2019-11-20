package com.devsda.hack.alterego.application;

import com.devsda.hack.alterego.constant.AlteregoConstants;
import com.devsda.hack.alterego.model.AlteregoConfiguration;
import com.devsda.hack.alterego.ressource.FlightDelayCompensationResources;
import com.devsda.hack.alterego.ressource.HealthCheckResources;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class AlteregoApplication extends Application<AlteregoConfiguration> {

    private static final Logger log = LoggerFactory.getLogger(AlteregoApplication.class);

    public static void main(String[] args) throws Exception {
        new AlteregoApplication().run(args);
    }

    @Override
    public void run(AlteregoConfiguration alteregoConfiguration, Environment environment) throws Exception {

        Injector injector = createInjector(alteregoConfiguration, environment);

        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter(AlteregoConstants.ServletFilter.CORS, CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter(AlteregoConstants.ServletFilter.ALLOWED_ORIGINS, AlteregoConstants.ServletFilter.ALLOWED_ORIGIN_NAMES);
        cors.setInitParameter(AlteregoConstants.ServletFilter.ALLOWED_HEADERS, AlteregoConstants.ServletFilter.ALLOWED_HEADER_NAMES);
        cors.setInitParameter(AlteregoConstants.ServletFilter.ALLOWED_METHODS, AlteregoConstants.ServletFilter.ALLOWED_METHOD_NAMES);

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        environment.jersey().register(HealthCheckResources.class);
//        FlightDelayCompensationService fdcService = injector.getInstance(FlightDelayCompensationService.class);
//        fdcService.handleFlightDelayCompensation();
        environment.jersey().register(injector.getInstance(FlightDelayCompensationResources.class));
    }

    /**
     * This method creates a injector
     *
     * @param alteregoConfiguration
     * @param environment
     * @return
     */
    public Injector createInjector(AlteregoConfiguration alteregoConfiguration, Environment environment) {

        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {

                try {

//                    bind(AlteregoConfiguration.class).toInstance(alteregoConfiguration);

                    // Other objects
                    bind(AlteregoConfiguration.class).toInstance(alteregoConfiguration);
//                    CalendarOperations calops = new CalendarOperations(alteregoConfiguration);
//                    bind(CalendarOperations.class).toInstance(calops);
//                    FlightDelayCompensationService fdcService = new FlightDelayCompensationService(calops);
//                    bind(FlightDelayCompensationService.class).toInstance(fdcService);
                } catch (Exception  e) {
                    log.error("Failed to create DI tree", e);
                }


            }
        });

        return injector;
    }
}
