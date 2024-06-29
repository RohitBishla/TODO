package org.example.dao;

//package com.todo.dao;

import org.example.api.Task;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

import java.util.List;
import java.util.Optional;

public class TaskDAO {
    private final Jdbi jdbi;

    public TaskDAO(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<Task> getAllTasks() {
        try (Handle handle = jdbi.open()) {
            return handle.createQuery("SELECT * FROM tasks").mapToBean(Task.class).list();
        }
    }

    public Optional<Task> getTask(int id) {
        try (Handle handle = jdbi.open()) {
            return handle.createQuery("SELECT * FROM tasks WHERE id = :id").bind("id", id).mapToBean(Task.class).findOne();
        }
    }

    public void createTask(Task task) {
        try (Handle handle = jdbi.open()) {
            handle.createUpdate("INSERT INTO tasks (description, status, start_date, target_date) VALUES (:description, :status, :startDate, :targetDate)")
                    .bindBean(task)
                    .execute();
        }
    }

    public void updateTask(Task task) {
        try (Handle handle = jdbi.open()) {
            handle.createUpdate("UPDATE tasks SET description = :description, status = :status, start_date = :startDate, target_date = :targetDate WHERE id = :id")
                    .bindBean(task)
                    .execute();
        }
    }

    public void deleteTask(int id) {
        try (Handle handle = jdbi.open()) {
            handle.createUpdate("DELETE FROM tasks WHERE id = :id").bind("id", id).execute();
        }
    }
}

