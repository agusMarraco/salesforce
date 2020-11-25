package composite;


import java.util.HashMap;
import java.util.Set;

public abstract class Node {

    private String path;
    private Node parent;

    public Node(String path, Node parent){
        this.parent = parent;
        this.path = path;
    }

    public abstract Node goToParentNode();
    public abstract Node findChild(String name);
    public abstract Set<Node> listChildren();
    public abstract void createDirectory(String name);
    public abstract void createFile(String name);
    public abstract Boolean isFile();
    public abstract HashMap<String, Node> getChildren();
    public String getFullPath(){
        String path = "";
        if(this.getParent() != null)
            path = this.getParent().getFullPath();
        return path.concat ("/").concat(this.path);
    }

    public String getPath() {
        return path;
    }

    public Node getParent(){
        return this.parent;
    }

}
