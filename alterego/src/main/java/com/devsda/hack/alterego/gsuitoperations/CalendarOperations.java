package com.devsda.hack.alterego.gsuitoperations;


import com.devsda.hack.alterego.model.AlteregoConfiguration;
import com.devsda.utils.httputils.HttpMethod;
import com.devsda.utils.httputils.constants.Protocol;
import com.devsda.utils.httputils.methods.HttpGetMethod;
import com.google.api.services.calendar.model.Calendar;
import com.google.api.services.calendar.model.Events;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

//@Singleton
public class CalendarOperations {

    private static final Logger log = LoggerFactory.getLogger(CalendarOperations.class);

    @Inject
    private AlteregoConfiguration alteregoConfiguration;
//
//    public CalendarOperations(AlteregoConfiguration alteregoConfiguration) {
//        this.alteregoConfiguration = alteregoConfiguration;
//    }

    public List<LinkedHashMap> listCalendarEvents() throws Exception {

        String hostname = "https://www.googleapis.com";
        String uri = "/calendar/v3/calendars/{calendarId}/events".replace("{calendarId}", alteregoConfiguration.getCalendarId());

        Map<String, String> parameters = new HashMap<>();
        parameters.put("maxResults", "15");
        parameters.put("key", alteregoConfiguration.getApiKey());

        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "*/*");
        headers.put("accept-encoding", "gzip, deflate, br");
        headers.put("accept-language", "en-GB,en-US;q=0.9,en;q=0.8");
        headers.put("sec-fetch-mode", "cors");
        headers.put("sec-fetch-site", "same-origin");
        headers.put("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.97 Safari/537.36");
        headers.put("x-client-data", "CI62yQEIo7bJAQjBtskBCKmdygEI4qjKAQjLrsoBCM6wygEI6LHKAQj3tMoBGKukygE=");
        headers.put("x-goog-encode-response-if-executable", "base64");
        headers.put("x-javascript-user-agent", "apix/3.0.0 google-api-javascript-client/1.1.0");
        headers.put("x-origin", "https://explorer.apis.google.com");
        headers.put("x-referer", "https://explorer.apis.google.com");
        headers.put("x-requested-with", "XMLHttpRequest");
        headers.put("Authorization", String.format("Bearer %s", alteregoConfiguration.getAuthToken()));

        HttpMethod httpGetMethod = new HttpGetMethod();

        Calendar calendar = httpGetMethod.call(Protocol.HTTPS, "www.googleapis.com", null, "/calendar/v3/calendars/amanr.rastogi@gmail.com/events", parameters, headers, null, Calendar.class);
        List<LinkedHashMap> items = (List<LinkedHashMap>)calendar.get("items");
        return items;
    }
}
