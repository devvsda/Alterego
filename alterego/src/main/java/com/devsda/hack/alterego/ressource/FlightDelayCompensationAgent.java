package com.devsda.hack.alterego.ressource;

import com.devsda.hack.alterego.constant.AlteregoConstants;
import com.devsda.hack.alterego.service.FlightDelayCompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(AlteregoConstants.Resources.FlightDelayCompenationAgent)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FlightDelayCompensationAgent {

    private static final Logger log = LoggerFactory.getLogger(FlightDelayCompensationAgent.class);

    @Inject
    private FlightDelayCompensationService fdcService;

    @POST
    public Response handleFlightDelayCompensation() {
        try {
            fdcService.handleFlightDelayCompensation();
        }catch(Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.ok("Success").build();
    }
}
