package org.example.resources;

//package com.todo.resource;

import org.example.dao.TaskDAO;
import org.example.api.Task;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {
    private final TaskDAO taskDAO;

    public TaskResource(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @GET
    public List<Task> getAllTasks() {
        return taskDAO.getAllTasks();
    }

    @GET
    @Path("/{id}")
    public Response getTask(@PathParam("id") int id) {
        Optional<Task> task = taskDAO.getTask(id);
        return task.map(value -> Response.ok(value).build()).orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    public Response createTask(Task task) {
        taskDAO.createTask(task);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateTask(@PathParam("id") int id, Task task) {
        task.setId(id);
        taskDAO.updateTask(task);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTask(@PathParam("id") int id) {
        taskDAO.deleteTask(id);
        return Response.noContent().build();
    }
}
//@Path("/tasks")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//public class TaskResource {
//    private final TaskDAO taskDAO;
//
//    public TaskResource(TaskDAO taskDAO) {
//        this.taskDAO = taskDAO;
//    }
//
//    @GET
//    public List<Task> getAllTasks() {
//        return taskDAO.getAllTasks();
//    }
//
//    @GET
//    @Path("/{id}")
//    public Response getTask(@PathParam("id") int id) {
//        Optional<Task> task = taskDAO.getTask(id);
//        return task.map(value -> Response.ok(value).build()).orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
//    }
//
//    @POST
//    public Response createTask(Task task) {
//        taskDAO.createTask(task);
//        return Response.status(Response.Status.CREATED).build();
//    }
//
//    @PUT
//    @Path("/{id}")
//    public Response updateTask(@PathParam("id") int id, Task task) {
//        task.setId(id);
//        taskDAO.updateTask(task);
//        return Response.ok().build();
//    }
//
//    @DELETE
//    @Path("/{id}")
//    public Response deleteTask(@PathParam("id") int id) {
//        taskDAO.deleteTask(id);
//        return Response.noContent().build();
//    }
//}
