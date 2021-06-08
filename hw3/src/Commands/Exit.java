package Commands;

import FileSystem.FileSystem;
import CLI.CLI;

import java.util.List;

public class Exit extends Command {
    @Override
    public void action(List<String> parameters, CLI cli, FileSystem fileSystem) {
        cli.endSession();
    }

    @Override
    public String toString() {
        return "exit";
    }
}
