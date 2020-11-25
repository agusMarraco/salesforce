package processor.commands;

import composite.Node;
import processor.QuitException;

public class QuitCommand implements Command {
    @Override
    public String getName() {
        return "quit";
    }

    @Override
    public Node runCommand(Node node, String param) {
        throw new QuitException();
    }
}
