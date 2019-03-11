package ru.trandefil.sc.dto;

import ru.trandefil.sc.model.Task;

import java.util.Date;

public class TaskDTO {

    private String id;

    private String name;

    private String description;

    private Date begin;

    private Date end;

    private String projectId;

    private String assigneeId;

    private String executorId;

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.name = task.getName();
        this.description = task.getDescription();
        this.begin = task.getStart();
        this.end = task.getEnd();
        this.projectId = task.getProject().getId();
        this.assigneeId = task.getAssignee().getId();
        this.executorId = task.getExecutor().getId();
    }

    public TaskDTO() {
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
    }

    public String getExecutorId() {
        return executorId;
    }

    public void setExecutorId(String executorId) {
        this.executorId = executorId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

}
