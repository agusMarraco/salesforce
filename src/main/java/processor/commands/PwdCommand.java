package processor.commands;

import composite.Node;

public class PwdCommand implements Command {
    @Override
    public String getName() {
        return "pwd";
    }

    @Override
    public Node runCommand(Node node, String param) {
        System.out.println(node.getFullPath());
        return node;
    }
}
