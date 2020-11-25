package processor.commands;

import composite.Directory;
import composite.Node;

public class MkDirCommand implements Command{
    @Override
    public String getName() {
        return "mkdir";
    }

    @Override
    public Node runCommand(Node node, String param) {
        node.createDirectory(param);
        return node;
    }
}
