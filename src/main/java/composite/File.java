package composite;

import java.util.HashSet;
import java.util.Set;

public class File extends Node {
    public File(String path, Node parent) {
        super(path, parent);
    }

    @Override
    public Node goToParentNode() {
        return getParent();
    }

    @Override
    public Node findChild(String name) {
        return null;
    }

    @Override
    public Set<Node> listChildren() {
        return new HashSet<Node>();
    }

    @Override
    public void createDirectory(String name) {

    }

    @Override
    public void createFile(String name) {

    }

    @Override
    public Boolean isFile() {
        return Boolean.TRUE;
    }
}
