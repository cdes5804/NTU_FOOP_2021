package Commands;

import FileSystem.FileSystem;
import FileSystem.Node;
import CLI.CLI;

import java.util.List;

public class ChangeDirectory extends Command {
    @Override
    public void action(List<String> parameters, CLI cli, FileSystem fileSystem) throws Exception {
        Node currentDirectory = cli.getCurrentWorkingDirectory();
        if (parameters.get(0).equals("..")) {
            cli.setCurrentWorkingDirectory(currentDirectory.getParentNode());
        } else {
            int index = currentDirectory.findChildByName(parameters.get(0));

            if (index < 0) {
                throw new Exception(parameters.get(0) + " does not exist within the current directory");
            }

            Node targetNode = currentDirectory.getChildNodes().get(index);
            if (targetNode.getEntityPath() == null) {
                throw new Exception(parameters.get(0) + " is not a directory");
            }

            Node destinationNode = fileSystem.getNodeByPath(targetNode.getEntityPath());
            if (destinationNode == null) {
                throw new Exception(targetNode.getEntityPath() + " is not found");
            }

            cli.setCurrentWorkingDirectory(destinationNode);
        }
    }

    @Override
    public String toString() {
        return "cd";
    }
}
