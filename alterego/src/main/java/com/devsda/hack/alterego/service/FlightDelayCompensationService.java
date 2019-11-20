package com.devsda.hack.alterego.service;

import com.devsda.hack.alterego.gsuitoperations.CalendarOperations;
import com.devsda.hack.alterego.model.BookingInfo;
import com.devsda.hack.alterego.utils.FlightUtils;
import com.devsda.hack.alterego.utils.MailUtils;
import com.google.inject.Inject;

import java.util.LinkedHashMap;
import java.util.List;

// @Singleton
public class FlightDelayCompensationService {

    @Inject
    private CalendarOperations calOps;

//    public FlightDelayCompensationService(CalendarOperations calOps) {
//        this.calOps = calOps;
//    }

    public void handleFlightDelayCompensation() throws Exception {
        List<LinkedHashMap> eventItems = calOps.listCalendarEvents();
        if (eventItems != null) {
            for (LinkedHashMap<String, String> e : eventItems) {
                String summary = e.get("summary");
                if (FlightUtils.isFlightEvent(summary) && FlightUtils.isFlightDelayed(summary)) {
                    BookingInfo bookingInfo = FlightUtils.getBookingInfo(e);
                    //To Do: mail sending part should be async
                    MailUtils.sendMail(bookingInfo);
                }
            }
        }
    }
}
