package Commands;

import FileSystem.FileSystem;
import FileSystem.Node;
import FileSystem.File;
import CLI.CLI;

import java.util.List;

public class Touch extends Command {
    @Override
    public void action(List<String> parameters, CLI cli, FileSystem fileSystem) throws Exception {
        Node currentDirectory = cli.getCurrentWorkingDirectory();
        File newFile = new File(parameters.get(0), currentDirectory);
        newFile.storeData(parameters.get(1));
        currentDirectory.addChild(newFile);
    }

    @Override
    public String toString() {
        return "touch";
    }
}
