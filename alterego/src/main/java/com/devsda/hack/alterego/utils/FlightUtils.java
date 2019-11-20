package com.devsda.hack.alterego.utils;

import com.devsda.hack.alterego.model.BookingInfo;
import com.devsda.hack.alterego.model.CarrierInfo;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.common.base.Strings;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

public class FlightUtils {

    private static boolean[] flightDelayFake = {true, true, true, false};
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

    //probability of returning true is 75%
    public static boolean isFlightDelayed(String eventSummary) {
        Random rand = new Random();
        int idx = rand.nextInt(4);
        return flightDelayFake[idx];
        //to do : if flight stats or some other service works, we can see if below information is required
        //CarrierInfo carrierInfo = getCarrierInfo(eventSummary);
        //return true;
    }

    public static BookingInfo getBookingInfo(LinkedHashMap event) {
        List<LinkedHashMap<String, String>> attendees = (List<LinkedHashMap<String, String>>) event.get("attendees");
        String email = ((LinkedHashMap)attendees.get(0)).get("email").toString();
        BookingInfo bookingInfo = new BookingInfo();
        bookingInfo.setEmailId(email);
        return bookingInfo;
    }
}
