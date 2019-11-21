package com.devsda.hack.alterego.utils;

import com.devsda.hack.alterego.model.BookingInfo;
import com.devsda.hack.alterego.model.CarrierInfo;
import com.devsda.utils.httputils.constants.Protocol;
import com.devsda.utils.httputils.methods.HttpGetMethod;
import com.google.api.client.json.GenericJson;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.common.base.Strings;

import java.util.*;

public class FlightUtils {

    private static final String flightStatusHost = "api.flightstats.com";
    private static final String flightStatusApiPath = "/flex/flightstatus/rest/v2/json/flight/status" +
            "/#carrierName/#carrierId/dep/#year/#month/#date";

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

    public static boolean isFlightDelayed(String eventSummary, String date) throws Exception {

        return true;
        //uncomment the below code to make real flight status check
        /*CarrierInfo carrierInfo = getCarrierInfo(eventSummary);
        String[] dateParts = date.split("-");
        String path = flightStatusApiPath
                .replaceFirst("#carrierName", carrierInfo.getCarrierName())
                .replaceFirst("#carrierId", carrierInfo.getCarrierId())
                .replaceFirst("#year", dateParts[0])
                .replaceFirst("#month", dateParts[1])
                .replaceFirst("#date", dateParts[2]);
        HttpGetMethod flightStatusGetMethod = new HttpGetMethod();
        Map<String, String> header = new HashMap<String, String>();
        header.put("appId", "8eced9ab");
        header.put("appKey", "b1275923257d00c205dd786ebef20e77");
        Map<String, String> param = new HashMap<String, String>();
        header.put("utc", "false");
        GenericJson status = flightStatusGetMethod.call(Protocol.HTTPS, flightStatusHost, null, path, param, header, null, GenericJson.class);
        List<Map> flightStatuses = (List<Map>) status.get("flightStatuses");
        Map delays = (Map) flightStatuses.get(0).get("delays");
        // if delays map is empty, there was no delay
        return !delays.isEmpty();*/
    }

    public static BookingInfo getBookingInfo(LinkedHashMap event) {
        List<LinkedHashMap<String, String>> attendees = (List<LinkedHashMap<String, String>>) event.get("attendees");
        String email = ((LinkedHashMap)attendees.get(0)).get("email").toString();
        BookingInfo bookingInfo = new BookingInfo();
        bookingInfo.setEmailId(email);
        return bookingInfo;
    }

    public static void main (String[] x) throws  Exception{
        String date = "2019-11-20";
        boolean status = isFlightDelayed("Flight to New Delhi (AI 127)", date);
        System.out.println(status);

    }
}
