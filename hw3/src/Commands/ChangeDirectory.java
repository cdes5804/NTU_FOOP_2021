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

            Node linkNode = currentDirectory.getChildNodes().get(index);
            if (linkNode.getEntityPath() == null) {
                throw new Exception(parameters.get(0) + " is not a directory");
            }

            Node targetNode = fileSystem.getNodeByPath(linkNode.getEntityPath());
            if (targetNode == null) {
                throw new Exception(linkNode.getEntityPath() + " is not found");
            }

            cli.setCurrentWorkingDirectory(targetNode);
        }
    }

    @Override
    public String toString() {
        return "cd";
    }
}
