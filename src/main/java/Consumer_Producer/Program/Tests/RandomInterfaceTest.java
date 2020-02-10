package Consumer_Producer.Program.Tests;

import Consumer_Producer.Program.RandomInterface;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomInterfaceTest implements RandomInterface {

    @Test
    void randomValueTestWithPositiveSet(){

        int[] array = {3,12,333,222,1245,5243,67,684,79,23,541,436,54,7456,72,22,102194};

        for(int x: array) {
           assertTrue(randomValue(x)>0);
        }
    }
}
