package processor.commands;

import composite.Node;

public interface Command {

    String getName();
    Node runCommand(Node node, String param);

}
