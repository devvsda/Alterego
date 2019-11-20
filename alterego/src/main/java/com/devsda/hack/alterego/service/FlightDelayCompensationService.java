package com.devsda.hack.alterego.service;

import com.devsda.hack.alterego.gsuitoperations.CalendarOperations;
import com.devsda.hack.alterego.model.BookingInfo;
import com.devsda.hack.alterego.utils.FlightUtils;
import com.devsda.hack.alterego.utils.MailUtils;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

// @Singleton
public class FlightDelayCompensationService {

    @Inject
    private CalendarOperations calOps;

//    public FlightDelayCompensationService(CalendarOperations calOps) {
//        this.calOps = calOps;
//    }

    public void handleFlightDelayCompensation() throws Exception {
        Events events = calOps.listCalendarEvents();
        List<Event> items = events.getItems();
        if (items != null) {
            for (Event e : items) {
                if (FlightUtils.isFlightEvent(e.getSummary()) && FlightUtils.isFlightDelayed(e.getSummary())) {
                    BookingInfo bookingInfo = FlightUtils.getBookingInfo(e);
                    //To Do: mail sending part should be async
                    MailUtils.sendMail(bookingInfo);
                }
            }
        }
    }
}
