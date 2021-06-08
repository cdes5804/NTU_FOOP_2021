package FileSystem;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Node implements Tree {
    protected String name;
    Node parentNode;
    protected List<Node> childNodes;
    protected String data;

    public Node(String name, Node parentNode) {
        this.name = name;
        this.parentNode = parentNode == null ? this : parentNode;
        this.childNodes = new ArrayList<Node>();
        this.data = null;
    }

    public String getName() {
        return name;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public List<Node> getChildNodes() {
        return childNodes;
    }

    public void storeData(String data) {
        this.data = data;
    }

    abstract public String getEntityPath();

    public String getData() throws Exception {
        if (data == null) {
            throw new Exception("no data in node");
        }
        return data;
    }

    @Override
    public String getFullPath() {
        List<String> path = new ArrayList<String>();

        Node currentNode = this;
        while (currentNode != currentNode.parentNode) {
            path.add(currentNode.getName());
            currentNode = currentNode.parentNode;
        }
        
        Collections.reverse(path);
        return "/" + String.join("/", path);
    }
}
