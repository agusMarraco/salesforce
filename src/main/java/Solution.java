import composite.Directory;
import composite.Node;
import processor.CommandNotFoundException;
import processor.CommandProcessor;
import processor.QuitException;

import java.util.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        CommandProcessor commandProcessor = new CommandProcessor();
        Scanner scanner = new Scanner(System.in);
        Boolean run = Boolean.TRUE;
        Node baseNode = new Directory("root", null);
        while(run) {
            printMessage("Enter your command");
            String input = scanner.nextLine();
            List<String> command = Arrays.asList(input.split(" "));
            try {
                baseNode = commandProcessor.execute(command, baseNode);
            } catch (CommandNotFoundException ex) {
                printMessage("Command not Found");

            } catch (QuitException ex) {
                printMessage("Finishing up");
                run = Boolean.FALSE;
            }
        }

    }

    private static void printMessage (String message){
        System.out.println(message);
    }


}