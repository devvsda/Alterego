package com.devsda.hack.alterego.service;

import com.devsda.hack.alterego.ApplicationContextUtil;
import com.devsda.hack.alterego.gsuitoperations.CalendarOperations;
import com.devsda.hack.alterego.gsuitoperations.CalendarOperationsTest;
import com.google.inject.Injector;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlightDelayCompensationServiceTest {

    private static final Logger log = LoggerFactory.getLogger(FlightDelayCompensationServiceTest.class);
    private static FlightDelayCompensationService flightDelayCompensationService;

    @BeforeClass
    public static void setup() throws Exception {

        Injector injector = ApplicationContextUtil.createApplicationInjector();
        flightDelayCompensationService = injector.getInstance(FlightDelayCompensationService.class);


    }

    @AfterClass
    public static void cleanup() {

    }

    @Test
    public void objectCheckTest() {
        System.out.println(flightDelayCompensationService);
    }

    @Test
    public void handleFlightDelayCompensationTest() throws Exception {
        flightDelayCompensationService.handleFlightDelayCompensation();
    }


}
