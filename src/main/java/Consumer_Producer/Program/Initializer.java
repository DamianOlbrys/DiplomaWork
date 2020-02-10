package Consumer_Producer.Program;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//0) Czas życia bez zasobu
//1) Czas kupna zasobu
//2) Długość kolejki
//3) Ilość klientów
//4) Ilość zasobów wyprodukowanych w sekunde
// DOBRE WARTOSCI 8000 6 15 100 1000

@Getter
@Setter
public class Initializer implements Constants {

    private HashMap<String, Integer> arguments = new HashMap<>();

    public void initialize() throws Exception {

        arguments.put(Constants.LIVE_TIME_KEY, Constants.LIVE_TIME_VALUE);
        arguments.put(Constants.BUY_TIME_KEY, Constants.BUY_TIME_VALUE);
        arguments.put(Constants.QUEUE_LENGTH_KEY,Constants.QUEUE_LENGTH_VALUE);
        arguments.put(Constants.AMOUNT_OF_CLIENTS_KEY, Constants.AMOUNT_OF_CLIENTS_VALUE);
        arguments.put(Constants.FOOD_PER_SECOND_KEY, Constants.DONUTS_PER_SECOND_VALUE);
        arguments.put(Constants.MAGAZINE_CAPACITY_KEY, Constants.MAGAZINE_CAPACITY_VALUE);

        System.out.println(arguments);

        Consumer.queueSize = arguments.get(Constants.QUEUE_LENGTH_KEY);
        BlockingQueue<Consumer> queue1 = new ArrayBlockingQueue<>(Consumer.queueSize);
        BlockingQueue<Consumer> queue2 = new ArrayBlockingQueue<>(Consumer.queueSize);

        Thread producer = new Thread(new Producer(arguments.get(Constants.FOOD_PER_SECOND_KEY), arguments.get(Constants.MAGAZINE_CAPACITY_KEY)));
        producer.start();

        @SuppressWarnings(Constants.MISMATCHED_ARRAY_WARNING)
        Consumer[] consumer = new Consumer[arguments.get(Constants.AMOUNT_OF_CLIENTS_KEY)];

        for (int i = 0; i < consumer.length; ++i) {
            consumer[i] = new Consumer(arguments.get(Constants.LIVE_TIME_KEY), queue1, queue2, (arguments.get(Constants.BUY_TIME_KEY)));
        }
    }
}
