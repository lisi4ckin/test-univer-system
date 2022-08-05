package com.example.resources;

import com.example.entities.Profile;
import com.example.services.ProfileService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ResourceBundle;

@Path("/profile")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

    @Inject
    ProfileService profileService;

    @DELETE
    @Path("/{id}")
    public Response deleteProfile(@PathParam("id") Long id){
        profileService.deleteProfile(Profile.findById(id));
        return Response.ok().build();
    }
}
