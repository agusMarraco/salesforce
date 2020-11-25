package processor.commands;

import composite.Node;

import java.util.List;
import java.util.Set;

public class LsCommand implements Command {
    @Override
    public String getName() {
        return "ls";
    }

    @Override
    public Node runCommand(Node node, String param) {
        Set<Node> children = node.listChildren();
        Boolean recursive = param.equals("-r");
        for (Node child: children){
            System.out.println(child.getPath());
            if(recursive) {
                runCommand(child, param);
            }
        }
        return node;
    }
}
