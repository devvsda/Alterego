package com.devsda.hack.alterego.gsuitoperations;

import com.devsda.hack.alterego.ApplicationContextUtil;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.calendar.model.Calendar;
import com.google.api.services.gmail.Gmail;
import com.google.inject.Injector;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalendarOperationsTest {

    private static final Logger log = LoggerFactory.getLogger(CalendarOperationsTest.class);
    private static CalendarOperations calendarOperations;

    @BeforeClass
    public static void setup() throws Exception {

        Injector injector = ApplicationContextUtil.createApplicationInjector();
        calendarOperations = injector.getInstance(CalendarOperations.class);

    }

    @AfterClass
    public static void cleanup() {

    }

    @Test
    public void getMessagesTest() throws Exception {


        Calendar calendar = calendarOperations.listCalendarEvents();
        log.info(String.format("Calendar ressponse : %s", calendar) );
        System.out.println(calendar);
    }
}
