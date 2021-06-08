package Commands;

import FileSystem.FileSystem;
import CLI.CLI;

import java.util.List;

public abstract class Command {
    public abstract void action(List<String> parameters, CLI cli, FileSystem fileSystem) throws Exception;
}
