package Dijkstra.Program.Model.Tests;

import Dijkstra.Program.Model.ModelConstants;
import org.junit.jupiter.api.Test;
import org.hamcrest.core.IsEqual;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ModelConstantsTest {

    @Test
    void edgeConstant() {
        String edge = "Edge ~ ";

        assertThat(edge, IsEqual.equalTo(ModelConstants.EDGE));
    }

    @Test
    void dashSignConstant() {
        String dashSign = " - ";

        assertThat(dashSign, IsEqual.equalTo(ModelConstants.DASH_SIGN));
    }

    @Test
    void oneConstant() {
        int one = 1;

        assertEquals(one, ModelConstants.ONE);
    }
}