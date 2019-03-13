package ru.trandefil.sc.generated;

import ru.trandefil.sc.dto.TaskDTO;
import ru.trandefil.sc.model.Session;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Date;
import java.util.List;

@WebService
public interface TaskEndPoint {

    @WebMethod
    List<TaskDTO> getAllTasks(@WebParam(name = "session") Session session);

    @WebMethod
    TaskDTO saveTask(
            @WebParam(name = "id") String id,
            @WebParam(name = "name") String name,
            @WebParam(name = "desc") String desc,
            @WebParam(name = "start") Date start,
            @WebParam(name = "end") Date end,
            @WebParam(name = "projectId") String projectId,
            @WebParam(name = "executorId") String executorId,
            @WebParam(name = "session") Session session);

    @WebMethod
    TaskDTO updateTask(@WebParam(name = "task") TaskDTO task, @WebParam(name = "session") Session session);

    @WebMethod
    boolean deleteTaskByName(@WebParam(name = "name") String name, @WebParam(name = "session") Session session);

    @WebMethod
    TaskDTO getTaskByName(@WebParam(name = "name") String name, @WebParam(name = "session") Session session);

}
