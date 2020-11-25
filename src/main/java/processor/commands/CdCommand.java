package processor.commands;

import composite.Node;

public class CdCommand implements Command {
    @Override    public String getName() {
        return "cd";
    }

    @Override
    public Node runCommand(Node node, String param) {
        if(param.equals("..")) {
            Node parent = node.goToParentNode();
            if(parent != null)
                node = parent;
        }else {
            Node child = node.findChild(param);
            if(child != null && !child.isFile()) {
                node = child;
            }
        }

        return node;
    }
}
