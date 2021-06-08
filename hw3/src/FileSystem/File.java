package FileSystem;

public class File extends Node {
    public File(String name, Node parentNode) {
        super(name, parentNode);
    }

    @Override
    public String getEntityPath() {
        return null;
    }

    @Override
    public final int findChildByName(String name) throws Exception {
        throw new Exception("A file does not contain any child");
    }

    @Override
    public final void addChild(Node child) throws Exception {
        throw new Exception("Cannot add a node in a file");
    }
}
