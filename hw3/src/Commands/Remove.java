package Commands;

import FileSystem.FileSystem;
import FileSystem.Node;
import CLI.CLI;

import java.util.List;

public class Remove extends Command {
    @Override
    public void action(List<String> parameters, CLI cli, FileSystem fileSystem) throws Exception {
        Node currentDirectory = cli.getCurrentWorkingDirectory();
        int index = currentDirectory.findChildByName(parameters.get(0));

        if (index < 0) {
            throw new Exception(parameters.get(0) + " does not exist within the current directory");
        }

        currentDirectory.getChildNodes().remove(index);
    }

    @Override
    public String toString() {
        return "rm";
    }
}
