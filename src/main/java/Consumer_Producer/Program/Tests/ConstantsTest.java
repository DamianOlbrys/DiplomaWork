package Consumer_Producer.Program.Tests;

import Consumer_Producer.Program.Constants;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;

class ConstantsTest {

    @Test
    void zeroConstant() {
        int ZERO = 0;
        assertEquals(ZERO, Constants.ZERO);
    }

    @Test
    void foodPerTempoConstant() {
        int FOOD_PER_TEMPO = 1;
        assertEquals(FOOD_PER_TEMPO,Constants.FOOD_PER_TEMPO);
    }

    @Test
    void systemExitOneConstant() {
        int SYSTEM_EXIT_ONE = 1;
        assertEquals(SYSTEM_EXIT_ONE,Constants.SYSTEM_EXIT_ONE);
    }

    @Test
    void timeToChooseQueueConstant() {
        int TIME_TO_CHOOSE_QUEUE = 5;
        assertEquals(TIME_TO_CHOOSE_QUEUE,Constants.TIME_TO_CHOOSE_QUEUE);
    }

    @Test
    void increasedHungerConstant() {
        int INCREASED_HUNGER = 5;
        assertEquals(INCREASED_HUNGER,Constants.INCREASED_HUNGER);
    }

    @Test
    void decreasedHungerConstant() {
        int DECREASED_HUNGER = 20;
        assertEquals(DECREASED_HUNGER,Constants.DECREASED_HUNGER);
    }

    @Test
    void requiredHungerToEnterTheQueueConstant() {
        int REQ_HUNGER_TO_ENTER_THE_QUEUE = 30;
        assertEquals(REQ_HUNGER_TO_ENTER_THE_QUEUE,Constants.REQ_HUNGER_TO_ENTER_THE_QUEUE);
    }

    @Test
    void hundredConstant() {
        int HUNDRED = 100;
        assertEquals(HUNDRED,Constants.HUNDRED);
    }

    @Test
    void oneConstant() {
        int ONE = 1;
        assertEquals(ONE,Constants.ONE);
    }

    @Test
    void threadLiveMessageConstant() {
        String THREAD_LIVE_MESSAGE = "Thread live time have to be greater than 2!";
        assertThat(THREAD_LIVE_MESSAGE, IsEqual.equalTo(Constants.THREAD_LIVE_MESSAGE));
    }

    @Test
    void noFoodLeftConstant() {
        String NO_FOOD_LEFT = "Sorry, there  is no food in the shop";
        assertThat(NO_FOOD_LEFT, IsEqual.equalTo(Constants.NO_FOOD_LEFT));
    }

    @Test
    void clientConstant() {
        String CLIENT = "Consumer ";
        assertThat(CLIENT, IsEqual.equalTo(Constants.CLIENT));
    }

    @Test
    void mismatchedArrayWarningConstant() {
        String MISMATCHED_ARRAY_WARNING = "MismatchedReadAndWriteOfArray";
        assertThat(MISMATCHED_ARRAY_WARNING, IsEqual.equalTo(Constants.MISMATCHED_ARRAY_WARNING));
    }

    @Test
    void liveTimeKeyConstant() {
        String LIVE_TIME_KEY = "Live Time";
        assertThat(LIVE_TIME_KEY, IsEqual.equalTo(Constants.LIVE_TIME_KEY));
    }

    @Test
    void buyTimeKeyConstant() {
        String BUY_TIME_KEY = "Buy Time";
        assertThat(BUY_TIME_KEY, IsEqual.equalTo(Constants.BUY_TIME_KEY));
    }

    @Test
    void queueLenghtKeyConstant() {
       String QUEUE_LENGTH_KEY = "Queue Length";
        assertThat(QUEUE_LENGTH_KEY, IsEqual.equalTo(Constants.QUEUE_LENGTH_KEY));
    }

    @Test
    void amountOfClientsKeyConstant() {
        String AMOUNT_OF_CLIENTS_KEY = "Amount of clients";
        assertThat(AMOUNT_OF_CLIENTS_KEY, IsEqual.equalTo(Constants.AMOUNT_OF_CLIENTS_KEY));
    }

