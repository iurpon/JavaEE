package ru.trandefil.sc.util;

import ru.trandefil.sc.model.Project;
import ru.trandefil.sc.model.Role;
import ru.trandefil.sc.model.Task;
import ru.trandefil.sc.model.User;

import java.util.UUID;

public class EntityData {

    private EntityData() {
    }

    public static Project PROJECT1 = new Project(UUID.randomUUID().toString(),"project1","description1");

    public static Project PROJECT2 = new Project(UUID.randomUUID().toString(),"project2","description2");

    public static User USER = new User(UUID.randomUUID().toString(),"User","user", Role.USER);

    public static User ROOT = new User(UUID.randomUUID().toString(),"root","root", Role.ADMIN);

    public static Task TASK1 = new Task(UUID.randomUUID().toString(),"task1_project1","description11",
            DateUtil.fromString("2011-03-03"),DateUtil.fromString("2012-03-03"),PROJECT1);

    public static Task TASK2 = new Task(UUID.randomUUID().toString(),"task2_project1","description12",
            DateUtil.fromString("2012-03-03"),DateUtil.fromString("2013-03-03"),PROJECT1);

    public static Task TASK3 = new Task(UUID.randomUUID().toString(),"task1_project2","description21",
            DateUtil.fromString("2013-03-03"),DateUtil.fromString("2014-03-03"),PROJECT2);

    public static Task TASK4 = new Task(UUID.randomUUID().toString(),"task2_project2","description22",
            DateUtil.fromString("2016-03-03"),DateUtil.fromString("2017-03-03"),PROJECT2);

}
