package com.devsda.hack.alterego.utils;

import com.devsda.hack.alterego.model.BookingInfo;
import com.devsda.hack.alterego.model.CarrierInfo;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.common.base.Strings;

import java.util.List;

public class FlightUtils {

    public static boolean isFlightEvent(String eventSummary) {
        if(!Strings.isNullOrEmpty(eventSummary)) {
            return eventSummary.startsWith("Flight to");
        }
        return Boolean.FALSE;
    }

    public static CarrierInfo getCarrierInfo(String eventSummary) {
        if(!Strings.isNullOrEmpty(eventSummary)) {
            String[] carrierInfoStrs = eventSummary.substring(eventSummary.lastIndexOf('(') + 1, eventSummary.length() - 1).split(" ");
            if(carrierInfoStrs.length == 2) {
                return new CarrierInfo(carrierInfoStrs[0], carrierInfoStrs[1]);
            }
        }
        return null;
    }

    public static boolean isFlightDelayed(String eventSummary) {
        CarrierInfo carrierInfo = getCarrierInfo(eventSummary);
        return true;
    }

    public static BookingInfo getBookingInfo(Event event) {
        List<EventAttendee> attendees = event.getAttendees();
        String email = attendees.get(0).getEmail();
        BookingInfo bookingInfo = new BookingInfo();
        bookingInfo.setEmailId(email);
        return bookingInfo;
    }
}
