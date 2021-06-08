package Commands;

import FileSystem.FileSystem;
import FileSystem.Link;
import FileSystem.Node;
import CLI.CLI;

import java.util.List;

public class SoftLink extends Command {
    @Override
    public void action(List<String> parameters, CLI cli, FileSystem fileSystem) throws Exception {
        Node currentDirectory = cli.getCurrentWorkingDirectory();
        int targetIndex = currentDirectory.findChildByName(parameters.get(0));

        if (targetIndex < 0) {
            throw new Exception(parameters.get(0) + " does not exist within the current directory");
        }

        Node targetNode = currentDirectory.getChildNodes().get(targetIndex);

        if (targetNode.getEntityPath() == null) {
            throw new Exception(parameters.get(0) + " is not a directory");
        }

        int linkIndex = currentDirectory.findChildByName(parameters.get(1));

        if (linkIndex >= 0) {
            throw new Exception(parameters.get(1) + " exists within the current directory");
        }

        Link newLink = new Link(parameters.get(1), currentDirectory, targetNode.getFullPath());
        currentDirectory.addChild(newLink);
    }

    @Override
    public String toString() {
        return "ln";
    }
}
