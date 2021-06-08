package FileSystem;

import java.util.List;
import java.util.Arrays;

public class FileSystem {
    private Directory rootDirectory;

    public FileSystem() {
        String rootDirectoryName = "/";
        Directory rootDirectoryParent = null;
        rootDirectory = new Directory(rootDirectoryName, rootDirectoryParent);
    }

    public Directory getRootDirectory() {
        return rootDirectory;
    }

    public Node getNodeByPath(String fullPath) {
        List<String> paths = Arrays.asList(fullPath.replaceAll("^/+", "").split("/"));
        Node currentNode = rootDirectory;
        try {
            for (String path : paths) {
                int index = currentNode.findChildByName(path);
                if (index < 0) {
                    return null;
                }
                currentNode = currentNode.getChildNodes().get(index);
            }
            return currentNode;
        } catch (Exception err) {
            return null;
        }
    }
}
