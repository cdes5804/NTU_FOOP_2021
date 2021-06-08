package FileSystem;

public class Link extends Node {
    public Link(String name, Node parentNode, String path) {
        super(name, parentNode);
        this.data = path;
    }

    @Override
    public String getEntityPath() {
        return data;
    }

    @Override
    public final int findChildByName(String name) throws Exception {
        throw new Exception("A soft link does not contain any child");
    }

    @Override
    public final void addChild(Node child) throws Exception {
        throw new Exception("Cannot add a node in a soft link");
    }
}
