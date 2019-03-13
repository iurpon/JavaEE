package ru.trandefil.sc.command.json;

import ru.trandefil.sc.command.AbstractCommand;

import java.io.File;

public class DataJsonClearCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-json-clear";
    }

    @Override
    public String description() {
        return "return json data";
    }

    @Override
    public void execute() {
        File file = new File("data.json");
        file.delete();
    }

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public boolean isAdmin() {
        return true;
    }
}
