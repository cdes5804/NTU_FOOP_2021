package Commands;

import FileSystem.FileSystem;
import CLI.CLI;
import FileSystem.Directory;
import FileSystem.Node;

import java.util.List;

public class MakeDirectory extends Command {
    @Override
    public void action(List<String> parameters, CLI cli, FileSystem fileSystem) throws Exception {
        Node currentDirectory = cli.getCurrentWorkingDirectory();
        Directory newDirectory = new Directory(parameters.get(0), currentDirectory);
        currentDirectory.addChild(newDirectory);
    }

    @Override
    public String toString() {
        return "mkdir";
    }
}
