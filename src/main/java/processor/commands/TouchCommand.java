package processor.commands;

import composite.Node;

public class TouchCommand implements Command {
    @Override
    public String getName() {
        return "touch";
    }

    @Override
    public Node runCommand(Node node, String param) {
        node.createFile(param);
        return node;
    }
}
