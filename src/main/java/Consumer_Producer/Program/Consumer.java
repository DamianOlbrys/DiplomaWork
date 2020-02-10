package Consumer_Producer.Program;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.BlockingQueue;

@Getter
@Setter
public class Consumer implements Runnable, Constants, RandomInterface {

    static int queueSize;
    private int buyTime;
    private int liveTime;
    private int hunger;
    private long start;
    private boolean isTrue;
    private int testingTime;
    private int queue1Entered;
    private int queue2Entered;

    private volatile BlockingQueue<Consumer> queue1;
    private volatile BlockingQueue<Consumer> queue2;

    public Consumer(int liveTime, BlockingQueue<Consumer> queue1, BlockingQueue<Consumer> queue2, int buyTime) throws Exception {
        new Thread(this).start();
        this.buyTime = buyTime;
        this.queue1 = queue1;
        this.queue2 = queue2;
        this.hunger = Constants.ZERO;
        start = System.currentTimeMillis();
        this.liveTime = randomValue(liveTime);
        if (this.liveTime < 2) {
            System.out.println();
            System.err.println(Constants.THREAD_LIVE_MESSAGE);
            throw new Exception(Constants.LIVE_EXCEPTION_MESSAGE);
        }
        this.isTrue = true;
        this.buyTime = randomValue(buyTime);
    }

    @Override
    public synchronized void run() {
        long startTime = System.nanoTime();

        while (isTrue) {
            if (testingTime > 1) {
                isTrue = methodToTime(testingTime, startTime);
            }
            try {
                if (hunger + 15 >= Constants.HUNDRED) {
                    hunger = Constants.HUNDRED;
                } else {
                    Thread.sleep(Constants.HUNDRED);
                    this.hunger += Constants.INCREASED_HUNGER;
                }
                if (this.hunger > Constants.REQ_HUNGER_TO_ENTER_THE_QUEUE && this.hunger < Constants.HUNDRED && Producer.food > Constants.ONE) {
                    if (queue1.size() <= queue2.size()) {
                        chooseQueue1();
                        Thread.sleep(buyTime);
                        sellFoodFromQueue1();
                        queue1Entered++;
                    } else if (queue1.size() > queue2.size()) {
                        chooseQueue2();
                        Thread.sleep(buyTime);
                        sellFoodFromQueue2();
                        queue2Entered++;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ((System.currentTimeMillis() - start) > ((long) liveTime) || this.hunger >= Constants.HUNDRED) {
                System.err.println(Constants.THREAD_NAME + Thread.currentThread().getName() + Constants.DIED_HAVING + this.hunger + Constants.PERCENT_HUNGER);
                break;
            }
        }
    }

    private synchronized void chooseQueue1() throws InterruptedException {
        Thread.sleep(Constants.TIME_TO_CHOOSE_QUEUE);
        queue1.put(Consumer.this);
        System.out.println(Constants.CLIENT + Thread.currentThread().getName() + Constants.ENTERING_QUEUE_NO_1 + hunger + Constants.PERCENT_SIGN);
    }


    private synchronized void chooseQueue2() throws InterruptedException {
        Thread.sleep(Constants.TIME_TO_CHOOSE_QUEUE);
        queue2.put(Consumer.this);
        System.out.println(Constants.CLIENT + Thread.currentThread().getName() + Constants.ENTERING_QUEUE_NO_2 + hunger + Constants.PERCENT_SIGN);
    }

    private synchronized void sellFoodFromQueue1() throws InterruptedException {
        if (Producer.food > 1) {
            queue1.take();
            this.hunger -= randomValue(Constants.DECREASED_HUNGER);
            System.err.println(Thread.currentThread().getName() + Constants.LEAVING_QUEUE_1
                    + Constants.I_STILL_HAVE + (Constants.HUNDRED * ((long) this.liveTime - (System.currentTimeMillis() - start))) / (long) this.liveTime
                    + Constants.PERCENT_LIVE_TIME + Constants.AT_THE_STORE + --Producer.food + Constants.FOOD_LEFT);
        } else {
            System.out.println(Constants.NO_FOOD_LEFT);
        }
    }

    private synchronized void sellFoodFromQueue2() throws InterruptedException {
        if (Producer.food > 1) {
            queue2.take();
            this.hunger -= randomValue(Constants.DECREASED_HUNGER);
            System.err.println(Thread.currentThread().getName() + Constants.LEAVING_QUEUE_2
                    + Constants.I_STILL_HAVE + (Constants.HUNDRED * ((long) this.liveTime - (System.currentTimeMillis() - start))) / (long) this.liveTime
                    + Constants.PERCENT_LIVE_TIME + Constants.AT_THE_STORE + --Producer.food + Constants.FOOD_LEFT);
        } else {
            System.out.println(Constants.NO_FOOD_LEFT);
        }
    }


    private boolean methodToTime(long testingTime, long startTime) {
        long oneSec = 1_000_000_000;
        long endTime = System.nanoTime();
        long durationInNano = (endTime - startTime);
        return durationInNano < (testingTime * oneSec);
    }
}



