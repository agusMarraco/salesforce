package processor.commands;

import composite.Node;

import java.util.Arrays;
import java.util.List;

public class CdCommand implements Command {
    @Override    public String getName() {
        return "cd";
    }

    @Override
    public Node runCommand(Node node, String param) {
        List<String> paths = Arrays.asList(param.split("/"));
        for(String path: paths) {
            if(path.equals("..")) {
                Node parent = node.goToParentNode();
                if(parent != null)
                    node = parent;
            }else {
                Node child = node.findChild(path);
                if(child != null && !child.isFile()) {
                    node = child;
                }
            }
        }


        return node;
    }
}
