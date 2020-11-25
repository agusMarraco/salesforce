package composite;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Directory extends Node {

    private HashMap<String, Node> children;
    public Directory(String path, Node parent) {
        super(path, parent);
        children = new HashMap<>();
    }

    @Override
    public Node goToParentNode() {
        return getParent();
    }

    @Override
    public Node findChild(String name) {
        Node child = null;
        if(children.keySet().contains(name)) {
            child = children.get(name);

        } else {
            System.out.println("Directory not found");
        }
        return child;
    }

    @Override
    public Set<Node> listChildren() {
        return new HashSet<>(this.children.values());
    }

    @Override
    public void createDirectory(String name) {
        if(!children.containsKey(name)) {
            String directoryPath = name;
            Node directory = new Directory(directoryPath, this);
            children.put(directory.getPath(), directory);
        } else {
            System.out.println("Directory already exists");
        }

    }

    @Override
    public void createFile(String name) {
        if(!children.containsKey(name)) {
            String filePath =name;
            if(filePath.length() > 100) {
                filePath = filePath.substring(0,100);
            }
            Node file = new File(filePath, this);
            children.put(file.getPath(), file);
        }
    }

    @Override
    public Boolean isFile() {
        return Boolean.FALSE;
    }

    @Override
    public HashMap<String, Node> getChildren() {
        return children;
    }
}
