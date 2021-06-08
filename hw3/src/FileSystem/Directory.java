package FileSystem;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Directory extends Node {
    public Directory(String name, Node parentNode) {
        super(name, parentNode);
    }

    @Override
    public String getEntityPath() {
        return getFullPath();
    }

    @Override
    public final int findChildByName(String name) {
        List<String> nodeNames = childNodes.stream().map(node -> node.getName()).collect(Collectors.toList());
        int index = Collections.binarySearch(nodeNames, name);
        return index;
    }

    @Override
    public final void addChild(Node child) throws Exception {
        int index = findChildByName(child.getName());

        if (index < 0) {
            index = -index - 1;
            childNodes.add(index, child);
        } else {
            throw new Exception(child.getName() + " exists as a file or as a sub-directory within the current directory");
        }
    }
}
