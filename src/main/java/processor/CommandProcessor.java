package processor;

import composite.Node;
import processor.commands.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CommandProcessor {

    private HashMap<String, Command> commandMap;
    private List<String> possibleParams = Arrays.asList("-r");

    public CommandProcessor(){

        this.commandMap = new HashMap<>();
        CdCommand cdCommand = new CdCommand();
        LsCommand lsCommand = new LsCommand();
        MkDirCommand mkDirCommand = new MkDirCommand();
        PwdCommand pwdCommand = new PwdCommand();
        TouchCommand touchCommand = new TouchCommand();
        QuitCommand quitCommand = new QuitCommand();
        this.commandMap.put(cdCommand.getName(), cdCommand);
        this.commandMap.put(lsCommand.getName(), lsCommand);
        this.commandMap.put(mkDirCommand.getName(), mkDirCommand);
        this.commandMap.put(pwdCommand.getName(), pwdCommand);
        this.commandMap.put(touchCommand.getName(), touchCommand);
        this.commandMap.put(quitCommand.getName(), quitCommand);
    }

    public Node execute(List<String> commandAndParams, Node currentNode) {
            String command = commandAndParams.get(0);
            String params = "";
            validateCommand(command);
            if(command.equals("ls") && hasParams(commandAndParams)) {
                params = commandAndParams.get(1);
                validateCommand(params);
            }else {
                if(hasParams(commandAndParams)){
                    params = commandAndParams.get(1);
                }
            }
        currentNode = commandMap.get(command).runCommand(currentNode, params);
        return currentNode;


    }

    private void validateCommand(String command) {
        if(!commandMap.keySet().contains(command) && !possibleParams.contains(command)) {
            throw new CommandNotFoundException(command);
        }
    }

    private Boolean hasParams(List<String> input){
        return input.size() > 1;
    }
}
