import composite.Directory;
import composite.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import processor.CommandProcessor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTest {

    private CommandProcessor commandProcessor;

    @Before
    public void setUp() {
        commandProcessor = new CommandProcessor();
    }

    @Test
    public void test_main_case() {
        Node baseNode = new Directory("root", null);
        List<String> lines = Arrays.asList(
                "mkdir pepe",
                "mkdir pepe2",
                "cd pepe",
                "touch pepe3",
                "mkdir pepe4",
                "cd pepe/pepe4",
                "cd ../.."
        );
        baseNode = commandProcessor.execute(Arrays.asList(lines.get(0).split(" ")), baseNode);
        Assert.assertTrue(baseNode.getChildren().containsKey("pepe"));
        baseNode = commandProcessor.execute(Arrays.asList(lines.get(1).split(" ")), baseNode);
        Assert.assertTrue(baseNode.getChildren().containsKey("pepe2"));
        baseNode = commandProcessor.execute(Arrays.asList(lines.get(2).split(" ")), baseNode);
        Assert.assertTrue(baseNode.getPath().equals("pepe"));
        baseNode = commandProcessor.execute(Arrays.asList(lines.get(3).split(" ")), baseNode);
        Assert.assertTrue(baseNode.getChildren().containsKey("pepe3"));
        baseNode = commandProcessor.execute(Arrays.asList(lines.get(4).split(" ")), baseNode);
        Assert.assertTrue(baseNode.getChildren().containsKey("pepe4"));
        baseNode = commandProcessor.execute(Arrays.asList(lines.get(5).split(" ")), baseNode);
        Assert.assertTrue(baseNode.getPath().equals("pepe4"));
        baseNode = commandProcessor.execute(Arrays.asList(lines.get(6).split(" ")), baseNode);
        Assert.assertTrue(baseNode.getPath().equals("root"));




    }
}
