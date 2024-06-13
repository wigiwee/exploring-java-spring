package com.RestDemo;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

@Path("/students")
public class StudentResource {

    private StudentRepository studentRepo = new StudentRepository();

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) //takes list of return types and returns based on request
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArrayList<Student> getAllStudent(){
        ArrayList<Student> students =studentRepo.getAll();
        return students;
    }

    //post is used to createStudent a new resource
    @POST
    @Path("/student")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) //takes list of return types and returns based on request
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Student createStudent(Student s){
        studentRepo.create(s);
        return s;
    }

    @GET
    @Path("/student/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) //takes list of return types and returns based on request
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Student getStudent(@PathParam("id") int id){
        return studentRepo.get(id);
    }

    @DELETE
    @Path("/student/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) //takes list of return types and returns based on request
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Student deleteStudent(@PathParam("id" ) int id){
        Student s = studentRepo.get(id);
        studentRepo.delete(id);
        return s;
    }

    //put is used to update value
    @PUT
    @Path("/student")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) //takes list of return types and returns based on request
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void updateStudent(Student s){
        //if student not present in db then create new one

        if(studentRepo.get(s.getId()).getId() == 0){
            studentRepo.create(s);
        }else {
            studentRepo.update(s);
        }
    }
}