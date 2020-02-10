package Consumer_Producer.Program.Tests;

import Consumer_Producer.Program.Initializer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InitializerTest {

    @Test
    void defaultArguments() throws Exception {
        Initializer initializer = new Initializer();
        initializer.initialize();

        assertEquals(6, initializer.getArguments().size());

    }
}
