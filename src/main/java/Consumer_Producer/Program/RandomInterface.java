package Consumer_Producer.Program;

import java.util.Random;

public interface RandomInterface {

    Random random = new Random();

    default int randomValue(int value) {
        int multiplier = (int) (value * 0.4);
        value = (int) (value * 0.8 + random.nextInt(multiplier));
        return value;
    }
}
