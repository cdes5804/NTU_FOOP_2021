package FileSystem;

public interface Tree {
    public String getFullPath();
    public void addChild(Node child) throws Exception;
    public int findChildByName(String name) throws Exception;
}
