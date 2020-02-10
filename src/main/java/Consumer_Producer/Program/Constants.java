package Consumer_Producer.Program;

public interface Constants {

    int ZERO = 0;
    int FOOD_PER_TEMPO = 1;
    int SYSTEM_EXIT_ONE = 1;
    int TIME_TO_CHOOSE_QUEUE = 5;
    int INCREASED_HUNGER = 5;
    int DECREASED_HUNGER = 20;
    int REQ_HUNGER_TO_ENTER_THE_QUEUE = 30;
    int HUNDRED = 100;
    int ONE = 1;

    String THREAD_LIVE_MESSAGE = "Thread live time have to be greater than 2!";
    String NO_FOOD_LEFT = "Sorry, there  is no food in the shop";
    String CLIENT = "Consumer ";
    String MISMATCHED_ARRAY_WARNING = "MismatchedReadAndWriteOfArray";

    String LIVE_TIME_KEY = "Live Time";
    String BUY_TIME_KEY = "Buy Time";
    String QUEUE_LENGTH_KEY = "Queue Length";
    String AMOUNT_OF_CLIENTS_KEY = "Amount of clients";
    String FOOD_PER_SECOND_KEY = "Food per second";
    String MAGAZINE_CAPACITY_KEY = "Magazine capacity";
    String THREAD_NAME = "Thread ";
    String DIED_HAVING = " died having ";
    String PERCENT_HUNGER =" % hunger ";
    String ENTERING_QUEUE_NO_1 = " has entered the queue no.1 (Hunger: ";
    String ENTERING_QUEUE_NO_2 = " has entered the queue no.2 (Hunger: ";
    String PERCENT_SIGN = "%)";
    String LEAVING_QUEUE_1 = " has left the queue no.1 ";
    String LEAVING_QUEUE_2 = " has left the queue no.2 ";
    String I_STILL_HAVE = " I still have ";
    String FOOD_LEFT = " food is left.";
    String PERCENT_LIVE_TIME = " % live time.";
    String AT_THE_STORE = " At the store ";
    String INFINITE_LOOP_STATEMENT = "InfiniteLoopStatement";
    String BAD_INPUT_MESSAGE = "Magazine Capacity and tempo values have to be number from positive set!";
    String LIVE_EXCEPTION_MESSAGE = "Live time have to be greater then 2";


    //Constants for test purposes
    int LIVE_TIME_VALUE = 8000;
    int BUY_TIME_VALUE = 6;
    int QUEUE_LENGTH_VALUE = 15;
    int AMOUNT_OF_CLIENTS_VALUE = 100;
    int DONUTS_PER_SECOND_VALUE = 1000;
    int MAGAZINE_CAPACITY_VALUE = 2000;
}
