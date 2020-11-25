package processor.commands;

import composite.Node;
import processor.CommandProcessor;

public class PwdCommand implements Command {
    @Override
    public String getName() {
        return "pwd";
    }

    @Override
    public Node runCommand(Node node, String param) {
        System.out.println(node.getPath());
        return node;
    }
}