    @Test
    void foodPerSecondKeyConstant() {
        String FOOD_PER_SECOND_KEY = "Food per second";
        assertThat(FOOD_PER_SECOND_KEY, IsEqual.equalTo(Constants.FOOD_PER_SECOND_KEY));
    }

    @Test
    void magazineCapacityKeyConstant() {
        String MAGAZINE_CAPACITY_KEY = "Magazine capacity";
        assertThat(MAGAZINE_CAPACITY_KEY, IsEqual.equalTo(Constants.MAGAZINE_CAPACITY_KEY));
    }

    @Test
    void threadNameConstant() {
        String THREAD_NAME = "Thread ";
        assertThat(THREAD_NAME, IsEqual.equalTo(Constants.THREAD_NAME));
    }

    @Test
    void diedHavingConstant() {
        String DIED_HAVING = " died having ";
        assertThat(DIED_HAVING, IsEqual.equalTo(Constants.DIED_HAVING));
    }

    @Test
    void percentHungerConstant() {
        String PERCENT_HUNGER = " % hunger ";
        assertThat(PERCENT_HUNGER, IsEqual.equalTo(Constants.PERCENT_HUNGER));
    }

    @Test
    void enteringQueueNo1Constant() {
        String ENTERING_QUEUE_NO_1 = " has entered the queue no.1 (Hunger: ";
        assertThat(ENTERING_QUEUE_NO_1, IsEqual.equalTo(Constants.ENTERING_QUEUE_NO_1));
    }

    @Test
    void enteringQueueNo2Constant() {
        String ENTERING_QUEUE_NO_2 = " has entered the queue no.2 (Hunger: ";
        assertThat(ENTERING_QUEUE_NO_2, IsEqual.equalTo(Constants.ENTERING_QUEUE_NO_2));
    }

    @Test
    void percentSignConstant() {
        String PERCENT_SIGN = "%)";
        assertThat(PERCENT_SIGN, IsEqual.equalTo(Constants.PERCENT_SIGN));
    }

    @Test
    void leavingQueue1Constant() {
        String LEAVING_QUEUE_1 = " has left the queue no.1 ";
        assertThat(LEAVING_QUEUE_1, IsEqual.equalTo(Constants.LEAVING_QUEUE_1));
    }

    @Test
    void leavingQueue2Constant() {
        String LEAVING_QUEUE_2 = " has left the queue no.2 ";
        assertThat(LEAVING_QUEUE_2, IsEqual.equalTo(Constants.LEAVING_QUEUE_2));
    }

    @Test
    void iStillHaveConstant() {
        String I_STILL_HAVE = " I still have ";
        assertThat(I_STILL_HAVE, IsEqual.equalTo(Constants.I_STILL_HAVE));
    }

    @Test
    void foodLeftConstant() {
        String FOOD_LEFT = " food is left.";
        assertThat(FOOD_LEFT, IsEqual.equalTo(Constants.FOOD_LEFT));
    }

    @Test
    void percentLiveTimeConstant() {
        String PERCENT_LIVE_TIME = " % live time.";
        assertThat(PERCENT_LIVE_TIME, IsEqual.equalTo(Constants.PERCENT_LIVE_TIME));
    }

    @Test
    void atTheStoreConstant() {
        String AT_THE_STORE = " At the store ";
        assertThat(AT_THE_STORE, IsEqual.equalTo(Constants.AT_THE_STORE));
    }

    @Test
    void infiniteLoopStatementConstant() {
        String INFINITE_LOOP_STATEMENT = "InfiniteLoopStatement";
        assertThat(INFINITE_LOOP_STATEMENT, IsEqual.equalTo(Constants.INFINITE_LOOP_STATEMENT));
    }

    @Test
    void badInputMessageConstant() {
        String BAD_INPUT_MESSAGE = "Magazine Capacity and tempo values have to be number from positive set!";
        assertThat(BAD_INPUT_MESSAGE, IsEqual.equalTo(Constants.BAD_INPUT_MESSAGE));
    }

    @Test
    void liveExceptionMessageConstant() {
        String LIVE_EXCEPTION_MESSAGE = "Live time have to be greater then 2";
        assertThat(LIVE_EXCEPTION_MESSAGE, IsEqual.equalTo(Constants.LIVE_EXCEPTION_MESSAGE));
    }
}
