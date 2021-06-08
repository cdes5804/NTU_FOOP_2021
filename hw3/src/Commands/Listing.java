package Commands;

import FileSystem.Node;
import FileSystem.FileSystem;
import CLI.CLI;

import java.util.List;

public class Listing extends Command {
    @Override
    public void action(List<String> parameters, CLI cli, FileSystem fileSystem) {
        Node currentDirectory = cli.getCurrentWorkingDirectory();
        for (Node node : currentDirectory.getChildNodes()) {
            System.out.println(node.getName());
        }
    }

    @Override
    public String toString() {
        return "ls";
    }
}
