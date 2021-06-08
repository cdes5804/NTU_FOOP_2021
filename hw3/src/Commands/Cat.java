package Commands;

import FileSystem.FileSystem;
import FileSystem.Node;
import CLI.CLI;

import java.util.List;

public class Cat extends Command {
    @Override
    public void action(List<String> parameters, CLI cli, FileSystem fileSystem) throws Exception {
        Node currentDirectory = cli.getCurrentWorkingDirectory();
        int index = currentDirectory.findChildByName(parameters.get(0));

        if (index < 0) {
            throw new Exception(parameters.get(0) + " does not exist within the current directory");
        }

        Node fileNode = currentDirectory.getChildNodes().get(index);
        try {
            System.out.println(fileNode.getData());
        } catch (Exception err) {
            throw new Exception(parameters.get(0) + " is a directory");
        }
    }

    @Override
    public String toString() {
        return "cat";
    }
}
