package Dijkstra.Program.View.Tests;

import Dijkstra.Program.View.Initializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.hamcrest.core.IsEqual;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InitializerTest {

    private Initializer initializer;

    @BeforeEach
    void setUp() {
        initializer = new Initializer();
    }

    @Test
    void jFrameEqualsNotNull() {
        assertNotNull(initializer.getJFrame());
    }

    @Test
    void jFrameTitle() {
        initializer.start();

        assertThat("Dijkstra Algorithm", IsEqual.equalTo(initializer.getJFrame().getTitle()));
    }

    @Test
    void jFrameDefaultCloseOperation() {
        initializer.start();

        assertEquals(3, initializer.getJFrame().getDefaultCloseOperation());
    }

    @Test
    void jFrameExtendedState() {
        initializer.start();

        assertEquals(6, initializer.getJFrame().getExtendedState());
    }

    @Test
    void jFrameVisibility() {
        initializer.start();

        assertTrue(initializer.getJFrame().isVisible());
    }
}
