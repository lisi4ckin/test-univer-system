package com.example.resources;

import com.example.entities.Groups;
import com.example.services.GroupService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/groups")
public class GroupResources {

    @Inject
    GroupService groupService;

    @Path("/add")
    @POST
    public Response addGroup(Groups group){
        groupService.addGroup(group);
        return Response.ok().build();
    }

    @GET
    public Response getAllGroups(){
        return Response.ok(groupService.getAllGroups()).build();
    }
}
