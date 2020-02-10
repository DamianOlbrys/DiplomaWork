package Consumer_Producer.Program.Tests;

import Consumer_Producer.Program.Consumer;
import Consumer_Producer.Program.Producer;
import org.junit.jupiter.api.Test;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class ConsumerTest {

    @Test
    void constructorDefaultValues() {
        int buyTime = 0;
        int liveTime = 0;
        BlockingQueue<Consumer> queue1 = new ArrayBlockingQueue<>(1);
        BlockingQueue<Consumer> queue2 = new ArrayBlockingQueue<>(1);

        assertThrows(Exception.class, () -> new Consumer(liveTime, queue1, queue2, buyTime));
    }

    @Test
    void constructorHungerDefaultValue() throws Exception {
        int buyTime = 10;
        int liveTime = 10;
        BlockingQueue<Consumer> queue1 = new ArrayBlockingQueue<>(10);
        BlockingQueue<Consumer> queue2 = new ArrayBlockingQueue<>(10);
        Consumer consumer = new Consumer(liveTime, queue1, queue2, buyTime);
        assertEquals(0, consumer.getHunger());
    }

    @Test
    void constructorBuyTimeGT50() throws Exception {
        int buyTime = 100;
        int liveTime = 5;
        BlockingQueue<Consumer> queue1 = new ArrayBlockingQueue<>(10);
        BlockingQueue<Consumer> queue2 = new ArrayBlockingQueue<>(10);
        Consumer consumer = new Consumer(liveTime, queue1, queue2, buyTime);
        System.out.println(consumer.getBuyTime());
        assertTrue(consumer.getBuyTime() > 50);
    }

    @Test
    void runHunger2Sec() throws Exception {
        int buyTime = 10;
        int liveTime = 500_000;
        BlockingQueue<Consumer> queue1 = new ArrayBlockingQueue<>(10);
        BlockingQueue<Consumer> queue2 = new ArrayBlockingQueue<>(10);
        Consumer consumer = new Consumer(liveTime, queue1, queue2, buyTime);
        consumer.setTestingTime(2);

        consumer.run();

        System.out.println(consumer.getHunger());
        assertTrue(5 < consumer.getHunger());
    }

    @Test
    void runHunger5Sec() throws Exception {
        int buyTime = 10;
        int liveTime = 500_000;
        BlockingQueue<Consumer> queue1 = new ArrayBlockingQueue<>(10);
        BlockingQueue<Consumer> queue2 = new ArrayBlockingQueue<>(10);
        Consumer consumer = new Consumer(liveTime, queue1, queue2, buyTime);
        consumer.setTestingTime(2);

        consumer.run();

        System.out.println(consumer.getHunger());
        assertTrue(5 < consumer.getHunger());
    }

    @Test
    void runHunger10Sec() throws Exception {
        int buyTime = 10;
        int liveTime = 500_000;
        BlockingQueue<Consumer> queue1 = new ArrayBlockingQueue<>(10);
        BlockingQueue<Consumer> queue2 = new ArrayBlockingQueue<>(10);
        Consumer consumer = new Consumer(liveTime, queue1, queue2, buyTime);
        consumer.setTestingTime(10);

        consumer.run();

        System.out.println(consumer.getHunger());
        assertTrue(5 < consumer.getHunger());
    }

    @Test
    void queue1EQ0() throws Exception {
        int buyTime = 10;
        int liveTime = 500_000;
        BlockingQueue<Consumer> queue1 = new ArrayBlockingQueue<>(10);
        BlockingQueue<Consumer> queue2 = new ArrayBlockingQueue<>(10);
        Consumer consumer = new Consumer(liveTime, queue1, queue2, buyTime);
        consumer.setTestingTime(10);

        consumer.run();

        System.out.println(consumer.getQueue1().size());
        assertEquals(0, consumer.getQueue1().size());
    }


    @Test
    void queue2EQ0() throws Exception {
        int buyTime = 10;
        int liveTime = 500_000;
        BlockingQueue<Consumer> queue1 = new ArrayBlockingQueue<>(10);
        BlockingQueue<Consumer> queue2 = new ArrayBlockingQueue<>(10);
        Consumer consumer = new Consumer(liveTime, queue1, queue2, buyTime);
        consumer.setTestingTime(10);

        consumer.run();

        System.out.println(consumer.getQueue2().size());
        assertEquals(0, consumer.getQueue2().size());
    }

    @Test
    void queue1EnteredMoreThan1Time() throws Exception {
        int buyTime = 10;
        int liveTime = 500_000;
        BlockingQueue<Consumer> queue1 = new ArrayBlockingQueue<>(10);
        BlockingQueue<Consumer> queue2 = new ArrayBlockingQueue<>(10);
        Consumer consumer = new Consumer(liveTime, queue1, queue2, buyTime);
        consumer.setTestingTime(2);
        Producer producer = new Producer(200, 200);
        producer.setTestingTime(2);
        producer.run();

        consumer.run();

        System.out.println(consumer.getQueue1Entered());
        System.out.println(consumer.getQueue2Entered());
        assertTrue(consumer.getQueue1Entered() > 1);
    }

    @Test
    void queue1EnteredMoreThan15Times() throws Exception {
        int buyTime = 10;
        int liveTime = 500_000;
        BlockingQueue<Consumer> queue1 = new ArrayBlockingQueue<>(10);
        BlockingQueue<Consumer> queue2 = new ArrayBlockingQueue<>(10);
        Consumer consumer = new Consumer(liveTime, queue1, queue2, buyTime);
        consumer.setTestingTime(10);
        Producer producer = new Producer(200, 200);
        producer.setTestingTime(10);
        producer.run();

        consumer.run();

        System.out.println(consumer.getQueue1Entered());
        assertTrue(consumer.getQueue1Entered() > 15);
    }
 }

