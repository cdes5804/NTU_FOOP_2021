package Commands;

import FileSystem.FileSystem;
import FileSystem.Node;
import CLI.CLI;

import java.util.List;

public class Search extends Command {
    @Override
    public void action(List<String> parameters, CLI cli, FileSystem fileSystem) {
        Node currentDirectory = cli.getCurrentWorkingDirectory();
        preOrderSearch(currentDirectory, parameters.get(0));
    }

    private void preOrderSearch(Node root, String searchPattern) {
        if (root.getName().contains(searchPattern)) {
            System.out.println(root.getName());
        }

        for (Node childNodes : root.getChildNodes()) {
            preOrderSearch(childNodes, searchPattern);
        }
    }

    @Override
    public String toString() {
        return "search";
    }
}
