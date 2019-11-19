package com.devsda.hack.alterego.ressource;


import com.devsda.hack.alterego.constant.AlteregoConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

@Path(AlteregoConstants.Resources.HealthCheck)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HealthCheckResources {


    private static final Logger log = LoggerFactory.getLogger(HealthCheckResources.class);

    @Path("/{echoText}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response healthCheck(@PathParam("echoText") String echoText) throws Exception {

        Map<String, String> response = new HashMap<>();

        response.put("echoString", echoText);
        response.put("hostName", InetAddress.getLocalHost().getHostName());

        ObjectMapper objectMapper = new ObjectMapper();
        String stringifyResponse = objectMapper.writeValueAsString(response);

        return Response.ok(stringifyResponse).build();
    }

}
