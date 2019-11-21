package com.devsda.hack.alterego.ressource;

import com.devsda.hack.alterego.constant.AlteregoConstants;
import com.devsda.hack.alterego.service.FlightDelayCompensationService;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(AlteregoConstants.Resources.FlightDelayCompenationAgent)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FlightDelayCompensationResources {

    private static final Logger log = LoggerFactory.getLogger(FlightDelayCompensationResources.class);

    @Inject
    private FlightDelayCompensationService flightDelayCompensationService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response handleFlightDelayCompensation() {
        try {
            flightDelayCompensationService.handleFlightDelayCompensation();
        }catch(Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.ok().build();
    }
}
