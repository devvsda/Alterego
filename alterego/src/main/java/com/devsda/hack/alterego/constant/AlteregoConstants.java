package com.devsda.hack.alterego.constant;

public class AlteregoConstants {

    public static final class ServletFilter {

        public static final String CORS = "CORS";
        public static final String ALLOWED_ORIGINS = "allowedOrigins";
        public static final String ALLOWED_HEADERS = "allowedHeaders";
        public static final String ALLOWED_METHODS = "allowedMethods";

        public static final String ALLOWED_ORIGIN_NAMES = "*";
        public static final String ALLOWED_HEADER_NAMES = "X-Requested-With,Content-Type,Accept,Origin";
        public static final String ALLOWED_METHOD_NAMES = "OPTIONS,GET,PUT,POST,DELETE,HEAD";
    }

    public static final class Resources {
        public static final String HealthCheck = "/healthCheck";
        public static final String FlightDelayCompenationAgent = "/flightDelayCompensationAgent";

        public static final String REGISTRATION = "/register";
        public static final String RETRIEVE = "/retrieve";
        public static final String EXECUTE = "/execute";
        public static final String MANAGE = "/manage";
        public static final String UPDATE = "/update";
        public static final String EXECUTION = "/execution";

        public static final String CLIENTS = "/clients";
        public static final String CLIENT = "/client";
        public static final String ENDPOINT = "/endpoint";
        public static final String GRAPH_DETAILS = "/graphXML";
        public static final String EXECUTION_STATE = "/executionState";
        public static final String GET_ALL_EXECUTIONS = "/getAllExecutions";
        public static final String ENDPOINTS = "/endpoints";
        public static final String KILL = "/kill";
        public static final String RESUME = "/resume";
        public static final String RESTART = "/restart";

        public static final String WORKFLOW_DETAILS = "/workflowDetails";
        public static final String ENDPOINT_DETAILS = "/endpointDetails";

        public static final String EXECUTION_DETAILS = "/executionDetails";

    }

    public static final class MailConstants {
        public static final String SUBJECT = "Regarding flight delay";
        public static final String BODY = "Dear Sir/Madam,\n" +
                "\n" +
                "I am writing to you regarding flight I5 1728. My booking reference for this flight was BYQI92.\n" +
                "\n" +
                "This flight was scheduled to depart from BLR on 15/11/2019 at 16:00 IST. However, the flight was delayed and did not arrive at BLR until 20:30 IST meaning it was 4 hours and 30 minutes late.\n" +
                "\n" +
                "The passenger(s) in my party was Hitesh Jhamb.\n" +
                "\n" +
                "I am seeking compensation of 3000 Rupees per passenger, due to the fact that the scheduled length of my flight was 1556km. This compensation is per delayed passenger in my party, resulting in a total of 3000 Rupees.\n" +
                "\n" +
                "I look forward to hearing from you and would welcome a response within 7 days.\n" +
                "\n" +
                "Yours faithfully,\n" +
                "Hitesh Jhamb";
    }

}
