package com.devsda.hack.alterego.service;

import com.devsda.hack.alterego.gsuitoperations.CalendarOperations;
import com.devsda.hack.alterego.model.BookingInfo;
import com.devsda.hack.alterego.utils.FlightUtils;
import com.devsda.hack.alterego.utils.MailUtils;
import com.google.inject.Inject;

import java.util.HashMap;
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
        System.out.println("event size [" + eventItems == null? 0 : eventItems.size() + "]");
        if (eventItems != null) {
            for (LinkedHashMap e : eventItems) {
                String summary = e.get("summary").toString();
                if(FlightUtils.isFlightEvent(summary)) {
                    String dateTime = ((HashMap)e.get("start")).get("dateTime").toString();
                    String departDate = dateTime.split("T")[0];
                    if (FlightUtils.isFlightDelayed(summary, departDate)) {
                        BookingInfo bookingInfo = FlightUtils.getBookingInfo(e);
                        //To Do: mail sending part should be async
                        MailUtils.sendMail(bookingInfo);
                    }
                }
            }
        }
    }
}
