package Consumer_Producer.Program.Tests;

import Consumer_Producer.Program.Producer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProducerTest {

    @BeforeEach
    void beforeEach() {
        Producer.food = 0;
    }

    @AfterEach
    void afterEach() {
        Producer.food = 0;
    }

    @Test
    void constructorTempoFromPositiveSet() {
        int[] tempo = {1, 5, 2, 555, 12, 54, 73, 784568484, 85684562, 412341, 512351235, 23, 5865, 84, 4};
        int magazineCapacity = 0;

        for (int value : tempo) {
            assertThrows(Exception.class, () -> new Producer(value, magazineCapacity));
        }
    }

    @Test
    void constructorTempoFromNegativeSet() {
        int[] tempo = {-1, -5, -2, -555, -12, -54, -73, -784568484, -85684562, -412341, -512351235, -23, -5865, -84, -4};
        int magazineCapacity = 0;

        for (int value : tempo) {
            assertThrows(Exception.class, () -> new Producer(value, magazineCapacity));
        }
    }

    @Test
    void constructorMagazineCapacityFromPositiveSet() {
        int tempo = 0;
        int[] magazineCapacity = {1, 5, 2, 555, 12, 54, 73, 784568484, 85684562, 412341, 512351235, 23, 5865, 84, 4};

        for (int value : magazineCapacity) {
            assertThrows(Exception.class, () -> new Producer(tempo, value));
        }
    }

    @Test
    void constructorMagazineCapacityFromNegativeSet() {
        int tempo = 0;
        int[] magazineCapacity = {-1, -5, -2, -555, -12, -54, -73, -784568484, -85684562, -412341, -512351235, -23, -5865, -84, -4};

        for (int value : magazineCapacity) {
            assertThrows(Exception.class, () -> new Producer(tempo, value));
        }
    }

    @Test
    void constructorDefaultValues() {
        int tempo = 0;
        int magazineCapacity = 0;

        assertThrows(Exception.class, () -> new Producer(tempo, magazineCapacity));
    }

    @Test
    void constructorWithTempoPositiveSetOfNumbers() throws Exception {
        int[] tempo = {1, 5, 2, 555, 12, 54, 73, 784568484, 85684562, 412341, 512351235, 23, 5865, 84, 4};
        int[] magazineCapacity = {1, 5, 2, 555, 12, 54, 73, 784568484, 85684562, 412341, 512351235, 23, 5865, 84, 4};

        for (int tempoValue : tempo) {
            for (int magazineCapacityValues : magazineCapacity) {
                Producer producer = new Producer(tempoValue, magazineCapacityValues);
                assertEquals(tempoValue, producer.getTempo());
            }
        }
    }

    @Test
    void constructorWithMagazineCapacityPositiveSetOfNumbers() throws Exception {
        int[] tempo = {1, 5, 2, 555, 12, 54, 73, 784568484, 85684562, 412341, 512351235, 23, 5865, 84, 4};
        int[] magazineCapacity = {1, 5, 2, 555, 12, 54, 73, 784568484, 85684562, 412341, 512351235, 23, 5865, 84, 4};

        for (int tempoValue : tempo) {
            for (int magazineCapacityValues : magazineCapacity) {
                Producer producer = new Producer(tempoValue, magazineCapacityValues);
                assertEquals(magazineCapacityValues, producer.getMagazineCapacity());
            }
        }
    }

    @Test
    void defaultConstructorFood() {
        assertEquals(0, Producer.food);
    }

    @Test
    void defaultConstructorIsTrue() throws Exception {
        int tempo = 10;
        int magazineCapacity = 10;

        Producer producer = new Producer(tempo, magazineCapacity);
        assertTrue(producer.isTrue());
    }


    @Test
    void foodPer1kNanos2Sec() throws Exception {
        int tempo = 1000;
        int magazineCapacity = 1_000_000;

        Producer producer = new Producer(tempo, magazineCapacity);
        producer.setTestingTime(2);
        producer.run();

        producer.setTrue(false);
        System.out.println(Producer.food);
        assertTrue(Producer.food > 100);
    }

    @Test
    void foodPer500kNanos2Sec() throws Exception {
        int tempo = 500000;
        int magazineCapacity = 1000000;

        Producer producer = new Producer(tempo, magazineCapacity);
        producer.setTestingTime(2);
        producer.run();

        producer.setTrue(false);
        System.out.println(Producer.food);
        assertTrue(Producer.food > 100);
    }

    @Test
    void foodPer800kNanos2Sec() throws Exception {
        int tempo = 800_000;
        int magazineCapacity = 1_000_000;

        Producer producer = new Producer(tempo, magazineCapacity);
        producer.setTestingTime(2);
        producer.run();

        producer.setTrue(false);
        System.out.println(Producer.food);
        assertTrue(Producer.food > 100);
    }

    @Test
    void foodPer2mNanos2Sec() throws Exception {
        int tempo = 2_000_000;
        int magazineCapacity = 1_000_000;

        Producer producer = new Producer(tempo, magazineCapacity);
        producer.setTestingTime(2);
        producer.run();

        producer.setTrue(false);
        System.out.println(Producer.food);
        assertTrue(Producer.food > 100);
    }

    @Test
    void foodPer10mNanos2Sec() throws Exception {
        int tempo = 10_000_000;
        int magazineCapacity = 1_000_000;

        Producer producer = new Producer(tempo, magazineCapacity);
        producer.setTestingTime(2);
        producer.run();

        producer.setTrue(false);
        System.out.println(Producer.food);
        assertTrue(Producer.food > 10);
    }

    @Test
    void foodPer1kNanos10Sec() throws Exception {
        int tempo = 1000;
        int magazineCapacity = 1_000_000;

        Producer producer = new Producer(tempo, magazineCapacity);
        producer.setTestingTime(10);
        producer.run();

        producer.setTrue(false);
        System.out.println(Producer.food);
        assertTrue(Producer.food > 100);
    }

    @Test
    void foodPer500kNanos10Sec() throws Exception {
        int tempo = 500000;
        int magazineCapacity = 1000000;

        Producer producer = new Producer(tempo, magazineCapacity);
        producer.setTestingTime(10);
        producer.run();

        producer.setTrue(false);
        System.out.println(Producer.food);
        assertTrue(Producer.food > 100);
    }

    @Test
    void foodPer800kNanos10Sec() throws Exception {
        int tempo = 800_000;
        int magazineCapacity = 1_000_000;

        Producer producer = new Producer(tempo, magazineCapacity);
        producer.setTestingTime(10);
        producer.run();

        producer.setTrue(false);
        System.out.println(Producer.food);
        assertTrue(Producer.food > 100);
    }

    @Test
    void foodPer2mNanos10Sec() throws Exception {
        int tempo = 2_000_000;
        int magazineCapacity = 1_000_000;

        Producer producer = new Producer(tempo, magazineCapacity);
        producer.setTestingTime(10);
        producer.run();

        producer.setTrue(false);
        System.out.println(Producer.food);
        assertTrue(Producer.food > 100);
    }

    @Test
    void foodPer10mNanos10Sec() throws Exception {

        int tempo = 10_000_000;
        int magazineCapacity = 1_000_000;

        Producer producer = new Producer(tempo, magazineCapacity);
        producer.setTestingTime(10);
        producer.run();

        producer.setTrue(false);
        System.out.println(Producer.food);
        assertTrue(Producer.food > 10);
    }

    @Test
    void magazineCapacityEQ1() throws Exception {
        int tempo = 1_000;
        int magazineCapacity = 1;
        Producer.food = 0;

        Producer producer = new Producer(tempo, magazineCapacity);
        producer.setTestingTime(10);
        producer.run();

        producer.setTrue(false);
        System.out.println(Producer.food);
        assertTrue(Producer.food <= magazineCapacity);
    }

    @Test
    void magazineCapacityEQ100() throws Exception {
        int tempo = 1_000;
        int magazineCapacity = 100;
        Producer.food = 0;

        Producer producer = new Producer(tempo, magazineCapacity);
        producer.setTestingTime(10);
        producer.run();

        producer.setTrue(false);
        System.out.println(Producer.food);
        assertTrue(Producer.food <= magazineCapacity);
    }

    @Test
    void magazineCapacityEQ1k() throws Exception {
        int tempo = 1_000;
        int magazineCapacity = 1_000;
        Producer.food = 0;

        Producer producer = new Producer(tempo, magazineCapacity);
        producer.setTestingTime(10);
        producer.run();

        producer.setTrue(false);
        System.out.println(Producer.food);
        assertTrue(Producer.food <= magazineCapacity);
    }

    @Test
    void magazineCapacityEQ2k() throws Exception {
        int tempo = 1_000;
        int magazineCapacity = 2_000;
        Producer.food = 0;

        Producer producer = new Producer(tempo, magazineCapacity);
        producer.setTestingTime(10);
        producer.run();

        producer.setTrue(false);
        System.out.println(Producer.food);
        assertTrue(Producer.food <= magazineCapacity);
    }

    @Test
    void magazineCapacityEQ5k() throws Exception {
        int tempo = 1_000;
        int magazineCapacity = 5_000;
        Producer.food = 0;

        Producer producer = new Producer(tempo, magazineCapacity);
        producer.setTestingTime(10);
        producer.run();

        producer.setTrue(false);
        System.out.println(Producer.food);
        assertTrue(Producer.food <= magazineCapacity);
    }
}


