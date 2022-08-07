package com.example.resources;

import com.example.entities.Student;
import com.example.services.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/students")
public class StudentResource {

    @Inject
    StudentService studentService;

    @GET
    public Response getAllStudents(){
        return Response.ok(studentService.getAllStudent()).build();
    }

    @POST
    @Path("/add")
    public Response addStudent(Student student){
        studentService.addStudent(student);
        return Response.ok().build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteStudentById(@PathParam("id") Long id){
        studentService.deleteStudent(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/update")
    public Response updateStudentById(Student student){
        studentService.updateStudent(student);
        return Response.ok().build();
    }
}
